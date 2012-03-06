package org.hxzon.netprotocol.packet;

import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.osipresentation.OsiPresentationParser;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.parse.ProtocolDescUtil;
import org.hxzon.netprotocol.payload.BerNodePayload;
import org.hxzon.netprotocol.payload.MissPayload;

public class OsiSessionPacket extends Packet {
    static {
        ProtocolBindingList.addBinding(new ProtocolBinding<CotpPacket>() {

            @Override
            public Packet match(CotpPacket packet) {
                return new OsiSessionPacket();
            }

        });
        ProtocolDescUtil.putDesc(OsiSessionPacket.class, "osi session");
    }

    public int expectHeaderLength() {
        return 4;
    }

    public IPacketPayload exceptPayload() {
        if (_miss) {
            return new MissPayload();
        }
        BerNode node = OsiPresentationParser.parser.parsePresentation(getSrcData(), getPayloadOffset());
        return new BerNodePayload(node, this);
    }

}
