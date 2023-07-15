package com.github.lordfirespeed.jetbrainsluau.lang.psi

import com.github.lordfirespeed.jetbrainsluau.lang.LuauLanguage
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.TokenType.WHITE_SPACE
import com.github.lordfirespeed.jetbrainsluau.lang.psi.LuauTypeHolder.*

class LuauTokenType(debugName: String) : IElementType(debugName, LuauLanguage) {
    override fun toString() = "LuauTokenType." + super.toString()
}

val LUAU_STRING_ESCAPES = TokenSet.create(HEX_ESCAPE, UNICODE_ESCAPE, DECIMAL_ESCAPE, NEWLINE_ESCAPE, CHAR_ESCAPE)
val LUAU_STRING_LITERALS = TokenSet.create(DOUBLEQUOTE, NORMAL_STRING_TEXT, QUOTE, CHAR_STRING_TEXT)
val LUAU_INTERP_STRINGS = TokenSet.create(INTERP_STRING_START, INTERP_STRING_TEXT, INTERP_STRING_END)
val LUAU_NUMBERS = TokenSet.create(NUMBER, HEX_NUMBER, BINARY_NUMBER)
val LUAU_COMMENTS = TokenSet.create(COMMENT, LINE_COMMENT, DOC_COMMENT)
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

val LUAU_ASSIGNMENT_OPS = TokenSet.create(
    EQ,
    PLUSEQ,
    MINUSEQ,
    MULEQ,
    DIVEQ,
    MODEQ,
    EXPONENTEQ,
    CONCATEQ
)

val LUAU_BINARY_OP_SIGNS = TokenSet.create(
    EQEQ,
    NEQ,
    LE,
    GE,
    GT,
    LT,
    PLUS,
    MINUS,
    MUL,
    DIV,
    MOD,
    EXPONENT
)

val LUAU_BINARY_OP_KWS = TokenSet.create(
    AND,
    OR
)

val LUAU_UNARY_OP_SIGNS = TokenSet.create(
    HASH,
    MINUS
)

val LUAU_UNARY_OP_KWS = TokenSet.create(
    NOT
)

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

val LUAU_STRINGS = TokenSet.orSet(LUAU_STRING_LITERALS, LUAU_INTERP_STRINGS)
val LUAU_BINARY_OPS = TokenSet.orSet(LUAU_BINARY_OP_KWS, LUAU_BINARY_OP_SIGNS)
val LUAU_UNARY_OPS = TokenSet.orSet(LUAU_UNARY_OP_KWS, LUAU_UNARY_OP_SIGNS)
val LUAU_OPS = TokenSet.orSet(LUAU_BINARY_OPS, LUAU_UNARY_OPS)
val LUAU_OPERATOR_SIGNS = TokenSet.orSet(LUAU_ASSIGNMENT_OPS, LUAU_BINARY_OP_SIGNS, LUAU_UNARY_OP_SIGNS)
val LUAU_TOP_ELEMENTS = TokenSet.orSet(LUAU_COMMENTS, LUAU_STATEMENTS)
val LUAU_LITERALS = TokenSet.orSet(LUAU_STRINGS, LUAU_NUMBERS, LUAU_OTHER_EXPRESSIONS)