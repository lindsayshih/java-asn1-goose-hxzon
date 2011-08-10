package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.AccessResult;
import org.hxzon.asn1.mms.choice.VariableAccessSpecification;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class ReadResponse extends BerSequence {
//	Read-Response ::= SEQUENCE
//	{
//	variableAccessSpecificatn [0] VariableAccessSpecification OPTIONAL,
//	listOfAccessResult	  [1] IMPLICIT SEQUENCE OF AccessResult
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new VariableAccessSpecification().init("variableAccessSpecificatn", "variableAccessSpecificatn", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerSequenceOf("listOfAccessResult", "listOfAccessResult", tag, stream, AccessResult.class);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
