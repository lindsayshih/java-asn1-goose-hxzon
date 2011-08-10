package org.hxzon.asn1;

import com.chaosinmotion.asn1.BerOctetString;
import com.chaosinmotion.asn1.Tag;

public class UnknownBerNode extends BerOctetString {

	public UnknownBerNode(int tag) {
		setName("unknown " + Tag.toString(tag));
		setDisplayString("unknown " + Tag.toString(tag));
	}
}
