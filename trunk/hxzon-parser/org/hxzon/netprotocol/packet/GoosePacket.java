package org.hxzon.netprotocol.packet;

import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.goose.GoosePdu;
import org.hxzon.asn1.goose.GoosePduParser;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.field.ProtocolInt31Field;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;

public class GoosePacket extends Packet {
    static {
        ProtocolBindingList.addBinding(new ProtocolBinding<EthernetPacket>() {

            @Override
            public Packet match(EthernetPacket packet) {
                if (packet.fetchType().getValue().equalsIgnoreCase(EthernetType_Goose)) {
                    return new GoosePacket();
                } else {
                    return null;
                }
            }

        });
        ProtocolBindingList.addBinding(new ProtocolBinding<VlanPacket>() {

            @Override
            public Packet match(VlanPacket packet) {
                if (packet.fetchType().getValue().equalsIgnoreCase(EthernetType_Goose)) {
                    return new GoosePacket();
                } else {
                    return null;
                }
            }

        });
    }
    public static final int HeaderLength = 8;
    public static final String EthernetType_Goose = "88b8";
    private ProtocolInt31Field appId;
    private ProtocolInt31Field pduLen;
    private ProtocolInt31Field reserved1;
    private ProtocolInt31Field reserved2;
    private GoosePdu goosePdu;

    protected int expectHeaderLength() {
        return HeaderLength;
    }

    protected ProtocolField[] expectHeaderFields() {
        return new ProtocolField[] { fetchAppId(), fetchPduLen(), fetchReserved1(), fetchReserved2() };
    }

    public ProtocolInt31Field fetchAppId() {
        if (appId == null) {
            appId = new ProtocolInt31Field("appId", "应用标识", 0, 2, this);
        }
        return appId;
    }

    public void setAppId(int appId) {
//		this.appId = appId;
    }

    public ProtocolInt31Field fetchPduLen() {
        if (pduLen == null) {
            pduLen = new ProtocolInt31Field("pduLen", "PDU长度", 2, 2, this);
        }
        return pduLen;
    }

    public void setPduLen(int pduLen) {
//		this.pduLen = pduLen;
    }

    public ProtocolInt31Field fetchReserved1() {
        if (reserved1 == null) {
            reserved1 = new ProtocolInt31Field("reserved1", "保留1", 4, 2, this);
        }
        return reserved1;
    }

    public void setReserved1(int reserved1) {
//		this.reserved1 = reserved1;
    }

    public ProtocolInt31Field fetchReserved2() {
        if (reserved2 == null) {
            reserved2 = new ProtocolInt31Field("reserved2", "保留2", 6, 2, this);
        }
        return reserved2;
    }

    public void setReserved2(int reserved2) {
//		this.reserved2 = reserved2;
    }

    public BerNode fetchGoosepdu() {
        if (goosePdu == null) {
            goosePdu = GoosePduParser.parser.parseGoose(super.getSrcData(), super.getPayloadOffset());
        }
        return goosePdu;
    }

    public IPacketPayload exceptPayload() {
        return (IPacketPayload) fetchGoosepdu();
    }

    public String getProtocolTypeDesc() {
        return "goose";
    }
}
