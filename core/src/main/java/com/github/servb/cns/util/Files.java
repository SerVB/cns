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
package com.github.servb.cns.util;

import com.badlogic.gdx.files.FileHandle;
import java.io.FileNotFoundException;

/**
 * The class provides static methods to work with files.
 *
 * @author SerVB
 */
public final class Files {

    /** Prevents from creating an instance of the class. */
    private Files() {
    }

    /**
     * Throws the exception if the file doesn't exist.
     *
     * @param fh                        The file.
     * @param name                      The sense of the file; its human name.
     * @throws FileNotFoundException    If the file doesn't exist.
     */
    public static void checkFile(final FileHandle fh, final String name) throws FileNotFoundException {
        if (!fh.exists()) {
            throw new FileNotFoundException(name + " not found: " + fh.path());
        }
    }

    /**
     * Returns the child if it exists; otherwise throws the exception.
     *
     * @param parent                    The file which child is needed.
     * @param path                      The path to the needed child.
     * @param name                      The sense of the child file; its human name.
     * @return                          The needed child.
     * @throws FileNotFoundException    If the child isn't found.
     */
    public static FileHandle getCheckedChild(final FileHandle parent, final String path, final String name)
            throws FileNotFoundException {
        final FileHandle child = parent.child(path);
        checkFile(child, name);
        return child;
    }
}
