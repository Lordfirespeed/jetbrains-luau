// This is a generated file. Not intended for manual editing.
package com.github.lordfirespeed.jetbrainsluau.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LuauFunctionBody extends PsiElement {

  @Nullable
  LuauGenericTypeList getGenericTypeList();

  @Nullable
  LuauParamList getParamList();

  @Nullable
  LuauReturnType getReturnType();

  @NotNull
  LuauBlock getBlock();

}
