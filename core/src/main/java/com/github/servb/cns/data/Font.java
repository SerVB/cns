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
import java.util.HashMap;
import java.util.Objects;
import servb.metric.SimpleRectangle;
import servb.util.file.CreatedFromFile;

/**
 * The Font class.
 * <p>
 * An instance of the class is immutable.
 *
 * @author SerVB
 */
public final class Font implements CreatedFromFile {

    private final Texture texturestage;
    private final Material material;
    private final int textureWidth;
    private final int textureHeight;

    /** Characters. TODO: Is there any immutable map? */
    private final HashMap<Character, SimpleRectangle> characters;

    private final File xmlFile;

    private Font(final File xmlFile) {
        this.xmlFile = xmlFile;

        throw new UnsupportedOperationException("TODO!");
    }

    public static Font fromFile(final File xmlFile) {
        return new Font(xmlFile);
    }

    //<editor-fold desc="hashCode & equals" defaultstate="collapsed">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.texturestage);
        hash = 71 * hash + Objects.hashCode(this.material);
        hash = 71 * hash + this.textureWidth;
        hash = 71 * hash + this.textureHeight;
        hash = 71 * hash + Objects.hashCode(this.characters);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Font other = (Font) obj;
        if (this.textureWidth != other.textureWidth) {
            return false;
        }
        if (this.textureHeight != other.textureHeight) {
            return false;
        }
        if (!Objects.equals(this.texturestage, other.texturestage)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        return Objects.equals(this.characters, other.characters);
    }
    //</editor-fold>

    @Override
    public String toString() {
        return String.format("Font(%s)=%x", xmlFile.getName(), hashCode());
    }

    @Override
    public File getSourceFile() {
        return xmlFile;
    }

}
