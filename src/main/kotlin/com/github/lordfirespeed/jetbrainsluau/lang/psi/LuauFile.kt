package com.github.lordfirespeed.jetbrainsluau.lang.psi

import com.github.lordfirespeed.jetbrainsluau.lang.LuauFileType
import com.github.lordfirespeed.jetbrainsluau.lang.LuauLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider

class LuauFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, LuauLanguage) {
    override fun getFileType() = LuauFileType

    override fun toString() = "Luau file"
}