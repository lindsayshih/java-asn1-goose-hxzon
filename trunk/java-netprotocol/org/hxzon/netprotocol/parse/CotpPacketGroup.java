package org.hxzon.netprotocol.parse;

import java.util.ArrayList;
import java.util.List;

import org.hxzon.netprotocol.packet.CotpPacket;

public class CotpPacketGroup {

    private List<CotpPacket> _packets = new ArrayList<CotpPacket>();

    private int _key;
    private boolean _reachLast;
    private byte[] _reassembly;

    public CotpPacketGroup(int key) {
        _key = key;
    }

    public void addPacket(CotpPacket packet) {
        _packets.add(packet);
        packet.setCotpGroup(this);
        if (packet.isLastUnit()) {
            _reachLast = true;
        }
    }

    public byte[] getReassemblyPayload() {
        if (_reassembly == null && _reachLast == true) {
            int reassemblyLen = 0;
            for (CotpPacket packet : _packets) {
                reassemblyLen += packet.getPayloadLength();
            }
            _reassembly = new byte[reassemblyLen];
            int i = 0;
            int len = 0;
            for (CotpPacket packet : _packets) {
                len = packet.getPayloadLength();
                System.arraycopy(packet.getSrcData(), packet.getPayloadOffset(), _reassembly, i, len);
                i += len;
            }
        }
        return _reassembly;
    }

    public List<CotpPacket> getPackets() {
        return _packets;
    }

    public int getKey() {
        return _key;
    }

    public boolean isReachLast() {
        return _reachLast;
    }
}
