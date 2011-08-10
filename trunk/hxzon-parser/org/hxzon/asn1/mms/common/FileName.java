package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;

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
