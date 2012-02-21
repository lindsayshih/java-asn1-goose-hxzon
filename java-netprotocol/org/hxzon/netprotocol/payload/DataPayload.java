package org.hxzon.netprotocol.payload;

import org.hxzon.netprotocol.common.IPacket;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.util.BytesUtil;

public class DataPayload implements IPacketPayload {
    private byte[] _srcData;
    private int _offset;
    private IPacket _srcPacket;
    private boolean _miss;

    @Override
    public byte[] getData() {
        return BytesUtil.copyBytes(_srcData, _offset, getLength());
    }

    @Override
    public int getLength() {
        return _srcData.length - _offset;
    }

    @Override
    public int getOffset() {
        return _offset;
    }

    @Override
    public byte[] getSrcData() {
        return _srcData;
    }

    @Override
    public IPacket getSrcPacket() {
        return _srcPacket;
    }

    @Override
    public void setSrcPacket(IPacket srcPacket) {
        this._srcPacket = srcPacket;
        this._srcData = srcPacket.getSrcData();
        this._offset = srcPacket.getOffset() + srcPacket.getHeaderLength();
    }

    public String getName() {
        return "user data";
    }

    public String getProtocolTypeDesc() {
        return "user data";
    }

}
