package org.hxzon.netprotocol.packet;

import org.hxzon.asn1.osipresentation.OsiPresentationParser;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;

import com.chaosinmotion.asn1.BerNode;

public class OsiPresentationPacket extends Packet {
	static {
		ProtocolBindingList.addBinding(new ProtocolBinding<OsiSessionPacket>() {

			@Override
			public Packet match(OsiSessionPacket packet) {
				return new OsiPresentationPacket();
			}

		});
	}
	private BerNode osiPresentation;

	protected int expectHeaderLength() {
		return getSrcData().length - getOffset();
	}

	public BerNode fetchPresentation() {
		if (osiPresentation == null) {
			osiPresentation = new OsiPresentationParser().parsePresentation(getData(), getOffset());
		}
//		fetchPresentationPayload();
//		if (osiPresFakeHeader == null) {
//			osiPresFakeHeader = osiPresentation;
//		}
//		return osiPresFakeHeader;
		return osiPresentation;
	}

	public BerNode fetchPresentationPayload() {
//		if (osiPresFakePayload == null) {
//			osiPresFakePayload = osiPresentation.getUserData().deepCopy();
//			osiPresentation.getUserData().clear();
//		}
//		return osiPresFakePayload;
		return null;
	}

	public String toString() {
		return "osi presentation";
	}
}
