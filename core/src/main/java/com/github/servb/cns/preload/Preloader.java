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
import com.github.servb.cns.file.FontFile;
import com.github.servb.cns.file.LanguageFile;
import com.github.servb.cns.util.Files;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The Preloader class contains game assets.
 * Provides static methods and fields to works with assets.
 * Initializes with load(...), disposes with dispose() methods.
 *
 * @author SerVB
 */
public final class Preloader {

    /** Prevents from creating an instance of the class. */
    private Preloader() {
    }

    /** Relative path to the "data/" dir from the CNS dir. */
    public static final String DATA_DIR_NAME = "data/";
    /** Relative path to the "preload/" dir from the "data/" dir. */
    public static final String PRELOAD_DIR_NAME = "preload/";
    /** Relative path to the "language/" dir from the "data/" dir. */
    public static final String LANGUAGE_DIR_NAME = "language/";

    /** The fonts file name in the "preload/" dir. */
    public static final String FONTS_FILE_NAME = "fonts.xml";

    /** The tag name in preload file contains the path to file to be preloaded. */
    public static final String FILE_LINK_ELEMENT = "object";

    /** Fonts container (Path from the CNS dir : FontFile). */
    public static Map<String, FontFile> fonts;
    /** Languages container (Language name : LanguageFile). */
    public static Map<String, LanguageFile> languages;

    /**
     * Launches the Preloader. Initializes containers.
     *
     * @param cnsDir                    The CNS dir (which contains "data/" dir).
     * @throws FileNotFoundException    If there is no needed file.
     */
    public static void load(final FileHandle cnsDir) throws FileNotFoundException {
        Files.checkFile(cnsDir, "Root CNS dir");
        final FileHandle dataDir = Files.getCheckedChild(cnsDir, DATA_DIR_NAME, "Data dir");
        final FileHandle preloadDir = Files.getCheckedChild(dataDir, PRELOAD_DIR_NAME, "Preload dir");
        Gdx.app.log("Preloader", "OK. Preload dir found");

        loadFonts(dataDir, preloadDir);
        loadLanguages(dataDir);
        Gdx.app.log("Preloader", "OK. Preloaded");
    }

    public static void dispose() {
        // TODO: implement
    }

    /**
     * Returns the array of paths to files to be preloaded for the preload file.
     *
     * @param xmlFile   The preload file.
     * @return          The array of paths.
     */
    public static String[] getChildrenPaths(final FileHandle xmlFile) {
        final XmlReader xmlReader = new XmlReader();
        final Element hierarchy = xmlReader.parse(xmlFile);
        final Array<Element> links = hierarchy.getChildrenByName(FILE_LINK_ELEMENT);
        final String[] result = new String[links.size];
        for (int i = 0; i < result.length; ++i) {
            result[i] = links.get(i).getText();
        }
        return result;
    }

    private static void loadFonts(final FileHandle dataDir, final FileHandle preloadDir) throws FileNotFoundException {
        final FileHandle fontsFile = Files.getCheckedChild(preloadDir, FONTS_FILE_NAME, "Fonts file");
        final String[] fontPaths = getChildrenPaths(fontsFile);
        final Map<String, FontFile> readFonts = new HashMap<>();
        for (final String fontPath : fontPaths) {
            final FileHandle font = Files.getCheckedChild(dataDir, fontPath, "Font");
            readFonts.put(fontPath, new FontFile(dataDir, font));
        }
        fonts = Collections.unmodifiableMap(readFonts);
    }

    private static void loadLanguages(final FileHandle dataDir)
            throws FileNotFoundException {
        final FileHandle languagesDir = Files.getCheckedChild(dataDir, LANGUAGE_DIR_NAME, "Languages dir");
        final FileHandle[] languageFiles = languagesDir.list();
        final Map<String, LanguageFile> readLanguages = new HashMap<>();
        for (final FileHandle languageFile : languageFiles) {
            final LanguageFile language = new LanguageFile(dataDir, languageFile);
            readLanguages.put(language.getName(), language);
        }
        languages = Collections.unmodifiableMap(readLanguages);
    }
}
