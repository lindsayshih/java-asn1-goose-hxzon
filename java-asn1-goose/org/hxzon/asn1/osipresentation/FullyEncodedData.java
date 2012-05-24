package org.hxzon.asn1.osipresentation;

import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerSequenceOf;

public class FullyEncodedData extends BerSequenceOf implements UserDataContainer {

    public FullyEncodedData() {
        super(PdvList.class);
    }

    public BerNode[] getUserData() {
        return getChildren();
    }

}
