package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.field.ProtocolBitField;
import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.field.ProtocolInt31HexField;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.parse.ProtocolDescUtil;

public class VlanPacket extends Packet {
    static {
        ProtocolBindingList.addBinding(new ProtocolBinding<EthernetPacket>() {

            @Override
            public Packet match(EthernetPacket packet) {
                if (packet.fetchType().getValue() == EthernetType_Vlan) {
                    return new VlanPacket();
                }
                return null;
            }

        });
        ProtocolDescUtil.putDesc(VlanPacket.class, "vlan");
    }
    public static final int HeaderLength = 4;
    public static final int EthernetType_Vlan = 0x8100;

    private ProtocolBitField _priority;
    private ProtocolBitField _cfi;
    private ProtocolBitField _vlanId;
    private ProtocolInt31HexField _type;

    protected int expectHeaderLength() {
        return HeaderLength;
    }

    protected ProtocolField[] expectHeaderFields() {
        return new ProtocolField[] { fetchPriority(), fetchCfi(), fetchVlanId(), fetchType() };
    }

    public ProtocolInt31HexField fetchType() {
        if (_type == null) {
            _type = new ProtocolInt31HexField("type", "以太网类型", 2, 2, true, this);
        }
        return _type;
    }

    public ProtocolBitField fetchPriority() {
        if (_priority == null) {
            _priority = new ProtocolBitField("priority", "优先级", 0, 0, 3, this);
        }
        return _priority;
    }

    public ProtocolBitField fetchCfi() {
        if (_cfi == null) {
            _cfi = new ProtocolBitField("cfi", "格式", 0, 3, 1, this) {
                public String getValueAsString() {
                    return getValue() == 0 ? "规范格式" : "非规范格式";
                }
            };
        }
        return _cfi;
    }

    public ProtocolBitField fetchVlanId() {
        if (_vlanId == null) {
            _vlanId = new ProtocolBitField("vlan id", "VLAN ID", 0, 4, 12, this);
        }
        return _vlanId;
    }

}
