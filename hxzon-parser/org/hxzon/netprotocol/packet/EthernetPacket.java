package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.parse.ProtocolField;
import org.hxzon.netprotocol.parse.ProtocolMacField;
import org.hxzon.netprotocol.parse.ProtocolStringField;

public class EthernetPacket extends Packet {
	static {
		ProtocolBindingList.addBinding(new ProtocolBinding<Packet>() {

			@Override
			public Packet match(Packet packet) {
				return new EthernetPacket();
			}

		});
	}
	public static final int HeaderLength = 14;
	private ProtocolMacField srcMac;
	private ProtocolMacField destMac;
	private ProtocolStringField type;

	protected int expectHeaderLength() {
		return HeaderLength;
	}

	protected ProtocolField[] expectHeaderFields() {
		return new ProtocolField[] { fetchDestMac(), fetchSrcMac(), fetchType() };
	}

	public ProtocolMacField fetchSrcMac() {
		if (srcMac == null) {
			srcMac = new ProtocolMacField("srcMac", "源网卡地址", 6, 6, this);
		}
		return srcMac;
	}

	public void setSrcMac(byte[] srcMac) {
//		this.srcMac = srcMac;
	}

	public ProtocolMacField fetchDestMac() {
		if (destMac == null) {
			destMac = new ProtocolMacField("destMac", "目的网卡地址", 0, 6, this);
		}
		return destMac;
	}

	public void setDestMac(byte[] destMac) {
//		this.destMac = destMac;
	}

	public ProtocolStringField fetchType() {
		if (type == null) {
			type = new ProtocolStringField("type", "以太网类型", 12, 2, this);
			if (VlanPacket.EthernetType_vlan.equals(type.getValue())) {
				type.setDisplayString("vlan");
			}
		}
		return type;
	}

	public String getType() {
		return "ethernet";
	}
}
