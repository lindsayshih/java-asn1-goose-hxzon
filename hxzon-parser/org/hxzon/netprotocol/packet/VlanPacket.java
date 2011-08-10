package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.parse.ProtocolBitField;
import org.hxzon.netprotocol.parse.ProtocolField;
import org.hxzon.netprotocol.parse.ProtocolStringField;

public class VlanPacket extends Packet {
	static {
		ProtocolBindingList.addBinding(new ProtocolBinding<EthernetPacket>() {

			@Override
			public Packet match(EthernetPacket packet) {
				if (packet.fetchType().getValue().equals(EthernetType_vlan)) {
					return new VlanPacket();
				}
				return null;
			}

		});
	}
	public static final int HeaderLength = 4;
	public static final String EthernetType_vlan = "8100";

	private ProtocolBitField priority;
	private ProtocolBitField cfi;
	private ProtocolBitField valnId;
	private ProtocolStringField type;

	protected int expectHeaderLength() {
		return HeaderLength;
	}

	protected ProtocolField[] expectHeaderFields() {
		return new ProtocolField[] { fetchPriority(), fetchCfi(), fetchValnId(), fetchType() };
	}

	public ProtocolStringField fetchType() {
		if (type == null) {
			type = new ProtocolStringField("type", "以太网类型", 2, 2, this);
		}
		return type;
	}

	public ProtocolBitField fetchPriority() {
		if (priority == null) {
			priority = new ProtocolBitField("priority", "优先级", 0, 0, 3, this);
		}
		return priority;
	}

	public ProtocolBitField fetchCfi() {
		if (cfi == null) {
			cfi = new ProtocolBitField("cfi", "格式", 0, 3, 1, this) {
				public String getValueAsString() {
					return getValue() == 0 ? "规范格式" : "非规范格式";
				}
			};
		}
		return cfi;
	}

	public ProtocolBitField fetchValnId() {
		if (valnId == null) {
			valnId = new ProtocolBitField("vlan id", "VLAN ID", 0, 4, 12, this);
		}
		return valnId;
	}

	public String getProtocolTypeDesc() {
		return "vlan";
	}
}
