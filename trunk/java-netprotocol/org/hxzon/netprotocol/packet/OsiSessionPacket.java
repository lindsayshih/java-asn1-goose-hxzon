package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.parse.ProtocolDescUtil;

public class OsiSessionPacket extends Packet {
    static {
        ProtocolBindingList.addBinding(new ProtocolBinding<CotpPacket>() {

            @Override
            public Packet match(CotpPacket packet) {
                return new OsiSessionPacket();
            }

        });
        ProtocolDescUtil.putDesc(OsiSessionPacket.class,"osi session");
    }

    public int expectHeaderLength() {
        return 4;
    }

}
