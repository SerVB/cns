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

import com.github.servb.cns.data.Language;
import com.github.servb.cns.data.Weapon;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * The Container class.
 * <p>
 * An instance of the class is immutable.
 *
 * @author SerVB
 */
public final class Preloader {

    private final Set<Language> languages = new HashSet<>();
    private final Set<Weapon> weapons = new HashSet<>();


    public Preloader(final File dataFolder) {
        throw new UnsupportedOperationException("TODO!");
    }

}
