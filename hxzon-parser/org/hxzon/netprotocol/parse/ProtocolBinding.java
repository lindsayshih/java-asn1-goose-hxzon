package org.hxzon.netprotocol.parse;

import org.hxzon.netprotocol.packet.Packet;

public interface ProtocolBinding<T extends Packet> {
    Packet match(T packet);
}
