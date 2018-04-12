/*
 * Copyright 2018 SerVB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.servb.cns.file;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import com.github.servb.cns.preload.Preloader;
import java.util.HashMap;
import java.util.Map;

/**
 * The language file.
 *
 * @author SerVB
 */
public final class LanguageFile {

    public final Map<String, String> text = new HashMap<>();
    public final String name;

    public final FontFile font1;
    public final FontFile font2;

    public LanguageFile(final FileHandle dataDir, final FileHandle xmlFile) {
        final XmlReader xmlReader = new XmlReader();
        final Element hierarchy = xmlReader.parse(xmlFile);
        final Element rootObject = hierarchy.getChild(0); // <object name="English">...</object>
        name = rootObject.getAttribute("name");
        fillMapRec(rootObject, "");
        font1 = getFont("font1");
        font2 = getFont("font2");
    }

    private FontFile getFont(final String name) {
        final FontFile ans = Preloader.fonts.get(text.get(name));
        text.remove(name);
        return ans;
    }

    private void fillMapRec(final Element nowElement, final String nowPath) {
        final Array<Element> children = nowElement.getChildrenByName("object");
        if (children.size == 0) {
            text.put(nowPath, nowElement.getText());
        } else {
            for (final Element child : children) {
                fillMapRec(child, nowPath + "." + child.getAttribute("name"));
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getUnformatedString(final String key) {
        return text.get(key);
    }
}
