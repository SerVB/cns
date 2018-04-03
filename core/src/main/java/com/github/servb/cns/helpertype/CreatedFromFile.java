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
package com.github.servb.cns.helpertype;

import java.io.File;

/**
 * The interface is used for classes are created from a file.
 *
 * @author SerVB
 */
public interface CreatedFromFile {

    /**
     * Returns the file the object has been created from (AKA the source file).
     *
     * @return The source file.
     */
    public File getSourceFile();

}
