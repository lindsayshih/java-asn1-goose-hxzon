package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;

public class OsiSessionPacket extends Packet {
	static {
		ProtocolBindingList.addBinding(new ProtocolBinding<CotpPacket>() {

			@Override
			public Packet match(CotpPacket packet) {
				return new OsiSessionPacket();
			}

		});
	}

	public int expectHeaderLength() {
		return 4;
	}
	
	public String toString(){
		return "osi session";
	}
}
