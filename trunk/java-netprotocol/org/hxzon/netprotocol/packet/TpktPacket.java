package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.field.ProtocolInt31Field;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.parse.ProtocolDescUtil;

public class TpktPacket extends Packet {
    static {
        ProtocolBindingList.addBinding(new ProtocolBinding<TcpPacket>() {

            @Override
            public Packet match(TcpPacket packet) {
                if (packet.fetchSourcePort().getValue() == 102 || packet.fetchDestPort().getValue() == 102) {
                    return new TpktPacket();
                } else {
                    return null;
                }
            }

        });
        ProtocolDescUtil.putDesc(TpktPacket.class, "tpkt");
    }
    public static final int HeaderLength = 4;
    private ProtocolInt31Field _version;
    private ProtocolInt31Field _reserved;
    //min=7, max=65535
    private ProtocolInt31Field _totalLen;

    protected int expectHeaderLength() {
        return HeaderLength;
    }

    protected ProtocolField[] expectHeaderFields() {
        return new ProtocolField[] { fetchVersion(), fetchReserved(), fetchTotalLen() };
    }

    public ProtocolInt31Field fetchVersion() {
        if (_version == null) {
            _version = new ProtocolInt31Field("version", "版本", 0, 1, true, this);
        }
        return _version;
    }

    public void setVersion(ProtocolInt31Field version) {
        this._version = version;
    }

    public ProtocolInt31Field fetchReserved() {
        if (_reserved == null) {
            _reserved = new ProtocolInt31Field("reserved", "保留", 1, 1, this);
        }
        return _reserved;
    }

    public void setReserved(ProtocolInt31Field reserved) {
        this._reserved = reserved;
    }

    public ProtocolInt31Field fetchTotalLen() {
        if (_totalLen == null) {
            _totalLen = new ProtocolInt31Field("total length", "总长度", 2, 2, true, this);
        }
        return _totalLen;
    }

    public void setTotalLen(ProtocolInt31Field length) {
        this._totalLen = length;
    }

}
