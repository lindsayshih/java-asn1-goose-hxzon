package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;

public class FileReadResponse extends BerSequence {
//	FileRead-Response ::= SEQUENCE {
//		fileData	[0] IMPLICIT OCTET STRING,
//		moreFollows	[1] IMPLICIT BOOLEAN DEFAULT TRUE
//		}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return Asn1Utils.createBerOctetString("fileData", "fileData", tag, stream);
        case Tag.CONTEXT | 1:
            return Asn1Utils.createBerBoolean("moreFollows", "moreFollows", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
