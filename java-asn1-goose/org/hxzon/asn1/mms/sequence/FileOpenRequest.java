package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.common.FileName;

public class FileOpenRequest extends BerSequence {
//	FileOpen-Request ::= SEQUENCE {
//		fileName	[0] IMPLICIT FileName,
//		initialPosition	[1] IMPLICIT Unsigned32
//		}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new FileName().init("fileName", "fileName", tag, stream);
        case Tag.CONTEXT | 1:
            return Asn1Utils.createBerUnsigned32("initialPosition", "initialPosition", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
