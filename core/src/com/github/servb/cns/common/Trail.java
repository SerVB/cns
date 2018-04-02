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

/**
 * The Trail class.
 * <p>
 * An instance of the class is immutable.
 *
 * @author SerVB
 */
public final class Trail {

    /** Mesh. */
    private final Mesh mesh;

    /** Material. */
    private final Material material;

    /**
     * Constructs a {@code Trail} object with the given parameters.
     *
     * @param mesh      Mesh.
     * @param material  Material.
     */
    private Trail(final Mesh mesh, final Material material) {
        this.mesh = mesh;
        this.material = material;
    }

    public static Trail valueOf(final Mesh mesh, final Material material) {
        return new Trail(mesh, material);
    }

    //<editor-fold desc="Getters" defaultstate="collapsed">
    public Mesh mesh() {
        return mesh;
    }

    public Material material() {
        return material;
    }
    //</editor-fold>

    //<editor-fold desc="hashCode & equals" defaultstate="collapsed">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.mesh);
        hash = 67 * hash + Objects.hashCode(this.material);
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
        final Trail other = (Trail) obj;
        if (!Objects.equals(this.mesh, other.mesh)) {
            return false;
        }
        return Objects.equals(this.material, other.material);
    }
    //</editor-fold>

    @Override
    public String toString() {
        return String.format("Trail{%s, %s}", mesh, material);
    }

}
