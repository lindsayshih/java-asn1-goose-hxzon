package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.ext.BerIntegerEx;

public class AcknowledgmentFilter extends BerIntegerEx {
//	acknowledgmentFilter		[2] IMPLICIT INTEGER 
//	{
//	not-acked			(0),
//	acked				(1),
//	all				(2) 
//	} DEFAULT not-acked,
    static {
        addValueString(0, "not-acked(0)", AcknowledgmentFilter.class);
        addValueString(1, "acked(1)", AcknowledgmentFilter.class);
        addValueString(2, "all(2)", AcknowledgmentFilter.class);
    }

    public AcknowledgmentFilter() {
    }

}
