package org.hxzon.netprotocol.packet;

import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.osipresentation.OsiPresentation;
import org.hxzon.asn1.osipresentation.OsiPresentationParser;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;

public class OsiPresentationPacket extends Packet {
    static {
        ProtocolBindingList.addBinding(new ProtocolBinding<OsiSessionPacket>() {

            @Override
            public Packet match(OsiSessionPacket packet) {
                return new OsiPresentationPacket();
            }

        });
    }

    protected int expectHeaderLength() {
//		return getSrcData().length - getOffset();
        return 0;
    }

    private BerNode pres;

    public IPacketPayload exceptPayload() {
        return (IPacketPayload) fetchOsiPresentation();
    }

    public BerNode[] getUserData() {
        if (pres instanceof OsiPresentation) {
            return ((OsiPresentation) pres).getUserData();
        }
        return new BerNode[0];
    }

    public BerNode fetchOsiPresentation() {
        if (pres == null) {
            pres = OsiPresentationParser.parser.parsePresentation(getSrcData(), getOffset());
        }
        return pres;
    }

//	public boolean isEmptyPayload() {
//		return true;
//	}

    public String getProtocolTypeDesc() {
        return "osi presentation";
    }
}