package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.common.Identifier;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.BerVisibleString;
import com.chaosinmotion.asn1.Tag;

public class OutputRequest extends BerSequence {
//	Output-Request ::= SEQUENCE
//	{
//	operatorStationName	[0] IMPLICIT Identifier,
//	listOfOutputData	[1] IMPLICIT SEQUENCE OF VisibleString
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new Identifier().init("operatorStationName", "operatorStationName", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerSequenceOf("listOfOutputData", "listOfOutputData", tag, stream, BerVisibleString.class);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
