package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;

public class GetCapabilityListRequest extends BerSequence {
//	GetCapabilityList-Request ::= SEQUENCE {
//		continueAfter	VisibleString OPTIONAL
//		}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		default:
			return Asn1Utils.createBerVisibleString("continueAfter", "continueAfter", tag, stream);
		}
	}

}
