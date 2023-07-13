package com.github.lordfirespeed.jetbrainsluau.lang.parser

import com.github.lordfirespeed.jetbrainsluau.lang.LuauLanguage
import org.antlr.intellij.adaptor.parser.ANTLRParserAdaptor
import com.github.lordfirespeed.jetbrainsluau.gen.lang.LuauParser as _LuauParser

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;

class AdaptedLuauParser : ANTLRParserAdaptor(LuauLanguage, _LuauParser(null)) {
    override fun parse(parser: Parser, root: IElementType?): ParseTree? {
        // start rule depends on root passed in; sometimes we want to create an ID node etc...
        return if (root is IFileElementType) {
            (parser as _LuauParser).chunk()
        } else
            (parser as _LuauParser).block()
        // let's hope it's an ID as needed by "rename function"
    }
}