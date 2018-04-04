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
import java.util.Set;
import com.github.servb.cns.common.effect.AbstractEffect;
import com.github.servb.cns.util.Disablable;
import servb.util.file.CreatedFromFile;

/**
 * The Level class.
 * <p>
 * An instance of the class is immutable.
 *
 * @author SerVB
 */
public final class Level implements CreatedFromFile {

    private final String name;

    private final boolean showHintIntro;
    private final boolean showHintCask;
    private final boolean showHintChain;
    private final boolean showHintShip;
    private final boolean showHintWeapon;
    private final boolean showHintLevelUp;
    private final boolean showHintPlanet;

    private final boolean disablePlanetUpgrade;
    private final boolean disableShipUpgrade;

    private final Set<AbstractEffect> effects;
    private final Set<AbstractEvent> schedule;

    private final Set<Disablable> disabled;

    private final File xmlFile;

    private Level(final File xmlFile) {
        this.xmlFile = xmlFile;

        throw new UnsupportedOperationException("TODO!");
    }

    public static Level fromFile(final File xmlFile) {
        return new Level(xmlFile);
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
        return String.format("Level(%s)=%x", xmlFile.getName(), hashCode());
    }

    @Override
    public File getSourceFile() {
        return xmlFile;
    }

    public static abstract class AbstractEvent {

        private final LevelObject object;
        private final int count;

        private final long beginTime;
        private final long endTime;
        private final boolean zoom;

        private final LevelObject shard;
        private final int shardCount;

    }

    public static final class OrbitEvent extends AbstractEvent {

        private final double orbitRadius;

    }

    public static final class PositionEvent extends AbstractEvent {

        private final double xPosition;
        private final double yPosition;

    }

}
