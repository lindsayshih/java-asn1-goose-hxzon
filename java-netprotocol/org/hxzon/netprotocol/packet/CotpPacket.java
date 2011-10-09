package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.netprotocol.field.ProtocolBitField;
import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.field.ProtocolInt31Field;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.payload.DataPayload;

public class CotpPacket extends Packet {
    static {
        ProtocolBindingList.addBinding(new ProtocolBinding<TpktPacket>() {

            @Override
            public Packet match(TpktPacket packet) {
                return new CotpPacket();
            }

        });
    }
    private ProtocolInt31Field length;
    private ProtocolBitField pduType;
//	private ProtocolInt31Field nrAndEot;
    private ProtocolBitField tpduNumber;
    private ProtocolBitField isLast;

    protected int expectHeaderLength() {
        return fetchPduLength().getValue() + 1;
    }

    protected ProtocolField[] expectHeaderFields() {
        return new ProtocolField[] { fetchPduLength(), fetchPduType(), fetchTpduNumber(), fetchIsLast() };
    }

    public ProtocolInt31Field fetchPduLength() {
        if (length == null) {
            length = new ProtocolInt31Field("pdu length", "PDU长度", 0, 1, this);
        }
        return length;
    }

    public void setLength(ProtocolInt31Field length) {
        this.length = length;
    }

    public ProtocolBitField fetchPduType() {
        if (pduType == null) {
            pduType = new ProtocolBitField("pdu type", "PDU类型", 1, 0, 4, this) {
                public String getValueAsString() {
                    return pduTypeDescription(getValue());
                }
            };
        }
        return pduType;
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

    public void setPduType(ProtocolBitField pduType) {
        this.pduType = pduType;
    }

//	public ProtocolInt31Field fetchNrAndEot() {
//		if (nrAndEot == null) {
//			nrAndEot = new ProtocolInt31Field("TPDU-NR and EOT", "nr and eot", 2, 1, this);
//		}
//		return nrAndEot;
//	}
//
//	public void setNrAndEot(ProtocolInt31Field nrAndEot) {
//		this.nrAndEot = nrAndEot;
//	}

    public ProtocolBitField fetchTpduNumber() {
        if (tpduNumber == null) {
            tpduNumber = new ProtocolBitField("TPDU number", "TPDU number", 2, 1, 7, this);
        }
        return tpduNumber;
    }

    public static final int LastUnit = 1;

    public ProtocolBitField fetchIsLast() {
        if (isLast == null) {
            isLast = new ProtocolBitField("is last unit", "is last unit", 2, 0, 1, this) {
                public String getValueAsString() {
                    return getValue() == LastUnit ? "last" : "not last";
                }
            };
        }
        return isLast;
    }

    public IPacketPayload exceptPayload() {
        if (fetchIsLast().getValue() != LastUnit) {
            return new DataPayload();
        }
        return null;
    }

    public String getProtocolTypeDesc() {
        return "cotp";
    }

}
