package org.hxzon.netprotocol.packet;

import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.sv.SvPduParser;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.field.ProtocolInt31Field;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.parse.ProtocolDescUtil;
import org.hxzon.netprotocol.payload.BerNodePayload;

public class SvPacket extends Packet {
    static {
        ProtocolBindingList.addBinding(new ProtocolBinding<EthernetPacket>() {

            @Override
            public Packet match(EthernetPacket packet) {
                if (packet.fetchType().getValue() == EthernetType_Sv) {
                    return new SvPacket();
                } else {
                    return null;
                }
            }

        });
        ProtocolBindingList.addBinding(new ProtocolBinding<VlanPacket>() {

            @Override
            public Packet match(VlanPacket packet) {
                if (packet.fetchType().getValue() == EthernetType_Sv) {
                    return new SvPacket();
                } else {
                    return null;
                }
            }

        });
        ProtocolDescUtil.putDesc(SvPacket.class, "sv");
    }
    public static final int HeaderLength = 8;
    public static final int EthernetType_Sv = 0x88ba;
    private ProtocolInt31Field _appId;
    private ProtocolInt31Field _pduLen;
    private ProtocolInt31Field _reserved1;
    private ProtocolInt31Field _reserved2;
    private IPacketPayload _svPdu;

    protected int expectHeaderLength() {
        return HeaderLength;
    }

    protected ProtocolField[] expectHeaderFields() {
        return new ProtocolField[] { fetchAppId(), fetchPduLen(), fetchReserved1(), fetchReserved2() };
    }

    public ProtocolInt31Field fetchAppId() {
        if (_appId == null) {
            _appId = new ProtocolInt31Field("appId", "应用标识", 0, 2, true, this);
        }
        return _appId;
    }

    public ProtocolInt31Field fetchPduLen() {
        if (_pduLen == null) {
            _pduLen = new ProtocolInt31Field("pduLen", "PDU长度", 2, 2, true, this);
        }
        return _pduLen;
    }

    public ProtocolInt31Field fetchReserved1() {
        if (_reserved1 == null) {
            _reserved1 = new ProtocolInt31Field("reserved1", "保留1", 4, 2, true, this);
        }
        return _reserved1;
    }

    public ProtocolInt31Field fetchReserved2() {
        if (_reserved2 == null) {
            _reserved2 = new ProtocolInt31Field("reserved2", "保留2", 6, 2, true, this);
        }
        return _reserved2;
    }

    public IPacketPayload fetchSvpdu() {
        if (_svPdu == null) {
            BerNode node = SvPduParser.parser.parseSv(getSrcData(), getPayloadOffset());
            _svPdu = new BerNodePayload(node, this);
        }
        return _svPdu;
    }

    public IPacketPayload exceptPayload() {
        return fetchSvpdu();
    }

}
