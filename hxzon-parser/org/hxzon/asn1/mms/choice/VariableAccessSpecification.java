package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.BerChoice;
import org.hxzon.asn1.mms.sequence.ListOfVariable;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.Tag;

public class VariableAccessSpecification extends BerChoice {

	public VariableAccessSpecification() {
		setName("variable access specification");
		setDisplayString("variable access specification");
	}

//	VariableAccessSpecification ::= CHOICE
//	{
//	listOfVariable		[0] IMPLICIT SEQUENCE OF SEQUENCE
//		{
//		variableSpecification	VariableSpecification,
//		alternateAccess		[5] IMPLICIT AlternateAccess OPTIONAL
//		},
//	variableListName	[1] ObjectName
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerSequenceOf("listOfVariable", "listOfVariable", tag, stream, ListOfVariable.class);
		case Tag.CONTEXT | 1:
			return new ObjectName().init("variableListName","variableListName",tag, stream, true);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
