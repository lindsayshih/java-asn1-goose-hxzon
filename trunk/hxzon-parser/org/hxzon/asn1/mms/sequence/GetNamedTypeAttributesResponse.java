package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.TypeSpecification;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class GetNamedTypeAttributesResponse extends BerSequence {
//	GetNamedTypeAttributes-Response ::= SEQUENCE
//	{
//	mmsDeletable		[0] IMPLICIT BOOLEAN,
//	typeSpecification	TypeSpecification
//	} 
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerBoolean("mmsDeletable", "mmsDeletable", tag, stream);
		default:
			return new TypeSpecification().init("typeSpecification", "typeSpecification", tag, stream);
		}
	}

}
