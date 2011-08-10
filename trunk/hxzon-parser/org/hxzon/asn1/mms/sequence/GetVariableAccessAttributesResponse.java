package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.Address;
import org.hxzon.asn1.mms.choice.TypeSpecification;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class GetVariableAccessAttributesResponse extends BerSequence {
//	GetVariableAccessAttributes-Response ::= SEQUENCE
//	{
//	mmsDeletable		[0] IMPLICIT BOOLEAN,
//	address			[1] Address OPTIONAL,
//	typeSpecification	[2] TypeSpecification
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerBoolean("mmsDeletable", "mmsDeletable", tag, stream);
		case Tag.CONTEXT | 1:
			return new Address().init("address", "address", tag, stream, true);
		case Tag.CONTEXT | 2:
			return new TypeSpecification().init("typeSpecification", "typeSpecification", tag, stream, true);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
