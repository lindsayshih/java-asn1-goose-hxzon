package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.mms.common.Identifier;

public class ReportPoolSemaphoreStatusResponse extends BerSequence {
//	ReportPoolSemaphoreStatus-Response ::= SEQUENCE
//	{
//	listOfNamedTokens	[0] IMPLICIT SEQUENCE OF CHOICE
//		{
//		freeNamedToken		[0] IMPLICIT Identifier,
//		ownedNamedToken		[1] IMPLICIT Identifier,
//		hungNamedToken		[2] IMPLICIT Identifier
//		},
//	moreFollows		[1] IMPLICIT BOOLEAN DEFAULT TRUE
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return Asn1Utils.createBerSequenceOf("listOfNamedTokens", "listOfNamedTokens", tag, stream, NamedTokens.class);
        case Tag.CONTEXT | 1:
            return Asn1Utils.createBerBoolean("moreFollows", "moreFollows", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

    public static class NamedTokens extends BerChoice {
        public BerNode create(int tag, BerInputStream stream) {
            switch (tag) {
            case Tag.CONTEXT | 0:
                return new Identifier().init("freeNamedToken", "freeNamedToken", tag, stream);
            case Tag.CONTEXT | 1:
                return new Identifier().init("ownedNamedToken", "ownedNamedToken", tag, stream);
            case Tag.CONTEXT | 2:
                return new Identifier().init("hungNamedToken", "hungNamedToken", tag, stream);
            default:
                return Asn1Utils.createUnknown(tag, stream);
            }
        }
    }

}
