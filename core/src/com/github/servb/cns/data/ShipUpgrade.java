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
import java.util.HashSet;
import java.util.Set;
import com.github.servb.cns.util.Disablable;
import servb.util.file.CreatedFromFile;

/**
 * The Ship Upgrade class.
 * <p>
 * An instance of the class is immutable.
 *
 * @author SerVB
 */
public final class ShipUpgrade implements CreatedFromFile, Disablable {

    private final String name;
    private final String description;
    private final Texture icon;
    private final Purpose purpose;
    private final long addingValue;
    private final Set<ShipUpgrade> requirements = new HashSet<>();

    private final File xmlFile;

    private ShipUpgrade(final File xmlFile) {
        this.xmlFile = xmlFile;

        throw new UnsupportedOperationException("TODO!");
    }

    public static ShipUpgrade fromFile(final File xmlFile) {
        return new ShipUpgrade(xmlFile);
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
        return String.format("ShipUpgrade(%s)=%x", xmlFile.getName(), hashCode());
    }

    @Override
    public File getSourceFile() {
        return xmlFile;
    }

    public static enum Purpose {
        ARMOR,
        BULLET_SPEED,
        CLIP_SIZE,
        DAMAGE,
        EXPERIENCE,
        EXPLOSION,
        RECOIL,
        RELOAD,
        REPAIR,
        SHIP_SPEED,
        SHOT_SPEED;
    }

}
