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
 * The Sound class.
 * <p>
 * An instance of the class is immutable.
 *
 * @author SerVB
 */
public final class Sound implements CreatedFromFile {

    /**
     * {@code No sound} constant. TODO: change the value!
     */
    public static final Sound NO_SOUND = null;

    private final File soundFile;

    private Sound(final File soundFile) {
        this.soundFile = soundFile;

        throw new UnsupportedOperationException("TODO!");
    }

    public static Sound fromFile(final File stream) {
        return new Sound(stream);
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
        return String.format("Sound(%s)=%x", soundFile.getName(), hashCode());
    }

    @Override
    public File getSourceFile() {
        return soundFile;
    }

}
