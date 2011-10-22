package org.hxzon.asn1.core.type.ext;

import java.util.HashMap;
import java.util.Map;

import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.type.BerInteger;

public class BerIntegerEx2 extends BerInteger {

    private final Map<String, String> valueStrings = new HashMap<String, String>();
    private final Map<String, String> displayStrings = new HashMap<String, String>();

    public String getValueAsString() {
        int tagNumber = getTag() & Tag.TAGNUMBER_MASK;
        String valueAsString = valueStrings.get(tagNumber + "-" + getValue());
        if (valueAsString != null) {
            return valueAsString;
        } else {
            valueAsString = valueStrings.get(tagNumber + "-x");
            return valueAsString != null ? valueAsString : super.getValueAsString();
        }
    }

    public void addValueString(int tagNumber, int value, String valueAsString) {
        valueStrings.put(tagNumber + "-" + value, valueAsString);
    }

    public void addValueString(int tagNumber, String valueAsString) {
        valueStrings.put(tagNumber + "-x", valueAsString);
    }

    public void addDisplayString(int tagNumber, String displayString) {
        displayStrings.put(String.valueOf(tagNumber), displayString);
    }

    public String getDisplayString() {
        int tagNumber = getTag() & Tag.TAGNUMBER_MASK;
        return displayStrings.get(String.valueOf(tagNumber));
    }
}
