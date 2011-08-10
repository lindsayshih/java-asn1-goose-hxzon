package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.parse.ProtocolField;
import org.hxzon.netprotocol.parse.ProtocolInt31Field;

public class UdpPacket extends Packet {
	static {
		ProtocolBindingList.addBinding(new ProtocolBinding<Ip4Packet>() {

			@Override
			public Packet match(Ip4Packet packet) {
				if (packet.fetchProtocolCode().getValue().equals("11")) {
					return new UdpPacket();
				} else {
					return null;
				}
			}

		});
	}
	public static final int HeaderLength = 8;
	private ProtocolInt31Field sourcePort;
	private ProtocolInt31Field destPort;
	private ProtocolInt31Field totalLen;
	private ProtocolInt31Field checksum;

	protected int expectHeaderLength() {
		return HeaderLength;
	}

	protected ProtocolField[] expectHeaderFields() {
		return new ProtocolField[] { fetchSourcePort(), fetchDestPort(), fetchTotalLen(), fetchChecksum() };
	}

	public ProtocolInt31Field fetchSourcePort() {
		if (sourcePort == null) {
			sourcePort = new ProtocolInt31Field("sourcePort", "源端口", 0, 2, this);
		}
		return sourcePort;
	}

	public void setSourcePort(ProtocolInt31Field sourcePort) {
		this.sourcePort = sourcePort;
	}

	public ProtocolInt31Field fetchDestPort() {
		if (destPort == null) {
			destPort = new ProtocolInt31Field("destPort", "目的端口", 2, 2, this);
		}
		return destPort;
	}

	public void setDestPort(ProtocolInt31Field destPort) {
		this.destPort = destPort;
	}

	public ProtocolInt31Field fetchTotalLen() {
		if (totalLen == null) {
			totalLen = new ProtocolInt31Field("totalLen", "总长度", 4, 2, this);
		}
		return totalLen;
	}

	public void setTotalLen(ProtocolInt31Field headerLen) {
		this.totalLen = headerLen;
	}

	public ProtocolInt31Field fetchChecksum() {
		if (checksum == null) {
			checksum = new ProtocolInt31Field("check sum", "校验和", 6, 2, this);
		}
		return checksum;
	}

	public void setChecksum(ProtocolInt31Field checksum) {
		this.checksum = checksum;
	}

	public String toString() {
		return "udp";
	}
}
