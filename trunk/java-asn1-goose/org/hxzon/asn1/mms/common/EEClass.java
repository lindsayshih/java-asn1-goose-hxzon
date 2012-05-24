package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.ext.BerIntegerEx;

public class EEClass extends BerIntegerEx {
//	EE-Class ::= INTEGER
//	{
//	modifier		(0),
//	notification		(1)
//	}
    static {
        addValueString(0, "modifier(0)", EEClass.class);
        addValueString(1, "notification(1)", EEClass.class);

    }

    public EEClass() {
    }

}
