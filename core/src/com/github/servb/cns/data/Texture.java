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
package com.github.servb.cns.data;

import java.io.File;
import servb.util.file.CreatedFromFile;

/**
 * The Texture class.
 * <p>
 * An instance of the class is immutable.
 *
 * @author SerVB
 */
public final class Texture implements CreatedFromFile {

    /** The texture file declaring the Texture object. */
    private final File textureFile;

    private Texture(final File textureFile) {
        this.textureFile = textureFile;

        throw new UnsupportedOperationException("TODO!");
    }

    public static Texture fromFile(final File textureFile) {
        return new Texture(textureFile);
    }

    //<editor-fold desc="hashCode & equals" defaultstate="collapsed">
    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("TODO!");
    }

    @Override
    public boolean equals(final Object obj) {
        throw new UnsupportedOperationException("TODO!");
    }
    //</editor-fold>

    @Override
    public String toString() {
        return String.format("Texture(%s)=%x", textureFile.getName(), hashCode());
    }

    @Override
    public File getSourceFile() {
        return textureFile;
    }

}
