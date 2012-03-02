package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.field.ProtocolInt31Field;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.parse.ProtocolDescUtil;

public class UdpPacket extends Packet {
    static {
        ProtocolBindingList.addBinding(new ProtocolBinding<Ip4Packet>() {

            @Override
            public Packet match(Ip4Packet packet) {
                if (packet.fetchProtocolCode().getValue() == IpType_Udp) {
                    return new UdpPacket();
                } else {
                    return null;
                }
            }

        });
        ProtocolDescUtil.putDesc(UdpPacket.class, "udp");
    }
    public static final int MaxTotalLength = 1472;
    public static final int HeaderLength = 8;
    public static final int IpType_Udp = 17;
    private ProtocolInt31Field _sourcePort;
    private ProtocolInt31Field _destPort;
    private ProtocolInt31Field _totalLen;
    private ProtocolInt31Field _checksum;

    protected int expectHeaderLength() {
        return HeaderLength;
    }

    protected ProtocolField[] expectHeaderFields() {
        return new ProtocolField[] { fetchSourcePort(), fetchDestPort(), fetchTotalLen(), fetchChecksum() };
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

    public ProtocolInt31Field fetchTotalLen() {
        if (_totalLen == null) {
            _totalLen = new ProtocolInt31Field("totalLen", "总长度", 4, 2, true, this);
        }
        return _totalLen;
    }

    public ProtocolInt31Field fetchChecksum() {
        if (_checksum == null) {
            _checksum = new ProtocolInt31Field("check sum", "校验和", 6, 2, true, this);
        }
        return _checksum;
    }

}
