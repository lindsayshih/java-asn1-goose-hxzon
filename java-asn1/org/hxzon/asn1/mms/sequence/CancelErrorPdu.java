package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;

public class CancelErrorPdu extends BerSequence {
//	Cancel-ErrorPDU ::= SEQUENCE
//	{
//	originalInvokeID	[0] IMPLICIT Unsigned32,
//	serviceError		[1] IMPLICIT ServiceError
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return Asn1Utils.createBerUnsigned32("originalInvokeID", "originalInvokeID", tag, stream);
        case Tag.CONTEXT | 1:
            return new ServiceError().init("serviceError", "serviceError", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
