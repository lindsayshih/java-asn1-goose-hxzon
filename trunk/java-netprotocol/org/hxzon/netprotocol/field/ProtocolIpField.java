package org.hxzon.netprotocol.field;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolIpField extends ProtocolInt63Field {

    public ProtocolIpField(String name, String display, int offset, int len, Packet srcPacket) {
        super(name, display, offset, len, true, srcPacket);
    }

    public String getValueAsString() {
        return getIpAsString(getValue());
    }

    public static String getIpAsString(long theIp) {
        String toReturn = "";
        for (int i = 0; i < 4; i++) {
            long field = theIp % 256;
            theIp = theIp / 256;
            toReturn = field + toReturn;
            if (i != 3)
                toReturn = "." + toReturn;
        }
        return toReturn;
    }

//    public static long IPStringToNum(String theIp) {
//        String[] fields = stringToArray(theIp, ".");
//        long sum = 0;
//        for (int i = 0; i < fields.length; i++) {
//            sum = sum * 256 + Integer.parseInt(fields[i]);
//        }
//        return sum;
//    }
//
//    private static String[] stringToArray(String inString, String delimiter) {
//        int start = 0, end = 0;
//        if (inString == null || delimiter == null) {
//            return null;
//        }
//        int count = 1;
//        int index = 0;
//        int dl = delimiter.length();
//        while (true) {
//            index = inString.indexOf(delimiter, index);
//            if (index < 0) {
//                break;
//            }
//            count++;
//            index += dl;
//        }
//        String array[] = new String[count];
//        for (int i = 0; i < count; i++) {
//            end = inString.indexOf(delimiter, start);
//            if (end == -1) { // The delimiter wasn't found
//                array[i] = new String(inString.substring(start)); // extract from start to the end
//                return array;
//            }
//            array[i] = new String(inString.substring(start, end));
//            start = end + dl; // move the start to the the end of the last delimiter
//        }
//        return array;
//    }
}
