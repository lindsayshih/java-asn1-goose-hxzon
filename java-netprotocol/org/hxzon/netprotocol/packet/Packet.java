package org.hxzon.netprotocol.packet;

import java.util.ArrayList;
import java.util.List;

import org.hxzon.netprotocol.common.IPacket;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.netprotocol.common.PacketHelper;
import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.payload.EmptyPayload;
import org.hxzon.netprotocol.payload.ErrorPayload;
import org.hxzon.netprotocol.payload.NullPayload;
import org.hxzon.netprotocol.payload.UnknownPayload;
import org.hxzon.util.BytesUtil;

public class Packet extends PacketHelper implements IPacket {

    public Packet() {
    }

    public Packet(byte[] data) {
        setSrcData(data);
    }

    public void init(IPacket srcPacket) {
        init(srcPacket.getSrcData(), srcPacket.getOffset() + srcPacket.getHeaderLength());
    }

    public void init(byte[] srcData, int offset) {
        this._srcData = srcData;
        this._offset = offset;
        this._headerLength = this._srcData.length;//for some field fetch before expectHeaderLength
        this._headerLength = expectHeaderLength();
        if (this._offset + this._headerLength > _srcData.length) {
            this._headerLength = _srcData.length - this._offset;
            this._miss = true;
        }
    }

    public IPacket getSrcPacket() {
        return _srcPacket;
    }

    public void setSrcPacket(IPacket srcPacket) {
        this._srcPacket = srcPacket;
        init(srcPacket);
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

//-----------------------------------------------
    protected int expectHeaderLength() {
        return 0;
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

    public Packet findBinding() {
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

}
