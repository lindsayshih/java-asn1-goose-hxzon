package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.common.Identifier;

public class StopRequest extends BerSequence {
//	Stop-Request ::= SEQUENCE 
//	{
//	programInvocationName	[0] IMPLICIT Identifier
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new Identifier().init("programInvocationName", "programInvocationName", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
