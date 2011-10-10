package org.hxzon.asn1.core.type.ext;

public class FakeBerInteger extends FakeBerNode {

    private long value;

    public FakeBerInteger(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public String getValueAsString() {
        return String.valueOf(getValue());
    }

    @Override
    public String getAsn1TypeDesc() {
        return "FakeBerInteger";
    }

}
