package com.github.lordfirespeed.jetbrainsluau.lang.psi

import com.github.lordfirespeed.jetbrainsluau.lang.LuauLanguage
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.TokenType.WHITE_SPACE
import com.github.lordfirespeed.jetbrainsluau.lang.psi.LuauTypeHolder.*

class LuauTokenType(debugName: String) : IElementType(debugName, LuauLanguage) {
    override fun toString() = "LuauTokenType." + super.toString()
}

val LUAU_STRINGS = TokenSet.create(NORMAL_STRING, CHAR_STRING, GRAVE_STRING, LONG_STRING, STRING_INTERP)
val LUAU_NUMBERS = TokenSet.create(NUMBER, HEX_NUMBER, BINARY_NUMBER)
val LUAU_COMMENTS = TokenSet.create(COMMENT, LINE_COMMENT)
val LUAU_WHITESPACE = TokenSet.create(WHITE_SPACE)

val LUAU_KEYWORDS = TokenSet.create(
    AND,
    BREAK,
    DO,
    ELSE,
    ELSEIF,
    END,
    FALSE,
    FOR,
    FUNCTION,
    IF,
    IN,
    LOCAL,
    NIL,
    NOT,
    OR,
    REPEAT,
    RETURN,
    THEN,
    TRUE,
    UNTIL,
    WHILE
)

val LUAU_BRACES = TokenSet.create(LBRACE, LBRACE)
val LUAU_BRACKETS = TokenSet.create(LBRACK, RBRACK)
val LUAU_PARENTHESES = TokenSet.create(LPAREN, RPAREN)

val LUAU_STATEMENTS = TokenSet.create(
    ASSIGNMENT,
    COMPOUND_ASSIGNMENT,
    FUNCTION_CALL,
    DO_BLOCK,
    WHILE_BLOCK,
    IF_ELSE_CHAIN,
    FOR_RANGE_BLOCK,
    FOR_VALUES_BLOCK,
    FUNCTION_DECLARATION,
    LOCAL_FUNCTION_DECLARATION,
    LOCAL_ASSIGNMENT,
    TYPE_DECLARATION
)

val LUAU_OTHER_EXPRESSIONS = TokenSet.create(
    NIL,
    TRUE,
    FALSE,
    ELLIPSIS,
    TABLE_CONSTRUCTOR,
    ANONYMOUS_FUNCTION,
    PREFIX_EXP,
    IF_ELSE_EXP
)

val LUAU_TOP_ELEMENTS = TokenSet.orSet(LUAU_COMMENTS, LUAU_STATEMENTS)

val LUAU_LITERALS = TokenSet.orSet(LUAU_STRINGS, LUAU_NUMBERS, LUAU_OTHER_EXPRESSIONS)