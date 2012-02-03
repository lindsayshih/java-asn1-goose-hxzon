package org.hxzon.asn1.core.type.ext;

import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.type.BerOctetString;

public class UnknownBerNode extends BerOctetString {

    public UnknownBerNode(int tag) {
        setName("unknown " + Tag.toString(tag));
        setDisplayString("unknown " + Tag.toString(tag));
    }
}
