// This is a generated file. Not intended for manual editing.
package com.github.lordfirespeed.jetbrainsluau.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.lordfirespeed.jetbrainsluau.lang.psi.LuauTypeHolder.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.lordfirespeed.jetbrainsluau.lang.psi.*;

public class LuauSimpleExpImpl extends ASTWrapperPsiElement implements LuauSimpleExp {

  public LuauSimpleExpImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuauVisitor visitor) {
    visitor.visitSimpleExp(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuauVisitor) accept((LuauVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LuauAnonymousFunction getAnonymousFunction() {
    return findChildByClass(LuauAnonymousFunction.class);
  }

  @Override
  @Nullable
  public LuauIfElseExp getIfElseExp() {
    return findChildByClass(LuauIfElseExp.class);
  }

  @Override
  @Nullable
  public LuauNumberLiteral getNumberLiteral() {
    return findChildByClass(LuauNumberLiteral.class);
  }

  @Override
  @Nullable
  public LuauPrefixExp getPrefixExp() {
    return findChildByClass(LuauPrefixExp.class);
  }

  @Override
  @Nullable
  public LuauStringInterp getStringInterp() {
    return findChildByClass(LuauStringInterp.class);
  }

  @Override
  @Nullable
  public LuauStringLiteral getStringLiteral() {
    return findChildByClass(LuauStringLiteral.class);
  }

  @Override
  @Nullable
  public LuauTableConstructor getTableConstructor() {
    return findChildByClass(LuauTableConstructor.class);
  }

}
