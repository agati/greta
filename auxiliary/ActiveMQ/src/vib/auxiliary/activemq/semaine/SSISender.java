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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vib.auxiliary.activemq.TextSender;
import vib.auxiliary.activemq.WhiteBoard;
import vib.core.signals.BMLTranslator;
import vib.core.signals.Signal;
import vib.core.util.Mode;
import vib.core.util.id.ID;
import vib.core.util.xml.XMLTree;

/**
 *
 * @author Angelo Cafaro
 */
public class SSISender extends TextSender {
    
    private HashMap<String, Object> semaineMap;
    public static String DEFAULT_ACTIVEMQ_TOPIC = "SSI";

    public SSISender() {
        this(WhiteBoard.DEFAULT_ACTIVEMQ_HOST,
            WhiteBoard.DEFAULT_ACTIVEMQ_PORT,
            DEFAULT_ACTIVEMQ_TOPIC);
    }

    public SSISender(String host, String port, String topic) {
        super(host, port, topic);
        semaineMap = new HashMap<String, Object>();
        semaineMap.put("content-type", "utterance");
        semaineMap.put("datatype", "XML");
        semaineMap.put("source", "Greta");
        semaineMap.put("event", "single");
        semaineMap.put("xml", true);
    }

    @Override
    protected void onSend(Map<String, Object> properties) {
        properties.put("usertime", System.currentTimeMillis());
        properties.put("content-creation-time", System.currentTimeMillis());
        properties.putAll(semaineMap);
        // Must be overrided to complete the map
    }
}
