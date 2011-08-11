package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.VariableAccessSpecification;


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
