// This is a generated file. Not intended for manual editing.
package com.github.lordfirespeed.jetbrainsluau.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LuauStat extends PsiElement {

  @Nullable
  LuauAssignment getAssignment();

  @Nullable
  LuauCompoundAssignment getCompoundAssignment();

  @Nullable
  LuauDoBlock getDoBlock();

  @Nullable
  LuauForRangeBlock getForRangeBlock();

  @Nullable
  LuauForValuesBlock getForValuesBlock();

  @Nullable
  LuauFunctionCall getFunctionCall();

  @Nullable
  LuauFunctionDeclaration getFunctionDeclaration();

  @Nullable
  LuauIfElseChain getIfElseChain();

  @Nullable
  LuauLocalAssignment getLocalAssignment();

  @Nullable
  LuauLocalFunctionDeclaration getLocalFunctionDeclaration();

  @Nullable
  LuauRepeatBlock getRepeatBlock();

  @Nullable
  LuauTypeDeclaration getTypeDeclaration();

  @Nullable
  LuauWhileBlock getWhileBlock();

}
