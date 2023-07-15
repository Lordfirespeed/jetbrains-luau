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

public class LuauIfElseChainImpl extends ASTWrapperPsiElement implements LuauIfElseChain {

  public LuauIfElseChainImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuauVisitor visitor) {
    visitor.visitIfElseChain(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuauVisitor) accept((LuauVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LuauElseBlock getElseBlock() {
    return findChildByClass(LuauElseBlock.class);
  }

  @Override
  @NotNull
  public List<LuauElseIfBlock> getElseIfBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuauElseIfBlock.class);
  }

  @Override
  @NotNull
  public LuauIfBlock getIfBlock() {
    return findNotNullChildByClass(LuauIfBlock.class);
  }

}
