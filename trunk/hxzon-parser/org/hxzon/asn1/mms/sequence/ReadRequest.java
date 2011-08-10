package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.VariableAccessSpecification;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class ReadRequest extends BerSequence {
//	Read-Request ::= SEQUENCE
//	{
//	specificationWithResult		[0] IMPLICIT BOOLEAN DEFAULT FALSE,
//	variableAccessSpecificatn	[1] VariableAccessSpecification
//	}

	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerBoolean("specificationWithResult", "specificationWithResult", tag, stream);
		case Tag.CONTEXT | 1:
			return new VariableAccessSpecification().init("variableAccessSpecificatn", "variableAccessSpecificatn", tag, stream, true);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
