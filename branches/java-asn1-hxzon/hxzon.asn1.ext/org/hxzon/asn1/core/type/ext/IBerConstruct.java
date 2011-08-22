package org.hxzon.asn1.core.type.ext;

import com.chaosinmotion.asn1.BerNode;

public interface IBerConstruct {
	public BerNode[] getChildren();

	public boolean remove(BerNode o);
}
