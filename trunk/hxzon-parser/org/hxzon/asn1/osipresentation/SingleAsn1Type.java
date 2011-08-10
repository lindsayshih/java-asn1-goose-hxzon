package org.hxzon.asn1.osipresentation;

import org.hxzon.asn1.BerSequenceOf;

import com.chaosinmotion.asn1.BerNode;

public class SingleAsn1Type extends BerSequenceOf implements UserDataContainer {

	public SingleAsn1Type(Class<? extends BerNode> type) {
		super(type);
	}

	public SingleAsn1Type(Class<? extends BerNode> type, boolean choiceChildHasTag) {
		super(type, choiceChildHasTag);
	}

	public BerNode[] getUserData() {
		return getChildren();
	}
}
