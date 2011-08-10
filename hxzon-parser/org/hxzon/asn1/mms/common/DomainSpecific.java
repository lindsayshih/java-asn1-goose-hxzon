package org.hxzon.asn1.mms.common;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;

public class DomainSpecific extends BerSequence {

	public DomainSpecific() {
		setName("domainSpecific");
		setDisplayString("domainSpecific");
	}

//	ObjectName ::= CHOICE 
//	{
//	vmd-specific		[0] IMPLICIT Identifier,
//	domain-specific	    [1] IMPLICIT SEQUENCE
//		{
//		domainId 	Identifier,
//		itemId		Identifier
//		},
//	aa-specific		[2] IMPLICIT Identifier
//	}

	@Override
	public BerNode create(int tag, BerInputStream stream) {
		if (super.isEmpty()) {
			return new Identifier().init("domainId", "domainId", tag, stream);
		} else {
			return new Identifier().init("itemId", "itemId", tag, stream);
		}
	}

}
