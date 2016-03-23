/*
 * Copyright 2002-2016 jamod & j2mod development teams
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.j2mod.modbus.procimg;

import com.j2mod.modbus.util.Observable;

/**
 * Class implementing an observable digital output.
 *
 * @author Dieter Wimberger
 * @version 1.2rc1 (09/11/2004)
 *
 * @author Steve O'Hara (4energy)
 * @version 2.0 (March 2016)
 *
 */
public class ObservableDigitalOut extends Observable implements DigitalOut {

    /**
     * A boolean holding the state of this digital out.
     */
    protected boolean m_Set;

    /**
     * Determine if the digital output is set.
     *
     * @return the boolean value of the digital output.
     */
    public boolean isSet() {
        return m_Set;
    }

    /**
     * Set or clear the digital output.  Will notify any registered
     * observers.
     */
    public void set(boolean b) {
        m_Set = b;
        notifyObservers("value");
    }
}
