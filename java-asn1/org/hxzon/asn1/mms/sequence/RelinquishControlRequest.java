package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.Identifier;

public class RelinquishControlRequest extends BerSequence {
//	RelinquishControl-Request ::= SEQUENCE
//	{
//	semaphoreName		[0] ObjectName,
//	namedToken		[1] IMPLICIT Identifier OPTIONAL
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new ObjectName().init("semaphoreName", "semaphoreName", tag, stream);
        case Tag.CONTEXT | 1:
            return new Identifier().init("namedToken", "namedToken", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
