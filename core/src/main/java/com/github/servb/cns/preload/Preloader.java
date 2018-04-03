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
import java.io.FileNotFoundException;

/**
 * The Container class.
 * <p>
 * An instance of the class is immutable.
 *
 * @author SerVB
 */
public final class Preloader {

    public Preloader(final FileHandle cnsDir) throws FileNotFoundException {
        if (!cnsDir.exists()) {
            throw new FileNotFoundException("Root CNS dir not found: " + cnsDir.path());
        }
        final FileHandle dataDir = cnsDir.child("data\\");
        if (!dataDir.exists()) {
            throw new FileNotFoundException("Data dir not found: " + dataDir.path());
        }
        final FileHandle preloadDir = dataDir.child("preload\\");
        if (!preloadDir.exists()) {
            throw new FileNotFoundException("Preload dir not found: " + preloadDir.path());
        }
        Gdx.app.log("info", "Preload dir found");
    }

}
