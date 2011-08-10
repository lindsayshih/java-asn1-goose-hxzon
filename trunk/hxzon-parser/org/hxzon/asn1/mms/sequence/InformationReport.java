package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.AccessResult;
import org.hxzon.asn1.mms.choice.VariableAccessSpecification;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class InformationReport extends BerSequence {

	public InformationReport() {
		setName("information report");
		setDisplayString("information report");
	}

//	InformationReport ::= SEQUENCE
//	{
//	variableAccessSpecification	VariableAccessSpecification,
//	listOfAccessResult		[0] IMPLICIT SEQUENCE OF AccessResult
//	}

	@Override
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerSequenceOf("listOfAccessResult", "access result集", tag, stream, AccessResult.class);
		default:
			return new VariableAccessSpecification().init(tag, stream,false);
		}
	}

}
