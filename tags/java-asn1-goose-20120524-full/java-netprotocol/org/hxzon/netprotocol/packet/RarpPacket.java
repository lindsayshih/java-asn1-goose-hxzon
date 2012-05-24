package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.field.ProtocolInt31Field;
import org.hxzon.netprotocol.field.ProtocolInt31HexField;
import org.hxzon.netprotocol.field.ProtocolIpField;
import org.hxzon.netprotocol.field.ProtocolMacField;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.parse.ProtocolDescUtil;

public class RarpPacket extends Packet {
    static {
        ProtocolBindingList.addBinding(new ProtocolBinding<EthernetPacket>() {

            @Override
            public Packet match(EthernetPacket packet) {
                if (packet.fetchType().getValue() == EthernetType_Rarp) {
                    return new RarpPacket();
                } else {
                    return null;
                }
            }

        });
        ProtocolBindingList.addBinding(new ProtocolBinding<VlanPacket>() {

            @Override
            public Packet match(VlanPacket packet) {
                if (packet.fetchType().getValue() == EthernetType_Rarp) {
                    return new RarpPacket();
                } else {
                    return null;
                }
            }

        });
        ProtocolDescUtil.putDesc(RarpPacket.class, "rarp");
    }
    public static final int EthernetType_Rarp = 0x8035;
    private ProtocolInt31Field _hardwareType;
    private ProtocolInt31HexField _protocolType;
    private ProtocolInt31Field _hardwareAddrLength;
    private ProtocolInt31Field _protocolAddrLength;
    private ProtocolInt31Field _operationType;
    private ProtocolMacField _sourceHardwareAddr;
    private ProtocolIpField _sourceProtocolAddr;
    private ProtocolMacField _destHardwareAddr;
    private ProtocolIpField _destProtocolAddr;

    protected int expectHeaderLength() {
        return 8 + 2 * (fetchHardwareAddrLength().getValue() + fetchProtocolAddrLength().getValue());
    }

    protected ProtocolField[] expectHeaderFields() {
        return new ProtocolField[] { fetchHardwareType(), fetchProtocolType(), fetchHardwareAddrLength(), fetchProtocolAddrLength(),//
                fetchOperationType(), fetchSourceHardwareAddr(), fetchSourceProtocolAddr(), fetchDestHardwareAddr(), fetchDestProtocolAddr() };
    }

    public ProtocolInt31Field fetchHardwareType() {
        if (_hardwareType == null) {
            _hardwareType = new ProtocolInt31Field("hardwareType", "硬件类型", 0, 2, true, this) {
                public String getValueAsString() {
                    if (getValue() == 1) {
                        return "以太网地址";
                    }
                    return super.getValueAsString();
                }
            };
        }
        return _hardwareType;
    }

    public ProtocolInt31HexField fetchProtocolType() {
        if (_protocolType == null) {
            _protocolType = new ProtocolInt31HexField("protocolType", "协议类型", 2, 2, true, this) {
                public String getValueAsString() {
                    if (getValue() == Ip4Packet.EthernetType_Ip4) {
                        return "IP地址";
                    }
                    return super.getValueAsString();
                }
            };
        }
        return _protocolType;
    }

    public ProtocolInt31Field fetchHardwareAddrLength() {
        if (_hardwareAddrLength == null) {
            _hardwareAddrLength = new ProtocolInt31Field("hardwareAddrLength", "硬件地址长度", 4, 1, true, this);
        }
        return _hardwareAddrLength;
    }

    public ProtocolInt31Field fetchProtocolAddrLength() {
        if (_protocolAddrLength == null) {
            _protocolAddrLength = new ProtocolInt31Field("protocolAddrLength", "协议地址长度", 5, 1, true, this);
        }
        return _protocolAddrLength;
    }

    public ProtocolInt31Field fetchOperationType() {
        if (_operationType == null) {
            _operationType = new ProtocolInt31Field("operationType", "操作类型", 6, 2, true, this) {
                public String getValueAsString() {
                    switch (getValue()) {
                    case 1:
                        return "ARP请求";
                    case 2:
                        return "ARP应答";
                    case 3:
                        return "RARP请求";
                    case 4:
                        return "RARP应答";
                    default:
                        return "未知操作";
                    }
                }
            };
        }
        return _operationType;
    }

    public ProtocolMacField fetchSourceHardwareAddr() {
        int addrLength = fetchHardwareAddrLength().getValue();
        if (_sourceHardwareAddr == null) {
            _sourceHardwareAddr = new ProtocolMacField("sourceHardwareAddr", "发送端硬件地址", 8, addrLength, this);
        }
        return _sourceHardwareAddr;
    }

    public ProtocolIpField fetchSourceProtocolAddr() {
        int addrLength = fetchProtocolAddrLength().getValue();
        if (_sourceProtocolAddr == null) {
            _sourceProtocolAddr = new ProtocolIpField("sourceProtocolAddr", "发送端协议地址", 14, addrLength, this);
        }
        return _sourceProtocolAddr;
    }

    public ProtocolMacField fetchDestHardwareAddr() {
        int addrLength = fetchHardwareAddrLength().getValue();
        if (_destHardwareAddr == null) {
            _destHardwareAddr = new ProtocolMacField("destHardwareAddr", "接收端硬件地址", 18, addrLength, this);
        }
        return _destHardwareAddr;
    }

    public ProtocolIpField fetchDestProtocolAddr() {
        int addrLength = fetchProtocolAddrLength().getValue();
        if (_destProtocolAddr == null) {
            _destProtocolAddr = new ProtocolIpField("destProtocolAddr", "接收端协议地址", 24, addrLength, this);
        }
        return _destProtocolAddr;
    }

}
