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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Mesh file.
 * <p>
 * The instance of the class is immutable.
 *
 * @author SerVB
 */
public final class MeshFile {

    public final String primitive;
    public final boolean coordinates;
    public final int colorCount;
    public final int textureCount;

    public final List<Vertex> vertices;
    public final List<Integer> indices;

    public MeshFile(final FileHandle xmlFile) {
        final Element mesh = new XmlReader().parse(xmlFile); // <mesh primitive="trianglestrip">...</mesh>
        primitive = mesh.getAttribute("primitive");
        /* DEBUG */ if (!"trianglestrip".equals(primitive)) {
            Gdx.app.log("Mesh", "Unknown primitive \"" + primitive + "\" in " + xmlFile.path());
        }

        {
            final Element format = mesh.getChildByName("format");
            coordinates = format.getChildByName("coordinates") != null;
            colorCount = Integer.parseInt(format.getChildByName("colors").getAttribute("count"));
            textureCount = Integer.parseInt(format.getChildByName("textures").getAttribute("count"));
        }

        {
            final ArrayList<Vertex> tmpVertices = new ArrayList<>();

            for (final Element vertex : mesh.getChildByName("vertices").getChildrenByName("vertex")) {
                final double x = Double.parseDouble(vertex.getAttribute("x"));
                final double y = Double.parseDouble(vertex.getAttribute("y"));
                final double z = Double.parseDouble(vertex.getAttribute("z"));
                final long color = Long.parseLong(vertex.getAttribute("color").substring(2), 16);
                final double u = Double.parseDouble(vertex.getAttribute("u"));
                final double v = Double.parseDouble(vertex.getAttribute("v"));

                tmpVertices.add(new Vertex(x, y, z, color, u, v));
            }

            tmpVertices.trimToSize();
            vertices = Collections.unmodifiableList(tmpVertices);
        }

        {
            final ArrayList<Integer> tmpIndices = new ArrayList<>();

            for (final Element index : mesh.getChildByName("indices").getChildrenByName("index")) {
                final int value = Integer.parseInt(index.getAttribute("value"));

                tmpIndices.add(value);
            }

            tmpIndices.trimToSize();
            indices = Collections.unmodifiableList(tmpIndices);
        }
    }

    public static final class Vertex {
        public final double x, y, z;
        public final long color;
        public final double u, v;

        public Vertex(final double x, final double y, final double z,
                final long color,
                final double u, final double v) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.color = color;
            this.u = u;
            this.v = v;
        }

        //<editor-fold defaultstate="collapsed" desc="hashCode & equals">
        @Override
        public int hashCode() {
            int hash = 3;
            hash = 53 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
            hash = 53 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
            hash = 53 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
            hash = 53 * hash + (int) (this.color ^ (this.color >>> 32));
            hash = 53 * hash + (int) (Double.doubleToLongBits(this.u) ^ (Double.doubleToLongBits(this.u) >>> 32));
            hash = 53 * hash + (int) (Double.doubleToLongBits(this.v) ^ (Double.doubleToLongBits(this.v) >>> 32));
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Vertex other = (Vertex) obj;
            if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
                return false;
            }
            if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
                return false;
            }
            if (Double.doubleToLongBits(this.z) != Double.doubleToLongBits(other.z)) {
                return false;
            }
            if (this.color != other.color) {
                return false;
            }
            if (Double.doubleToLongBits(this.u) != Double.doubleToLongBits(other.u)) {
                return false;
            }
            if (Double.doubleToLongBits(this.v) != Double.doubleToLongBits(other.v)) {
                return false;
            }
            return true;
        }
        //</editor-fold>

        @Override
        public String toString() {
            return "Vertex{" + "x=" + x + ", y=" + y + ", z=" + z + ", color=" + color + ", u=" + u + ", v=" + v + '}';
        }
    }
}
