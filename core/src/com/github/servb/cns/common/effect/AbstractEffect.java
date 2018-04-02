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
package com.github.servb.cns.common.effect;

import java.util.Objects;
import com.github.servb.cns.common.Visual;
import com.github.servb.cns.data.Sound;

/**
 * The AbstractEffect class.
 * <p>
 * An instance of the class is immutable.
 *
 * @author SerVB
 */
public class AbstractEffect {

    private final String name;

    /** Visual. */
    private final Visual visual;

    /** Is optional. */
    private final boolean optional;

    /** Sound. */
    private final Sound sound;

    /** Velocity. */
    private final double velocity;

    /** Lifetime. */
    private final double lifetime;

    /** Count. */
    private final int count;

    private final double xPosition;
    private final double yPosition;
    private final double zPosition;

    private final AbstractEffect target;

    /**
     * Constructs an {@code Effect} object with the given parameters.
     *
     * @param visual        Visual.
     * @param isOptional    Is optional.
     * @param sound         Sound.
     * @param velocity      Velocity.
     * @param lifetime      Lifetime.
     * @param count         Count.
     */
    private AbstractEffect(
            final Visual visual,
            final boolean isOptional,
            final Sound sound,
            final double velocity,
            final double lifetime,
            final int count
    ) {
        this.visual = visual;
        this.optional = isOptional;
        this.sound = sound;
        this.velocity = velocity;
        this.lifetime = lifetime;
        this.count = count;
    }

    public static AbstractEffect valueOf(
            final Visual visual,
            final boolean isOptional,
            final Sound sound,
            final double velocity,
            final double lifetime,
            final int count
    ) {
        return new AbstractEffect(visual, isOptional, sound, velocity, lifetime, count);
    }

    //<editor-fold desc="Getters" defaultstate="collapsed">
    public Visual visual() {
        return visual;
    }

    public boolean isOptional() {
        return optional;
    }

    public Sound sound() {
        return sound;
    }

    public double velocity() {
        return velocity;
    }

    public double lifetime() {
        return lifetime;
    }

    public int count() {
        return count;
    }
    //</editor-fold>

    //<editor-fold desc="hashCode & equals" defaultstate="collapsed">
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.visual);
        hash = 97 * hash + (this.optional ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.sound);
        hash = 97 * hash +
                (int) (Double.doubleToLongBits(this.velocity) ^ (Double.doubleToLongBits(this.velocity) >>> 32));
        hash = 97 * hash +
                (int) (Double.doubleToLongBits(this.lifetime) ^ (Double.doubleToLongBits(this.lifetime) >>> 32));
        hash = 97 * hash + this.count;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractEffect other = (AbstractEffect) obj;
        if (this.optional != other.optional) {
            return false;
        }
        if (Double.doubleToLongBits(this.velocity) != Double.doubleToLongBits(other.velocity)) {
            return false;
        }
        if (Double.doubleToLongBits(this.lifetime) != Double.doubleToLongBits(other.lifetime)) {
            return false;
        }
        if (this.count != other.count) {
            return false;
        }
        if (!Objects.equals(this.visual, other.visual)) {
            return false;
        }
        return Objects.equals(this.sound, other.sound);
    }
    //</editor-fold>

    @Override
    public String toString() {
        throw new UnsupportedOperationException("TODO!");
    }

}
