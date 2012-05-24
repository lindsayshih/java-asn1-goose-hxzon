package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.ext.BerIntegerEx;

public class ECState extends BerIntegerEx {
//	EC-State ::= INTEGER
//	{
//	disabled		(0),
//	idle			(1),
//	active			(2)
//	}
    static {
        addValueString(0, "disabled(0)", ECState.class);
        addValueString(1, "idle(1)", ECState.class);
        addValueString(2, "active(2)", ECState.class);

    }

    public ECState() {
    }

}
