package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.field.ProtocolInt31HexField;
import org.hxzon.netprotocol.field.ProtocolMacField;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.parse.ProtocolDescUtil;

public class EthernetPacket extends Packet {
    static {
        ProtocolBindingList.addBinding(new ProtocolBinding<Packet>() {

            @Override
            public Packet match(Packet packet) {
                return new EthernetPacket();
            }

        });
        ProtocolDescUtil.putDesc(EthernetPacket.class, "ethernet");
    }
    public static final int HeaderLength = 14;
    private ProtocolMacField _srcMac;
    private ProtocolMacField _destMac;
    private ProtocolInt31HexField _type;

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

    public ProtocolMacField fetchDestMac() {
        if (_destMac == null) {
            _destMac = new ProtocolMacField("destMac", "目的网卡地址", 0, 6, this);
        }
        return _destMac;
    }

    public ProtocolInt31HexField fetchType() {
        if (_type == null) {
            _type = new ProtocolInt31HexField("type", "以太网类型", 12, 2, true, this);
            if (VlanPacket.EthernetType_Vlan == _type.getValue()) {
                _type.setName("vlan");
            }
        }
        return _type;
    }

}
