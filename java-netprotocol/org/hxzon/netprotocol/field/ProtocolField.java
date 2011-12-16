package org.hxzon.netprotocol.field;

import org.hxzon.netprotocol.packet.Packet;

public abstract class ProtocolField {
    private Packet _packet;
    private int _offset;
    private int _len;
    private String _name;
    private String _displayString;
    private int _miss = State_Rigth;
    public static final int State_Rigth = 0;
    public static final int State_WrongOffset = 1;
    public static final int State_WrongLen = 2;

    public abstract String getValueAsString();

    public String getValueAsDisplay() {
        if (_miss == State_WrongOffset) {
            return "wrong offset";
        } else if (_miss == State_WrongLen) {
            return "miss";
        } else {
            return getValueAsString();
        }
    }

    public boolean isRight() {
        return _miss == State_Rigth;
    }

    public void setSaveOffsetAndLen(Packet packet, int offset, int len) {
        int headerLength = packet.getHeaderLength();
        if (offset < 0) {
            offset = 0;
        }
        if (offset > headerLength) {
            System.err.println("err offset(" + offset + ") when headerLength=" + headerLength);
            offset = headerLength;
            _miss = State_WrongOffset;
        }
        setOffset(packet.getOffset() + offset);
        if (len < 0) {
            len = 0;
        }
        if (offset + len > headerLength) {
            System.err.println("err len(" + len + ") when offset=" + offset + ",and headerLength=" + headerLength);
            len = headerLength - offset;
            _miss = State_WrongLen;
        }
        setLen(len);
    }

    public int getOffset() {
        return _offset;
    }

    private void setOffset(int offset) {
        this._offset = offset;
    }

    public int getLen() {
        return _len;
    }

    private void setLen(int len) {
        this._len = len;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getDisplayString() {
        return _displayString;
    }

    public void setDisplayString(String display) {
        this._displayString = display;
    }

    public String toString() {
        return _name;
    }

    public Packet getPacket() {
        return _packet;
    }

    public void setPacket(Packet packet) {
        this._packet = packet;
    }
}
