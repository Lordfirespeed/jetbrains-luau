package com.github.lordfirespeed.jetbrainsluau.ide.lsp

import com.intellij.ide.plugins.PluginManagerCore
import com.intellij.openapi.extensions.PluginId
import com.intellij.openapi.util.SystemInfoRt

object LuauLspPlatformAdaptor {
    private val pluginSource: String?
        get() = PluginManagerCore.getPlugin(PluginId.getId("com.github.lordfirespeed.jetbrainsluau"))?.pluginPath?.toFile()?.path

    private val exe: String
        get() {

            return if (SystemInfoRt.isWindows) {
                "luau-lsp.exe"
            } else {
                "luau-lsp"
            }
        }

    val luauLanguageServer: String = "$pluginSource/server/$exe"
}