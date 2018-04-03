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

import servb.util.file.CreatedFromFile;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import com.github.servb.cns.common.effect.AbstractEffect;
import com.github.servb.cns.common.Trail;
import com.github.servb.cns.common.Visual;
import com.github.servb.cns.util.XmlParser;

/**
 * The Bullet class.
 * <p>
 * An instance of the class is immutable.
 *
 * @author SerVB
 */
public final class Bullet implements CreatedFromFile {

    /** Velocity. */
    private final double velocity;

    /** Damage. */
    private final double damage;

    /** Lifetime. */
    private final double lifetime;

    /** Radius. */
    private final double radius;

    /** Visual. */
    private final Visual visual;

    /** Trail. */
    private final Trail trail;

    /** Effects. TODO: Is there any immutable set? */
    private final HashSet<AbstractEffect> effects;

    /** The XML file declaring the Bullet object. */
    private final File xmlFile;

    /**
     * Constructs a Bullet object from the XML file.
     *
     * @param xmlFile The XML file.
     */
    private Bullet(final File xmlFile) throws ParserConfigurationException, SAXException, IOException {
        this.xmlFile = xmlFile;

        final DocumentBuilderFactory dbf = XmlParser.get(); // Get Builder Factory
        final DocumentBuilder db = dbf.newDocumentBuilder(); // Create Builder
        final Document bulletDocument = db.parse(this.xmlFile); // Parse Document



    }

    public static Bullet fromFile(final File xmlFile) {
        return new Bullet(xmlFile);
    }

    //<editor-fold desc="Getters" defaultstate="collapsed">
    public double velocity() {
        return velocity;
    }

    public double damage() {
        return damage;
    }

    public double lifetime() {
        return lifetime;
    }

    public double radius() {
        return radius;
    }

    public Visual visual() {
        return visual;
    }

    public Trail trail() {
        return trail;
    }

    public HashSet<AbstractEffect> effects() {
        return new HashSet<>(effects);
    }
    //</editor-fold>

    //<editor-fold desc="hashCode & equals" defaultstate="collapsed">
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash +
                (int) (Double.doubleToLongBits(this.velocity) ^ (Double.doubleToLongBits(this.velocity) >>> 32));
        hash = 73 * hash +
                (int) (Double.doubleToLongBits(this.damage) ^ (Double.doubleToLongBits(this.damage) >>> 32));
        hash = 73 * hash +
                (int) (Double.doubleToLongBits(this.lifetime) ^ (Double.doubleToLongBits(this.lifetime) >>> 32));
        hash = 73 * hash +
                (int) (Double.doubleToLongBits(this.radius) ^ (Double.doubleToLongBits(this.radius) >>> 32));
        hash = 73 * hash + Objects.hashCode(this.visual);
        hash = 73 * hash + Objects.hashCode(this.trail);
        hash = 73 * hash + Objects.hashCode(this.effects);
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
        final Bullet other = (Bullet) obj;
        if (Double.doubleToLongBits(this.velocity) != Double.doubleToLongBits(other.velocity)) {
            return false;
        }
        if (Double.doubleToLongBits(this.damage) != Double.doubleToLongBits(other.damage)) {
            return false;
        }
        if (Double.doubleToLongBits(this.lifetime) != Double.doubleToLongBits(other.lifetime)) {
            return false;
        }
        if (Double.doubleToLongBits(this.radius) != Double.doubleToLongBits(other.radius)) {
            return false;
        }
        if (!Objects.equals(this.visual, other.visual)) {
            return false;
        }
        if (!Objects.equals(this.trail, other.trail)) {
            return false;
        }
        return Objects.equals(this.effects, other.effects);
    }
    //</editor-fold>

    @Override
    public String toString() {
        return String.format("Bullet(%s)=%x", xmlFile.getName(), hashCode());
    }

    @Override
    public File getSourceFile() {
        return xmlFile;
    }

}
