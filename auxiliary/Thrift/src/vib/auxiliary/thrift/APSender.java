/*
 * This file is part of the auxiliaries of Greta.
 *
 * Greta is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Greta is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Greta.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package vib.auxiliary.thrift;

import vib.auxiliary.thrift.gen_java.Message;
import vib.auxiliary.thrift.gen_java.ThriftAnimParam;
import vib.auxiliary.thrift.gen_java.ThriftAnimParamFrame;
import vib.auxiliary.thrift.services.Sender;
import vib.core.util.animationparameters.AnimationParameter;
import vib.core.util.animationparameters.AnimationParametersFrame;
import vib.core.util.id.ID;
import vib.core.util.log.Logs;
import vib.core.util.time.Timer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ken Prepin
 */
public abstract class APSender<APF extends AnimationParametersFrame> extends Sender{
    public APSender(){
        this(Sender.DEFAULT_THRIFT_HOST, Sender.DEFAULT_THRIFT_PORT);
    }

    public APSender(String host, int port){
        super(host, port);
    }

    public void sendAnimParamFrameList(List<APF> gretaAPFrames, String type, ID requestId) {
       List<ThriftAnimParamFrame> thriftAPFrameList = gretaAPFrameListToThriftAPFrameList(gretaAPFrames);
       Message m = new Message();
       m.type = type;
       m.id = requestId.toString();
       m.time = Timer.getTimeMillis();
       m.APFrameList = thriftAPFrameList;
       send(m);
    }

    private List<ThriftAnimParamFrame> gretaAPFrameListToThriftAPFrameList(List<APF> gretaAPFrames) {
        List<ThriftAnimParamFrame> thriftAPFrameList  = new ArrayList<>(gretaAPFrames.size());

        for (AnimationParametersFrame gretaFrame : gretaAPFrames) {
            ThriftAnimParamFrame thriftFrame = new ThriftAnimParamFrame();
            thriftFrame.frameNumber = gretaFrame.getFrameNumber();
            Logs.debug("thriftFrame.frameNumber: " + thriftFrame.frameNumber);
            thriftFrame.animParamList = new ArrayList<>(gretaFrame.size());
            List<AnimationParameter> apList = gretaFrame.getAnimationParametersList();
            for (AnimationParameter ap : apList){
                ThriftAnimParam thriftAP = new ThriftAnimParam(ap.getMask(), ap.getValue());
                thriftFrame.animParamList.add(thriftAP);
            }
            thriftAPFrameList.add(thriftFrame);
        }
        return thriftAPFrameList;
    }
}
