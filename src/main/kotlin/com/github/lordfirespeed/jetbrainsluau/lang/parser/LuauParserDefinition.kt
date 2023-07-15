package com.github.lordfirespeed.jetbrainsluau.lang.parser

import com.github.lordfirespeed.jetbrainsluau.lang.lexer.LuauLexerAdapter
import com.github.lordfirespeed.jetbrainsluau.lang.psi.*
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet


class LuauParserDefinition : ParserDefinition {

    override fun createLexer(project: Project?): Lexer = LuauLexerAdapter()

    override fun createParser(project: Project?): PsiParser = _LuauParser()

    override fun getFileNodeType(): IFileElementType = LuauFileElementType

    override fun getWhitespaceTokens(): TokenSet = LUAU_WHITESPACE

    override fun getCommentTokens(): TokenSet = LUAU_COMMENTS

    override fun getStringLiteralElements(): TokenSet = LUAU_STRINGS

    override fun createElement(node: ASTNode): PsiElement = LuauTypeHolder.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = LuauFile(viewProvider)
}