package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.Modifier;

public class GetEventActionAttributesResponse extends BerSequence {
//	GetEventActionAttributes-Response ::= SEQUENCE
//	{
//	mmsDeletable			[0] IMPLICIT BOOLEAN DEFAULT FALSE,
//	listOfModifier			[1] IMPLICIT SEQUENCE OF Modifier
//-- XXX this one is neither in this ASN nor in the IMPORTS
//--	confirmed-Service-Request	[2] DefineEventAction-ConfirmedServiceRequest
// 	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return Asn1Utils.createBerBoolean("mmsDeletable", "mmsDeletable", tag, stream);
        case Tag.CONTEXT | 1:
            return Asn1Utils.createBerSequenceOf("listOfModifier", "listOfModifier", tag, stream, Modifier.class);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
