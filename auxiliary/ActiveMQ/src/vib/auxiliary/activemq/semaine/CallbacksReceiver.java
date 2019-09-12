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

package vib.auxiliary.activemq.semaine;

import vib.auxiliary.activemq.TextReceiver;
import vib.auxiliary.activemq.WhiteBoard;
import vib.core.feedbacks.Callback;
import vib.core.feedbacks.CallbackEmitter;
import vib.core.feedbacks.CallbackPerformer;
import vib.core.util.id.ID;
import vib.core.util.id.IDProvider;
import vib.core.util.xml.XML;
import vib.core.util.xml.XMLParser;
import vib.core.util.xml.XMLTree;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Ken Prepin
 */
public class CallbacksReceiver extends TextReceiver implements CallbackEmitter {

    private ArrayList<CallbackPerformer> callbackPerfList;
    private XMLParser callbackParser;

    public CallbacksReceiver() {
        this(WhiteBoard.DEFAULT_ACTIVEMQ_HOST,
                WhiteBoard.DEFAULT_ACTIVEMQ_PORT,
                "semaine.callback.output.Animation");
    }

    public CallbacksReceiver(String host, String port, String topic) {
        super(host, port, topic);
        callbackPerfList = new ArrayList<CallbackPerformer>();
        callbackParser = XML.createParser();
        callbackParser.setValidating(false);
    }

    @Override
    protected void onMessage(String content, Map<String, Object> properties) {
        XMLTree callbacks = callbackParser.parseBuffer(content.toString());

        if (callbacks == null) {
            return;
        }

        String callbackType = callbacks.findNodeCalled("event").getAttribute("type");
        double callbackTime = callbacks.findNodeCalled("event").getAttributeNumber("time") / 1000.;
        String requestId = properties.get("content-id").toString();
        Callback callback = new Callback(callbackType, callbackTime, IDProvider.createID(requestId));
        for (CallbackPerformer performer : callbackPerfList) {
            performer.performCallback(callback);
        }
    }

    @Override
    public void addCallbackPerformer(CallbackPerformer performer) {
        callbackPerfList.add(performer);
    }

    @Override
    public void removeCallbackPerformer(CallbackPerformer performer) {
        callbackPerfList.remove(performer);
    }
}
