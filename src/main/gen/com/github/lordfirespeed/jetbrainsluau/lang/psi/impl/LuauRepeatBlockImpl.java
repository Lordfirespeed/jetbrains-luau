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

public class LuauRepeatBlockImpl extends ASTWrapperPsiElement implements LuauRepeatBlock {

  public LuauRepeatBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuauVisitor visitor) {
    visitor.visitRepeatBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuauVisitor) accept((LuauVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public LuauExp getExp() {
    return findNotNullChildByClass(LuauExp.class);
  }

  @Override
  @NotNull
  public LuauBlock getBlock() {
    return findNotNullChildByClass(LuauBlock.class);
  }

}
