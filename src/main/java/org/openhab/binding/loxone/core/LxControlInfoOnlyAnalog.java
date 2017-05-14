/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.loxone.core;

import java.util.Map;

/**
 * An InfoOnlyAnalog type of control on Loxone Miniserver.
 * <p>
 * According to Loxone API documentation, this control covers analog virtual states only. This control does not send any
 * commands to the Miniserver. It can be used to read a formatted representation of an analog virtual state.
 *
 * @author Pawel Pieczul - initial commit
 *
 */
public class LxControlInfoOnlyAnalog extends LxControl {

    /**
     * A name by which Miniserver refers to analog virtual state controls
     */
    public final static String TYPE_NAME = "infoonlyanalog";
    /**
     * InfoOnlyAnalog state with current value
     */
    public final static String STATE_VALUE = "value";
    /**
     * InfoOnlyAnalog state with error value
     */
    public final static String STATE_ERROR = "error";

    private String format;

    public LxControlInfoOnlyAnalog(LxWsClient client, LxUuid uuid, String name, LxContainer room, LxCategory category,
            Map<String, LxControlState> states, String format) {
        super(client, uuid, name, room, category, states);
        this.format = format;
    }

    /**
     * Obtain current value of an analog virtual state, expressed in a format configured on the Miniserver
     *
     * @return
     *         string for the value of the state or null if current value is not compatible with this control
     */
    public String getFormattedValue() {
        LxControlState state = getState(STATE_VALUE);
        if (state != null) {
            return String.format(format, state.getValue());
        }
        return null;
    }
}
