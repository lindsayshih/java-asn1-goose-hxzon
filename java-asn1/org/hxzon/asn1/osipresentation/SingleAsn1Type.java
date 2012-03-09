package org.hxzon.asn1.osipresentation;

import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.core.type.ext.BerSequenceOf;

public class SingleAsn1Type extends BerSequenceOf implements UserDataContainer {

    public SingleAsn1Type(Class<? extends BerNode> type) {
        super(type);
    }

    public SingleAsn1Type(Class<? extends BerChoice> type, boolean choiceChildHasTag) {
        super(type, choiceChildHasTag);
    }

    public BerNode[] getUserData() {
        return getChildren();
    }
}
