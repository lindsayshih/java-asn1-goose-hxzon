package org.hxzon.netprotocol.common;

import java.util.ArrayList;
import java.util.List;

import org.hxzon.netprotocol.field.ProtocolField;

public class PacketHelper extends PayloadHelper implements IPacket {
    protected int _headerLength;
    protected List<ProtocolField> _headerFields;
    protected IPacketPayload _payload;
    protected IPacketPayload _lastPayload;

    public PacketHelper() {
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

    public IPacketPayload getLastPayload() {
        if (_lastPayload == null) {
            IPacketPayload packet = getPayload();
            while (packet instanceof IPacket) {
                packet = ((IPacket) packet).getPayload();
            }
            _lastPayload = packet;
        }
        return _lastPayload;
    }

}
