package org.hxzon.asn1.osipresentation;

import org.hxzon.asn1.BerSequenceOf;

import com.chaosinmotion.asn1.BerNode;

public class SingleAsn1Type extends BerSequenceOf {

	public SingleAsn1Type(Class<? extends BerNode> type) {
		super(type);
	}

	public SingleAsn1Type(Class<? extends BerNode> type, boolean choiceChildHasTag) {
		super(type, choiceChildHasTag);
	}
}
