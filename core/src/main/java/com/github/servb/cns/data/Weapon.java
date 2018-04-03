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
import java.util.Objects;
import java.util.Set;
import com.github.servb.cns.common.effect.AbstractEffect;
import com.github.servb.cns.util.Disablable;
import servb.util.file.CreatedFromFile;

/**
 * The Weapon class.
 * <p>
 * An instance of the class is immutable.
 *
 * @author SerVB
 */
public final class Weapon implements CreatedFromFile, Disablable {

    private final String name;
    private final long clipSize;
    private final long cooldown;
    private final double reload;
    private final double recoil;
    private final double recover;
    private final String type;
    private final Texture icon;
    private final Sound sound;

    private final Set<BulletEntry> bullets = new HashSet<>();
    private final Set<AbstractEffect> effects = new HashSet<>();

    private final File xmlFile;

    private Weapon(final File xmlFile) {
        this.xmlFile = xmlFile;

        throw new UnsupportedOperationException("TODO!");
    }

    public static Weapon fromFile(final File xmlFile) {
        return new Weapon(xmlFile);
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
        return String.format("Weapon(%s)=%x", xmlFile.getName(), hashCode());
    }

    @Override
    public File getSourceFile() {
        return xmlFile;
    }

    public static final class BulletEntry {
        //<editor-fold desc="..." defaultstate="collapsed">
        private final Bullet bullet;
        private final double rotate;

        private BulletEntry(final Bullet bullet, final double rotate) {
            this.bullet = bullet;
            this.rotate = rotate;
        }

        public static BulletEntry valueOf(final Bullet bullet, final double rotate) {
            return new BulletEntry(bullet, rotate);
        }

        //<editor-fold desc="hashCode & equals" defaultstate="collapsed">
        @Override
        public int hashCode() {
            int hash = 3;
            hash = 59 * hash + Objects.hashCode(this.bullet);
            hash = 59 * hash +
                    (int) (Double.doubleToLongBits(this.rotate) ^ (Double.doubleToLongBits(this.rotate) >>> 32));
            return hash;
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final BulletEntry other = (BulletEntry) obj;
            if (Double.doubleToLongBits(this.rotate) != Double.doubleToLongBits(other.rotate)) {
                return false;
            }
            return Objects.equals(this.bullet, other.bullet);
        }
        //</editor-fold>

        @Override
        public String toString() {
            return String.format("%s, rotate = %.2f", bullet, rotate);
        }
        //</editor-fold>
    }

}
