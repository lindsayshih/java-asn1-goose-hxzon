package org.hxzon.netprotocol.packet;

import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.osipresentation.OsiPresentation;
import org.hxzon.asn1.osipresentation.OsiPresentationParser;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.payload.BerNodePayload;

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

    private IPacketPayload _pres;

    public IPacketPayload exceptPayload() {
        return (IPacketPayload) fetchOsiPresentation();
    }

    public BerNode[] getUserData() {
        if (_pres instanceof OsiPresentation) {
            return ((OsiPresentation) _pres).getUserData();
        }
        return new BerNode[0];
    }

    public IPacketPayload fetchOsiPresentation() {
        if (_pres == null) {
            BerNode node = OsiPresentationParser.parser.parsePresentation(getSrcData(), getOffset());
            _pres = new BerNodePayload(node, this);
        }
        return _pres;
    }

//	public boolean isEmptyPayload() {
//		return true;
//	}

    public String getProtocolTypeDesc() {
        return "osi presentation";
    }
}
