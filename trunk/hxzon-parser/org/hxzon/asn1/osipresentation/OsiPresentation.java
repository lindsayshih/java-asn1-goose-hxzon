package org.hxzon.asn1.osipresentation;

import org.hxzon.asn1.FakeBerConstruct;
import org.hxzon.asn1.osipresentation.PdvList.PresentationDataValues;

import com.chaosinmotion.asn1.BerConstruct;
import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;

public class OsiPresentation extends BerSequence {
	public OsiPresentation() {
		setName("iso 8823 osi presentation");
		setDisplayString("iso 8823 osi presentation");
	}

	@Override
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
//		case Tag.APPLICATION | 1:
//			return new OsiPresentation(tag, this, stream);
		default:
//			return Asn1Utils.createUnknownTagBerNode(tag, stream);
			return new UserData().init(tag, stream, false);
		}
	}

	SingleAsn1Type userData;

	public SingleAsn1Type getUserData() {
		if (userData == null) {
			for (BerNode node : getChildren()) {
				node = findUserData(node);
				if (node != null) {
					userData = (SingleAsn1Type) node;
					return userData;
				}
			}
			userData = null;
		}
		return userData;
	}

	public SingleAsn1Type findUserData(BerNode node) {
		if (node instanceof SingleAsn1Type) {
			return (SingleAsn1Type) node;
		}
		if (node instanceof BerConstruct) {
			for (BerNode tmp : ((BerConstruct) node).getChildren()) {
				tmp = findUserData(tmp);
				if (tmp != null) {
					return (SingleAsn1Type) tmp;
				}
			}
		}
		if (node instanceof FakeBerConstruct) {
			for (BerNode tmp : ((FakeBerConstruct) node).getChildren()) {
				tmp = findUserData(tmp);
				if (tmp != null) {
					return (SingleAsn1Type) tmp;
				}
			}
		}
		return null;
	}
}
