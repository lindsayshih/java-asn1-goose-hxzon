package org.hxzon.asn1.core.type.ext;

import org.hxzon.asn1.core.type.base.BerNode;

public interface IBerConstruct {
    public BerNode[] getChildren();

    public boolean remove(BerNode o);
}
