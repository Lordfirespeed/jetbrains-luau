package com.github.lordfirespeed.jetbrainsluau.ide.highlight

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey

object LuauColors {
    val DOC_COMMENT = createTextAttributesKey("LUAU_DOC_COMMENT", DefaultLanguageHighlighterColors.DOC_COMMENT)
    val LINE_COMMENT = createTextAttributesKey("LUAU_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
    val BLOCK_COMMENT = createTextAttributesKey("LUAU_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)

    val STRING_LITERAL = createTextAttributesKey("LUAU_STRING_LITERAL", DefaultLanguageHighlighterColors.STRING)
    val KEYWORD = createTextAttributesKey("LUAU_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    val IDENTIFIER = createTextAttributesKey("LUAU_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
    val NUMBER = createTextAttributesKey("LUAU_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
    val BRACKETS = createTextAttributesKey("LUAU_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
    val PARENTHESES = createTextAttributesKey("LUAU_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES)
    val BRACES = createTextAttributesKey("LUAU_BRACES", DefaultLanguageHighlighterColors.BRACES)
    val DOT = createTextAttributesKey("LUAU_DOT", DefaultLanguageHighlighterColors.DOT)
    val COMMA = createTextAttributesKey("LUAU_COMMA", DefaultLanguageHighlighterColors.COMMA)
    val SEMI = createTextAttributesKey("LUAU_SEMI", DefaultLanguageHighlighterColors.SEMICOLON)
    val OPERATION_SIGN = createTextAttributesKey("LUAU_OPERATION_SIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN)

    val VALID_ESCAPE = createTextAttributesKey("LUAU_VALID_ESCAPE", DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE)

    val TYPE_NAME = createTextAttributesKey("PRISMA_TYPE_NAME", DefaultLanguageHighlighterColors.CLASS_NAME)
    val TYPE_REFERENCE = createTextAttributesKey("PRISMA_TYPE_REFERENCE", TYPE_NAME)
    val ATTRIBUTE = createTextAttributesKey("PRISMA_ATTRIBUTE", DefaultLanguageHighlighterColors.METADATA)
    val PARAMETER = createTextAttributesKey("PRISMA_PARAMETER", DefaultLanguageHighlighterColors.PARAMETER)
    val FIELD_NAME = createTextAttributesKey("PRISMA_FIELD_NAME", DefaultLanguageHighlighterColors.INSTANCE_FIELD)
    val FIELD_REFERENCE = createTextAttributesKey("PRISMA_FIELD_REFERENCE", FIELD_NAME)
    val FUNCTION = createTextAttributesKey("PRISMA_FUNCTION", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
}