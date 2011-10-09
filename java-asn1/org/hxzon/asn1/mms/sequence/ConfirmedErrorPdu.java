package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;

public class ConfirmedErrorPdu extends BerSequence {
    public ConfirmedErrorPdu() {
    }

//	Confirmed-ErrorPDU ::= SEQUENCE 
//	{
//	invokeID 			[0]	IMPLICIT Unsigned32,
//	modifierPosition	[1]	IMPLICIT Unsigned32 OPTIONAL,
//	serviceError		[2]	IMPLICIT ServiceError
//	}

    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return Asn1Utils.createBerUnsigned32("invokeID", "invokeID", tag, stream);
        case Tag.CONTEXT | 1:
            return Asn1Utils.createBerUnsigned32("modifierPosition", "modifierPosition", tag, stream);
        case Tag.CONTEXT | 2:
            return new ServiceError().init("serviceError", "serviceError", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
