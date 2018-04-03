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

import java.util.Objects;

/**
 * The XML Element Descriptor class.
 * <p>
 * An instance of the class is immutable.
 *
 * @author SerVB
 */
public final class XmlElementDesc {

    public static final String TYPE_OBJECT = "object";

    private final String parentType;
    private final String parentName;
    private final String selfType;
    private final String selfName;

    private XmlElementDesc(
            final String parentType,
            final String parentName,
            final String selfType,
            final String selfName
    ) {
        this.parentType = parentType;
        this.parentName = parentName;
        this.selfType = selfType;
        this.selfName = selfName;
    }

    public static final XmlElementDesc objectNobject(final String parentName, final String selfName) {
        return new XmlElementDesc(TYPE_OBJECT, parentName, TYPE_OBJECT, selfName);
    }

    //<editor-fold desc="Getters" defaultstate="collapsed">
    public String parentType() {
        return parentType;
    }

    public String parentName() {
        return parentName;
    }

    public String selfType() {
        return selfType;
    }

    public String selfName() {
        return selfName;
    }
    //</editor-fold>

    //<editor-fold desc="hashCode & equals" defaultstate="collapsed">
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.parentType);
        hash = 79 * hash + Objects.hashCode(this.parentName);
        hash = 79 * hash + Objects.hashCode(this.selfType);
        hash = 79 * hash + Objects.hashCode(this.selfName);
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
        final XmlElementDesc other = (XmlElementDesc) obj;
        if (!Objects.equals(this.parentType, other.parentType)) {
            return false;
        }
        if (!Objects.equals(this.parentName, other.parentName)) {
            return false;
        }
        if (!Objects.equals(this.selfType, other.selfType)) {
            return false;
        }
        return Objects.equals(this.selfName, other.selfName);
    }
    //</editor-fold>

    @Override
    public String toString() {
        return String.format("%s (%s) :: %s (%s)", parentName, parentType, selfName, selfType);
    }

}
