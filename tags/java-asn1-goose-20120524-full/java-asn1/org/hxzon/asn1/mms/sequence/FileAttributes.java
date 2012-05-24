package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;

public class FileAttributes extends BerSequence {
//	FileAttributes ::= SEQUENCE {
//		sizeOfFile	[0] IMPLICIT Unsigned32,
//		lastModified	[1] IMPLICIT GeneralizedTime OPTIONAL
//		}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return Asn1Utils.createBerUnsigned32("sizeOfFile", "sizeOfFile", tag, stream);
        case Tag.CONTEXT | 1:
            //TODO
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
