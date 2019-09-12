/*
 * This file is part of the auxiliaries of Greta.
 * 
 * Greta is free software: you can redistribute it and / or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Greta is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Greta.If not, see <http://www.gnu.org/licenses/>.
 */

package org.joml.lwjgl;

public interface ViewSettings {

    /**
     * The distance between the viewer's eyes and the screen in some distance
     * measure (such as centimeters).
     */
    double distanceToScreen = 60.0;
    /**
     * The height of the screen area in the same distance measure (such as
     * centimeters).
     */
    double screenHeight = 32.5;
    /**
     * The vertical resolution of the screen in pixels.
     */
    int screenHeightPx = 1200;

}
