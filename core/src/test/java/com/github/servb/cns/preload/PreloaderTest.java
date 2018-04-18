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
import com.github.servb.cns.test.AbstractGameTest;
import java.io.FileNotFoundException;
import java.util.HashSet;
import static org.junit.Assert.fail;
import org.junit.Test;

public final class PreloaderTest extends AbstractGameTest {

    @Test
    public void testConstructor() {
        try {
            Preloader.load(Gdx.files.external(CNS1_FICTIVE_DIR));
            Gdx.app.log("Test Constructor", "OK");
        } catch (final FileNotFoundException ex) {
            Gdx.app.log("ex", "->", ex);
            fail("Exception is thrown...");
        }
    }

    @Test
    public void testFictiveDir() { // Search for all <tag>/link/to/file</tag>
        try {
            final FileHandle dataDir = Gdx.files.external(CNS1_FICTIVE_DIR).child("data/");
            final HashSet<FileHandle> doneFiles = new HashSet<>();
            final HashSet<FileHandle> files = new HashSet<>();

            for (final FileHandle level : dataDir.child("level/").list()) {
                files.add(level);
            }

            while (!files.isEmpty()) {
                final FileHandle next = files.iterator().next();
                files.remove(next);
                doneFiles.add(next);

                if ("xml".equals(next.extension())) { // If file can have links inside
                    final String readString = next.readString("utf-8");
                    int nowPos = 0;
                    while (readString.indexOf(">/", nowPos) != -1) {
                        final int startPos = readString.indexOf(">/", nowPos) + 1;
                        final int endPos = readString.indexOf("<", startPos);
                        nowPos = endPos;
                        final String newPath = readString.substring(startPos, endPos).replace("%04d", "0000");
                        final FileHandle child = dataDir.child(newPath);
                        if (!doneFiles.contains(child)) {
                            files.add(child);
                        }
                    }
                }
            }

            Gdx.app.log("Test Fictive Dir", "OK, found " + doneFiles.size() + " files");
        } catch (final Exception ex) {
            Gdx.app.log("ex", "->", ex);
            fail("Exception is thrown...");
        }
    }

}
