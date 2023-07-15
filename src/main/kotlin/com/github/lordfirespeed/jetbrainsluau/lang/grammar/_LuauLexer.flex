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

%public
%class _LuauLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

COMMENT=--\[(=*)\[(.|\n)*?\]\1\]
LINE_COMMENT=--[^\r\n\u0085\u2028\u2029]*
SHEBANG=#\![^\r\n\u0085\u2028\u2029]*
NORMAL_STRING=\"(\\((x[0-9a-fA-F]{2})|(u\{[0-9a-fA-F]+\})|([0-9]{1,3}|z?\n|.))|[^\"\\\n])*\"
CHAR_STRING='(\\((x[0-9a-fA-F]{2})|(u\{[0-9a-fA-F]+\})|([0-9]{1,3}|z?\n|.))|[^'\\\n])*'
GRAVE_STRING=`(\\((x[0-9a-fA-F]{2})|(u\{[0-9a-fA-F]+\})|([0-9]{1,3}|z?\n|.))|([^`\\{\n]))*`
LONG_STRING=\[(=*)\[(.|\n)*?\]\1\]
WHITE_SPACE=[ \t\u000C\r\n]+
INTERP_BEGIN=`(\\((x[0-9a-fA-F]{2})|(u\{[0-9a-fA-F]+\})|([0-9]{1,3}|z?\n|.))|[^`\\{\n])*\{
INTERP_MID=\}(\\((x[0-9a-fA-F]{2})|(u\{[0-9a-fA-F]+\})|([0-9]{1,3}|z?\n|.))|[^`\\{\n])*\{
INTERP_END=\}(\\((x[0-9a-fA-F]{2})|(u\{[0-9a-fA-F]+\})|([0-9]{1,3}|z?\n|.))|[^`\\{\n])*`
NUMBER=[0-9](_|[0-9])*(\.[0-9](_|[0-9])*)?([Ee]-?[0-9](_|[0-9])*)?
HEX_NUMBER=0[xX][0-9a-fA-F][0-9a-fA-F_]*
BINARY_NUMBER=0[bB][01][01_]*
IDENTIFIER=[a-zA-Z_][a-zA-Z_0-9]*

%state INTERP
%%

<INTERP> {
  {INTERP_MID}         { return INTERP_MID; }
  {INTERP_END}         { yybegin(YYINITIAL); return INTERP_END; }
}

<YYINITIAL, INTERP> {
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

  {COMMENT}            { return COMMENT; }
  {LINE_COMMENT}       { return LINE_COMMENT; }
  {SHEBANG}            { return SHEBANG; }
  {NORMAL_STRING}      { return NORMAL_STRING; }
  {CHAR_STRING}        { return CHAR_STRING; }
  {GRAVE_STRING}       { return GRAVE_STRING; }
  {LONG_STRING}        { return LONG_STRING; }
  {WHITE_SPACE}        { return TokenType.WHITE_SPACE; }
  {INTERP_BEGIN}       { yybegin(INTERP); return INTERP_BEGIN; }
  {NUMBER}             { return NUMBER; }
  {HEX_NUMBER}         { return HEX_NUMBER; }
  {BINARY_NUMBER}      { return BINARY_NUMBER; }
  {IDENTIFIER}         { return IDENTIFIER; }
}

[^] { return TokenType.BAD_CHARACTER; }
