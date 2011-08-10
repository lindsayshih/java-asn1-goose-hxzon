package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.parse.ProtocolField;
import org.hxzon.netprotocol.parse.ProtocolInt31Field;

public class TpktPacket extends Packet {
	static {
		ProtocolBindingList.addBinding(new ProtocolBinding<TcpPacket>() {

			@Override
			public Packet match(TcpPacket packet) {
				if (packet.fetchSourcePort().getValue() == 102 || packet.fetchDestPort().getValue() == 102) {
					return new TpktPacket();
				} else {
					return null;
				}
			}

		});
	}
	public static final int HeaderLength = 4;
	private ProtocolInt31Field version;
	private ProtocolInt31Field reserved;
	//min=7, max=65535
	private ProtocolInt31Field totalLen;

	protected int expectHeaderLength() {
		return HeaderLength;
	}

	protected ProtocolField[] expectHeaderFields() {
		return new ProtocolField[] { fetchVersion(), fetchReserved(), fetchTotalLen() };
	}

	public ProtocolInt31Field fetchVersion() {
		if (version == null) {
			version = new ProtocolInt31Field("version", "版本", 0, 1, this);
		}
		return version;
	}

	public void setVersion(ProtocolInt31Field version) {
		this.version = version;
	}

	public ProtocolInt31Field fetchReserved() {
		if (reserved == null) {
			reserved = new ProtocolInt31Field("reserved", "保留", 1, 1, this);
		}
		return reserved;
	}

	public void setReserved(ProtocolInt31Field reserved) {
		this.reserved = reserved;
	}

	public ProtocolInt31Field fetchTotalLen() {
		if (totalLen == null) {
			totalLen = new ProtocolInt31Field("total length", "总长度", 2, 2, this);
		}
		return totalLen;
	}

	public void setTotalLen(ProtocolInt31Field length) {
		this.totalLen = length;
	}

	public String getProtocolTypeDesc() {
		return "tpkt";
	}
}
