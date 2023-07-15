package com.github.lordfirespeed.jetbrainsluau.ide.lsp

import com.github.lordfirespeed.jetbrainsluau.lang.LuauFileType
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor

class LuauLspServerDescriptor(project: Project) : ProjectWideLspServerDescriptor(project, "Luau") {
    override fun isSupportedFile(file: VirtualFile): Boolean {
        return file.fileType is LuauFileType
    }

    // consider overriding OSProcessHandler#readerOptions with 'BaseOutputReader.Options.forMostlySilentProcess()' to reduce CPU usage.
    override fun createCommandLine(): GeneralCommandLine {
        return GeneralCommandLine().apply {
            withCharset(Charsets.UTF_8)
            withExePath(LuauLspPlatformAdaptor.luauLanguageServer)
            withParameters("lsp")
        }
    }
}