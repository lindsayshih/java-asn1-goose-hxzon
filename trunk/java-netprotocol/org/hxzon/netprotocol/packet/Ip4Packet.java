package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.field.ProtocolBitField;
import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.field.ProtocolInt31Field;
import org.hxzon.netprotocol.field.ProtocolIpField;
import org.hxzon.netprotocol.field.ProtocolStringField;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.util.BitUtil;

public class Ip4Packet extends Packet {
    static {
        ProtocolBindingList.addBinding(new ProtocolBinding<EthernetPacket>() {

            @Override
            public Packet match(EthernetPacket packet) {
                if (packet.fetchType().getValue().equals(EthernetType_Ip4)) {
                    return new Ip4Packet();
                } else {
                    return null;
                }
            }

        });
        ProtocolBindingList.addBinding(new ProtocolBinding<VlanPacket>() {

            @Override
            public Packet match(VlanPacket packet) {
                if (packet.fetchType().getValue().equals(EthernetType_Ip4)) {
                    return new Ip4Packet();
                } else {
                    return null;
                }
            }

        });
    }
    public static final int MaxPayloadLength = 1480;
    public static final String EthernetType_Ip4 = "0800";
    private ProtocolInt31Field _version;
    private ProtocolBitField _headerLen;
    private ProtocolInt31Field _differentiatedServices;
    private ProtocolInt31Field _totalLen;
    private ProtocolInt31Field _identification;
    private ProtocolBitField _fragmentFlags;
    private ProtocolBitField _fragmentOffset;
    private ProtocolInt31Field _ttl;
    private ProtocolStringField _protocolCode;
    private ProtocolInt31Field _checksum;
    private ProtocolIpField _sourceIp;
    private ProtocolIpField _destIp;

    protected int expectHeaderLength() {
        return fetchHeaderLen().getValue() * 4;
    }

    protected ProtocolField[] expectHeaderFields() {
        return new ProtocolField[] { fetchVersion(), fetchHeaderLen(), fetchDifferentiatedServices(), fetchTotalLen(), fetchIdentification(), fetchFragmentFlags(), fetchFragmentOffset(), fetchTtl(),
                fetchProtocolCode(), fetchChecksum(), fetchSourceIp(), fetchDestIp() };
    }

    public ProtocolInt31Field fetchVersion() {
        return _version;
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
        if (_totalLen == null) {
            _totalLen = new ProtocolInt31Field("total len", "总长度", 2, 2, true, this);
        }
        return _totalLen;
    }

    public ProtocolBitField fetchHeaderLen() {
        if (_headerLen == null) {
            _headerLen = new ProtocolBitField("headerLength", "头部长度", 0, 4, 4, this) {
                public String getValueAsString() {
                    return String.valueOf(getValue() + "*4");
                }
            };
        }
        return _headerLen;
    }

    public ProtocolInt31Field fetchDifferentiatedServices() {
        if (_differentiatedServices == null) {
//			differentiatedServices = new ProtocolBitField("tos", 1, 0, 8, this);
            _differentiatedServices = new ProtocolInt31Field("tos", "差别服务", 1, 1, this);
        }
        return _differentiatedServices;
    }

    public void setDifferentiatedServices(int differentiatedServices) {
//		this.differentiatedServices = differentiatedServices;
    }

    public ProtocolInt31Field fetchIdentification() {
        if (_identification == null) {
            _identification = new ProtocolInt31Field("identification", "标识", 4, 2, this);
        }
        return _identification;
    }

    public void setIdentification(int identification) {
//		this.identification = identification;
    }

    public ProtocolBitField fetchFragmentFlags() {
        if (_fragmentFlags == null) {
            _fragmentFlags = new ProtocolBitField("fragment flags", "段标识", 6, 0, 3, this) {
                public String getValueAsString() {
                    return fragmentFlagDescription(getValue());
                }
            };
        }
        return _fragmentFlags;
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

    public boolean isDontFragment() {
        return BitUtil.isSet(fetchFragmentFlags().getValue(), DontFragment);
    }

    public boolean isMoreFragment() {
        return BitUtil.isSet(fetchFragmentFlags().getValue(), MoreFragment);
    }

    public void setFragmentFlags(int fragmentFlags) {
//		this.fragmentFlags = fragmentFlags;
    }

    public ProtocolBitField fetchFragmentOffset() {
        if (_fragmentOffset == null) {
            _fragmentOffset = new ProtocolBitField("fragment offset", "段偏移", 6, 3, 13, this);
        }
        return _fragmentOffset;
    }

    public void setFragmentOffset(int fragmentOffset) {
//		this.fragmentOffset = fragmentOffset;
    }

    public ProtocolInt31Field fetchTtl() {
        if (_ttl == null) {
            _ttl = new ProtocolInt31Field("ttl", "生存时间", 8, 1, true, this);
        }
        return _ttl;
    }

    public void setTtl(int ttl) {
//		this.ttl = ttl;
    }

    public ProtocolStringField fetchProtocolCode() {
        if (_protocolCode == null) {
            _protocolCode = new ProtocolStringField("protocol", "协议类型", 9, 1, this);
        }
        return _protocolCode;
    }

    public void setProtocolCode(String code) {
//		this.protocolCode = code;
    }

    public ProtocolInt31Field fetchChecksum() {
        return _checksum;
    }

    public void setChecksum(int checksum) {
//		this.checksum = checksum;
    }

    public ProtocolIpField fetchSourceIp() {
        if (_sourceIp == null) {
            _sourceIp = new ProtocolIpField("sourceIp", "源IP", 12, 4, this);
        }
        return _sourceIp;
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
        if (_destIp == null) {
            _destIp = new ProtocolIpField("destIp", "目的IP", 16, 4, this);
        }
        return _destIp;
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

    public String getProtocolTypeDesc() {
        return "ip4";
    }

}
