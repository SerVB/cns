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
import java.util.Objects;
import servb.util.file.CreatedFromFile;

/**
 * The Material class.
 * <p>
 * An instance of the class is immutable.
 *
 * @author SerVB
 */
public final class Material implements CreatedFromFile {

    private final PixelShader shader;

    private final File xmlFile;

    private Material(final File xmlFile) {
        this.xmlFile = xmlFile;

        throw new UnsupportedOperationException("TODO!");
    }

    public static Material fromFile(final File xmlFile) {
        return new Material(xmlFile);
    }

    public PixelShader shader() {
        return shader;
    }

    //<editor-fold desc="hashCode & equals" defaultstate="collapsed">
    @Override
    public int hashCode() {
        return Objects.hashCode(this.shader);
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
        final Material other = (Material) obj;
        return Objects.equals(this.shader, other.shader);
    }
    //</editor-fold>

    @Override
    public String toString() {
        return String.format("Material(%s)=%x", xmlFile.getName(), hashCode());
    }

    @Override
    public File getSourceFile() {
        return xmlFile;
    }

}
