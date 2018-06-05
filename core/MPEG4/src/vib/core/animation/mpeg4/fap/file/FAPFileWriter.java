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
package vib.core.animation.mpeg4.fap.file;

import vib.core.animation.mpeg4.fap.FAPFrame;
import vib.core.util.Constants;
import vib.core.util.id.ID;
import vib.core.util.log.Logs;
import java.util.List;

/**
 *
 * @author Radoslaw Niewiadomski
 */
public class FAPFileWriter implements vib.core.animation.mpeg4.fap.FAPFramePerformer {

    private String path;

    public FAPFileWriter() {
        path = "";
    }

    public FAPFileWriter(String path) {
        this.path = path;
    }

    @Override
    public void performFAPFrames(List<FAPFrame> fapframes, ID requestId) {
        String name = (path + requestId + ".fap");
        try {

            java.io.FileWriter fos = new java.io.FileWriter(name);

            String first_line =  "2.1 "+ name + " "+Constants.FRAME_PER_SECOND+" "+ fapframes.size()+"\n";
            fos.write(first_line);

            int first = fapframes.get(0).getFrameNumber();
            for(FAPFrame frame : fapframes) {
                fos.write(frame.AnimationParametersFrame2String(frame.getFrameNumber() - first));
            }

            fos.close();
        } catch (Exception ignored2) {
            Logs.warning("Error saving file: " + ignored2);
        }

    }//end of perorm

    @Override
    public void performFAPFrame(FAPFrame fapf, ID string) {

    }
}
