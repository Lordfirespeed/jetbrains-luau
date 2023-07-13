package com.github.lordfirespeed.jetbrainsluau.lang.psi

import com.github.lordfirespeed.jetbrainsluau.gen.lang.LuauParser
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode

class LuauElementTypes {
    object Factory {
        fun createElement(node: ASTNode): PsiElement {
            if (node.elementType is TokenIElementType) {
                return ANTLRPsiNode(node)
            }
            if (node.elementType !is RuleIElementType) {
                return ANTLRPsiNode(node)
            }
            val ruleElementIndex = (node.elementType as RuleIElementType).ruleIndex
            return ANTLRPsiNode(node)
        }
    }
}