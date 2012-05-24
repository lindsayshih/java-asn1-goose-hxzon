package org.hxzon.util;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class My1024NumberFormat extends NumberFormat {
    private static final long serialVersionUID = 1L;
    private static final double G = 1024 * 1024 * 1024;
    private static final double M = 1024 * 1024;
    private static final double K = 1024;

    private static final My1024NumberFormat instance = new My1024NumberFormat();

    public static final My1024NumberFormat getMyNumberFormat() {
        return instance;
    }

    private My1024NumberFormat() {

    }

    private void clean(StringBuffer toAppendTo) {
//        int pos = toAppendTo.indexOf(".");
//        if (pos != -1) {
//            String tmp = toAppendTo.substring(pos);
//            if (tmp.length() > 3) {
//                tmp = tmp.substring(0, 3);
//            }
//            toAppendTo.delete(pos, toAppendTo.length());
//            toAppendTo.append(tmp);
//        }
    }

    @Override
    public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {
        if (number >= G) {
            toAppendTo.append(number / G);
            clean(toAppendTo);
            return toAppendTo.append(" G");
        } else if (number >= M) {
            toAppendTo.append(number / M);
            clean(toAppendTo);
            return toAppendTo.append(" M");
        } else if (number >= K) {
            toAppendTo.append(number / K);
            clean(toAppendTo);
            return toAppendTo.append(" K");
        }
        return toAppendTo.append(number);
    }

    @Override
    public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {
        if (number >= G) {
            return toAppendTo.append(number / G).append(" G");
        } else if (number >= M) {
            return toAppendTo.append(number / M).append(" M");
        } else if (number >= K) {
            return toAppendTo.append(number / K).append(" K");
        }
        return toAppendTo.append(number);
    }

    @Override
    public Number parse(String source, ParsePosition parsePosition) {
        return null;
    }

}
