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

public class LuauStatImpl extends ASTWrapperPsiElement implements LuauStat {

  public LuauStatImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuauVisitor visitor) {
    visitor.visitStat(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuauVisitor) accept((LuauVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LuauAssignment getAssignment() {
    return findChildByClass(LuauAssignment.class);
  }

  @Override
  @Nullable
  public LuauCompoundAssignment getCompoundAssignment() {
    return findChildByClass(LuauCompoundAssignment.class);
  }

  @Override
  @Nullable
  public LuauDoBlock getDoBlock() {
    return findChildByClass(LuauDoBlock.class);
  }

  @Override
  @Nullable
  public LuauForRangeBlock getForRangeBlock() {
    return findChildByClass(LuauForRangeBlock.class);
  }

  @Override
  @Nullable
  public LuauForValuesBlock getForValuesBlock() {
    return findChildByClass(LuauForValuesBlock.class);
  }

  @Override
  @Nullable
  public LuauFunctionCall getFunctionCall() {
    return findChildByClass(LuauFunctionCall.class);
  }

  @Override
  @Nullable
  public LuauFunctionDeclaration getFunctionDeclaration() {
    return findChildByClass(LuauFunctionDeclaration.class);
  }

  @Override
  @Nullable
  public LuauIfElseChain getIfElseChain() {
    return findChildByClass(LuauIfElseChain.class);
  }

  @Override
  @Nullable
  public LuauLocalAssignment getLocalAssignment() {
    return findChildByClass(LuauLocalAssignment.class);
  }

  @Override
  @Nullable
  public LuauLocalFunctionDeclaration getLocalFunctionDeclaration() {
    return findChildByClass(LuauLocalFunctionDeclaration.class);
  }

  @Override
  @Nullable
  public LuauRepeatBlock getRepeatBlock() {
    return findChildByClass(LuauRepeatBlock.class);
  }

  @Override
  @Nullable
  public LuauTypeDeclaration getTypeDeclaration() {
    return findChildByClass(LuauTypeDeclaration.class);
  }

  @Override
  @Nullable
  public LuauWhileBlock getWhileBlock() {
    return findChildByClass(LuauWhileBlock.class);
  }

}
