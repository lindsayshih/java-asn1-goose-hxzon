package org.hxzon.asn1.core.type.ext;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;


public class BerSequenceOf extends BerSequence {
	private Class<? extends BerNode> type;
	private boolean choiceChildHasTag = false;

	public BerSequenceOf(Class<? extends BerNode> type) {
		this(type, false);
	}

	public BerSequenceOf(Class<? extends BerNode> type, boolean choiceChildHasTag) {
		this.type = type;
		this.choiceChildHasTag = choiceChildHasTag;
		setName("seq of " + type.getSimpleName());
	}

	@Override
	public BerNode create(int tag, BerInputStream stream) {
		BerNode node = null;
		try {
			node = type.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (node instanceof BerChoice) {
			return ((BerChoice) node).init(tag, stream, choiceChildHasTag);
		}
		return node.init(tag, stream);
	}

}
