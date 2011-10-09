package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.mms.common.Identifier;

public class TakeControlResponse extends BerChoice {
//	TakeControl-Response ::= CHOICE
//	{	
//	noResult		[0] IMPLICIT NULL,
//	namedToken		[1] IMPLICIT Identifier
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return Asn1Utils.createBerNull("noResult", "noResult", tag, stream);
        case Tag.CONTEXT | 1:
            return new Identifier().init("namedToken", "namedToken", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
