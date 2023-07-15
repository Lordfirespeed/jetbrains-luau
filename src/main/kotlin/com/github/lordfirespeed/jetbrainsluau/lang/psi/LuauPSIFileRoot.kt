package com.github.lordfirespeed.jetbrainsluau.lang.psi

import com.github.lordfirespeed.jetbrainsluau.LuauIcons
import com.github.lordfirespeed.jetbrainsluau.lang.LuauFileType
import com.github.lordfirespeed.jetbrainsluau.lang.LuauLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider


class LuauPSIFileRoot(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, LuauLanguage) {
    override fun getFileType() = LuauFileType

    override fun toString() = "Luau File"

    override fun getIcon(flags: Int) = LuauIcons.LUAU
}