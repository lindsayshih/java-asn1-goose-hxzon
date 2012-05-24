package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.netprotocol.common.PacketGroup;
import org.hxzon.netprotocol.field.ProtocolBitField;
import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.field.ProtocolInt31Field;
import org.hxzon.netprotocol.parse.CotpPacketCache;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.parse.ProtocolDescUtil;
import org.hxzon.netprotocol.payload.DataPayload;
import org.hxzon.netprotocol.payload.MissPayload;

public class CotpPacket extends Packet {
    static {
        ProtocolBindingList.addBinding(new ProtocolBinding<TpktPacket>() {

            @Override
            public Packet match(TpktPacket packet) {
                return new CotpPacket();
            }

        });
        ProtocolDescUtil.putDesc(CotpPacket.class, "cotp");
    }
    private ProtocolInt31Field _length;
    private ProtocolBitField _pduType;
//	private ProtocolInt31Field nrAndEot;
    private ProtocolBitField _tpduNumber;
    private ProtocolBitField _isLast;
    private PacketGroup<CotpPacket> _group;

    protected int expectHeaderLength() {
        return fetchPduLength().getValue() + 1;
    }

    protected ProtocolField[] expectHeaderFields() {
        return new ProtocolField[] { fetchPduLength(), fetchPduType(), fetchTpduNumber(), fetchIsLast() };
    }

    public ProtocolInt31Field fetchPduLength() {
        if (_length == null) {
            _length = new ProtocolInt31Field("pdu length", "PDU长度", 0, 1, true, this);
        }
        return _length;
    }

    public ProtocolBitField fetchPduType() {
        if (_pduType == null) {
            _pduType = new ProtocolBitField("pdu type", "PDU类型", 1, 0, 4, this) {
                public String getValueAsString() {
                    return pduTypeDescription(getValue());
                }
            };
        }
        return _pduType;
    }

//    14         CR: connection request  (binary 1110)
//    13         CC: connection confirm  (binary 1101)
//     8         DR: disconnect request  (binary 1000)
//    15         DT: data                (binary 1111)
//     1         ED: expedited data      (binary 0001)
    public static final int CR = 14;
    public static final int CC = 13;
    public static final int DR = 8;
    public static final int DT = 15;
    public static final int ED = 1;

    public String pduTypeDescription(int pduType) {
        switch (pduType) {
        case CR:
            return "connection request";
        case CC:
            return "connection confirm";
        case DR:
            return "disconnect request";
        case DT:
            return "data";
        case ED:
            return "expedited data";
        default:
            return "ERROR";
        }
    }

    public ProtocolBitField fetchTpduNumber() {
        if (_tpduNumber == null) {
            _tpduNumber = new ProtocolBitField("TPDU number", "TPDU number", 2, 1, 7, this);
        }
        return _tpduNumber;
    }

    public static final int LastUnit = 1;

    public ProtocolBitField fetchIsLast() {
        if (_isLast == null) {
            _isLast = new ProtocolBitField("is last unit", "is last unit", 2, 0, 1, this) {
                public String getValueAsString() {
                    return getValue() == LastUnit ? "last" : "not last";
                }
            };
        }
        return _isLast;
    }

    public boolean isLastUnit() {
        return fetchIsLast().getValue() == LastUnit;
    }

    public IPacketPayload exceptPayload() {
        if (_miss) {
            return new MissPayload();
        }
        CotpPacketCache.addCotpPacket(this);
        if (_group != null) {
            DataPayload dataPayload = new DataPayload();
            dataPayload.setGroup(_group);
            return dataPayload;
        }
        return null;
    }

    public PacketGroup<CotpPacket> getGroup() {
        return _group;
    }

    public void setGroup(PacketGroup<CotpPacket> group) {
        this._group = group;
    }

}
