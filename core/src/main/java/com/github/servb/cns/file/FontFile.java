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
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import java.util.ArrayList;
import java.util.List;

/**
 * The Font class.
 * <p>
 * TODO: An instance of the class is immutable.
 *
 * @author SerVB
 */
public final class FontFile {

    private final BitmapFont bitmapFont;

    private static final class FontCharacter {
        public final int id, x, y, width, height;

        public FontCharacter(final int id, final int x, final int y, final int width, final int height) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    public FontFile(final FileHandle dataDir, final FileHandle xmlFile) {
        if (false) {
            final XmlReader xmlReader = new XmlReader();
            final XmlReader.Element font = xmlReader.parse(xmlFile);
            final Array<XmlReader.Element> charTags = font.getChildrenByName("character");
            final List<FontCharacter> parsedChars = new ArrayList<>();
            for (final Element charTag : charTags) {
                final int id = Integer.parseInt(charTag.getChildByName("id").getText());
                final int x = Integer.parseInt(charTag.getChildByName("x").getText());
                final int y = Integer.parseInt(charTag.getChildByName("y").getText());
                final int width = Integer.parseInt(charTag.getChildByName("width").getText());
                final int height = Integer.parseInt(charTag.getChildByName("height").getText());
                parsedChars.add(new FontCharacter(id, x, y, width, height));
            }
            final String texturePath = font.getChildByName("texturestage").getText();
            throw new UnsupportedOperationException("TODO: generate font from xml!");
        } else {
            bitmapFont = new BitmapFont();
        }
    }

    public BitmapFont getBitmapFont() {
        return bitmapFont;
    }

}
