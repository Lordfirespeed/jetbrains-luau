package com.github.lordfirespeed.jetbrainsluau.lang.psi

import com.github.lordfirespeed.jetbrainsluau.lang.LuauLanguage
import com.github.lordfirespeed.jetbrainsluau.lang.parser.LuauParserDefinition
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import org.antlr.intellij.adaptor.psi.Trees;

import org.antlr.intellij.adaptor.psi.ScopeNode

object LuauIdentifierFactory {
    fun createIdentifier(project: Project, context: ScopeNode, name: String): PsiElement =
        Trees.createLeafFromText(project,
            LuauLanguage,
            context,
            name,
            LuauParserDefinition.LUAU_NAMES_TOKEN);
}