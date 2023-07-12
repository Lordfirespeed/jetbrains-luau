package com.github.lordfirespeed.jetbrainsluau.ide.lsp

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.LspServerSupportProvider
import com.github.lordfirespeed.jetbrainsluau.lang.LuauFileType

class LuauLspServerSupportProvider : LspServerSupportProvider {
    override fun fileOpened(project: Project, file: VirtualFile, serverStarter: LspServerSupportProvider.LspServerStarter) {
        if (file.fileType != LuauFileType) return

        serverStarter.ensureServerStarted(LuauLspServerDescriptor(project))
    }
}