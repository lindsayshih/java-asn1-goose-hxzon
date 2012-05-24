package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.ext.BerIntegerEx;

public class ECClass extends BerIntegerEx {
//	EC-Class ::= INTEGER
//	{
//	network-triggered	(0),
//	monitored		(1)
//	}
    static {
        addValueString(0, "network-triggered(0)", ECClass.class);
        addValueString(1, "monitored(1)", ECClass.class);

    }

    public ECClass() {
    }

}
