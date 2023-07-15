// This is a generated file. Not intended for manual editing.
package com.github.lordfirespeed.jetbrainsluau.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.lordfirespeed.jetbrainsluau.lang.psi.LuauTypeHolder.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class _LuauParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return chunk(b, l + 1);
  }

  /* ********************************************************** */
  // 'function' FunctionBody
  public static boolean AnonymousFunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AnonymousFunction")) return false;
    if (!nextTokenIs(b, FUNCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNCTION);
    r = r && FunctionBody(b, l + 1);
    exit_section_(b, m, ANONYMOUS_FUNCTION, r);
    return r;
  }

  /* ********************************************************** */
  // VarList '=' ExpList
  public static boolean Assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Assignment")) return false;
    if (!nextTokenIs(b, "<assignment>", IDENTIFIER, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT, "<assignment>");
    r = VarList(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && ExpList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '+' | '-' | '*' | '/' | '^' | '%' | '..' | '<' | '<=' | '>' | '>=' | '==' | '~=' | 'and' | 'or'
  public static boolean BinaryOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BinaryOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINARY_OP, "<binary op>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, EXPONENT);
    if (!r) r = consumeToken(b, MOD);
    if (!r) r = consumeToken(b, CONCAT);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, LE);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, GE);
    if (!r) r = consumeToken(b, EQEQ);
    if (!r) r = consumeToken(b, NEQ);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, OR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (':' Type)?
  public static boolean Binding(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Binding")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && Binding_1(b, l + 1);
    exit_section_(b, m, BINDING, r);
    return r;
  }

  // (':' Type)?
  private static boolean Binding_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Binding_1")) return false;
    Binding_1_0(b, l + 1);
    return true;
  }

  // ':' Type
  private static boolean Binding_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Binding_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Binding (',' BindingList)?
  public static boolean BindingList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BindingList")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Binding(b, l + 1);
    r = r && BindingList_1(b, l + 1);
    exit_section_(b, m, BINDING_LIST, r);
    return r;
  }

  // (',' BindingList)?
  private static boolean BindingList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BindingList_1")) return false;
    BindingList_1_0(b, l + 1);
    return true;
  }

  // ',' BindingList
  private static boolean BindingList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BindingList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && BindingList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SimpleExp ('::' Type)?
  static boolean CastExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CastExp")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SimpleExp(b, l + 1);
    r = r && CastExp_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('::' Type)?
  private static boolean CastExp_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CastExp_1")) return false;
    CastExp_1_0(b, l + 1);
    return true;
  }

  // '::' Type
  private static boolean CastExp_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CastExp_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "::");
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Var CompoundOp Exp
  public static boolean CompoundAssignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompoundAssignment")) return false;
    if (!nextTokenIs(b, "<compound assignment>", IDENTIFIER, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPOUND_ASSIGNMENT, "<compound assignment>");
    r = Var(b, l + 1);
    r = r && CompoundOp(b, l + 1);
    r = r && Exp(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '+=' | '-=' | '*=' | '/=' | '%=' | '^=' | '..='
  public static boolean CompoundOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CompoundOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPOUND_OP, "<compound op>");
    r = consumeToken(b, PLUSEQ);
    if (!r) r = consumeToken(b, MINUSEQ);
    if (!r) r = consumeToken(b, MULEQ);
    if (!r) r = consumeToken(b, DIVEQ);
    if (!r) r = consumeToken(b, MODEQ);
    if (!r) r = consumeToken(b, EXPONENTEQ);
    if (!r) r = consumeToken(b, CONCATEQ);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'do' block 'end'
  public static boolean DoBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DoBlock")) return false;
    if (!nextTokenIs(b, DO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DO);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, DO_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // 'else' block
  public static boolean ElseBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ElseBlock")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && block(b, l + 1);
    exit_section_(b, m, ELSE_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // 'elseif' Exp 'then' block
  public static boolean ElseIfBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ElseIfBlock")) return false;
    if (!nextTokenIs(b, ELSEIF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSEIF);
    r = r && Exp(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && block(b, l + 1);
    exit_section_(b, m, ELSE_IF_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // (CastExp ( BinaryOp Exp )*) | (UnaryOp Exp ( BinaryOp Exp )*)
  public static boolean Exp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Exp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXP, "<exp>");
    r = Exp_0(b, l + 1);
    if (!r) r = Exp_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CastExp ( BinaryOp Exp )*
  private static boolean Exp_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Exp_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CastExp(b, l + 1);
    r = r && Exp_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( BinaryOp Exp )*
  private static boolean Exp_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Exp_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Exp_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Exp_0_1", c)) break;
    }
    return true;
  }

  // BinaryOp Exp
  private static boolean Exp_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Exp_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BinaryOp(b, l + 1);
    r = r && Exp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // UnaryOp Exp ( BinaryOp Exp )*
  private static boolean Exp_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Exp_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = UnaryOp(b, l + 1);
    r = r && Exp(b, l + 1);
    r = r && Exp_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( BinaryOp Exp )*
  private static boolean Exp_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Exp_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Exp_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Exp_1_2", c)) break;
    }
    return true;
  }

  // BinaryOp Exp
  private static boolean Exp_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Exp_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BinaryOp(b, l + 1);
    r = r && Exp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (Exp ',')* Exp
  public static boolean ExpList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXP_LIST, "<exp list>");
    r = ExpList_0(b, l + 1);
    r = r && Exp(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (Exp ',')*
  private static boolean ExpList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpList_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExpList_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpList_0", c)) break;
    }
    return true;
  }

  // Exp ','
  private static boolean ExpList_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpList_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Exp(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('[' Exp ']' '=' Exp) | (IDENTIFIER '=' Exp) | Exp
  public static boolean Field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Field")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD, "<field>");
    r = Field_0(b, l + 1);
    if (!r) r = Field_1(b, l + 1);
    if (!r) r = Exp(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '[' Exp ']' '=' Exp
  private static boolean Field_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Field_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && Exp(b, l + 1);
    r = r && consumeTokens(b, 0, RBRACK, EQ);
    r = r && Exp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER '=' Exp
  private static boolean Field_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Field_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, EQ);
    r = r && Exp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Field (FieldSep Field)* (FieldSep)?
  public static boolean FieldList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_LIST, "<field list>");
    r = Field(b, l + 1);
    r = r && FieldList_1(b, l + 1);
    r = r && FieldList_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (FieldSep Field)*
  private static boolean FieldList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!FieldList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FieldList_1", c)) break;
    }
    return true;
  }

  // FieldSep Field
  private static boolean FieldList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FieldSep(b, l + 1);
    r = r && Field(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (FieldSep)?
  private static boolean FieldList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldList_2")) return false;
    FieldList_2_0(b, l + 1);
    return true;
  }

  // (FieldSep)
  private static boolean FieldList_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldList_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FieldSep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ',' | ';'
  public static boolean FieldSep(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldSep")) return false;
    if (!nextTokenIs(b, "<field sep>", COMMA, SEMI)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_SEP, "<field sep>");
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMI);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'for' Binding '=' Exp ',' Exp [',' Exp] 'do' block 'end'
  public static boolean ForRangeBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForRangeBlock")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && Binding(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && Exp(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && Exp(b, l + 1);
    r = r && ForRangeBlock_6(b, l + 1);
    r = r && consumeToken(b, DO);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, FOR_RANGE_BLOCK, r);
    return r;
  }

  // [',' Exp]
  private static boolean ForRangeBlock_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForRangeBlock_6")) return false;
    ForRangeBlock_6_0(b, l + 1);
    return true;
  }

  // ',' Exp
  private static boolean ForRangeBlock_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForRangeBlock_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Exp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'for' BindingList 'in' ExpList 'do' block 'end'
  public static boolean ForValuesBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForValuesBlock")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && BindingList(b, l + 1);
    r = r && consumeToken(b, IN);
    r = r && ExpList(b, l + 1);
    r = r && consumeToken(b, DO);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, FOR_VALUES_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // ('(' ExpList? ')') | TableConstructor | StringLiteral
  public static boolean FunctionArgs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionArgs")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_ARGS, "<function args>");
    r = FunctionArgs_0(b, l + 1);
    if (!r) r = TableConstructor(b, l + 1);
    if (!r) r = StringLiteral(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '(' ExpList? ')'
  private static boolean FunctionArgs_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionArgs_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && FunctionArgs_0_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // ExpList?
  private static boolean FunctionArgs_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionArgs_0_1")) return false;
    ExpList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ('<' GenericTypeList '>')? '(' (ParamList)? ')' (':' ReturnType)? block 'end'
  public static boolean FunctionBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionBody")) return false;
    if (!nextTokenIs(b, "<function body>", LPAREN, LT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_BODY, "<function body>");
    r = FunctionBody_0(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && FunctionBody_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && FunctionBody_4(b, l + 1);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('<' GenericTypeList '>')?
  private static boolean FunctionBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionBody_0")) return false;
    FunctionBody_0_0(b, l + 1);
    return true;
  }

  // '<' GenericTypeList '>'
  private static boolean FunctionBody_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionBody_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LT);
    r = r && GenericTypeList(b, l + 1);
    r = r && consumeToken(b, GT);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ParamList)?
  private static boolean FunctionBody_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionBody_2")) return false;
    FunctionBody_2_0(b, l + 1);
    return true;
  }

  // (ParamList)
  private static boolean FunctionBody_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionBody_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ParamList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (':' ReturnType)?
  private static boolean FunctionBody_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionBody_4")) return false;
    FunctionBody_4_0(b, l + 1);
    return true;
  }

  // ':' ReturnType
  private static boolean FunctionBody_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionBody_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && ReturnType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VarOrExp nameAndArgs+
  public static boolean FunctionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCall")) return false;
    if (!nextTokenIs(b, "<function call>", IDENTIFIER, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL, "<function call>");
    r = VarOrExp(b, l + 1);
    r = r && FunctionCall_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // nameAndArgs+
  private static boolean FunctionCall_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCall_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nameAndArgs(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!nameAndArgs(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionCall_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'function' FunctionName FunctionBody
  public static boolean FunctionDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionDeclaration")) return false;
    if (!nextTokenIs(b, FUNCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNCTION);
    r = r && FunctionName(b, l + 1);
    r = r && FunctionBody(b, l + 1);
    exit_section_(b, m, FUNCTION_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ('.' IDENTIFIER)* (':' IDENTIFIER)?
  public static boolean FunctionName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && FunctionName_1(b, l + 1);
    r = r && FunctionName_2(b, l + 1);
    exit_section_(b, m, FUNCTION_NAME, r);
    return r;
  }

  // ('.' IDENTIFIER)*
  private static boolean FunctionName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionName_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!FunctionName_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FunctionName_1", c)) break;
    }
    return true;
  }

  // '.' IDENTIFIER
  private static boolean FunctionName_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionName_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (':' IDENTIFIER)?
  private static boolean FunctionName_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionName_2")) return false;
    FunctionName_2_0(b, l + 1);
    return true;
  }

  // ':' IDENTIFIER
  private static boolean FunctionName_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionName_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('<' GenericTypeList '>')? '(' (TypeList)? ')' '->' ReturnType
  public static boolean FunctionType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType")) return false;
    if (!nextTokenIs(b, "<function type>", LPAREN, LT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_TYPE, "<function type>");
    r = FunctionType_0(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && FunctionType_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && consumeToken(b, "->");
    r = r && ReturnType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('<' GenericTypeList '>')?
  private static boolean FunctionType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType_0")) return false;
    FunctionType_0_0(b, l + 1);
    return true;
  }

  // '<' GenericTypeList '>'
  private static boolean FunctionType_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LT);
    r = r && GenericTypeList(b, l + 1);
    r = r && consumeToken(b, GT);
    exit_section_(b, m, null, r);
    return r;
  }

  // (TypeList)?
  private static boolean FunctionType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType_2")) return false;
    FunctionType_2_0(b, l + 1);
    return true;
  }

  // (TypeList)
  private static boolean FunctionType_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypeList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (IDENTIFIER (',' GenericTypeList)?) | (GenericTypePackParameter (',' GenericTypePackParameter)*)
  public static boolean GenericTypeList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeList")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GenericTypeList_0(b, l + 1);
    if (!r) r = GenericTypeList_1(b, l + 1);
    exit_section_(b, m, GENERIC_TYPE_LIST, r);
    return r;
  }

  // IDENTIFIER (',' GenericTypeList)?
  private static boolean GenericTypeList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeList_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && GenericTypeList_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' GenericTypeList)?
  private static boolean GenericTypeList_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeList_0_1")) return false;
    GenericTypeList_0_1_0(b, l + 1);
    return true;
  }

  // ',' GenericTypeList
  private static boolean GenericTypeList_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeList_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && GenericTypeList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // GenericTypePackParameter (',' GenericTypePackParameter)*
  private static boolean GenericTypeList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeList_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GenericTypePackParameter(b, l + 1);
    r = r && GenericTypeList_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' GenericTypePackParameter)*
  private static boolean GenericTypeList_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeList_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!GenericTypeList_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GenericTypeList_1_1", c)) break;
    }
    return true;
  }

  // ',' GenericTypePackParameter
  private static boolean GenericTypeList_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeList_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && GenericTypePackParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (GenericTypeList (',' GenericTypePackParameterWithDefault)*) |
  //     (IDENTIFIER (',' IDENTIFIER)* (',' IDENTIFIER '=' Type)* (',' GenericTypePackParameterWithDefault)*) |
  //     (IDENTIFIER '=' Type (',' GenericTypePackParameterWithDefault)*) |
  //     (GenericTypePackParameterWithDefault (',' GenericTypePackParameterWithDefault)*)
  public static boolean GenericTypeListWithDefaults(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeListWithDefaults")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GenericTypeListWithDefaults_0(b, l + 1);
    if (!r) r = GenericTypeListWithDefaults_1(b, l + 1);
    if (!r) r = GenericTypeListWithDefaults_2(b, l + 1);
    if (!r) r = GenericTypeListWithDefaults_3(b, l + 1);
    exit_section_(b, m, GENERIC_TYPE_LIST_WITH_DEFAULTS, r);
    return r;
  }

  // GenericTypeList (',' GenericTypePackParameterWithDefault)*
  private static boolean GenericTypeListWithDefaults_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeListWithDefaults_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GenericTypeList(b, l + 1);
    r = r && GenericTypeListWithDefaults_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' GenericTypePackParameterWithDefault)*
  private static boolean GenericTypeListWithDefaults_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeListWithDefaults_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!GenericTypeListWithDefaults_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GenericTypeListWithDefaults_0_1", c)) break;
    }
    return true;
  }

  // ',' GenericTypePackParameterWithDefault
  private static boolean GenericTypeListWithDefaults_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeListWithDefaults_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && GenericTypePackParameterWithDefault(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER (',' IDENTIFIER)* (',' IDENTIFIER '=' Type)* (',' GenericTypePackParameterWithDefault)*
  private static boolean GenericTypeListWithDefaults_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeListWithDefaults_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && GenericTypeListWithDefaults_1_1(b, l + 1);
    r = r && GenericTypeListWithDefaults_1_2(b, l + 1);
    r = r && GenericTypeListWithDefaults_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' IDENTIFIER)*
  private static boolean GenericTypeListWithDefaults_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeListWithDefaults_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!GenericTypeListWithDefaults_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GenericTypeListWithDefaults_1_1", c)) break;
    }
    return true;
  }

  // ',' IDENTIFIER
  private static boolean GenericTypeListWithDefaults_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeListWithDefaults_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' IDENTIFIER '=' Type)*
  private static boolean GenericTypeListWithDefaults_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeListWithDefaults_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!GenericTypeListWithDefaults_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GenericTypeListWithDefaults_1_2", c)) break;
    }
    return true;
  }

  // ',' IDENTIFIER '=' Type
  private static boolean GenericTypeListWithDefaults_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeListWithDefaults_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, IDENTIFIER, EQ);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' GenericTypePackParameterWithDefault)*
  private static boolean GenericTypeListWithDefaults_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeListWithDefaults_1_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!GenericTypeListWithDefaults_1_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GenericTypeListWithDefaults_1_3", c)) break;
    }
    return true;
  }

  // ',' GenericTypePackParameterWithDefault
  private static boolean GenericTypeListWithDefaults_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeListWithDefaults_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && GenericTypePackParameterWithDefault(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER '=' Type (',' GenericTypePackParameterWithDefault)*
  private static boolean GenericTypeListWithDefaults_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeListWithDefaults_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, EQ);
    r = r && Type(b, l + 1);
    r = r && GenericTypeListWithDefaults_2_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' GenericTypePackParameterWithDefault)*
  private static boolean GenericTypeListWithDefaults_2_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeListWithDefaults_2_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!GenericTypeListWithDefaults_2_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GenericTypeListWithDefaults_2_3", c)) break;
    }
    return true;
  }

  // ',' GenericTypePackParameterWithDefault
  private static boolean GenericTypeListWithDefaults_2_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeListWithDefaults_2_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && GenericTypePackParameterWithDefault(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // GenericTypePackParameterWithDefault (',' GenericTypePackParameterWithDefault)*
  private static boolean GenericTypeListWithDefaults_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeListWithDefaults_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GenericTypePackParameterWithDefault(b, l + 1);
    r = r && GenericTypeListWithDefaults_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' GenericTypePackParameterWithDefault)*
  private static boolean GenericTypeListWithDefaults_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeListWithDefaults_3_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!GenericTypeListWithDefaults_3_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GenericTypeListWithDefaults_3_1", c)) break;
    }
    return true;
  }

  // ',' GenericTypePackParameterWithDefault
  private static boolean GenericTypeListWithDefaults_3_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypeListWithDefaults_3_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && GenericTypePackParameterWithDefault(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER '...'
  public static boolean GenericTypePack(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypePack")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, ELLIPSIS);
    exit_section_(b, m, GENERIC_TYPE_PACK, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER '...'
  public static boolean GenericTypePackParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypePackParameter")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, ELLIPSIS);
    exit_section_(b, m, GENERIC_TYPE_PACK_PARAMETER, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER '...' '=' (TypePack | VariadicTypePack | GenericTypePack)
  public static boolean GenericTypePackParameterWithDefault(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypePackParameterWithDefault")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, ELLIPSIS, EQ);
    r = r && GenericTypePackParameterWithDefault_3(b, l + 1);
    exit_section_(b, m, GENERIC_TYPE_PACK_PARAMETER_WITH_DEFAULT, r);
    return r;
  }

  // TypePack | VariadicTypePack | GenericTypePack
  private static boolean GenericTypePackParameterWithDefault_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GenericTypePackParameterWithDefault_3")) return false;
    boolean r;
    r = TypePack(b, l + 1);
    if (!r) r = VariadicTypePack(b, l + 1);
    if (!r) r = GenericTypePack(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'if' Exp 'then' block
  public static boolean IfBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfBlock")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && Exp(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && block(b, l + 1);
    exit_section_(b, m, IF_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // IfBlock ElseIfBlock* ElseBlock? 'end'
  public static boolean IfElseChain(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfElseChain")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = IfBlock(b, l + 1);
    r = r && IfElseChain_1(b, l + 1);
    r = r && IfElseChain_2(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, IF_ELSE_CHAIN, r);
    return r;
  }

  // ElseIfBlock*
  private static boolean IfElseChain_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfElseChain_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ElseIfBlock(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "IfElseChain_1", c)) break;
    }
    return true;
  }

  // ElseBlock?
  private static boolean IfElseChain_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfElseChain_2")) return false;
    ElseBlock(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'if' Exp 'then' Exp ('elseif' Exp 'then' Exp)* 'else' Exp
  public static boolean IfElseExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfElseExp")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && Exp(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && Exp(b, l + 1);
    r = r && IfElseExp_4(b, l + 1);
    r = r && consumeToken(b, ELSE);
    r = r && Exp(b, l + 1);
    exit_section_(b, m, IF_ELSE_EXP, r);
    return r;
  }

  // ('elseif' Exp 'then' Exp)*
  private static boolean IfElseExp_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfElseExp_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!IfElseExp_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "IfElseExp_4", c)) break;
    }
    return true;
  }

  // 'elseif' Exp 'then' Exp
  private static boolean IfElseExp_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfElseExp_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSEIF);
    r = r && Exp(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && Exp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('&' SimpleType)*
  public static boolean IntersectionSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IntersectionSuffix")) return false;
    Marker m = enter_section_(b, l, _NONE_, INTERSECTION_SUFFIX, "<intersection suffix>");
    while (true) {
      int c = current_position_(b);
      if (!IntersectionSuffix_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "IntersectionSuffix", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // '&' SimpleType
  private static boolean IntersectionSuffix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IntersectionSuffix_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "&");
    r = r && SimpleType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ('return' ExpList?) | 'break' | 'continue'
  public static boolean LastStat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LastStat")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAST_STAT, "<last stat>");
    r = LastStat_0(b, l + 1);
    if (!r) r = consumeToken(b, BREAK);
    if (!r) r = consumeToken(b, "continue");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'return' ExpList?
  private static boolean LastStat_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LastStat_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && LastStat_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ExpList?
  private static boolean LastStat_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LastStat_0_1")) return false;
    ExpList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'local' BindingList ('=' ExpList)?
  public static boolean LocalAssignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LocalAssignment")) return false;
    if (!nextTokenIs(b, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOCAL);
    r = r && BindingList(b, l + 1);
    r = r && LocalAssignment_2(b, l + 1);
    exit_section_(b, m, LOCAL_ASSIGNMENT, r);
    return r;
  }

  // ('=' ExpList)?
  private static boolean LocalAssignment_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LocalAssignment_2")) return false;
    LocalAssignment_2_0(b, l + 1);
    return true;
  }

  // '=' ExpList
  private static boolean LocalAssignment_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LocalAssignment_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && ExpList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'local' 'function' IDENTIFIER FunctionBody
  public static boolean LocalFunctionDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LocalFunctionDeclaration")) return false;
    if (!nextTokenIs(b, LOCAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LOCAL, FUNCTION, IDENTIFIER);
    r = r && FunctionBody(b, l + 1);
    exit_section_(b, m, LOCAL_FUNCTION_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (',' IDENTIFIER)*
  public static boolean NameList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NameList")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && NameList_1(b, l + 1);
    exit_section_(b, m, NAME_LIST, r);
    return r;
  }

  // (',' IDENTIFIER)*
  private static boolean NameList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NameList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!NameList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "NameList_1", c)) break;
    }
    return true;
  }

  // ',' IDENTIFIER
  private static boolean NameList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NameList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NUMBER | HEX_NUMBER | BINARY_NUMBER
  public static boolean NumberLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumberLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER_LITERAL, "<number literal>");
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, HEX_NUMBER);
    if (!r) r = consumeToken(b, BINARY_NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (BindingList (',' '...')?) | '...'
  public static boolean ParamList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamList")) return false;
    if (!nextTokenIs(b, "<param list>", ELLIPSIS, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM_LIST, "<param list>");
    r = ParamList_0(b, l + 1);
    if (!r) r = consumeToken(b, ELLIPSIS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BindingList (',' '...')?
  private static boolean ParamList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamList_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BindingList(b, l + 1);
    r = r && ParamList_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' '...')?
  private static boolean ParamList_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamList_0_1")) return false;
    ParamList_0_1_0(b, l + 1);
    return true;
  }

  // ',' '...'
  private static boolean ParamList_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParamList_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, ELLIPSIS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VarOrExp nameAndArgs*
  public static boolean PrefixExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixExp")) return false;
    if (!nextTokenIs(b, "<prefix exp>", IDENTIFIER, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREFIX_EXP, "<prefix exp>");
    r = VarOrExp(b, l + 1);
    r = r && PrefixExp_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // nameAndArgs*
  private static boolean PrefixExp_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixExp_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nameAndArgs(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PrefixExp_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // TablePropOrIndexer (FieldSep TablePropOrIndexer)* (FieldSep)?
  public static boolean PropList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropList")) return false;
    if (!nextTokenIs(b, "<prop list>", IDENTIFIER, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROP_LIST, "<prop list>");
    r = TablePropOrIndexer(b, l + 1);
    r = r && PropList_1(b, l + 1);
    r = r && PropList_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (FieldSep TablePropOrIndexer)*
  private static boolean PropList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PropList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PropList_1", c)) break;
    }
    return true;
  }

  // FieldSep TablePropOrIndexer
  private static boolean PropList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FieldSep(b, l + 1);
    r = r && TablePropOrIndexer(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (FieldSep)?
  private static boolean PropList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropList_2")) return false;
    PropList_2_0(b, l + 1);
    return true;
  }

  // (FieldSep)
  private static boolean PropList_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropList_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FieldSep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'repeat' block 'until' Exp
  public static boolean RepeatBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RepeatBlock")) return false;
    if (!nextTokenIs(b, REPEAT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REPEAT);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, UNTIL);
    r = r && Exp(b, l + 1);
    exit_section_(b, m, REPEAT_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // Type | TypePack
  public static boolean ReturnType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RETURN_TYPE, "<return type>");
    r = Type(b, l + 1);
    if (!r) r = TypePack(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NumberLiteral | StringLiteral | 'nil' | 'true' | 'false' | '...' | TableConstructor | AnonymousFunction | PrefixExp | IfElseExp | StringInterp
  public static boolean SimpleExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleExp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_EXP, "<simple exp>");
    r = NumberLiteral(b, l + 1);
    if (!r) r = StringLiteral(b, l + 1);
    if (!r) r = consumeToken(b, NIL);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, ELLIPSIS);
    if (!r) r = TableConstructor(b, l + 1);
    if (!r) r = AnonymousFunction(b, l + 1);
    if (!r) r = PrefixExp(b, l + 1);
    if (!r) r = IfElseExp(b, l + 1);
    if (!r) r = StringInterp(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'nil' |
  //     SingletonType |
  //     (IDENTIFIER ('.' IDENTIFIER) ('<' (TypeParams)? '>')?) |
  //     ('typeof' '(' Exp ')') |
  //     TableType |
  //     FunctionType |
  //     ('(' Type ')')
  public static boolean SimpleType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_TYPE, "<simple type>");
    r = consumeToken(b, NIL);
    if (!r) r = SingletonType(b, l + 1);
    if (!r) r = SimpleType_2(b, l + 1);
    if (!r) r = SimpleType_3(b, l + 1);
    if (!r) r = TableType(b, l + 1);
    if (!r) r = FunctionType(b, l + 1);
    if (!r) r = SimpleType_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER ('.' IDENTIFIER) ('<' (TypeParams)? '>')?
  private static boolean SimpleType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleType_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && SimpleType_2_1(b, l + 1);
    r = r && SimpleType_2_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '.' IDENTIFIER
  private static boolean SimpleType_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleType_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('<' (TypeParams)? '>')?
  private static boolean SimpleType_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleType_2_2")) return false;
    SimpleType_2_2_0(b, l + 1);
    return true;
  }

  // '<' (TypeParams)? '>'
  private static boolean SimpleType_2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleType_2_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LT);
    r = r && SimpleType_2_2_0_1(b, l + 1);
    r = r && consumeToken(b, GT);
    exit_section_(b, m, null, r);
    return r;
  }

  // (TypeParams)?
  private static boolean SimpleType_2_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleType_2_2_0_1")) return false;
    SimpleType_2_2_0_1_0(b, l + 1);
    return true;
  }

  // (TypeParams)
  private static boolean SimpleType_2_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleType_2_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypeParams(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'typeof' '(' Exp ')'
  private static boolean SimpleType_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleType_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "typeof");
    r = r && consumeToken(b, LPAREN);
    r = r && Exp(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' Type ')'
  private static boolean SimpleType_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SimpleType_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && Type(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // StringLiteral | 'true' | 'false'
  public static boolean SingletonType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SingletonType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SINGLETON_TYPE, "<singleton type>");
    r = StringLiteral(b, l + 1);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // INTERP_BEGIN Exp ( INTERP_MID Exp )* INTERP_END
  public static boolean StringInterp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringInterp")) return false;
    if (!nextTokenIs(b, INTERP_BEGIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTERP_BEGIN);
    r = r && Exp(b, l + 1);
    r = r && StringInterp_2(b, l + 1);
    r = r && consumeToken(b, INTERP_END);
    exit_section_(b, m, STRING_INTERP, r);
    return r;
  }

  // ( INTERP_MID Exp )*
  private static boolean StringInterp_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringInterp_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!StringInterp_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StringInterp_2", c)) break;
    }
    return true;
  }

  // INTERP_MID Exp
  private static boolean StringInterp_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringInterp_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTERP_MID);
    r = r && Exp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NORMAL_STRING | CHAR_STRING | GRAVE_STRING | LONG_STRING
  public static boolean StringLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StringLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_LITERAL, "<string literal>");
    r = consumeToken(b, NORMAL_STRING);
    if (!r) r = consumeToken(b, CHAR_STRING);
    if (!r) r = consumeToken(b, GRAVE_STRING);
    if (!r) r = consumeToken(b, LONG_STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' (FieldList)? '}'
  public static boolean TableConstructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TableConstructor")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && TableConstructor_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, TABLE_CONSTRUCTOR, r);
    return r;
  }

  // (FieldList)?
  private static boolean TableConstructor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TableConstructor_1")) return false;
    TableConstructor_1_0(b, l + 1);
    return true;
  }

  // (FieldList)
  private static boolean TableConstructor_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TableConstructor_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FieldList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '[' Type ']' ':' Type
  public static boolean TableIndexer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TableIndexer")) return false;
    if (!nextTokenIs(b, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && Type(b, l + 1);
    r = r && consumeTokens(b, 0, RBRACK, COLON);
    r = r && Type(b, l + 1);
    exit_section_(b, m, TABLE_INDEXER, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ':' Type
  public static boolean TableProp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TableProp")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, COLON);
    r = r && Type(b, l + 1);
    exit_section_(b, m, TABLE_PROP, r);
    return r;
  }

  /* ********************************************************** */
  // TableProp | TableIndexer
  public static boolean TablePropOrIndexer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TablePropOrIndexer")) return false;
    if (!nextTokenIs(b, "<table prop or indexer>", IDENTIFIER, LBRACK)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TABLE_PROP_OR_INDEXER, "<table prop or indexer>");
    r = TableProp(b, l + 1);
    if (!r) r = TableIndexer(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' (PropList)? '}'
  public static boolean TableType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TableType")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && TableType_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, TABLE_TYPE, r);
    return r;
  }

  // (PropList)?
  private static boolean TableType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TableType_1")) return false;
    TableType_1_0(b, l + 1);
    return true;
  }

  // (PropList)
  private static boolean TableType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TableType_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PropList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SimpleType (UnionSuffix | IntersectionSuffix)
  public static boolean Type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = SimpleType(b, l + 1);
    r = r && Type_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // UnionSuffix | IntersectionSuffix
  private static boolean Type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_1")) return false;
    boolean r;
    r = UnionSuffix(b, l + 1);
    if (!r) r = IntersectionSuffix(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ('export')? 'type' IDENTIFIER ('<' GenericTypeListWithDefaults '>')? '=' Type
  public static boolean TypeDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DECLARATION, "<type declaration>");
    r = TypeDeclaration_0(b, l + 1);
    r = r && consumeToken(b, "type");
    r = r && consumeToken(b, IDENTIFIER);
    r = r && TypeDeclaration_3(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && Type(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('export')?
  private static boolean TypeDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDeclaration_0")) return false;
    TypeDeclaration_0_0(b, l + 1);
    return true;
  }

  // ('export')
  private static boolean TypeDeclaration_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDeclaration_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "export");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('<' GenericTypeListWithDefaults '>')?
  private static boolean TypeDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDeclaration_3")) return false;
    TypeDeclaration_3_0(b, l + 1);
    return true;
  }

  // '<' GenericTypeListWithDefaults '>'
  private static boolean TypeDeclaration_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeDeclaration_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LT);
    r = r && GenericTypeListWithDefaults(b, l + 1);
    r = r && consumeToken(b, GT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (Type (',' TypeList)?) | ('...' Type)
  public static boolean TypeList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_LIST, "<type list>");
    r = TypeList_0(b, l + 1);
    if (!r) r = TypeList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Type (',' TypeList)?
  private static boolean TypeList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeList_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Type(b, l + 1);
    r = r && TypeList_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' TypeList)?
  private static boolean TypeList_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeList_0_1")) return false;
    TypeList_0_1_0(b, l + 1);
    return true;
  }

  // ',' TypeList
  private static boolean TypeList_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeList_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypeList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '...' Type
  private static boolean TypeList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeList_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELLIPSIS);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(' (TypeList)? ')'
  public static boolean TypePack(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypePack")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && TypePack_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, TYPE_PACK, r);
    return r;
  }

  // (TypeList)?
  private static boolean TypePack_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypePack_1")) return false;
    TypePack_1_0(b, l + 1);
    return true;
  }

  // (TypeList)
  private static boolean TypePack_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypePack_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypeList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (Type | TypePack | VariadicTypePack | GenericTypePack) (',' TypeParams)?
  public static boolean TypeParams(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParams")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, TYPE_PARAMS, "<type params>");
    r = TypeParams_0(b, l + 1);
    r = r && TypeParams_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Type | TypePack | VariadicTypePack | GenericTypePack
  private static boolean TypeParams_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParams_0")) return false;
    boolean r;
    r = Type(b, l + 1);
    if (!r) r = TypePack(b, l + 1);
    if (!r) r = VariadicTypePack(b, l + 1);
    if (!r) r = GenericTypePack(b, l + 1);
    return r;
  }

  // (',' TypeParams)?
  private static boolean TypeParams_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParams_1")) return false;
    TypeParams_1_0(b, l + 1);
    return true;
  }

  // ',' TypeParams
  private static boolean TypeParams_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeParams_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && TypeParams(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '-' | 'not' | '#'
  public static boolean UnaryOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_OP, "<unary op>");
    r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, HASH);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ('?')* ('|' SimpleType ('?')*)+
  public static boolean UnionSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnionSuffix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNION_SUFFIX, "<union suffix>");
    r = UnionSuffix_0(b, l + 1);
    r = r && UnionSuffix_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ('?')*
  private static boolean UnionSuffix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnionSuffix_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!UnionSuffix_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "UnionSuffix_0", c)) break;
    }
    return true;
  }

  // ('?')
  private static boolean UnionSuffix_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnionSuffix_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "?");
    exit_section_(b, m, null, r);
    return r;
  }

  // ('|' SimpleType ('?')*)+
  private static boolean UnionSuffix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnionSuffix_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = UnionSuffix_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!UnionSuffix_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "UnionSuffix_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // '|' SimpleType ('?')*
  private static boolean UnionSuffix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnionSuffix_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "|");
    r = r && SimpleType(b, l + 1);
    r = r && UnionSuffix_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('?')*
  private static boolean UnionSuffix_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnionSuffix_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!UnionSuffix_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "UnionSuffix_1_0_2", c)) break;
    }
    return true;
  }

  // ('?')
  private static boolean UnionSuffix_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnionSuffix_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "?");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (IDENTIFIER | '(' Exp ')' VarSuffix) VarSuffix*
  public static boolean Var(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Var")) return false;
    if (!nextTokenIs(b, "<var>", IDENTIFIER, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR, "<var>");
    r = Var_0(b, l + 1);
    r = r && Var_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER | '(' Exp ')' VarSuffix
  private static boolean Var_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Var_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = Var_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' Exp ')' VarSuffix
  private static boolean Var_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Var_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && Exp(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && VarSuffix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VarSuffix*
  private static boolean Var_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Var_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!VarSuffix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Var_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // Var (',' Var)*
  public static boolean VarList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarList")) return false;
    if (!nextTokenIs(b, "<var list>", IDENTIFIER, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_LIST, "<var list>");
    r = Var(b, l + 1);
    r = r && VarList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' Var)*
  private static boolean VarList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!VarList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VarList_1", c)) break;
    }
    return true;
  }

  // ',' Var
  private static boolean VarList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Var(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Var | '(' Exp ')'
  static boolean VarOrExp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarOrExp")) return false;
    if (!nextTokenIs(b, "", IDENTIFIER, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Var(b, l + 1);
    if (!r) r = VarOrExp_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' Exp ')'
  private static boolean VarOrExp_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarOrExp_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && Exp(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // nameAndArgs* ('[' Exp ']' | '.' IDENTIFIER)
  static boolean VarSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarSuffix")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VarSuffix_0(b, l + 1);
    r = r && VarSuffix_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nameAndArgs*
  private static boolean VarSuffix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarSuffix_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nameAndArgs(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VarSuffix_0", c)) break;
    }
    return true;
  }

  // '[' Exp ']' | '.' IDENTIFIER
  private static boolean VarSuffix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarSuffix_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VarSuffix_1_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' Exp ']'
  private static boolean VarSuffix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarSuffix_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && Exp(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '...' Type
  public static boolean VariadicTypePack(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariadicTypePack")) return false;
    if (!nextTokenIs(b, ELLIPSIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELLIPSIS);
    r = r && Type(b, l + 1);
    exit_section_(b, m, VARIADIC_TYPE_PACK, r);
    return r;
  }

  /* ********************************************************** */
  // 'while' Exp 'do' block 'end'
  public static boolean WhileBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileBlock")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && Exp(b, l + 1);
    r = r && consumeToken(b, DO);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, WHILE_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // (stat ';'?)* (LastStat ';'?)?
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK, "<block>");
    r = block_0(b, l + 1);
    r = r && block_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (stat ';'?)*
  private static boolean block_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!block_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_0", c)) break;
    }
    return true;
  }

  // stat ';'?
  private static boolean block_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stat(b, l + 1);
    r = r && block_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ';'?
  private static boolean block_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_0_0_1")) return false;
    consumeToken(b, SEMI);
    return true;
  }

  // (LastStat ';'?)?
  private static boolean block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_1")) return false;
    block_1_0(b, l + 1);
    return true;
  }

  // LastStat ';'?
  private static boolean block_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = LastStat(b, l + 1);
    r = r && block_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ';'?
  private static boolean block_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_1_0_1")) return false;
    consumeToken(b, SEMI);
    return true;
  }

  /* ********************************************************** */
  // block
  static boolean chunk(PsiBuilder b, int l) {
    return block(b, l + 1);
  }

  /* ********************************************************** */
  // (':' IDENTIFIER)? FunctionArgs
  static boolean nameAndArgs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameAndArgs")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nameAndArgs_0(b, l + 1);
    r = r && FunctionArgs(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (':' IDENTIFIER)?
  private static boolean nameAndArgs_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameAndArgs_0")) return false;
    nameAndArgs_0_0(b, l + 1);
    return true;
  }

  // ':' IDENTIFIER
  private static boolean nameAndArgs_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameAndArgs_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Assignment |
  //     CompoundAssignment |
  //     FunctionCall |
  //     DoBlock |
  //     WhileBlock |
  //     RepeatBlock |
  //     IfElseChain |
  //     ForRangeBlock |
  //     ForValuesBlock |
  //     FunctionDeclaration |
  //     LocalFunctionDeclaration |
  //     LocalAssignment |
  //     TypeDeclaration
  public static boolean stat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STAT, "<stat>");
    r = Assignment(b, l + 1);
    if (!r) r = CompoundAssignment(b, l + 1);
    if (!r) r = FunctionCall(b, l + 1);
    if (!r) r = DoBlock(b, l + 1);
    if (!r) r = WhileBlock(b, l + 1);
    if (!r) r = RepeatBlock(b, l + 1);
    if (!r) r = IfElseChain(b, l + 1);
    if (!r) r = ForRangeBlock(b, l + 1);
    if (!r) r = ForValuesBlock(b, l + 1);
    if (!r) r = FunctionDeclaration(b, l + 1);
    if (!r) r = LocalFunctionDeclaration(b, l + 1);
    if (!r) r = LocalAssignment(b, l + 1);
    if (!r) r = TypeDeclaration(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
