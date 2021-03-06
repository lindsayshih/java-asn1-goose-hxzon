package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.Modifier;
import org.hxzon.asn1.mms.choice.ObjectName;

public class DefineEventActionRequest extends BerSequence {
//	DefineEventAction-Request ::= SEQUENCE
//	{
//	eventActionName              	[0] ObjectName,
//	listOfModifier			[1] IMPLICIT SEQUENCE OF Modifier OPTIONAL
//-- XXX this one is neither in this ASN nor in the IMPORTS
//--	confirmed-Service-Request	[2] DefineEventAction-ConfirmedServiceRequest
//
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new ObjectName().init("eventActionName", "eventActionName", tag, stream);
        case Tag.CONTEXT | 1:
            return Asn1Utils.createBerSequenceOf("listOfModifier", "listOfModifier", tag, stream, Modifier.class, false);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
