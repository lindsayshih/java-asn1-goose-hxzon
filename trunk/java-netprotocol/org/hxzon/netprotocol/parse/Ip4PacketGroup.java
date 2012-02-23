package org.hxzon.netprotocol.parse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hxzon.netprotocol.packet.Ip4Packet;

public class Ip4PacketGroup {

    private List<Ip4Packet> _packets = new ArrayList<Ip4Packet>();

    private int _key;
    private boolean _reachLast;
    private byte[] _reassembly;

    public static final Comparator<Ip4Packet> comparator = new Comparator<Ip4Packet>() {

        @Override
        public int compare(Ip4Packet p1, Ip4Packet p2) {
            return p1.fetchFragmentOffset().getValue() - p2.fetchFragmentOffset().getValue();
        }

    };

    public Ip4PacketGroup(int key) {
        _key = key;
    }

    public void addPacket(Ip4Packet packet) {
        _packets.add(packet);
        packet.setIp4Group(this);
        if (!packet.isMoreFragment()) {
            _reachLast = true;
        }
    }

    public byte[] getReassemblyPayload() {
        if (_reassembly == null && _reachLast == true) {
            Collections.sort(_packets, comparator);
            Ip4Packet lastPacket = _packets.get(_packets.size() - 1);
            _reassembly = new byte[lastPacket.fetchFragmentOffset().getValue() * 8 + lastPacket.getPayloadLength()];
            int i = 0;
            int len = 0;
            for (Ip4Packet packet : _packets) {
                len = packet.getPayloadLength();
                System.arraycopy(packet.getSrcData(), packet.getPayloadOffset(), _reassembly, i, len);
                i += len;
            }
        }
        return _reassembly;
    }

    public List<Ip4Packet> getPackets() {
        return _packets;
    }

    public int getKey() {
        return _key;
    }

    public boolean isReachLast() {
        return _reachLast;
    }
}
