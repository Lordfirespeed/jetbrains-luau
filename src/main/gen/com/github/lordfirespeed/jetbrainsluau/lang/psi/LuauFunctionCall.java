// This is a generated file. Not intended for manual editing.
package com.github.lordfirespeed.jetbrainsluau.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LuauFunctionCall extends PsiElement {

  @Nullable
  LuauExp getExp();

  @NotNull
  List<LuauFunctionArgs> getFunctionArgsList();

  @Nullable
  LuauVar getVar();

}
