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
 * A jalousie type of control on Loxone Miniserver.
 * <p>
 * According to Loxone API documentation, a jalousie control covers:
 * <ul>
 * <li>Blinds
 * <li>Automatic blinds
 * <li>Automatic blinds integrated
 * </ul>
 *
 * @author Pawel Pieczul - initial commit
 *
 */
public class LxControlJalousie extends LxControl {
    /**
     * A name by which Miniserver refers to jalousie controls
     */
    public final static String TYPE_NAME = "jalousie";

    /**
     * Jalousie is moving up
     */
    public final static String STATE_UP = "up";
    /**
     * Jalousie is moving down
     */
    public final static String STATE_DOWN = "down";
    /**
     * The position of the Jalousie, a number from 0 to 1
     * Jalousie upper position = 0
     * Jalousie lower position = 1
     */
    public final static String STATE_POSITION = "position";
    /**
     * The shade position of the Jalousie (blinds), a number from 0 to 1
     * Blinds are not shaded = 0
     * Blinds are shaded = 1
     */
    public final static String STATE_SHADE_POSITION = "shadeposition";
    /**
     * Only used by ones with Autopilot, this represents the safety shutdown
     */
    public final static String STATE_SAFETY_ACTIVE = "safetyactive";
    /**
     * Only used by ones with Autopilot
     */
    public final static String STATE_AUTO_ALLOWED = "autoallowed";
    /**
     * Only used by ones with Autopilot
     */
    public final static String STATE_AUTO_ACTIVE = "autoactive";
    /**
     * Only used by ones with Autopilot, this represents the output QI in Loxone Config
     */
    public final static String STATE_LOCKED = "locked";

    /**
     * Command string used to set control's state to Down
     */
    private final static String CMD_DOWN = "Down";
    /**
     * Command string used to set control's state to Up
     */
    private final static String CMD_UP = "Up";
    /**
     * Command string used to set control's state to Full Down
     */
    private final static String CMD_FULL_DOWN = "FullDown";
    /**
     * Command string used to set control's state to Full Up
     */
    private final static String CMD_FULL_UP = "FullUp";
    /**
     * Command string used to stop rollershutter
     */
    private final static String CMD_STOP = "Stop";

    public LxControlJalousie(LxWsClient client, LxUuid uuid, String name, LxContainer room, LxCategory category,
            Map<String, LxControlState> states) {
        super(client, uuid, name, room, category, states);
    }

    /**
     * Set rollershutter to full up position.
     * <p>
     * Sends a command to operate the rollershutter.
     *
     * @throws IOException
     *             when something went wrong with communication
     */
    public void FullUp() throws IOException {
        socketClient.sendAction(uuid, CMD_FULL_UP);
    }

    /**
     * Set rollershutter to full down position.
     * <p>
     * Sends a command to operate the rollershutter.
     *
     * @throws IOException
     *             when something went wrong with communication
     */
    public void FullDown() throws IOException {
        socketClient.sendAction(uuid, CMD_FULL_DOWN);
    }

    /**
     * Stop movement of a rollershutter
     * <p>
     * Sends a command to operate the rollershutter.
     *
     * @throws IOException
     *             when something went wrong with communication
     */
    public void Stop() throws IOException {
        socketClient.sendAction(uuid, CMD_STOP);
    }

}
