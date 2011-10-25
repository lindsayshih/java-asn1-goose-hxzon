package org.hxzon.asn1.core.type.ext;

import java.util.HashMap;
import java.util.Map;

import org.hxzon.asn1.core.type.BerInteger;

public abstract class BerIntegerEx extends BerInteger {
    private static final Map<String, String> valueStrings = new HashMap<String, String>();

    public String getValueAsString() {
        String valueAsString = valueStrings.get(getClass().getName() + "-" + getValue());
        if (valueAsString != null) {
            return valueAsString;
        } else {
            return super.getValueAsString();
        }
    }

    public static void addValueString(int value, String valueAsString, Class<?> clazz) {
        valueStrings.put(clazz.getName() + "-" + value, valueAsString);
    }

}
