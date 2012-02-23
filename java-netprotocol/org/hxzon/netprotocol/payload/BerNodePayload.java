package org.hxzon.netprotocol.payload;

import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.netprotocol.common.IPacket;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.util.BytesUtil;

public class BerNodePayload implements IPacketPayload {

    private BerNode _berNode;
    private IPacket _srcPacket;

    public BerNodePayload(BerNode node, IPacket srcPacket) {
        _berNode = node;
        _srcPacket = srcPacket;
    }

    @Override
    public int getOffset() {
        return _berNode.getTagOffset();
    }

    @Override
    public int getLength() {
        return _berNode.getTotalLen();
    }

    @Override
    public byte[] getSrcData() {
        return _srcPacket.getSrcData();
    }

    @Override
    public byte[] getData() {
        return BytesUtil.copyBytes(getSrcData(), getOffset(), getLength());
    }

    @Override
    public void setSrcPacket(IPacket srcPacket) {
//        this._srcPacket = srcPacket;
    }

    @Override
    public IPacket getSrcPacket() {
        return _srcPacket;
    }

    @Override
    public String getName() {
        return _berNode.getName();
    }

    @Override
    public String getProtocolTypeDesc() {
        return _berNode.getName();
    }

    public BerNode getBerNode() {
        return _berNode;
    }

}
