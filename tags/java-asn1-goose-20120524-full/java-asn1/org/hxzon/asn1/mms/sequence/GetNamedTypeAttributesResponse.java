package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.TypeSpecification;

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
