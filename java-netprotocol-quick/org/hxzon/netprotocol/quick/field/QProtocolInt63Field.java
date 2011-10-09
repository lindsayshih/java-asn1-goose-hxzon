package org.hxzon.netprotocol.quick.field;

public class QProtocolInt63Field extends QProtocolField {
    private long value;

    public void setValue(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    @Override
    public String getValueAsString() {
        return String.valueOf(getValue());
    }
}
