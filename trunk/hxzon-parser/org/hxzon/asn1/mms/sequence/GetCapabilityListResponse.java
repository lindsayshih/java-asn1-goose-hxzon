package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.BerVisibleString;
import com.chaosinmotion.asn1.Tag;

public class GetCapabilityListResponse extends BerSequence {
//	GetCapabilityList-Response ::= SEQUENCE {
//		listOfCapabilities	[0] IMPLICIT SEQUENCE OF VisibleString,
//		moreFollows		[1] IMPLICIT BOOLEAN DEFAULT TRUE
//		}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerSequenceOf("listOfCapabilities", "listOfCapabilities", tag, stream, BerVisibleString.class);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerBoolean("moreFollows", "moreFollows", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
