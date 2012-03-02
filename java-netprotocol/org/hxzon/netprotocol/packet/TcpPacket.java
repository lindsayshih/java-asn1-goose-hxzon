package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.field.ProtocolBitField;
import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.field.ProtocolInt31Field;
import org.hxzon.netprotocol.field.ProtocolInt63Field;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.parse.ProtocolDescUtil;
import org.hxzon.util.BitUtil;

public class TcpPacket extends Packet {
    static {
        ProtocolBindingList.addBinding(new ProtocolBinding<Ip4Packet>() {

            @Override
            public Packet match(Ip4Packet packet) {
                if (packet.fetchProtocolCode().getValue() == IpType_Tcp) {
                    return new TcpPacket();
                } else {
                    return null;
                }
            }

        });
        ProtocolDescUtil.putDesc(TcpPacket.class, "tcp");
    }
    public static final int IpType_Tcp = 6;
    private ProtocolInt31Field _sourcePort;
    private ProtocolInt31Field _destPort;
    private ProtocolInt63Field _sequenceNumber;
    //希望接收的下一序号，表示已正确接收了所有序号小于确认号的数据字节
    private ProtocolInt63Field _acknowledgementNumber;
    private ProtocolBitField _headerLen;
    private ProtocolBitField _flag;
    private ProtocolInt31Field _windowSize;
    private ProtocolInt31Field _checksum;
    private ProtocolInt31Field _urgentPointer;

    protected int expectHeaderLength() {
        return fetchHeaderLen().getValue() * 4;
    }

    protected ProtocolField[] expectHeaderFields() {
        return new ProtocolField[] { fetchSourcePort(), fetchDestPort(), fetchSequenceNumber(), fetchAcknowledgementNumber(), fetchHeaderLen(), fetchFlag(), fetchWindowSize(), fetchChecksum(),
                fetchUrgentPointer() };
    }

    public ProtocolInt31Field fetchSourcePort() {
        if (_sourcePort == null) {
            _sourcePort = new ProtocolInt31Field("sourcePort", "源端口", 0, 2, true, this);
        }
        return _sourcePort;
    }

    public ProtocolInt31Field fetchDestPort() {
        if (_destPort == null) {
            _destPort = new ProtocolInt31Field("destPort", "目的端口", 2, 2, true, this);
        }
        return _destPort;
    }

    public ProtocolInt63Field fetchSequenceNumber() {
        if (_sequenceNumber == null) {
            _sequenceNumber = new ProtocolInt63Field("sequenceNumber", "序列号", 4, 4, true, this);
        }
        return _sequenceNumber;
    }

    public ProtocolInt63Field fetchAcknowledgementNumber() {
        if (_acknowledgementNumber == null) {
            _acknowledgementNumber = new ProtocolInt63Field("acknowledgementNumber", "确认序列号", 8, 4, true, this);
        }
        return _acknowledgementNumber;
    }

    public ProtocolBitField fetchHeaderLen() {
        if (_headerLen == null) {
            _headerLen = new ProtocolBitField("header len", "头部长度", 12, 0, 4, this) {
                public String getValueAsString() {
                    return (getValue() * 4) + "(=" + getValue() + "*4)";
                }
            };
        }
        return _headerLen;
    }

    public ProtocolBitField fetchFlag() {
        if (_flag == null) {
            _flag = new ProtocolBitField("flag", "标识", 12, 7, 9, this) {
                public String getValueAsString() {
                    return flagDescription(getValue());
                }
            };
        }
        return _flag;
    }

    public static final int Ns = 1 << 8;
    public static final int Cwr = 1 << 7;
    public static final int Ece = 1 << 6;
    //紧急数据偏移量(紧急指针)有效
    public static final int Urg = 1 << 5;
    //确认序号有效
    public static final int Ack = 1 << 4;
    //接收方应该立即将数据提交给应用程序
    public static final int Psh = 1 << 3;
    //连接复位
    public static final int Rst = 1 << 2;
    //序号同步(建立连接)
    public static final int Syn = 1 << 1;
    //发送方字节流结束
    public static final int Fin = 1 << 0;

    public String flagDescription(int flag) {
        StringBuilder sb = new StringBuilder();
        if (BitUtil.isSet(flag, Ns)) {
            sb.append("ECN-nonce concealment protection,");
        }
        if (BitUtil.isSet(flag, Cwr)) {
            sb.append("Congestion Window Reduced,");
        }
        if (BitUtil.isSet(flag, Ece)) {
            sb.append("ECN-Echo,");
        }
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

    public ProtocolInt31Field fetchWindowSize() {
        if (_windowSize == null) {
            _windowSize = new ProtocolInt31Field("window size", "窗口大小", 14, 2, true, this);
        }
        return _windowSize;
    }

    public ProtocolInt31Field fetchChecksum() {
        if (_checksum == null) {
            _checksum = new ProtocolInt31Field("check sum", "校验和", 16, 2, true, this);
        }
        return _checksum;
    }

    public ProtocolInt31Field fetchUrgentPointer() {
        if (_urgentPointer == null) {
            _urgentPointer = new ProtocolInt31Field("urgent pointer", "紧急指针", 18, 2, true, this);
        }
        return _urgentPointer;
    }

}
