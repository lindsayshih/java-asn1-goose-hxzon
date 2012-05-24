package org.hxzon.netprotocol.parse;

import java.util.Collections;
import java.util.Comparator;

import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.netprotocol.common.PacketGroup;
import org.hxzon.netprotocol.packet.Ip4Packet;
import org.hxzon.netprotocol.packet.Packet;

public class Ip4PacketGroup extends PacketGroup<Ip4Packet> {

    public static final Comparator<Ip4Packet> comparator = new Comparator<Ip4Packet>() {

        @Override
        public int compare(Ip4Packet p1, Ip4Packet p2) {
            return p1.fetchFragmentOffset().getValue() - p2.fetchFragmentOffset().getValue();
        }

    };

    public Ip4PacketGroup(int key) {
        super(key);
    }

    public void addPacket(Ip4Packet packet) {
        super.addPacket(packet);
        packet.setGroup(this);
        if (!packet.isMoreFragment()) {
            _reachLast = true;
        }
    }

    public IPacketPayload parsePayload() {
        Collections.sort(_packets, comparator);
        Ip4Packet lastPacket = _packets.get(_packets.size() - 1);
        byte[] reassembly = new byte[lastPacket.fetchFragmentOffset().getValue() * 8 + lastPacket.getPayloadLength()];
        int i = 0;
        int len = 0;
        for (Ip4Packet packet : _packets) {
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
