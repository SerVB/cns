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
package com.github.servb.cns.common;

import java.util.Objects;
import com.github.servb.cns.data.Material;
import com.github.servb.cns.data.Texture;

/**
 * The Visual class.
 * <p>
 * An instance of the class is immutable.
 *
 * @author SerVB
 */
public final class Visual {

    /** Mesh. */
    private final Mesh mesh;

    /** Material. */
    private final Material material;

    /** Texstage. */
    private final Texture texstage;

    /**
     * Constructs a {@code Visual} object with the given parameters.
     *
     * @param mesh      Mesh.
     * @param material  Material.
     * @param texstage  Texstage.
     */
    private Visual(final Mesh mesh, final Material material, final Texture texstage) {
        this.mesh = mesh;
        this.material = material;
        this.texstage = texstage;
    }

    public static Visual valueOf(final Mesh mesh, final Material material, final Texture texstage) {
        return new Visual(texstage, texstage, texstage);
    }

    //<editor-fold desc="Getters" defaultstate="collapsed">
    /**
     * Returns Mesh.
     *
     * @return Mesh.
     */
    public Mesh mesh() {
        return mesh;
    }

    /**
     * Returns Material.
     *
     * @return Material.
     */
    public Material material() {
        return material;
    }

    /**
     * Returns Texstage.
     *
     * @return Texstage.
     */
    public Texture texstage() {
        return texstage;
    }
    //</editor-fold>

    //<editor-fold desc="hashCode & equals" defaultstate="collapsed">
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.mesh);
        hash = 59 * hash + Objects.hashCode(this.material);
        hash = 59 * hash + Objects.hashCode(this.texstage);
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
        final Visual other = (Visual) obj;
        if (!Objects.equals(this.mesh, other.mesh)) {
            return false;
        }
        if (!Objects.equals(this.material, other.material)) {
            return false;
        }
        return Objects.equals(this.texstage, other.texstage);
    }
    //</editor-fold>

    @Override
    public String toString() {
        return String.format("Visual{%s, %s, %s}", mesh, material, texstage);
    }

}
