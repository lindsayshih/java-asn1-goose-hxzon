package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;


public class FileName extends BerSequence {
//	FileName ::= SEQUENCE OF GraphicString

	public FileName() {
		setName("FileName");
		setDisplayString("FileName");
	}

	public BerNode create(int tag, BerInputStream stream) {
		//hxzon:use visible string
		return Asn1Utils.createBerVisibleString("fileName", "fileName", tag, stream);
	}

}
