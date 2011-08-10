package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.parse.ProtocolField;
import org.hxzon.netprotocol.parse.ProtocolStringField;

public class VlanPacket extends Packet {
	static {
		ProtocolBindingList.addBinding(new ProtocolBinding<EthernetPacket>() {

			@Override
			public Packet match(EthernetPacket packet) {
				if (packet.fetchType().getValue().equals("8100")) {
					return new VlanPacket();
				}
				return null;
			}

		});
	}
	public static final int HeaderLength = 4;

	private ProtocolStringField type;

	protected int expectHeaderLength() {
		return HeaderLength;
	}

	protected ProtocolField[] expectHeaderFields() {
		return new ProtocolField[] { fetchType() };
	}

	public ProtocolStringField fetchType() {
		if (type == null) {
			type = new ProtocolStringField("type", "以太网类型", 2, 2, this);
		}
		return type;
	}

	public void setType(String type) {
//		this.type = type;
	}

	public String toString() {
		return "vlan";
	}
}
