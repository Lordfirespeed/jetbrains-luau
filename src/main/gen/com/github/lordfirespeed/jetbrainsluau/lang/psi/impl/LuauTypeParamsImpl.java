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

public class LuauTypeParamsImpl extends ASTWrapperPsiElement implements LuauTypeParams {

  public LuauTypeParamsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuauVisitor visitor) {
    visitor.visitTypeParams(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuauVisitor) accept((LuauVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LuauGenericTypePack getGenericTypePack() {
    return findChildByClass(LuauGenericTypePack.class);
  }

  @Override
  @Nullable
  public LuauType getType() {
    return findChildByClass(LuauType.class);
  }

  @Override
  @Nullable
  public LuauTypePack getTypePack() {
    return findChildByClass(LuauTypePack.class);
  }

  @Override
  @Nullable
  public LuauTypeParams getTypeParams() {
    return findChildByClass(LuauTypeParams.class);
  }

  @Override
  @Nullable
  public LuauVariadicTypePack getVariadicTypePack() {
    return findChildByClass(LuauVariadicTypePack.class);
  }

}
