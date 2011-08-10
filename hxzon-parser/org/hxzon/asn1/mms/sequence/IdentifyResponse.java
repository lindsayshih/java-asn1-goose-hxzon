package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerOID;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class IdentifyResponse extends BerSequence {
//	Identify-Response ::= SEQUENCE {
//		vendorName		[0] IMPLICIT VisibleString,
//		modelName		[1] IMPLICIT VisibleString,
//		revision		[2] IMPLICIT VisibleString,
//		listOfAbstractSyntaxes	[3] IMPLICIT SEQUENCE OF OBJECT IDENTIFIER OPTIONAL
//		}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerVisibleString("verdorName", "vendorName", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerVisibleString("modelName", "modelName", tag, stream);
		case Tag.CONTEXT | 2:
			return Asn1Utils.createBerVisibleString("revision", "revision", tag, stream);
		case Tag.CONTEXT | 3:
			return Asn1Utils.createBerSequenceOf("listOfAbstractSyntaxes", "listOfAbstractSyntaxes", tag, stream, BerOID.class);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
