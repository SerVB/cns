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
import com.github.servb.cns.test.AbstractGameTest;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public final class MeshFileTest extends AbstractGameTest {

    @Test
    public void testFields() {
        final MeshFile meshFile
                = new MeshFile(Gdx.files.external(CNS1_FICTIVE_DIR).child("data/mesh/centered-1x1.xml"));

        assertEquals("Coordinates should be `true`", true, meshFile.coordinates);
        assertEquals("Colors count should be `1`", 1, meshFile.colorCount);
        assertEquals("Texture count should be `1`", 1, meshFile.textureCount);
        assertEquals("Indices should be [0, 1, 2, 3]", Arrays.asList(0, 1, 2, 3), meshFile.indices);

        assertEquals("Vertex 0 should be (-0.5, -0.5, 0.0, 0xFFFFFFFF, 0.0, 0.0)",
                new MeshFile.Vertex(-0.5, -0.5, 0.0, 0xFFFFFFFFl, 0.0, 0.0), meshFile.vertices.get(0));
        assertEquals("Vertex 1 should be (0.5, -0.5, 0.0, 0xFFFFFFFF, 1.0, 0.0)",
                new MeshFile.Vertex(0.5, -0.5, 0.0, 0xFFFFFFFFl, 1.0, 0.0), meshFile.vertices.get(1));
        assertEquals("Vertex 2 should be (-0.5, 0.5, 0.0, 0xFFFFFFFF, 0.0, 1.0)",
                new MeshFile.Vertex(-0.5, 0.5, 0.0, 0xFFFFFFFFl, 0.0, 1.0), meshFile.vertices.get(2));
        assertEquals("Vertex 3 should be (0.5, 0.5, 0.0, 0xFFFFFFFF, 1.0, 1.0)",
                new MeshFile.Vertex(0.5, 0.5, 0.0, 0xFFFFFFFFl, 1.0, 1.0), meshFile.vertices.get(3));
    }
}
