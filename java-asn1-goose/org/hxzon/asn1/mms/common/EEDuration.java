package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.ext.BerIntegerEx;

public class EEDuration extends BerIntegerEx {
//	EE-Duration ::= INTEGER
//	{
//	current			(0),
//	permanent		(1)
//	}
    static {
        addValueString(0, "current(0)", EEDuration.class);
        addValueString(1, "permanent(1)", EEDuration.class);

    }

    public EEDuration() {
    }

}
