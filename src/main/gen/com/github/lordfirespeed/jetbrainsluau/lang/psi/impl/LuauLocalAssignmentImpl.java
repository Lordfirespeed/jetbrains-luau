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

public class LuauLocalAssignmentImpl extends ASTWrapperPsiElement implements LuauLocalAssignment {

  public LuauLocalAssignmentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuauVisitor visitor) {
    visitor.visitLocalAssignment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuauVisitor) accept((LuauVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public LuauBindingList getBindingList() {
    return findNotNullChildByClass(LuauBindingList.class);
  }

  @Override
  @Nullable
  public LuauExpList getExpList() {
    return findChildByClass(LuauExpList.class);
  }

}
