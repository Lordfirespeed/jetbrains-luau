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

public class LuauStringEscapeImpl extends ASTWrapperPsiElement implements LuauStringEscape {

  public LuauStringEscapeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuauVisitor visitor) {
    visitor.visitStringEscape(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuauVisitor) accept((LuauVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getCharEscape() {
    return findChildByType(CHAR_ESCAPE);
  }

  @Override
  @Nullable
  public PsiElement getDecimalEscape() {
    return findChildByType(DECIMAL_ESCAPE);
  }

  @Override
  @Nullable
  public PsiElement getHexEscape() {
    return findChildByType(HEX_ESCAPE);
  }

  @Override
  @Nullable
  public PsiElement getNewlineEscape() {
    return findChildByType(NEWLINE_ESCAPE);
  }

  @Override
  @Nullable
  public PsiElement getUnicodeEscape() {
    return findChildByType(UNICODE_ESCAPE);
  }

}
