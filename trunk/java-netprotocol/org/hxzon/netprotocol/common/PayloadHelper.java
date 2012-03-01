package org.hxzon.netprotocol.common;

import org.hxzon.netprotocol.parse.ProtocolDescUtil;
import org.hxzon.util.BytesUtil;

public class PayloadHelper implements IPacketPayload {
    protected byte[] _srcData;
    protected int _offset = -1;
    protected int _len = -1;
    protected IPacket _srcPacket;
    protected boolean _miss;

    public PayloadHelper() {
    }

    public IPacket getSrcPacket() {
        return _srcPacket;
    }

    public void setSrcPacket(IPacket srcPacket) {
        this._srcPacket = srcPacket;
    }

    public byte[] getSrcData() {
        return _srcData;
    }

    public void setSrcData(byte[] data) {
        this._srcData = data;
    }

    public byte[] getData() {
        return BytesUtil.copyBytes(_srcData, _offset, getTotalLength());
    }

    public int getTotalLength() {
        return _srcData.length - _offset;
    }

    public int getLength() {
        return _len;
    }

    public void setLength(int len) {
        this._len = len;
    }

    public int getOffset() {
        return _offset;
    }

    public void setOffset(int offset) {
        this._offset = offset;
    }

    public String getProtocolTypeDesc() {
        String desc = ProtocolDescUtil.getDesc(this.getClass());
        return desc == null ? "unknown" : desc;
    }

    public String getName() {
        return getProtocolTypeDesc() + (_miss ? "(miss)" : "");
    }

    //----------------------------
    public byte[] getByteArray(int offset, int len) {
        return BytesUtil.copyBytes(_srcData, offset, len);
    }

    public String getHexString(int offset, int len) {
        return BytesUtil.toHexString(_srcData, offset, len);
    }

    public long getSigned(int offset, int len) {
        return BytesUtil.toSigned(_srcData, offset, len);
    }

    public long getUnsigned(int offset, int len) {
        return BytesUtil.toUnsigned(_srcData, offset, len);
    }

    public int getIntByBit(int offset, int len, int bitOffset, int bitLen) {
        try {
//			if (len == 1) {
//				return BytesUtil.toInt(srcData[offset], bitOffset, bitLen);
//			}
            return BytesUtil.toInt(_srcData, offset, len, bitOffset, bitLen);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
