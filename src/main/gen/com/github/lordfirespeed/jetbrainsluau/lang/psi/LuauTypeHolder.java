// This is a generated file. Not intended for manual editing.
package com.github.lordfirespeed.jetbrainsluau.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.lordfirespeed.jetbrainsluau.lang.psi.impl.*;

public interface LuauTypeHolder {

  IElementType ANONYMOUS_FUNCTION = new LuauElementType("ANONYMOUS_FUNCTION");
  IElementType ASSIGNMENT = new LuauElementType("ASSIGNMENT");
  IElementType BINARY_OP = new LuauElementType("BINARY_OP");
  IElementType BINDING = new LuauElementType("BINDING");
  IElementType BINDING_LIST = new LuauElementType("BINDING_LIST");
  IElementType BLOCK = new LuauElementType("BLOCK");
  IElementType COMPOUND_ASSIGNMENT = new LuauElementType("COMPOUND_ASSIGNMENT");
  IElementType COMPOUND_OP = new LuauElementType("COMPOUND_OP");
  IElementType DO_BLOCK = new LuauElementType("DO_BLOCK");
  IElementType ELSE_BLOCK = new LuauElementType("ELSE_BLOCK");
  IElementType ELSE_IF_BLOCK = new LuauElementType("ELSE_IF_BLOCK");
  IElementType EXP = new LuauElementType("EXP");
  IElementType EXP_LIST = new LuauElementType("EXP_LIST");
  IElementType FIELD = new LuauElementType("FIELD");
  IElementType FIELD_LIST = new LuauElementType("FIELD_LIST");
  IElementType FIELD_SEP = new LuauElementType("FIELD_SEP");
  IElementType FOR_RANGE_BLOCK = new LuauElementType("FOR_RANGE_BLOCK");
  IElementType FOR_VALUES_BLOCK = new LuauElementType("FOR_VALUES_BLOCK");
  IElementType FUNCTION_ARGS = new LuauElementType("FUNCTION_ARGS");
  IElementType FUNCTION_BODY = new LuauElementType("FUNCTION_BODY");
  IElementType FUNCTION_CALL = new LuauElementType("FUNCTION_CALL");
  IElementType FUNCTION_DECLARATION = new LuauElementType("FUNCTION_DECLARATION");
  IElementType FUNCTION_NAME = new LuauElementType("FUNCTION_NAME");
  IElementType FUNCTION_TYPE = new LuauElementType("FUNCTION_TYPE");
  IElementType GENERIC_TYPE_LIST = new LuauElementType("GENERIC_TYPE_LIST");
  IElementType GENERIC_TYPE_LIST_WITH_DEFAULTS = new LuauElementType("GENERIC_TYPE_LIST_WITH_DEFAULTS");
  IElementType GENERIC_TYPE_PACK = new LuauElementType("GENERIC_TYPE_PACK");
  IElementType GENERIC_TYPE_PACK_PARAMETER = new LuauElementType("GENERIC_TYPE_PACK_PARAMETER");
  IElementType GENERIC_TYPE_PACK_PARAMETER_WITH_DEFAULT = new LuauElementType("GENERIC_TYPE_PACK_PARAMETER_WITH_DEFAULT");
  IElementType IF_BLOCK = new LuauElementType("IF_BLOCK");
  IElementType IF_ELSE_CHAIN = new LuauElementType("IF_ELSE_CHAIN");
  IElementType IF_ELSE_EXP = new LuauElementType("IF_ELSE_EXP");
  IElementType INTERSECTION_SUFFIX = new LuauElementType("INTERSECTION_SUFFIX");
  IElementType LAST_STAT = new LuauElementType("LAST_STAT");
  IElementType LOCAL_ASSIGNMENT = new LuauElementType("LOCAL_ASSIGNMENT");
  IElementType LOCAL_FUNCTION_DECLARATION = new LuauElementType("LOCAL_FUNCTION_DECLARATION");
  IElementType NAME_LIST = new LuauElementType("NAME_LIST");
  IElementType NUMBER_LITERAL = new LuauElementType("NUMBER_LITERAL");
  IElementType PARAM_LIST = new LuauElementType("PARAM_LIST");
  IElementType PREFIX_EXP = new LuauElementType("PREFIX_EXP");
  IElementType PROP_LIST = new LuauElementType("PROP_LIST");
  IElementType REPEAT_BLOCK = new LuauElementType("REPEAT_BLOCK");
  IElementType RETURN_TYPE = new LuauElementType("RETURN_TYPE");
  IElementType SIMPLE_EXP = new LuauElementType("SIMPLE_EXP");
  IElementType SIMPLE_TYPE = new LuauElementType("SIMPLE_TYPE");
  IElementType SINGLETON_TYPE = new LuauElementType("SINGLETON_TYPE");
  IElementType STAT = new LuauElementType("STAT");
  IElementType STRING_INTERP = new LuauElementType("STRING_INTERP");
  IElementType STRING_LITERAL = new LuauElementType("STRING_LITERAL");
  IElementType TABLE_CONSTRUCTOR = new LuauElementType("TABLE_CONSTRUCTOR");
  IElementType TABLE_INDEXER = new LuauElementType("TABLE_INDEXER");
  IElementType TABLE_PROP = new LuauElementType("TABLE_PROP");
  IElementType TABLE_PROP_OR_INDEXER = new LuauElementType("TABLE_PROP_OR_INDEXER");
  IElementType TABLE_TYPE = new LuauElementType("TABLE_TYPE");
  IElementType TYPE = new LuauElementType("TYPE");
  IElementType TYPE_DECLARATION = new LuauElementType("TYPE_DECLARATION");
  IElementType TYPE_LIST = new LuauElementType("TYPE_LIST");
  IElementType TYPE_PACK = new LuauElementType("TYPE_PACK");
  IElementType TYPE_PARAMS = new LuauElementType("TYPE_PARAMS");
  IElementType UNARY_OP = new LuauElementType("UNARY_OP");
  IElementType UNION_SUFFIX = new LuauElementType("UNION_SUFFIX");
  IElementType VAR = new LuauElementType("VAR");
  IElementType VARIADIC_TYPE_PACK = new LuauElementType("VARIADIC_TYPE_PACK");
  IElementType VAR_LIST = new LuauElementType("VAR_LIST");
  IElementType WHILE_BLOCK = new LuauElementType("WHILE_BLOCK");

