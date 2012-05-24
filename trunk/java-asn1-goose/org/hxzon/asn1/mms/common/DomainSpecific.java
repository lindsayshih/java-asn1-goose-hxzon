package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;

public class DomainSpecific extends BerSequence {

    public DomainSpecific() {
        setId("domainSpecific");
        setName("domainSpecific");
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
