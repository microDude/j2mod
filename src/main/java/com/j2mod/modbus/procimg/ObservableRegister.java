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
 * Class implementing an observable register.
 *
 * @author Dieter Wimberger
 * @version 1.2rc1 (09/11/2004)
 *
 * @author Steve O'Hara (4energy)
 * @version 2.0 (March 2016)
 *
 */
public class ObservableRegister extends Observable implements Register {

    /**
     * The word holding the content of this register.
     */
    protected short m_Register;

    synchronized public int getValue() {
        return m_Register & 0xFFFF;
    }

    public final int toUnsignedShort() {
        return m_Register & 0xFFFF;
    }

    public final short toShort() {
        return m_Register;
    }

    public synchronized byte[] toBytes() {
        return new byte[]{(byte)(m_Register >> 8), (byte)(m_Register & 0xFF)};
    }

    public final synchronized void setValue(short s) {
        m_Register = s;
        notifyObservers("value");
    }

    public final synchronized void setValue(byte[] bytes) {
        if (bytes.length < 2) {
            throw new IllegalArgumentException();
        }
        else {
            m_Register = (short)(((short)((bytes[0] << 8))) | (((short)(bytes[1])) & 0xFF));
            notifyObservers("value");
        }
    }

    public final synchronized void setValue(int v) {
        m_Register = (short)v;
        notifyObservers("value");
    }
}