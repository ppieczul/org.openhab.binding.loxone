/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.loxone.core;

import java.io.IOException;
import java.util.Map;

/**
 * A switch type of control on Loxone Miniserver.
 * <p>
 * According to Loxone API documentation, a switch control is:
 * <ul>
 * <li>a virtual input of switch type
 * <li>a push button function block
 * </ul>
 *
 * @author Pawel Pieczul - initial commit
 *
 */
public class LxControlSwitch extends LxControl {

    /**
     * A name by which Miniserver refers to switch controls
     */
    public final static String TYPE_NAME = "switch";

    /**
     * Switch has one state that can be on/off
     */
    public final static String STATE_ACTIVE = "active";

    /**
     * Create switch control object.
     *
     * @param client
     *            communication client used to send commands to the Miniserver
     * @param uuid
     *            switch's UUID
     * @param name
     *            switch's name
     * @param room
     *            room to which switch belongs
     * @param category
     *            category to which switch belongs
     * @param states
     *            switch's states and their names (expecting one object with "active" name)
     */
    LxControlSwitch(LxWsClient client, LxUuid uuid, String name, LxContainer room, LxCategory category,
            Map<String, LxControlState> states) {
        super(client, uuid, name, room, category, states);
    }

    /**
     * Operate a Miniserver's switch object.
     * <p>
     * Sends a command to operate the switch.
     *
     * @param operation
     *            Operation to perform (CMD_ON or CMD_OFF)
     * @return
     *         true is operation succeeded, false is operation is not compatible with control
     * @throws IOException
     *             when something went wrong with communication
     */
    @Override
    public boolean operate(String operation) throws IOException {
        if (operation != LxControl.CMD_ON && operation != LxControl.CMD_OFF) {
            return false;
        }
        socketClient.sendAction(uuid, operation);
        return true;
    }
}
