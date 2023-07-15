package com.github.lordfirespeed.jetbrainsluau.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;

import static com.github.lordfirespeed.jetbrainsluau.lang.psi.LuauTypeHolder.*;

%%

%{
  public _LuauLexer() {
    this((java.io.Reader)null);
  }
%}
%{}
  private int zzStringInterpBracesDepth = 0;
%}

%public
%class _LuauLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=[ \t\u000C\r\n]+

COMMENT=--\[(=*)\[(.|\n)*?\]\1\]
DOC_COMMENT=---[^\r\n\u0085\u2028\u2029]*
LINE_COMMENT=--[^\r\n\u0085\u2028\u2029]*
SHEBANG=#\![^\r\n\u0085\u2028\u2029]*

HEX_ESCAPE=\\x[0-9a-fA-F]{2}
UNICODE_ESCAPE=\\u\{[0-9a-fA-F]+\}
DECIMAL_ESCAPE=\\[0-9]{1,3}
NEWLINE_ESCAPE=\\z?\n
SINGLE_CHAR_ESCAPE=\\.

NORMAL_STRING_CONTENT=[^\"\\\n]*
CHAR_STRING_CONTENT=[^'\\\n]*
INTERP_STRING_CONTENT=[^`\\{\n]*
LONG_STRING=\[(=*)\[(.|\n)*?\]\1\]

NUMBER=[0-9](_|[0-9])*(\.[0-9](_|[0-9])*)?([Ee]-?[0-9](_|[0-9])*)?
HEX_NUMBER=0[xX][0-9a-fA-F][0-9a-fA-F_]*
BINARY_NUMBER=0[bB][01][01_]*
IDENTIFIER=[a-zA-Z_][a-zA-Z_0-9]*

%state YYINTERP, YYDOCCOMMENT, YYINTERP_STRING, YYNORMAL_STRING, YYCHAR_STRING
%%

<YYINTERP_STRING, YYNORMAL_STRING, YYCHAR_STRING> {
  {HEX_ESCAPE}         { return HEX_ESCAPE; }
  {UNICODE_ESCAPE}     { return UNICODE_ESCAPE; }
  {DECIMAL_ESCAPE}     { return DECIMAL_ESCAPE; }
  {NEWLINE_ESCAPE}     { return NEWLINE_ESCAPE; }
  {SINGLE_CHAR_ESCAPE} { return CHAR_ESCAPE; }
}

<YYNORMAL_STRING> {
  {NORMAL_STRING_CONTENT} { return NORMAL_STRING_TEXT; }
  "\""                    { yybegin(YYINITIAL); return DOUBLEQUOTE; }
}

<YYCHAR_STRING> {
  {CHAR_STRING_CONTENT}   { return CHAR_STRING_TEXT; }
  "'"                     { yybegin(YYINITIAL); return QUOTE; }
}

<YYINTERP_STRING> {
  {INTERP_STRING_CONTENT} { return INTERP_STRING_TEXT; }
  "{"                     { zzStringInterpBracesDepth = 1; yybegin(YYINTERP); return INTERP_STRING_FRAGMENT_START; }
  "`"                     { yybegin(YYINITIAL); return INTERP_STRING_END; }
}

<YYDOCCOMMENT> {
  {WHITE_SPACE}        { return TokenType.WHITE_SPACE; }
  {COMMENT}            { return DOC_COMMENT; }
  {LINE_COMMENT}       { return DOC_COMMENT; }
  [^]                  { yypushback(1); yybegin(YYINITIAL); }
}

<YYINTERP> {
  "{"                  { zzStringInterpBracesDepth++; return LBRACE; }
  "}"                  { if (--zzStringInterpBracesDepth == 0) {
                           yybegin(YYINTERP_STRING); return INTERP_STRING_FRAGMENT_END;
                         }
                         return RBRACE; }
}

<YYINITIAL, YYINTERP> {
  {WHITE_SPACE}        { return TokenType.WHITE_SPACE; }

  "and"                { return AND; }
  "break"              { return BREAK; }
  "do"                 { return DO; }
  "else"               { return ELSE; }
  "elseif"             { return ELSEIF; }
  "end"                { return END; }
  "false"              { return FALSE; }
  "for"                { return FOR; }
  "function"           { return FUNCTION; }
  "if"                 { return IF; }
  "in"                 { return IN; }
  "local"              { return LOCAL; }
  "nil"                { return NIL; }
  "not"                { return NOT; }
  "or"                 { return OR; }
  "repeat"             { return REPEAT; }
  "return"             { return RETURN; }
  "then"               { return THEN; }
  "true"               { return TRUE; }
  "until"              { return UNTIL; }
  "while"              { return WHILE; }
  "+"                  { return PLUS; }
  "-"                  { return MINUS; }
  "*"                  { return MUL; }
  "/"                  { return DIV; }
  "%"                  { return MOD; }
  "^"                  { return EXPONENT; }
  "#"                  { return HASH; }
  "=="                 { return EQEQ; }
  "~="                 { return NEQ; }
  "<="                 { return LE; }
  ">="                 { return GE; }
  "<"                  { return LT; }
  ">"                  { return GT; }
  "="                  { return EQ; }
  "("                  { return LPAREN; }
  ")"                  { return RPAREN; }
  "{"                  { return LBRACE; }
  "}"                  { return RBRACE; }
  "["                  { return LBRACK; }
  "]"                  { return RBRACK; }
  ";"                  { return SEMI; }
  ":"                  { return COLON; }
  ","                  { return COMMA; }
  "."                  { return DOT; }
  ".."                 { return CONCAT; }
  "..."                { return ELLIPSIS; }
  "+="                 { return PLUSEQ; }
  "-="                 { return MINUSEQ; }
  "*="                 { return MULEQ; }
  "/="                 { return DIVEQ; }
  "%="                 { return MODEQ; }
  "^="                 { return EXPONENTEQ; }
  "..="                { return CONCATEQ; }

  {DOC_COMMENT}        { yybegin(YYDOCCOMMENT); return DOC_COMMENT; }
  {COMMENT}            { return COMMENT; }
  {LINE_COMMENT}       { return LINE_COMMENT; }
  {SHEBANG}            { return SHEBANG; }
  {LONG_STRING}        { return LONG_STRING; }
  "\""                 { yybegin(YYNORMAL_STRING); return DOUBLEQUOTE; }
  "'"                  { yybegin(YYCHAR_STRING); return QUOTE; }
  "`"                  { yybegin(YYINTERP_STRING); return INTERP_STRING_START; }
  {NUMBER}             { return NUMBER; }
  {HEX_NUMBER}         { return HEX_NUMBER; }
  {BINARY_NUMBER}      { return BINARY_NUMBER; }
  {IDENTIFIER}         { return IDENTIFIER; }
}

[^] { return TokenType.BAD_CHARACTER; }
