/* This file is part of Greta.
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
*//*
 * This file is part of VIB (Virtual Interactive Behaviour).
 */

package vib.core.util.enums;

/**
 * Open set item for BML influences (specific to VIB).
 * @author Mathieu Chollet
 */


public enum Influence {
    EYES/*(0)*/,
    HEAD/*(1)*/,
    SHOULDER/*(2)*/,
    TORSO/*(3)*/,
    WHOLE/*(4)*/;

    /* useless: look at ordinal() method ...

    public final int order;

    private Influence(int order) {
        this.order=order;
    }
   //*/
}
