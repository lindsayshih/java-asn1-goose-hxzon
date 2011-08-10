package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.common.Identifier;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.BerVisibleString;
import com.chaosinmotion.asn1.Tag;

public class InputRequest extends BerSequence {
//	Input-Request ::= SEQUENCE
//	{
//	operatorStationName	[0] IMPLICIT Identifier,
//	echo			[1] IMPLICIT BOOLEAN DEFAULT TRUE,
//	listOfPromptData	[2] IMPLICIT SEQUENCE OF VisibleString OPTIONAL,
//	inputTimeOut		[3] IMPLICIT Unsigned32 OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new Identifier().init("operatorStationName", "operatorStationName", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerBoolean("echo", "echo", tag, stream);
		case Tag.CONTEXT | 2:
			return Asn1Utils.createBerSequenceOf("listOfPromptData", "listOfPromptData", tag, stream, BerVisibleString.class);
		case Tag.CONTEXT | 3:
			return Asn1Utils.createBerUnsigned32("inputTimeOut", "inputTimeOut", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
