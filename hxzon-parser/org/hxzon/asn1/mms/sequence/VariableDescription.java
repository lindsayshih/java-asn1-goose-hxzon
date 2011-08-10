package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.UnknownBerNode;
import org.hxzon.asn1.mms.choice.Address;
import org.hxzon.asn1.mms.choice.TypeSpecification;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;

public class VariableDescription extends BerSequence {

	public VariableDescription() {
		setName("VariableDescription");
	}

//	VariableSpecification ::= CHOICE
//	{
//	name				[0] ObjectName,
//	address				[1] Address,
//	variableDescription		[2] IMPLICIT SEQUENCE
//		{
//		address			Address,
//		typeSpecification	TypeSpecification
//		},
//	scatteredAccessDescription	[3] IMPLICIT ScatteredAccessDescription,
//	invalidated			[4] IMPLICIT NULL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		//TODO
		BerNode node = new Address().init("address", "address", tag, stream);
		if (((Address) node).getRealNode() instanceof UnknownBerNode) {
			node = new TypeSpecification().init("typeSpecification", "typeSpecification", tag, stream);
		}
		return node;
//		switch (tag) {
//		default:
//			return Asn1Utils.createUnknownTagBerNode(tag, stream);
//		}
	}
}
