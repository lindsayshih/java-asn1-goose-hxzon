package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.ext.BerIntegerEx;

public class DomainState extends BerIntegerEx {
//	DomainState ::= INTEGER
//	{
//	non-existent	(0),
//	loading		(1),
//	ready		(2),
//	in-use		(3),
//	complete	(4),
//	incomplete	(5),
//	d1		(7),
//	d2		(8),
//	d3		(9),
//	d4		(10),
//	d5		(11),
//	d6		(12),
//	d7		(13),
//	d8		(14),
//	d9		(15)
//	}
    public DomainState() {
        addValueString(0, "non-existent(0)");
        addValueString(1, "loading(1)");
        addValueString(2, "ready(2)");
        addValueString(3, "in-use(3)");
        addValueString(4, "complete(4)");
        addValueString(5, "incomplete(5)");
        addValueString(6, null);
        addValueString(7, "d1(7)");
        addValueString(8, "d2(8)");
        addValueString(9, "d3(9)");
        addValueString(10, "d4(10)");
        addValueString(11, "d5(11)");
        addValueString(12, "d6(12)");
        addValueString(13, "d7(13)");
        addValueString(14, "d8(14)");
        addValueString(15, "d9(15)");
    }

}
