package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.ext.BerIntegerEx;

public class ECClass extends BerIntegerEx {
//	EC-Class ::= INTEGER
//	{
//	network-triggered	(0),
//	monitored		(1)
//	}
    public ECClass() {
        addValueString(0, "network-triggered(0)");
        addValueString(1, "monitored(1)");
    }

}
