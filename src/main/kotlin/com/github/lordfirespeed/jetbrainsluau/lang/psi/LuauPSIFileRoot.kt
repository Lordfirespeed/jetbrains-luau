package com.github.lordfirespeed.jetbrainsluau.lang.psi

import com.github.lordfirespeed.jetbrainsluau.LuauIcons
import com.github.lordfirespeed.jetbrainsluau.lang.LuauFileType
import com.github.lordfirespeed.jetbrainsluau.lang.LuauLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.SymtabUtils
import org.antlr.intellij.adaptor.psi.ScopeNode
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable


class LuauPSIFileRoot(viewProvider: @NotNull FileViewProvider) : PsiFileBase(viewProvider, LuauLanguage), ScopeNode {
    override fun getFileType() = LuauFileType

    override fun toString() = "Luau file"

    override fun getIcon(flags: Int) = LuauIcons.LUAU

    /** Return null since a file scope has no enclosing scope. It is
     * not itself in a scope.
     */
    override fun getContext(): ScopeNode? {
        return null
    }

    @Nullable
    override fun resolve(element: PsiNamedElement): PsiElement? {
//		System.out.println(getClass().getSimpleName()+
//		                   ".resolve("+element.getName()+
//		                   " at "+Integer.toHexString(element.hashCode())+")");
        return if (element.getParent() is CallSubtree) {
            SymtabUtils.resolve(this, LuauLanguage, element, "/script/function/ID")
        } else SymtabUtils.resolve(this, LuauLanguage, element, "/script/vardef/ID")
    }
}