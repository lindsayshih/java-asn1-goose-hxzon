package org.hxzon.netprotocol.common;

import java.util.ArrayList;
import java.util.List;

import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.parse.ProtocolDescUtil;
import org.hxzon.util.BytesUtil;

public class PacketHelper implements IPacket {
    protected byte[] _srcData;
    protected int _offset;
    protected int _len = -1;
    protected int _headerLength;
    protected IPacket _srcPacket;
    protected IPacketPayload _payload;
    protected IPacket _lastPacket;
    protected List<ProtocolField> _headerFields;
    protected boolean _miss;

    public PacketHelper() {
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
        if (_len == -1) {
            return getTotalLength();
        } else {
            return _len;
        }
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

    public int getPayloadOffset() {
        return this._offset + this._headerLength;
    }

    public int getPayloadLength() {
        return this._srcData.length - getPayloadOffset();
    }

    public int getHeaderLength() {
        return _headerLength;
    }

    public void setHeaderLength(int length) {
        this._headerLength = length;
    }

    public List<ProtocolField> getHeaderFields() {
        if (_headerFields == null) {
            _headerFields = new ArrayList<ProtocolField>();
        }
        return _headerFields;
    }

    public IPacketPayload getPayload() {
        return _payload;
    }

    public void setPayload(IPacketPayload payload) {
        this._payload = payload;
    }

    public IPacket getLastPacket() {
        return _lastPacket;
    }

    public String getLastPayloadType() {
        return getLastPacket().getPayload().getProtocolTypeDesc();
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
