package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.BerChoice;
import org.hxzon.asn1.mms.common.DomainSpecific;
import org.hxzon.asn1.mms.common.Identifier;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.Tag;

public class ObjectName extends BerChoice {

	public ObjectName() {
		setName("object name");
		setDisplayString("object name");
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

	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new Identifier().init("vmd-specific", "vmd-specific", tag, stream);
		case Tag.CONTEXT | 1:
			return new DomainSpecific().init("domain-specific", "domain-specific", tag, stream);
		case Tag.CONTEXT | 2:
			return new Identifier().init("aa-specific", "aa-specific", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}
}
