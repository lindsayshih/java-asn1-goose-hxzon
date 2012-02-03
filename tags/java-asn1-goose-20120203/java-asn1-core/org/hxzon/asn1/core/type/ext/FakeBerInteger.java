package org.hxzon.asn1.core.type.ext;

public class FakeBerInteger extends FakeBerNode {

    private long _value;

    public FakeBerInteger(long value) {
        this._value = value;
    }

    public long getValue() {
        return _value;
    }

    public String getValueAsString() {
        return String.valueOf(getValue());
    }

    @Override
    public String getAsn1TypeDesc() {
        return "FakeBerInteger";
    }

}
