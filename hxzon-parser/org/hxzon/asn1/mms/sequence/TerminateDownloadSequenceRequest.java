package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.common.Identifier;

public class TerminateDownloadSequenceRequest extends BerSequence {
//	TerminateDownloadSequence-Request ::= SEQUENCE
//	{
//	domainName	[0] IMPLICIT Identifier,
//	discard		[1] IMPLICIT ServiceError OPTIONAL
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new Identifier().init("domainName", "domainName", tag, stream);
        case Tag.CONTEXT | 1:
            return new ServiceError().init("discard", "discard", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
