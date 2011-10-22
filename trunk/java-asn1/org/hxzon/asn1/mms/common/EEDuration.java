package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.ext.BerIntegerEx;

public class EEDuration extends BerIntegerEx {
//	EE-Duration ::= INTEGER
//	{
//	current			(0),
//	permanent		(1)
//	}
    public EEDuration() {
        addValueString(0, "current(0)");
        addValueString(1, "permanent(1)");
    }

}
