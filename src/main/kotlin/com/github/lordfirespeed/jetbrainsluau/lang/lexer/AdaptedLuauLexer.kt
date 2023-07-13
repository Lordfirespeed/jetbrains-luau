package com.github.lordfirespeed.jetbrainsluau.lang.lexer

import com.github.lordfirespeed.jetbrainsluau.lang.LuauLanguage
import com.github.lordfirespeed.jetbrainsluau.gen.lang.LuauLexer as _LuauLexer
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor

class AdaptedLuauLexer : ANTLRLexerAdaptor(LuauLanguage, _LuauLexer(null))