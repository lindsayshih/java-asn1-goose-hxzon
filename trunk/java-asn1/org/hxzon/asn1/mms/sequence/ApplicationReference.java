package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;

public class ApplicationReference extends BerSequence {
//	ApplicationReference ::= SEQUENCE
//	{
//	ap-title			[0] AP-title 	        OPTIONAL,
//	ap-invocation-id	[1] AP-invocation-identifier OPTIONAL,
//	ae-qualifier		[2] AE-qualifier	        OPTIONAL,
//	ae-invocation-id	[3] AE-invocation-identifier OPTIONAL
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
//			return 
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
