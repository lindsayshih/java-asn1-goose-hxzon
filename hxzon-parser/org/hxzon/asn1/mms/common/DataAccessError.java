package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.BerInteger;

public class DataAccessError extends BerInteger {

	public DataAccessError() {
		setName("data access error");
		setDisplayString("data access error");
	}

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

	public String getValueAsString() {
		switch ((int) getValue()) {
		case 0:
			return "object-invalidated(0)";
		case 1:
			return "hardware-fault(1)";
		case 2:
			return "temporarily-unavailable(2)";
		case 3:
			return "object-access-denied(3)";
		case 4:
			return "object-undefined(4)";
		case 5:
			return "invalid-address(5)";
		case 6:
			return "type-unsupported(6)";
		case 7:
			return "type-inconsistent(7)";
		case 8:
			return "object-attribute-inconsistent(8)";
		case 9:
			return "object-access-unsupported(9)";
		case 10:
			return "object-non-existent(10)";
		default:
			return "";
		}
	}

}
