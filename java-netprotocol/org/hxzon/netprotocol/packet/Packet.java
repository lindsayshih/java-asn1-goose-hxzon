package org.hxzon.netprotocol.packet;

import java.util.ArrayList;
import java.util.List;

import org.hxzon.netprotocol.common.IPacket;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.netprotocol.common.PacketHelper;
import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.payload.ErrorPayload;
import org.hxzon.netprotocol.payload.MissPayload;
import org.hxzon.netprotocol.payload.UnknownPayload;

public class Packet extends PacketHelper implements IPacket {

    public Packet() {
    }

    public Packet(byte[] data) {
        setSrcData(data);
    }

//-----------------------------------------------
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
    public IPacketPayload getPayload() {
        if (_payload == null) {
            _payload = parsePayload();
        }
        return _payload;
    }

    public IPacketPayload exceptPayload() {
        if (_miss) {
            return new MissPayload();
        }
        return null;
    }

    public IPacketPayload findBinding() {
        return ProtocolBindingList.findBinding(this);
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
