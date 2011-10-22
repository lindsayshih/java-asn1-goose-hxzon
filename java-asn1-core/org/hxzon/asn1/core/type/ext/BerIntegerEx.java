package org.hxzon.asn1.core.type.ext;

import java.util.HashMap;
import java.util.Map;

import org.hxzon.asn1.core.type.BerInteger;

public class BerIntegerEx extends BerInteger {
    private final Map<String, String> valueStrings = new HashMap<String, String>();

    public String getValueAsString() {
        String valueAsString = valueStrings.get(String.valueOf(getValue()));
        if (valueAsString != null) {
            return valueAsString;
        } else {
            return super.getValueAsString();
        }
    }

    public void addValueString(int value, String valueAsString) {
        valueStrings.put(String.valueOf(value), valueAsString);
    }

}
