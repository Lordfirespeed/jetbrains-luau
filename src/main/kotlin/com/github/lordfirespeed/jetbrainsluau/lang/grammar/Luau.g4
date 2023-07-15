/*
BSD License

Copyright (c) 2023, Joseph Clack
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. Neither the NAME of Rainer Schuster nor the NAMEs of its contributors
   may be used to endorse or promote products derived from this software
   without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

This grammar file derives from:

    Luau 0.583 Grammar Documentation
    https://github.com/Roblox/luau/blob/0.583/docs/_pages/grammar.md

    Lua 5.4 grammar written by Kazunori Sakamoto and Alexander Alexeev
    https://github.com/antlr/grammars-v4/blob/master/lua/Lua.g4

This grammar has not been tested.
The author is not confident it is correct.
*/
grammar Luau;

chunk
    :   block EOF
    ;

block
    :  (stat (';')?)* (lastStat (';')?)?
    ;

stat
    :   varList '=' expList # Assignment
    |   var compoundOp exp # CompoundAssignment
    |   funcCall # FunctionCall
    |   'do' block 'end' # DoBlock
    |   'while' exp 'do' block 'end' # WhileBlock
    |   'repeat' block 'until' exp # RepeatBlock
    |   'if' exp 'then' block ('elseif' exp 'then' block)* ('else' block)? 'end' # IfElseBlock
    |   'for' binding '=' exp ',' exp (',' exp)? 'do' block 'end' # ForRangeBlock
    |   'for' bindingList 'in' expList 'do' block 'end' # ForValuesBlock
    |   'function' funcName funcBody # FunctionDeclaration
    |   'local' 'function' NAME funcBody # LocalFunctionDeclaration
    |   'local' bindingList ('=' expList)? # LocalAssignment
    |   ('export')? 'type' NAME ('<' genericTypeListWithDefaults '>')? '=' type # ExportTypeDeclaration
    ;


lastStat
    :   'return' (expList)? # ReturnStatement
    |   'break' # Break
    |   'continue' # Continue
    ;


funcName
    :   NAME ('.' NAME)* (':' NAME)?
    ;

funcBody
    :   ('<' genericTypeList '>')? '(' (parList)? ')' (':' returnType)? block 'end'
    ;

parList
    :   bindingList (',' '...')?
    |   '...'
    ;


expList
    :   exp (',' expList)?
    ;

nameList
    :   NAME (',' NAME)*
    ;


binding
    :   NAME (':' type)?
    ;

bindingList
    :   binding (',' bindingList)?
    ;

var: (NAME | '(' exp ')' varSuffix) varSuffix*;

prefixExp: varOrExp nameAndArgs*;

funcCall: varOrExp nameAndArgs+;

/* the actual grammar spec, which is left recursive (and so must be re-implemented)
var :  NAME | prefixexp '[' exp ']' | prefixexp '.' NAME;

prefixexp : var | functioncall | '(' exp ')';

funcCall :  prefixexp args | prefixexp ':' NAME args ;
*/

varList
    :   var (',' varList)?
    ;

varOrExp
    :    var | '(' exp ')'
    ;

varSuffix
    : nameAndArgs* ('[' exp ']' | '.' NAME)
    ;

nameAndArgs
    :   (':' NAME)? funcArgs
    ;

exp
    :   castExp (binOp exp)*
    |   unaryOp exp (binOp exp)*
    ;

ifElseExp
    :   'if' exp 'then' exp ('elseif' exp 'then' exp)* 'else' exp
    ;

castExp
    :  simpleExp ('::' type)?
    ;

stringInterp
    :   INTERP_BEGIN exp ( INTERP_MID exp )* INTERP_END
    ;

simpleExp
    :   NUMBER # NumberExpression
    |   STRING # StringExpression
    |   'nil' # NilExpression
    |   'true' # TrueExpression
    |   'false' # FalseExpression
    |   '...' # EllipsisExpression
    |   tableConstructor # TableExpression
    |   'function' funcBody # AnonymousFunctionExpression
    |   prefixExp # PrefixExpression
    |   ifElseExp # IfElseExpression
    |   stringInterp # StringInterpolationExpression
    ;

funcArgs
    :   '(' (expList)? ')'
    |   tableConstructor
    |   STRING
    ;


tableConstructor
    :   '{' (fieldList)? '}'
    ;

fieldList
    :   field (fieldSep field)* (fieldSep)?
    ;

field
    :   '[' exp ']' '=' exp
    |   NAME '=' exp
    |   exp
    ;

fieldSep
    :   ',' | ';'
    ;


compoundOp
    :   '+=' | '-=' | '*=' | '/=' | '%=' | '^=' | '..='
    ;

binOp
    :   '+' | '-' | '*' | '/' | '^' | '%' | '..' | '<' | '<=' | '>' | '>=' | '==' | '~=' | 'and' | 'or'
    ;

