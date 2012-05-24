package org.hxzon.netprotocol.parse;

import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.netprotocol.common.PacketGroup;
import org.hxzon.netprotocol.packet.CotpPacket;
import org.hxzon.netprotocol.packet.Packet;

public class CotpPacketGroup extends PacketGroup<CotpPacket> {

    protected CotpPacketGroup(int key) {
        super(key);
    }

    public void addPacket(CotpPacket packet) {
        super.addPacket(packet);
        packet.setGroup(this);
        if (packet.isLastUnit()) {
            _reachLast = true;
        }
    }

    public IPacketPayload parsePayload() {
        int reassemblyLen = 0;
        for (CotpPacket packet : _packets) {
            reassemblyLen += packet.getPayloadLength();
        }
        byte[] reassembly = new byte[reassemblyLen];
        int i = 0;
        int len = 0;
        for (CotpPacket packet : _packets) {
            len = packet.getPayloadLength();
            System.arraycopy(packet.getSrcData(), packet.getPayloadOffset(), reassembly, i, len);
            i += len;
        }
        _reassemblyData = reassembly;
        IPacketPayload payload = ProtocolBindingList.findBinding(_packets.get(0));
        if (payload != null) {
            if (payload instanceof Packet) {
                ((Packet) payload).init(reassembly, 0);
            }
        }
        return payload;
    }

}
