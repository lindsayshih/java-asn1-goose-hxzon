package org.hxzon.asn1.core.type.ext;

import java.util.HashMap;
import java.util.Map;

import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.type.BerInteger;

public class BerIntegerEx2 extends BerInteger {

    private static final Map<String, String> valueStrings = new HashMap<String, String>();
    private static final Map<String, String> displayStrings = new HashMap<String, String>();

    public String getValueAsString() {
        int tagNumber = getTag() & Tag.TAGNUMBER_MASK;
        String prefix = getClass().getName() + "-" + tagNumber;
        String valueAsString = valueStrings.get(prefix + "-" + getValue());
        if (valueAsString != null) {
            return valueAsString;
        } else {
            valueAsString = valueStrings.get(prefix + "-x");
            return valueAsString != null ? valueAsString : super.getValueAsString();
        }
    }

    public static void addValueString(int tagNumber, int value, String valueAsString, Class<?> clazz) {
        String prefix = clazz.getName() + "-" + tagNumber;
        valueStrings.put(prefix + "-" + value, valueAsString);
    }

    public static void addValueString(int tagNumber, String valueAsString, Class<?> clazz) {
        String prefix = clazz.getName() + "-" + tagNumber;
        valueStrings.put(prefix + "-x", valueAsString);
    }

    public static void addDisplayString(int tagNumber, String displayString, Class<?> clazz) {
        String prefix = clazz.getName() + "-" + tagNumber;
        displayStrings.put(prefix, displayString);
    }

    public String getDisplayString() {
        int tagNumber = getTag() & Tag.TAGNUMBER_MASK;
        String prefix = getClass().getName() + "-" + tagNumber;
        return displayStrings.get(prefix);
    }
}
