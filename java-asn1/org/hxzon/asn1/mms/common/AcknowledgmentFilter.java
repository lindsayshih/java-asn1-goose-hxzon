package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.ext.BerIntegerEx;

public class AcknowledgmentFilter extends BerIntegerEx {
//	acknowledgmentFilter		[2] IMPLICIT INTEGER 
//	{
//	not-acked			(0),
//	acked				(1),
//	all				(2) 
//	} DEFAULT not-acked,
    public AcknowledgmentFilter() {
        addValueString(0, "not-acked(0)");
        addValueString(1, "acked(1)");
        addValueString(2, "all(2)");
    }
}
