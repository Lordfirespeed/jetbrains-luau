import org.jetbrains.changelog.Changelog
import org.jetbrains.changelog.markdownToHTML
import de.undercouch.gradle.tasks.download.Download
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform

fun properties(key: String) = providers.gradleProperty(key)
fun environment(key: String) = providers.environmentVariable(key)

plugins {
    id("java") // Java support
    alias(libs.plugins.kotlin) // Kotlin support
    alias(libs.plugins.gradleIntelliJPlugin) // Gradle IntelliJ Plugin
    alias(libs.plugins.changelog) // Gradle Changelog Plugin
    alias(libs.plugins.qodana) // Gradle Qodana Plugin
    alias(libs.plugins.kover) // Gradle Kover Plugin
    alias(libs.plugins.download) // Undercrouch download plugin
}

group = properties("pluginGroup").get()
version = properties("pluginVersion").get()

val luauLspProjectUrl = properties("luauLspProjectUrl").get()
val luauLspVersion = properties("luauLspVersion").get()

val os = DefaultNativePlatform.getCurrentOperatingSystem()
val luauLspArchive = if (os.isWindows) {
    "luau-lsp-win64.zip"
} else if (os.isLinux) {
    val architecture = DefaultNativePlatform.getCurrentArchitecture()
    if (architecture.isArm) {
        "luau-lsp-linux-arm64.zip"
    } else {
        "luau-lsp-linux.zip"
    }
} else {
    "luau-lsp-macos.zip"
}
val luauLspArchiveDest = "build/tmp/downloadLuauLsp/${luauLspArchive}"

// Configure project's dependencies
repositories {
    mavenCentral()
}

// Dependencies are managed with Gradle version catalog - read more: https://docs.gradle.org/current/userguide/platforms.html#sub:version-catalog
dependencies {
//    implementation(libs.annotations)
}

// Set the JVM language level used to build the project. Use Java 11 for 2020.3+, and Java 17 for 2022.2+.
kotlin {
    jvmToolchain(17)
}

// Configure Gradle IntelliJ Plugin - read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    pluginName = properties("pluginName")
    version = properties("platformVersion")
    type = properties("platformType")

    // Plugin Dependencies. Uses `platformPlugins` property from the gradle.properties file.
    plugins = properties("platformPlugins").map { it.split(',').map(String::trim).filter(String::isNotEmpty) }
}

// Configure Gradle Changelog Plugin - read more: https://github.com/JetBrains/gradle-changelog-plugin
changelog {
    groups.empty()
    repositoryUrl = properties("pluginRepositoryUrl")
}

// Configure Gradle Qodana Plugin - read more: https://github.com/JetBrains/gradle-qodana-plugin
qodana {
    cachePath = provider { file(".qodana").canonicalPath }
    reportPath = provider { file("build/reports/inspections").canonicalPath }
    saveReport = true
    showReport = environment("QODANA_SHOW_REPORT").map { it.toBoolean() }.getOrElse(false)
}

// Configure Gradle Kover Plugin - read more: https://github.com/Kotlin/kotlinx-kover#configuration
koverReport {
    defaults {
        xml {
            onCheck = true
        }
    }
}

sourceSets {
    main {
        java.srcDirs("src/main/gen")
    }
}

tasks {
    task("downloadLuauLsp", type = Download::class) {
        src(arrayOf(
            "${luauLspProjectUrl}/releases/download/${luauLspVersion}/${luauLspArchive}",
        ))
        dest(luauLspArchiveDest)
        overwrite(false)
    }


    task("installLuauLsp", type = Copy::class) {
        dependsOn("downloadLuauLsp")
        from(zipTree(luauLspArchiveDest)) {
            into("server")
        }
        destinationDir = file("src/main/resources")
    }

    wrapper {
        gradleVersion = properties("gradleVersion").get()
    }

    patchPluginXml {
        version = properties("pluginVersion")
        sinceBuild = properties("pluginSinceBuild")
        untilBuild = properties("pluginUntilBuild")

        // Extract the <!-- Plugin description --> section from README.md and provide for the plugin's manifest
        pluginDescription = providers.fileContents(layout.projectDirectory.file("README.md")).asText.map {
            val start = "<!-- Plugin description -->"
            val end = "<!-- Plugin description end -->"

            with(it.lines()) {
                if (!containsAll(listOf(start, end))) {
                    throw GradleException("Plugin description section not found in README.md:\n$start ... $end")
                }
                subList(indexOf(start) + 1, indexOf(end)).joinToString("\n").let(::markdownToHTML)
            }
        }

        val changelog = project.changelog // local variable for configuration cache compatibility
        // Get the latest available change notes from the changelog file
        changeNotes = properties("pluginVersion").map { pluginVersion ->
            with(changelog) {
                renderItem(
                    (getOrNull(pluginVersion) ?: getUnreleased())
                        .withHeader(false)
                        .withEmptySections(false),
                    Changelog.OutputType.HTML,
                )
            }
        }
    }

    // Configure UI tests plugin
    // Read more: https://github.com/JetBrains/intellij-ui-test-robot
    runIdeForUiTests {
        systemProperty("robot-server.port", "8082")
        systemProperty("ide.mac.message.dialogs.as.sheets", "false")
        systemProperty("jb.privacy.policy.text", "<!--999.999-->")
        systemProperty("jb.consents.confirmation.enabled", "false")
    }

    signPlugin {
        certificateChain = environment("CERTIFICATE_CHAIN")
        privateKey = environment("PRIVATE_KEY")
        password = environment("PRIVATE_KEY_PASSWORD")
    }

    publishPlugin {
        dependsOn("patchChangelog")
        token = environment("PUBLISH_TOKEN")
        // The pluginVersion is based on the SemVer (https://semver.org) and supports pre-release labels, like 2.1.7-alpha.3
        // Specify pre-release label to publish the plugin in a custom Release Channel automatically. Read more:
        // https://plugins.jetbrains.com/docs/intellij/deployment.html#specifying-a-release-channel
        channels =
            properties("pluginVersion").map { listOf(it.split('-').getOrElse(1) { "default" }.split('.').first()) }
    }

    processResources {
        dependsOn("installLuauLsp")
    }

    patchPluginXml {
        dependsOn("installLuauLsp")
    }

    prepareSandbox {
        doLast {
            copy {
                from("${project.projectDir}/src/main/resources/server")
                into("${destinationDir.path}/${pluginName.get()}/server")
            }
        }
    }
}