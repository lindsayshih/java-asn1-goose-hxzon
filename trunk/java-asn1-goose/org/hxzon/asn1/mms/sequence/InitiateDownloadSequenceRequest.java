package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.BerVisibleString;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.common.Identifier;

public class InitiateDownloadSequenceRequest extends BerSequence {
//	InitiateDownloadSequence-Request ::= SEQUENCE
//	{
//	domainName		[0] IMPLICIT Identifier,
//	listOfCapabilities	[1] IMPLICIT SEQUENCE OF VisibleString,
//	sharable		[2] IMPLICIT BOOLEAN
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new Identifier().init("domainName", "domainName", tag, stream);
        case Tag.CONTEXT | 1:
            return Asn1Utils.createBerSequenceOf("listOfCapabilities", "listOfCapabilities", tag, stream, BerVisibleString.class);
        case Tag.CONTEXT | 2:
            return Asn1Utils.createBerBoolean("sharable", "sharable", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
