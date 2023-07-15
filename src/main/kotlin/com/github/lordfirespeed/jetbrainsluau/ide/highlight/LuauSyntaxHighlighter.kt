package com.github.lordfirespeed.jetbrainsluau.ide.highlight

import com.github.lordfirespeed.jetbrainsluau.lang.lexer.LuauLexerAdapter
import com.github.lordfirespeed.jetbrainsluau.lang.psi.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class LuauSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer = LuauLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> = pack(attributes[tokenType])

    companion object {
        private val attributes = buildMap<IElementType, TextAttributesKey> {
            put(LuauTypeHolder.DOC_COMMENT, LuauColors.DOC_COMMENT)
            put(LuauTypeHolder.LINE_COMMENT, LuauColors.LINE_COMMENT)
            put(LuauTypeHolder.COMMENT, LuauColors.BLOCK_COMMENT)

            put(LuauTypeHolder.IDENTIFIER, LuauColors.IDENTIFIER)
            put(LuauTypeHolder.COMMA, LuauColors.COMMA)
            put(LuauTypeHolder.SEMI, LuauColors.SEMI)
            put(LuauTypeHolder.DOT, LuauColors.DOT)
            put(LuauTypeHolder.EQ, LuauColors.OPERATION_SIGN)
            put(LuauTypeHolder.COLON, LuauColors.OPERATION_SIGN)
            put(LuauTypeHolder.COMPOUND_OP, LuauColors.OPERATION_SIGN)
            put(LuauTypeHolder.BINARY_OP, LuauColors.OPERATION_SIGN)
            put(LuauTypeHolder.UNARY_OP, LuauColors.OPERATION_SIGN)

            put(LuauTypeHolder.INTERP_STRING_FRAGMENT_START, LuauColors.VALID_ESCAPE)
            put(LuauTypeHolder.INTERP_STRING_FRAGMENT_END, LuauColors.VALID_ESCAPE)

            fillMap(this, LUAU_STRING_ESCAPES, LuauColors.VALID_ESCAPE)
            fillMap(this, LUAU_OPERATOR_SIGNS, LuauColors.OPERATION_SIGN)
            fillMap(this, LUAU_STRINGS, LuauColors.STRING_LITERAL)
            fillMap(this, LUAU_NUMBERS, LuauColors.NUMBER)
            fillMap(this, LUAU_KEYWORDS, LuauColors.KEYWORD)
            fillMap(this, LUAU_BRACKETS, LuauColors.BRACKETS)
            fillMap(this, LUAU_BRACES, LuauColors.BRACES)
            fillMap(this, LUAU_PARENTHESES, LuauColors.PARENTHESES)
        }
    }
}