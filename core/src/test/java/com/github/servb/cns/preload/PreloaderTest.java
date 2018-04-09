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
import com.github.servb.cns.test.GameTest;
import java.io.FileNotFoundException;
import static org.junit.Assert.fail;
import org.junit.Test;

public class PreloaderTest extends GameTest {

    @Test
    public void testConstructor() {
        final String fictiveDir = "Dropbox/CNS/cns/fictive-cns1-dir/";
        try {
            Preloader.load(Gdx.files.external(fictiveDir));
        } catch (final FileNotFoundException ex) {
            Gdx.app.log("ex", "->", ex);
            fail("Exception is thrown...");
        }
    }

}
