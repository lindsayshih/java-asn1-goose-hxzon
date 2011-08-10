package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.ObjectName;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class DefineNamedVariableListRequest extends BerSequence {
//	DefineNamedVariableList-Request ::= SEQUENCE
//	{
//	variableListName	ObjectName,
//	listOfVariable		[0] IMPLICIT SEQUENCE OF SEQUENCE
//		{
//		variableSpecification 	VariableSpecification,
//		alternateAccess		[5] IMPLICIT AlternateAccess OPTIONAL
//		}
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerSequenceOf("listOfVariable", "listOfVariable", tag, stream, ListOfVariable.class);
		default:
//			return Asn1Utils.createUnknownTagBerNode(tag, stream);
			return new ObjectName().init("variableListName", "variableListName", tag, stream);
		}
	}

}
