// This is a generated file. Not intended for manual editing.
package com.github.lordfirespeed.jetbrainsluau.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LuauExp extends PsiElement {

  @NotNull
  List<LuauBinaryOp> getBinaryOpList();

  @NotNull
  List<LuauExp> getExpList();

  @Nullable
  LuauSimpleExp getSimpleExp();

  @Nullable
  LuauType getType();

  @Nullable
  LuauUnaryOp getUnaryOp();

}
