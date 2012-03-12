package org.hxzon.netprotocol.common;

import java.util.ArrayList;
import java.util.List;

public class PacketGroup<P extends IPacket> {
    private int _key;
    protected boolean _reachLast;
    protected List<P> _packets = new ArrayList<P>();
    private IPacketPayload _reassemblyPayload;
    protected byte[] _reassemblyData;

    protected PacketGroup(int key) {
        this._key = key;
    }

    public void addPacket(P packet) {
        _packets.add(packet);
//        packet.setGroup(this);
//        if (packet.isLastPacket()) {
//            _reachLast = true;
//        }
    }

    public IPacketPayload getPayload() {
        if (_reassemblyPayload == null && isReachLast()) {
            _reassemblyPayload = parsePayload();
            _reassemblyPayload.setSrcPacket(_packets.get(0));
        }
        return _reassemblyPayload;
    }

    public IPacketPayload parsePayload() {
        return null;
    }

    public byte[] getReassemblyData() {
        return _reassemblyData;
    }

    public List<P> getPackets() {
        return _packets;
    }

    public int getKey() {
        return _key;
    }

    public boolean isReachLast() {
        return _reachLast;
    }
}
