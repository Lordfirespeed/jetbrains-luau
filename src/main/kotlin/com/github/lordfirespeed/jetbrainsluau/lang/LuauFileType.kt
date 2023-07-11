package com.github.lordfirespeed.jetbrainsluau.lang

import com.intellij.openapi.fileTypes.LanguageFileType
import com.github.lordfirespeed.jetbrainsluau.LuauBundle
import com.github.lordfirespeed.jetbrainsluau.LuauIcons
import javax.swing.Icon

object LuauFileType : LanguageFileType(LuauLanguage) {
    override fun getName(): String = "Luau"

    override fun getDescription(): String = LuauBundle.message("filetype.luau.description")

    override fun getDefaultExtension(): String = "luau"

    override fun getIcon(): Icon = LuauIcons.LUAU
}