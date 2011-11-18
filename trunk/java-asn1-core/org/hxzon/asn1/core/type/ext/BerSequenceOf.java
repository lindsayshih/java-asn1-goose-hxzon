package org.hxzon.asn1.core.type.ext;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;

public class BerSequenceOf extends BerSequence {
    private Class<? extends BerNode> _type;
    private boolean _choiceChildHasTag = false;

    public BerSequenceOf(Class<? extends BerNode> type) {
        this(type, false);
    }

    public BerSequenceOf(Class<? extends BerNode> type, boolean choiceChildHasTag) {
        this._type = type;
        this._choiceChildHasTag = choiceChildHasTag;
        setName("seq of " + type.getSimpleName());
    }

    @Override
    public BerNode create(int tag, BerInputStream stream) {
        BerNode node = null;
        try {
            node = _type.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (node instanceof BerChoice) {
            return ((BerChoice) node).init(tag, stream, _choiceChildHasTag);
        }
        return node.init(tag, stream);
    }

}
