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

public class LuauStringLiteralImpl extends ASTWrapperPsiElement implements LuauStringLiteral {

  public LuauStringLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuauVisitor visitor) {
    visitor.visitStringLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuauVisitor) accept((LuauVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getCharString() {
    return findChildByType(CHAR_STRING);
  }

  @Override
  @Nullable
  public PsiElement getGraveString() {
    return findChildByType(GRAVE_STRING);
  }

  @Override
  @Nullable
  public PsiElement getLongString() {
    return findChildByType(LONG_STRING);
  }

  @Override
  @Nullable
  public PsiElement getNormalString() {
    return findChildByType(NORMAL_STRING);
  }

}
