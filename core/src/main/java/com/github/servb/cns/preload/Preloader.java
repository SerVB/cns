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
package com.github.servb.cns.preload;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * The Container class.
 * <p>
 * An instance of the class is immutable.
 *
 * @author SerVB
 */
public final class Preloader {

    public static final String DATA_DIR_NAME = "data/";
    public static final String PRELOAD_DIR_NAME = "preload/";

    public static final String FONTS_FILE_NAME = "fonts.xml";

    public static final String FILE_LINK_ELEMENT = "object";

    public Preloader(final FileHandle cnsDir) throws FileNotFoundException {
        checkFile(cnsDir, "Root CNS dir");
        final FileHandle dataDir = getCheckedChild(cnsDir, DATA_DIR_NAME, "Data dir");
        final FileHandle preloadDir = getCheckedChild(dataDir, PRELOAD_DIR_NAME, "Preload dir");
        Gdx.app.log("OK", "Preload dir found");

        loadFonts(cnsDir, preloadDir);
    }

    private static FileHandle getCheckedChild(final FileHandle parent, final String path, final String name)
            throws FileNotFoundException {
        final FileHandle child = parent.child(path);
        checkFile(child, name);
        return child;
    }

    private static void checkFile(final FileHandle fh, final String name) throws FileNotFoundException {
        if (!fh.exists()) {
            throw new FileNotFoundException(name + " not found: " + fh.path());
        }
    }

    private static String[] getChildrenPaths(final FileHandle xmlFile) {
        final XmlReader xmlReader = new XmlReader();
        final Element hierarchy = xmlReader.parse(xmlFile);
        final Array<Element> links = hierarchy.getChildrenByName(FILE_LINK_ELEMENT);
        final String[] result = new String[links.size];
        for (int i = 0; i < result.length; ++i) {
            result[i] = links.get(i).getText();
        }
        return result;
    }

    private void loadFonts(final FileHandle cnsDir, final FileHandle preloadDir) throws FileNotFoundException {
        final FileHandle fontsFile = getCheckedChild(preloadDir, FONTS_FILE_NAME, "Fonts file");
        final String[] fontPaths = getChildrenPaths(fontsFile);
        Gdx.app.log("debug", Arrays.toString(fontPaths));
    }
}
