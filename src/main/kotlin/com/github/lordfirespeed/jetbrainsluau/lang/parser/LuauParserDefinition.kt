package com.github.lordfirespeed.jetbrainsluau.lang.parser

import com.github.lordfirespeed.jetbrainsluau.gen.lang.LuauLexer
import com.github.lordfirespeed.jetbrainsluau.gen.lang.LuauParser
import com.github.lordfirespeed.jetbrainsluau.lang.LuauLanguage
import com.github.lordfirespeed.jetbrainsluau.lang.lexer.AdaptedLuauLexer
import com.github.lordfirespeed.jetbrainsluau.lang.psi.LuauElementTypes
import com.github.lordfirespeed.jetbrainsluau.lang.psi.LuauFile
import com.github.lordfirespeed.jetbrainsluau.lang.psi.LuauFileElementType
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
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import java.util.stream.IntStream


class LuauParserDefinition : ParserDefinition {

    override fun createLexer(project: Project?): Lexer = AdaptedLuauLexer()

    override fun createParser(project: Project?): PsiParser = AdaptedLuauParser()

    override fun getFileNodeType(): IFileElementType = LuauFileElementType

    override fun getWhitespaceTokens(): TokenSet = LUAU_WHITESPACE

    override fun getCommentTokens(): TokenSet = LUAU_COMMENTS

    override fun getStringLiteralElements(): TokenSet = LUAU_STRINGS

    override fun createElement(node: ASTNode?): PsiElement = LuauElementTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = LuauFile(viewProvider)

    companion object {
        val LUAU_NAMES_TOKEN: TokenIElementType

        init {
            PSIElementTypeFactory.defineLanguageIElementTypes(
                LuauLanguage,
                IntStream.range(0, LuauParser.VOCABULARY.maxTokenType)
                    .mapToObj { tokenType -> LuauParser.VOCABULARY.getDisplayName(tokenType) }
                    .toArray { size -> arrayOfNulls<String>(size) },

                LuauParser.ruleNames
            )
            val tokenIElementTypes = PSIElementTypeFactory.getTokenIElementTypes(LuauLanguage)
            LUAU_NAMES_TOKEN = tokenIElementTypes[LuauLexer.NAME]
        }

        val LUAU_COMMENTS = PSIElementTypeFactory.createTokenSet(
            LuauLanguage,
            LuauLexer.COMMENT,
            LuauLexer.LINE_COMMENT
        )

        val LUAU_WHITESPACE = PSIElementTypeFactory.createTokenSet(
            LuauLanguage,
            LuauLexer.WHITESPACE
        )

        val LUAU_STRINGS = PSIElementTypeFactory.createTokenSet(
            LuauLanguage,
            LuauLexer.STRING
        )

        @JvmField
        val DOC_COMMENT = LuauTokenType("DOC_COMMENT")

        @JvmField
        val LINE_COMMENT = LuauTokenType("LINE_COMMENT")
    }
}