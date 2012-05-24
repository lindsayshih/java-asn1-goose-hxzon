package org.hxzon.netprotocol.parse;

import org.hxzon.netprotocol.common.IPacketPayload;

public interface ProtocolBinding<T extends IPacketPayload> {
    IPacketPayload match(T packet);
}
