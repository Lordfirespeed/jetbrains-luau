package com.github.lordfirespeed.jetbrainsluau

import com.intellij.ide.highlighter.XmlFileType
import com.intellij.psi.xml.XmlFile
import com.intellij.testFramework.TestDataPath
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import com.intellij.util.PsiErrorElementUtil

@TestDataPath("\$CONTENT_ROOT/src/test/testData")
class LuauPluginTest : BasePlatformTestCase() {
    override fun getTestDataPath() = "src/test/testData/rename"
}
