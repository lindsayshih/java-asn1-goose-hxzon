package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.ext.BerIntegerEx;

public class ECState extends BerIntegerEx {
//	EC-State ::= INTEGER
//	{
//	disabled		(0),
//	idle			(1),
//	active			(2)
//	}
    public ECState() {
        addValueString(0, "disabled(0)");
        addValueString(1, "idle(1)");
        addValueString(2, "active(2)");
    }

}
