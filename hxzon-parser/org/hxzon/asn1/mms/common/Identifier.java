package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.BerVisibleString;

public class Identifier extends BerVisibleString {
//	Identifier ::= VisibleString

	public Identifier() {
		setName("Identifier");
		setDisplayString("Identifier");
	}
}
