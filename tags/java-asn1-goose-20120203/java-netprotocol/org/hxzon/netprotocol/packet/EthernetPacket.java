package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.field.ProtocolMacField;
import org.hxzon.netprotocol.field.ProtocolStringField;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;

public class EthernetPacket extends Packet {
    static {
        ProtocolBindingList.addBinding(new ProtocolBinding<Packet>() {

            @Override
            public Packet match(Packet packet) {
                return new EthernetPacket();
            }

        });
    }
    public static final int HeaderLength = 14;
    private ProtocolMacField _srcMac;
    private ProtocolMacField _destMac;
    private ProtocolStringField _type;

    protected int expectHeaderLength() {
        return HeaderLength;
    }

    protected ProtocolField[] expectHeaderFields() {
        return new ProtocolField[] { fetchDestMac(), fetchSrcMac(), fetchType() };
    }

    public ProtocolMacField fetchSrcMac() {
        if (_srcMac == null) {
            _srcMac = new ProtocolMacField("srcMac", "源网卡地址", 6, 6, this);
        }
        return _srcMac;
    }

    public void setSrcMac(byte[] srcMac) {
//		this.srcMac = srcMac;
    }

    public ProtocolMacField fetchDestMac() {
        if (_destMac == null) {
            _destMac = new ProtocolMacField("destMac", "目的网卡地址", 0, 6, this);
        }
        return _destMac;
    }

    public void setDestMac(byte[] destMac) {
//		this.destMac = destMac;
    }

    public ProtocolStringField fetchType() {
        if (_type == null) {
            _type = new ProtocolStringField("type", "以太网类型", 12, 2, this);
            if (VlanPacket.EthernetType_Vlan.equals(_type.getValue())) {
                _type.setDisplayString("vlan");
            }
        }
        return _type;
    }

    public String getProtocolTypeDesc() {
        return "ethernet";
    }
}