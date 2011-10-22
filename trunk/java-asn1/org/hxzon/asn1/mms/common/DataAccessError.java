package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.ext.BerIntegerEx;

public class DataAccessError extends BerIntegerEx {

    public DataAccessError() {
        setName("data access error");
        setDisplayString("data access error");

//	DataAccessError ::= INTEGER
//	{
//	object-invalidated		(0),
//	hardware-fault			(1),
//	temporarily-unavailable		(2),
//	object-access-denied		(3),
//	object-undefined		(4),
//	invalid-address			(5),
//	type-unsupported		(6),
//	type-inconsistent		(7),
//	object-attribute-inconsistent	(8),
//	object-access-unsupported	(9),
//	object-non-existent		(10)
//	}
        addValueString(0, "object-invalidated(0)");
        addValueString(1, "hardware-fault(1)");
        addValueString(2, "temporarily-unavailable(2)");
        addValueString(3, "object-access-denied(3)");
        addValueString(4, "object-undefined(4)");
        addValueString(5, "invalid-address(5)");
        addValueString(6, "type-unsupported(6)");
        addValueString(7, "type-inconsistent(7)");
        addValueString(8, "object-attribute-inconsistent(8)");
        addValueString(9, "object-access-unsupported(9)");
        addValueString(10, "object-non-existent(10)");
    }

}