  IElementType AND = new LuauTokenType("and");
  IElementType BINARY_NUMBER = new LuauTokenType("BINARY_NUMBER");
  IElementType BREAK = new LuauTokenType("break");
  IElementType CHAR_STRING = new LuauTokenType("CHAR_STRING");
  IElementType COLON = new LuauTokenType(":");
  IElementType COMMA = new LuauTokenType(",");
  IElementType COMMENT = new LuauTokenType("COMMENT");
  IElementType CONCAT = new LuauTokenType("..");
  IElementType CONCATEQ = new LuauTokenType("..=");
  IElementType DIV = new LuauTokenType("/");
  IElementType DIVEQ = new LuauTokenType("/=");
  IElementType DO = new LuauTokenType("do");
  IElementType DOT = new LuauTokenType(".");
  IElementType ELLIPSIS = new LuauTokenType("...");
  IElementType ELSE = new LuauTokenType("else");
  IElementType ELSEIF = new LuauTokenType("elseif");
  IElementType END = new LuauTokenType("end");
  IElementType EQ = new LuauTokenType("=");
  IElementType EQEQ = new LuauTokenType("==");
  IElementType EXPONENT = new LuauTokenType("^");
  IElementType EXPONENTEQ = new LuauTokenType("^=");
  IElementType FALSE = new LuauTokenType("false");
  IElementType FOR = new LuauTokenType("for");
  IElementType FUNCTION = new LuauTokenType("function");
  IElementType GE = new LuauTokenType(">=");
  IElementType GRAVE_STRING = new LuauTokenType("GRAVE_STRING");
  IElementType GT = new LuauTokenType(">");
  IElementType HASH = new LuauTokenType("#");
  IElementType HEX_NUMBER = new LuauTokenType("HEX_NUMBER");
  IElementType IDENTIFIER = new LuauTokenType("IDENTIFIER");
  IElementType IF = new LuauTokenType("if");
  IElementType IN = new LuauTokenType("in");
  IElementType INTERP_BEGIN = new LuauTokenType("INTERP_BEGIN");
  IElementType INTERP_END = new LuauTokenType("INTERP_END");
  IElementType INTERP_MID = new LuauTokenType("INTERP_MID");
  IElementType LBRACE = new LuauTokenType("{");
  IElementType LBRACK = new LuauTokenType("[");
  IElementType LE = new LuauTokenType("<=");
  IElementType LINE_COMMENT = new LuauTokenType("LINE_COMMENT");
  IElementType LOCAL = new LuauTokenType("local");
  IElementType LONG_STRING = new LuauTokenType("LONG_STRING");
  IElementType LPAREN = new LuauTokenType("(");
  IElementType LT = new LuauTokenType("<");
  IElementType MINUS = new LuauTokenType("-");
  IElementType MINUSEQ = new LuauTokenType("-=");
  IElementType MOD = new LuauTokenType("%");
  IElementType MODEQ = new LuauTokenType("%=");
  IElementType MUL = new LuauTokenType("*");
  IElementType MULEQ = new LuauTokenType("*=");
  IElementType NEQ = new LuauTokenType("~=");
  IElementType NIL = new LuauTokenType("nil");
  IElementType NORMAL_STRING = new LuauTokenType("NORMAL_STRING");
  IElementType NOT = new LuauTokenType("not");
  IElementType NUMBER = new LuauTokenType("NUMBER");
  IElementType OR = new LuauTokenType("or");
  IElementType PLUS = new LuauTokenType("+");
  IElementType PLUSEQ = new LuauTokenType("+=");
  IElementType RBRACE = new LuauTokenType("}");
  IElementType RBRACK = new LuauTokenType("]");
  IElementType REPEAT = new LuauTokenType("repeat");
  IElementType RETURN = new LuauTokenType("return");
  IElementType RPAREN = new LuauTokenType(")");
  IElementType SEMI = new LuauTokenType(";");
  IElementType SHEBANG = new LuauTokenType("SHEBANG");
  IElementType THEN = new LuauTokenType("then");
  IElementType TRUE = new LuauTokenType("true");
  IElementType UNTIL = new LuauTokenType("until");
  IElementType WHILE = new LuauTokenType("while");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANONYMOUS_FUNCTION) {
        return new LuauAnonymousFunctionImpl(node);
      }
      else if (type == ASSIGNMENT) {
        return new LuauAssignmentImpl(node);
      }
      else if (type == BINARY_OP) {
        return new LuauBinaryOpImpl(node);
      }
      else if (type == BINDING) {
        return new LuauBindingImpl(node);
      }
      else if (type == BINDING_LIST) {
        return new LuauBindingListImpl(node);
      }
      else if (type == BLOCK) {
        return new LuauBlockImpl(node);
      }
      else if (type == COMPOUND_ASSIGNMENT) {
        return new LuauCompoundAssignmentImpl(node);
      }
      else if (type == COMPOUND_OP) {
        return new LuauCompoundOpImpl(node);
      }
      else if (type == DO_BLOCK) {
        return new LuauDoBlockImpl(node);
      }
      else if (type == ELSE_BLOCK) {
        return new LuauElseBlockImpl(node);
      }
      else if (type == ELSE_IF_BLOCK) {
        return new LuauElseIfBlockImpl(node);
      }
      else if (type == EXP) {
        return new LuauExpImpl(node);
      }
      else if (type == EXP_LIST) {
        return new LuauExpListImpl(node);
      }
      else if (type == FIELD) {
        return new LuauFieldImpl(node);
      }
      else if (type == FIELD_LIST) {
        return new LuauFieldListImpl(node);
      }
      else if (type == FIELD_SEP) {
        return new LuauFieldSepImpl(node);
      }
      else if (type == FOR_RANGE_BLOCK) {
        return new LuauForRangeBlockImpl(node);
      }
      else if (type == FOR_VALUES_BLOCK) {
        return new LuauForValuesBlockImpl(node);
      }
      else if (type == FUNCTION_ARGS) {
        return new LuauFunctionArgsImpl(node);
      }
      else if (type == FUNCTION_BODY) {
        return new LuauFunctionBodyImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new LuauFunctionCallImpl(node);
      }
      else if (type == FUNCTION_DECLARATION) {
        return new LuauFunctionDeclarationImpl(node);
      }
      else if (type == FUNCTION_NAME) {
        return new LuauFunctionNameImpl(node);
      }
      else if (type == FUNCTION_TYPE) {
        return new LuauFunctionTypeImpl(node);
      }
      else if (type == GENERIC_TYPE_LIST) {
        return new LuauGenericTypeListImpl(node);
      }
      else if (type == GENERIC_TYPE_LIST_WITH_DEFAULTS) {
        return new LuauGenericTypeListWithDefaultsImpl(node);
      }
      else if (type == GENERIC_TYPE_PACK) {
        return new LuauGenericTypePackImpl(node);
      }
      else if (type == GENERIC_TYPE_PACK_PARAMETER) {
        return new LuauGenericTypePackParameterImpl(node);
      }
      else if (type == GENERIC_TYPE_PACK_PARAMETER_WITH_DEFAULT) {
        return new LuauGenericTypePackParameterWithDefaultImpl(node);
      }
      else if (type == IF_BLOCK) {
        return new LuauIfBlockImpl(node);
      }
      else if (type == IF_ELSE_CHAIN) {
        return new LuauIfElseChainImpl(node);
      }
      else if (type == IF_ELSE_EXP) {
        return new LuauIfElseExpImpl(node);
      }
      else if (type == INTERSECTION_SUFFIX) {
        return new LuauIntersectionSuffixImpl(node);
      }
      else if (type == LAST_STAT) {
        return new LuauLastStatImpl(node);
      }
      else if (type == LOCAL_ASSIGNMENT) {
        return new LuauLocalAssignmentImpl(node);
      }
      else if (type == LOCAL_FUNCTION_DECLARATION) {
        return new LuauLocalFunctionDeclarationImpl(node);
      }
      else if (type == NAME_LIST) {
        return new LuauNameListImpl(node);
      }
      else if (type == NUMBER_LITERAL) {
        return new LuauNumberLiteralImpl(node);
      }
      else if (type == PARAM_LIST) {
        return new LuauParamListImpl(node);
      }
      else if (type == PREFIX_EXP) {
        return new LuauPrefixExpImpl(node);
      }
      else if (type == PROP_LIST) {
        return new LuauPropListImpl(node);
      }
      else if (type == REPEAT_BLOCK) {
        return new LuauRepeatBlockImpl(node);
      }
      else if (type == RETURN_TYPE) {
        return new LuauReturnTypeImpl(node);
      }
      else if (type == SIMPLE_EXP) {
        return new LuauSimpleExpImpl(node);
      }
      else if (type == SIMPLE_TYPE) {
        return new LuauSimpleTypeImpl(node);
      }
      else if (type == SINGLETON_TYPE) {
        return new LuauSingletonTypeImpl(node);
      }
      else if (type == STAT) {
        return new LuauStatImpl(node);
      }
      else if (type == STRING_INTERP) {
        return new LuauStringInterpImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new LuauStringLiteralImpl(node);
      }
      else if (type == TABLE_CONSTRUCTOR) {
        return new LuauTableConstructorImpl(node);
      }
      else if (type == TABLE_INDEXER) {
        return new LuauTableIndexerImpl(node);
      }
      else if (type == TABLE_PROP) {
        return new LuauTablePropImpl(node);
      }
      else if (type == TABLE_PROP_OR_INDEXER) {
        return new LuauTablePropOrIndexerImpl(node);
      }
      else if (type == TABLE_TYPE) {
        return new LuauTableTypeImpl(node);
      }
      else if (type == TYPE) {
        return new LuauTypeImpl(node);
      }
      else if (type == TYPE_DECLARATION) {
        return new LuauTypeDeclarationImpl(node);
      }
      else if (type == TYPE_LIST) {
        return new LuauTypeListImpl(node);
      }
      else if (type == TYPE_PACK) {
        return new LuauTypePackImpl(node);
      }
      else if (type == TYPE_PARAMS) {
        return new LuauTypeParamsImpl(node);
      }
      else if (type == UNARY_OP) {
        return new LuauUnaryOpImpl(node);
      }
      else if (type == UNION_SUFFIX) {
        return new LuauUnionSuffixImpl(node);
      }
      else if (type == VAR) {
        return new LuauVarImpl(node);
      }
      else if (type == VARIADIC_TYPE_PACK) {
        return new LuauVariadicTypePackImpl(node);
      }
      else if (type == VAR_LIST) {
        return new LuauVarListImpl(node);
      }
      else if (type == WHILE_BLOCK) {
        return new LuauWhileBlockImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
