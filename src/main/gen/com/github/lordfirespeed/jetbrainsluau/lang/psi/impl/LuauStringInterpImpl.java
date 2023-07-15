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

public class LuauStringInterpImpl extends ASTWrapperPsiElement implements LuauStringInterp {

  public LuauStringInterpImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuauVisitor visitor) {
    visitor.visitStringInterp(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuauVisitor) accept((LuauVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LuauInterpFragment> getInterpFragmentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuauInterpFragment.class);
  }

  @Override
  @NotNull
  public List<LuauStringEscape> getStringEscapeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuauStringEscape.class);
  }

  @Override
  @NotNull
  public PsiElement getInterpStringEnd() {
    return findNotNullChildByType(INTERP_STRING_END);
  }

  @Override
  @NotNull
  public PsiElement getInterpStringStart() {
    return findNotNullChildByType(INTERP_STRING_START);
  }

}
