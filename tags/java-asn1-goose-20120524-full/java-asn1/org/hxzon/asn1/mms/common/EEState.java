package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.ext.BerIntegerEx;

public class EEState extends BerIntegerEx {
//	EE-State ::= INTEGER
//	{
//	disabled		(0),
//	idle			(1),
//	active			(2),
//	activeNoAckA		(3),
//	idleNoAckI		(4),
//	idleNoAckA		(5),
//	idleAcked		(6),
//	activeAcked		(7)
//	}
    static {
        addValueString(0, "disabled(0)");
        addValueString(1, "idle(1)");
        addValueString(2, "active(2)");
        addValueString(3, "activeNoAckA(3)");
        addValueString(4, "idleNoAckI(4)");
        addValueString(5, "idleNoAckA(5)");
        addValueString(6, "idleAcked(6)");
        addValueString(7, "activeAcked(7)");

    }

    public static void addValueString(int value, String valueString) {
        addValueString(value, valueString, EEState.class);
    }

    public EEState() {
    }

}
