package org.hxzon.netprotocol.payload;

import org.hxzon.netprotocol.common.IPacket;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.netprotocol.common.PacketGroup;
import org.hxzon.netprotocol.common.PayloadHelper;

public class DataPayload extends PayloadHelper implements IPacketPayload {
    private PacketGroup<?> _group;

    public PacketGroup<?> getGroup() {
        return _group;
    }

    public void setGroup(PacketGroup<?> group) {
        this._group = group;
    }

    public String getProtocolTypeDesc() {
        if (_group != null) {
            IPacketPayload payload = _group.getPayload();
            if (payload != null) {
                if (payload instanceof IPacket) {
                    payload = ((IPacket) payload).getLastPayload();
                }
                return payload.getProtocolTypeDesc();
            }
        }
        return getSrcPacket().getProtocolTypeDesc();
    }

    public String getName() {
        return "user data";
    }

}
