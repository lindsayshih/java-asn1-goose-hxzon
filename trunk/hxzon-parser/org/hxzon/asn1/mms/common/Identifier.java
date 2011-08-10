package org.hxzon.asn1.mms.common;

import com.chaosinmotion.asn1.BerVisibleString;

public class Identifier extends BerVisibleString {
//	Identifier ::= VisibleString

	public Identifier() {
		setName("Identifier");
		setDisplayString("Identifier");
	}
}
