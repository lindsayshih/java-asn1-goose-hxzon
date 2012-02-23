package org.hxzon.asn1.core.type.ext;

import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.type.BerOctetString;

public class UnknownBerNode extends BerOctetString {

    public UnknownBerNode() {
        setId("unknown");
        setName("unknown");
    }

    public UnknownBerNode(int tag) {
        setId("unknown " + Tag.toString(tag));
        setName("unknown " + Tag.toString(tag));
    }

    public void setTag(int tag) {
        super.setTag(tag);
        setId("unknown " + Tag.toString(tag));
        setName("unknown " + Tag.toString(tag));
        setDisplayString(null);
    }

}
