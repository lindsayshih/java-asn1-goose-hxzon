package org.hxzon.netprotocol.packet;

import java.util.ArrayList;
import java.util.List;

import org.hxzon.netprotocol.common.IPacket;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.payload.EmptyPayload;
import org.hxzon.netprotocol.payload.ErrorPayload;
import org.hxzon.netprotocol.payload.NullPayload;
import org.hxzon.netprotocol.payload.UnknownPayload;
import org.hxzon.util.BytesUtil;

public class Packet implements IPacket {
    private byte[] _srcData;
    private int _offset;
    private int _headerLength;
    private IPacket _srcPacket;
    private IPacketPayload _payload;
    private IPacket _lastPacket;
    private List<ProtocolField> _headerFields;
    private boolean _miss;

    public Packet() {
    }

    public Packet(byte[] data) {
        setSrcData(data);
    }

    public IPacket getSrcPacket() {
        return _srcPacket;
    }

    public void setSrcPacket(IPacket srcPacket) {
        this._srcPacket = srcPacket;
        this._srcData = srcPacket.getSrcData();
        this._offset = srcPacket.getOffset() + srcPacket.getHeaderLength();
        this._headerLength = this._srcData.length;//for some field fetch before expectHeaderLength
        this._headerLength = expectHeaderLength();
        if (this._offset + this._headerLength > _srcData.length) {
            this._headerLength = _srcData.length - this._offset;
            this._miss = true;
        }
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

//-----------------------------------------------
    public int getLength() {
        return getTotalLength();
    }

    public int getTotalLength() {
        return _srcData.length - _offset;
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

//-----------------------------------------------
    protected int expectHeaderLength() {
        return 0;
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
            for (ProtocolField field : expectHeaderFields()) {
                _headerFields.add(field);
            }
        }
        return _headerFields;
    }

    protected ProtocolField[] expectHeaderFields() {
        return new ProtocolField[0];
    }

//---------------------------------------------
    public IPacketPayload exceptPayload() {
        return null;
    }

    public IPacket findBinding() {
        return ProtocolBindingList.findBinding(this);
    }

    public boolean isEmptyPayload() {
        return false;
    }

    public IPacketPayload getPayload() {
        if (_payload == null) {
            _payload = parsePayload();
        }
        return _payload;
    }

    public IPacket getLastPacket() {
        if (_lastPacket == null) {
            IPacketPayload packet = getPayload();
            while (packet instanceof IPacket) {
                packet = ((IPacket) packet).getPayload();
            }
            _lastPacket = packet.getSrcPacket();
        }
        return _lastPacket;
    }

    public String getLastPayloadType() {
        return getLastPacket().getPayload().getProtocolTypeDesc();
    }

    public void setPayload(IPacketPayload payload) {
        this._payload = payload;
    }

    private IPacketPayload parsePayload() {
        if (isEmptyPayload()) {
            _payload = new EmptyPayload();
        }
        if (_miss) {
            _payload = new NullPayload();
        }
        try {
            if (_payload == null) {
                _payload = exceptPayload();
            }
            if (_payload == null) {
                _payload = findBinding();
            }
            if (_payload == null) {
                _payload = new UnknownPayload();
            }
        } catch (Exception e) {
            _payload = new ErrorPayload(e.getMessage());
        }
        _payload.setSrcPacket(this);
        return _payload;
    }

//------------------------------------------------
    public String getProtocolTypeDesc() {
        return "Packet";
    }

    public String getName() {
        return getProtocolTypeDesc() + (_miss ? "(miss)" : "");
    }

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
