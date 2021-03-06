package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;

public class GetCapabilityListRequest extends BerSequence {
//	GetCapabilityList-Request ::= SEQUENCE {
//		continueAfter	VisibleString OPTIONAL
//		}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        default:
            return Asn1Utils.createBerVisibleString("continueAfter", "continueAfter", tag, stream);
        }
    }

}
