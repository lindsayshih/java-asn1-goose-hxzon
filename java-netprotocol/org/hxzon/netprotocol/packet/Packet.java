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
import org.hxzon.netprotocol.payload.MissPayload;
import org.hxzon.netprotocol.payload.UnknownPayload;

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
        this._len = this._srcData.length - this._offset;
    }

    public void setSrcPacket(IPacket srcPacket) {
        this._srcPacket = srcPacket;
        init(srcPacket);
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
        if (_miss) {
            return new MissPayload();
        }
        return null;
    }

    public Packet findBinding() {
        return ProtocolBindingList.findBinding(this);
    }

    public IPacketPayload getPayload() {
        if (_payload == null) {
            _payload = parsePayload();
        }
        return _payload;
    }

    private IPacketPayload parsePayload() {
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

}