unaryOp
    :   '-' | 'not' | '#'
    ;


simpleType
    :   'nil'
    |   singletonType
    |   NAME ('.' NAME)? ('<' (typeParams)? '>')?
    |   'typeof' '(' exp ')'
    |   tableType
    |   functionType
    |   '(' type ')'
    ;


singletonType
    :   STRING | 'true' | 'false'
    ;


unionSuffix
    :   ('?')* ('|' simpleType ('?')*)*
    ;

intersectionSuffix
    :   ('&' simpleType)*
    ;

type
    :   simpleType (unionSuffix | intersectionSuffix)
    ;


genericTypePackParameter
    :   NAME '...'
    ;

genericTypeList
    :   NAME (',' genericTypeList)?
    |   genericTypePackParameter (',' genericTypePackParameter)*
    ;


genericTypePackParameterWithDefault
    :   NAME '...' '=' (typePack | variadicTypePack | genericTypePack)
    ;

genericTypeListWithDefaults
    :   genericTypeList (',' genericTypePackParameterWithDefault)*
    |   NAME (',' NAME)* (',' NAME '=' type)* (',' genericTypePackParameterWithDefault)*
    |   NAME '=' type (',' genericTypePackParameterWithDefault)*
    |   genericTypePackParameterWithDefault (',' genericTypePackParameterWithDefault)*
    ;


typeList
    :   type (',' typeList)?
    |   '...' type
    ;

typeParams
    :   (type | typePack | variadicTypePack | genericTypePack) (',' typeParams)?
    ;

typePack
    :   '(' (typeList)? ')'
    ;

genericTypePack
    :   NAME '...'
    ;

variadicTypePack
    :   '...' type
    ;

returnType
    :   type | typePack
    ;

tableIndexer
    :   '[' type ']' ':' type
    ;

tableProp
    :   NAME ':' type
    ;

tablePropOrIndexer
    :   tableProp | tableIndexer
    ;

propList
    :   tablePropOrIndexer (fieldSep tablePropOrIndexer)* (fieldSep)?
    ;

tableType
    :   '{' (propList)? '}'
    ;

functionType
    :   ('<' genericTypeList '>')? '(' (typeList)? ')' '->' returnType
    ;

// LEXER

NAME
    :   [a-zA-Z_][a-zA-Z_0-9]*
	;

NUMBER
    : INT
    | FLOAT
    | EXPONENTIAL
    | HEX
    | BINARY
    ;

fragment
INTERP_BEGIN
    :   '`' InterpContent* '{'
    ;

fragment
INTERP_MID
    :   '}' InterpContent* '{'
    ;

fragment
INTERP_END
    :   '}' InterpContent* '`'
    ;

fragment
InterpContent
    :   ( EscapeSequence | ~('\\'|'`'|'{'))
    ;

STRING
    : NORMALSTRING
    | CHARSTRING
    | GRAVESTRING
    | LONGSTRING
    ;

fragment
Digit
    :   [0-9]
    ;

fragment
HexDigit
    :   [0-9a-fA-F]
    ;

INT
    :   Digit ('_' | Digit)*
    ;

FLOAT
    :   INT '.' INT
    ;

EXPONENTIAL
    :   (INT | FLOAT) ('E'|'e') ('-')? INT
    ;

HEX
    :   '0' [xX] HexDigit (HexDigit | '_')*
    ;

BINARY
    :   '0' [bB] [01] [01_]*
    ;

NORMALSTRING
    :  '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

CHARSTRING
   :	'\'' ( EscapeSequence | ~('\''|'\\') )* '\''
   ;

GRAVESTRING
   :    '`' InterpContent* '`'
   ;

LONGSTRING
    :   '[' NESTED_STR ']'
    ;

fragment
NESTED_STR
    :   '=' NESTED_STR '='
    |   '[' .*? ']'
    ;

fragment
EscapeSequence
    :   '\\' [abfnrtvz"'`{}|$#\\]
    |   '\\' '\r'? '\n'
    |   HexEscape
    |   UnicodeEscape
    |   DecimalEscape
    ;

fragment
DecimalEscape
    : '\\' Digit
    | '\\' Digit Digit
    | '\\' [0-2] [0-4] Digit
    | '\\' '25' [0-5]
    ;

fragment
HexEscape
    :   '\\' 'x' HexDigit HexDigit
    ;

fragment
UnicodeEscape
    :   '\\' 'u' '{' HexDigit+ '}'
    ;

fragment
SingleLineInputCharacter
    : ~[\r\n\u0085\u2028\u2029]
    ;

COMMENT
    : '--[' NESTED_STR ']' -> channel(HIDDEN)
    ;

LINE_COMMENT
    : '--' SingleLineInputCharacter* -> channel(HIDDEN)
    ;

WHITESPACE
    :  [ \t\u000C\r\n]+ -> channel(HIDDEN)
    ;
