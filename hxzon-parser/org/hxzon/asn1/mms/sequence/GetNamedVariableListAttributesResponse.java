package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class GetNamedVariableListAttributesResponse extends BerSequence {
//	GetNamedVariableListAttributes-Response ::= SEQUENCE
//	{
//	mmsDeletable		[0] IMPLICIT BOOLEAN,
//	listOfVariable		[1] IMPLICIT SEQUENCE OF SEQUENCE 
//		{
//		variableSpecification 		VariableSpecification,
//		alternateAccess			[5] IMPLICIT AlternateAccess OPTIONAL
//		}
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerBoolean("mmsDeletable", "mmsDeletable", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerSequenceOf("listOfVariable", "listOfVariable", tag, stream, ListOfVariable.class);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
