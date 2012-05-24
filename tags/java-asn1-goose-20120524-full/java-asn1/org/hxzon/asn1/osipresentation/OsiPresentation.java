package org.hxzon.asn1.osipresentation;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;

public class OsiPresentation extends BerSequence implements UserDataContainer {
    public OsiPresentation() {
        setId("iso 8823 osi presentation");
        setName("iso 8823 osi presentation");
    }

    @Override
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
//		case Tag.APPLICATION | 1:
//			return new OsiPresentation(tag, this, stream);
        default:
//			return Asn1Utils.createUnknownTagBerNode(tag, stream);
            return new OsiUserData().init(tag, stream, false);
        }
    }

    SingleAsn1Type userData;

    public BerNode[] getUserData() {
        for (BerNode child : getChildren()) {
            if (child instanceof UserDataContainer) {
                return ((UserDataContainer) child).getUserData();
            }
        }
        return new BerNode[0];
    }

}
