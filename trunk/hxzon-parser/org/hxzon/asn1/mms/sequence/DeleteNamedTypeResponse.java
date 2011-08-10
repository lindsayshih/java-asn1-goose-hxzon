package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class DeleteNamedTypeResponse extends BerSequence {
//	DeleteNamedType-Response ::= SEQUENCE
//	{
//	numberMatched	[0] IMPLICIT Unsigned32,
//	numberDeleted	[1] IMPLICIT Unsigned32
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerUnsignedInteger("numberMatched", "numberMatched", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerUnsignedInteger("numberDeleted", "numberDeleted", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
