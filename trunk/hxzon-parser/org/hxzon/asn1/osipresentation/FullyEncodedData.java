package org.hxzon.asn1.osipresentation;

import org.hxzon.asn1.BerSequenceOf;

import com.chaosinmotion.asn1.BerNode;

public class FullyEncodedData extends BerSequenceOf implements UserDataContainer {

	public FullyEncodedData() {
		super(PdvList.class);
	}

	public BerNode[] getUserData() {
		return getChildren();
	}

}
