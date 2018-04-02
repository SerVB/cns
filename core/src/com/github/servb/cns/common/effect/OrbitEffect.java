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

/**
 *
 * @author SerVB
 */
public final class OrbitEffect extends AbstractEffect {

    private final Orbit orbit;

    public static final class Orbit {

        private final double speed;
        private final double xAxis;
        private final double yAxis;
        private final double zAxis;
        private final double xCenter;
        private final double yCenter;
        private final double zCenter;

    }

}
