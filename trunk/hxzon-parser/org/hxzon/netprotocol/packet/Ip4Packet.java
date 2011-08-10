package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.parse.ProtocolBitField;
import org.hxzon.netprotocol.parse.ProtocolField;
import org.hxzon.netprotocol.parse.ProtocolInt31Field;
import org.hxzon.netprotocol.parse.ProtocolIpField;
import org.hxzon.netprotocol.parse.ProtocolStringField;
import org.hxzon.util.BitUtil;

public class Ip4Packet extends Packet {
	static {
		ProtocolBindingList.addBinding(new ProtocolBinding<EthernetPacket>() {

			@Override
			public Packet match(EthernetPacket packet) {
				if (packet.fetchType().getValue().equals("0800")) {
					return new Ip4Packet();
				} else {
					return null;
				}
			}

		});
		ProtocolBindingList.addBinding(new ProtocolBinding<VlanPacket>() {

			@Override
			public Packet match(VlanPacket packet) {
				if (packet.fetchType().getValue().equals("0800")) {
					return new Ip4Packet();
				} else {
					return null;
				}
			}

		});
	}
	private ProtocolInt31Field version;
	private ProtocolBitField headerLen;
	private ProtocolInt31Field differentiatedServices;
	private ProtocolInt31Field totalLen;
	private ProtocolInt31Field identification;
	private ProtocolBitField fragmentFlags;
	private ProtocolBitField fragmentOffset;
	private ProtocolInt31Field ttl;
	private ProtocolStringField protocolCode;
	private ProtocolInt31Field checksum;
	private ProtocolIpField sourceIp;
	private ProtocolIpField destIp;

	protected int expectHeaderLength() {
		return fetchHeaderLen().getValue() * 4;
	}

	protected ProtocolField[] expectHeaderFields() {
		return new ProtocolField[] { fetchVersion(), fetchHeaderLen(), fetchDifferentiatedServices(), fetchTotalLen(), fetchIdentification(), fetchFragmentFlags(), fetchFragmentOffset(), fetchTtl(),
				fetchProtocolCode(), fetchChecksum(), fetchSourceIp(), fetchDestIp() };
	}

	public ProtocolInt31Field fetchVersion() {
		return version;
	}

	public void setVersion(int version) {
//		this.version = version;
	}

//	public ProtocolBitField fetchTotalLen() {
//		if (totalLen == null) {
//			totalLen = new ProtocolBitField("totalLength", 2, 0, 16, this);
//		}
//		return totalLen;
//	}
	public ProtocolInt31Field fetchTotalLen() {
		if (totalLen == null) {
			totalLen = new ProtocolInt31Field("total len", "总长度", 2, 2, this);
		}
		return totalLen;
	}

	public ProtocolBitField fetchHeaderLen() {
		if (headerLen == null) {
			headerLen = new ProtocolBitField("headerLength", "头部长度", 0, 4, 4, this) {
				public String getValueAsString() {
					return String.valueOf(getValue() + "*4");
				}
			};
		}
		return headerLen;
	}

	public ProtocolInt31Field fetchDifferentiatedServices() {
		if (differentiatedServices == null) {
//			differentiatedServices = new ProtocolBitField("tos", 1, 0, 8, this);
			differentiatedServices = new ProtocolInt31Field("tos", "差别服务", 1, 1, this);
		}
		return differentiatedServices;
	}

	public void setDifferentiatedServices(int differentiatedServices) {
//		this.differentiatedServices = differentiatedServices;
	}

	public ProtocolInt31Field fetchIdentification() {
		if (identification == null) {
			identification = new ProtocolInt31Field("identification", "标识", 4, 2, this);
		}
		return identification;
	}

	public void setIdentification(int identification) {
//		this.identification = identification;
	}

	public ProtocolBitField fetchFragmentFlags() {
		if (fragmentFlags == null) {
			fragmentFlags = new ProtocolBitField("fragment flags", "段标识", 6, 0, 3, this) {
				public String getValueAsString() {
					return fragmentFlagDescription(getValue());
				}
			};
		}
		return fragmentFlags;
	}

	public static final int DontFragment = 1 << 1;
	public static final int MoreFragment = 1 << 0;

	public String fragmentFlagDescription(int flag) {
		StringBuilder sb = new StringBuilder();
		if (BitUtil.isSet(flag, DontFragment)) {
			sb.append("don't fragment,");
		}
		if (BitUtil.isSet(flag, MoreFragment)) {
			sb.append("more fragment,");
		}
		return sb.toString();
	}

	public void setFragmentFlags(int fragmentFlags) {
//		this.fragmentFlags = fragmentFlags;
	}

	public ProtocolBitField fetchFragmentOffset() {
		if (fragmentOffset == null) {
			fragmentOffset = new ProtocolBitField("fragment offset", "段偏移", 6, 3, 13, this);
		}
		return fragmentOffset;
	}

	public void setFragmentOffset(int fragmentOffset) {
//		this.fragmentOffset = fragmentOffset;
	}

	public ProtocolInt31Field fetchTtl() {
		if (ttl == null) {
			ttl = new ProtocolInt31Field("ttl", "生存时间", 8, 1, this);
		}
		return ttl;
	}

	public void setTtl(int ttl) {
//		this.ttl = ttl;
	}

	public ProtocolStringField fetchProtocolCode() {
		if (protocolCode == null) {
			protocolCode = new ProtocolStringField("protocol", "协议类型", 9, 1, this);
		}
		return protocolCode;
	}

	public void setProtocolCode(String code) {
//		this.protocolCode = code;
	}

	public ProtocolInt31Field fetchChecksum() {
		return checksum;
	}

	public void setChecksum(int checksum) {
//		this.checksum = checksum;
	}

	public ProtocolIpField fetchSourceIp() {
		if (sourceIp == null) {
			sourceIp = new ProtocolIpField("sourceIp", "源IP", 12, 4, this);
		}
		return sourceIp;
	}

//	public String getSourceIpAsString(){
//		String tmp="";
//		for(int i=0;i<4;i++){
//			tmp+=super.getInt(12+i, 1)+".";
//		}
//		return tmp;
//	}

	public void setSourceIp(byte[] sourceIp) {
//		this.sourceIp = sourceIp;
	}

	public ProtocolIpField fetchDestIp() {
		if (destIp == null) {
			destIp = new ProtocolIpField("destIp", "目的IP", 16, 4, this);
		}
		return destIp;
	}

//	public String getDestIpAsString(){
//		String tmp="";
//		for(int i=0;i<4;i++){
//			tmp+=super.getInt(16+i, 1)+".";
//		}
//		return tmp;
//	}

	public void setDestIp(byte[] destIp) {
//		this.destIp = destIp;
	}

	public String toString() {
		return "ip4";
	}

}
