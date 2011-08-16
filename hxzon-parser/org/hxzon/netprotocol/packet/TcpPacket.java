package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.field.ProtocolBitField;
import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.field.ProtocolInt31Field;
import org.hxzon.netprotocol.field.ProtocolInt63Field;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.util.BitUtil;

public class TcpPacket extends Packet {
	static {
		ProtocolBindingList.addBinding(new ProtocolBinding<Ip4Packet>() {

			@Override
			public Packet match(Ip4Packet packet) {
				if (packet.fetchProtocolCode().getValue().equals(IPType_Tcp)) {
					return new TcpPacket();
				} else {
					return null;
				}
			}

		});
	}
	private static final String IPType_Tcp = "06";
	private ProtocolInt31Field sourcePort;
	private ProtocolInt31Field destPort;
	private ProtocolInt63Field sequenceNumber;
	private ProtocolInt63Field acknowledgementNumber;
	private ProtocolBitField headerLen;
	private ProtocolBitField flag;
	private ProtocolInt31Field windowSize;
	private ProtocolInt31Field checksum;
	private ProtocolInt31Field urgentPointer;

	protected int expectHeaderLength() {
		return fetchHeaderLen().getValue() * 4;
	}

	protected ProtocolField[] expectHeaderFields() {
		return new ProtocolField[] { fetchSourcePort(), fetchDestPort(), fetchSequenceNumber(), fetchAcknowledgementNumber(), fetchHeaderLen(), fetchFlag(), fetchWindowSize(), fetchChecksum(),
				fetchUrgentPointer() };
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

	public ProtocolInt63Field fetchSequenceNumber() {
		if (sequenceNumber == null) {
			sequenceNumber = new ProtocolInt63Field("sequenceNumber", "序列号", 4, 4, this);
		}
		return sequenceNumber;
	}

	public void setSequenceNumber(long sequenceNumber) {
	}

	public ProtocolInt63Field fetchAcknowledgementNumber() {
		if (acknowledgementNumber == null) {
			acknowledgementNumber = new ProtocolInt63Field("acknowledgementNumber", "确认序列号", 8, 4, this);
		}
		return acknowledgementNumber;
	}

	public void setAcknowledgementNumber(long acknowledgementNumber) {
	}

	public ProtocolBitField fetchHeaderLen() {
		if (headerLen == null) {
			headerLen = new ProtocolBitField("header len", "头部长度", 12, 0, 4, this) {
				public String getValueAsString() {
					return String.valueOf(getValue() + "*4");
				}
			};
		}
		return headerLen;
	}

	public void setHeaderLen(ProtocolBitField headerLen) {
		this.headerLen = headerLen;
	}

	public ProtocolBitField fetchFlag() {
		if (flag == null) {
			flag = new ProtocolBitField("flag", "标识", 13, 2, 6, this) {
				public String getValueAsString() {
					return flagDescription(getValue());
				}
			};
		}
		return flag;
	}

	public static final int Urg = 1 << 5;
	public static final int Ack = 1 << 4;
	public static final int Psh = 1 << 3;
	public static final int Rst = 1 << 2;
	public static final int Syn = 1 << 1;
	public static final int Fin = 1 << 0;

	public String flagDescription(int flag) {
		StringBuilder sb = new StringBuilder();
		if (BitUtil.isSet(flag, Urg)) {
			sb.append("Urgent,");
		}
		if (BitUtil.isSet(flag, Ack)) {
			sb.append("Acknowledgment,");
		}
		if (BitUtil.isSet(flag, Psh)) {
			sb.append("Push,");
		}
		if (BitUtil.isSet(flag, Rst)) {
			sb.append("Reset,");
		}
		if (BitUtil.isSet(flag, Syn)) {
			sb.append("Syn,");
		}
		if (BitUtil.isSet(flag, Fin)) {
			sb.append("Fin");
		}
		return sb.toString();
	}

	public void setFlag(ProtocolBitField flag) {
		this.flag = flag;
	}

	public ProtocolInt31Field fetchWindowSize() {
		if (windowSize == null) {
			windowSize = new ProtocolInt31Field("window size", "窗口大小", 14, 2, this);
		}
		return windowSize;
	}

	public void setWindowSize(ProtocolInt31Field windowSize) {
		this.windowSize = windowSize;
	}

	public ProtocolInt31Field fetchChecksum() {
		if (checksum == null) {
			checksum = new ProtocolInt31Field("check sum", "校验和", 16, 2, this);
		}
		return checksum;
	}

	public void setChecksum(ProtocolInt31Field checksum) {
		this.checksum = checksum;
	}

	public ProtocolInt31Field fetchUrgentPointer() {
		if (urgentPointer == null) {
			urgentPointer = new ProtocolInt31Field("urgent pointer", "紧急指针", 18, 2, this);
		}
		return urgentPointer;
	}

	public void setUrgentPointer(ProtocolInt31Field urgentPointer) {
		this.urgentPointer = urgentPointer;
	}

	public String getProtocolTypeDesc() {
		return "tcp";
	}
}
