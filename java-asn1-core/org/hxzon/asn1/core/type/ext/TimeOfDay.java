package org.hxzon.asn1.core.type.ext;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hxzon.asn1.core.type.BerOctetString;
import org.hxzon.util.BytesUtil;

public class TimeOfDay extends BerOctetString {
    private static final SimpleDateFormat _format = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
    private static final DecimalFormat _decimalFormat = new DecimalFormat();
    private static final String _numberPattern = "0.000000";
    private static final long _secondsOneDay = 24 * 3600;
    private static final long _millisecondsOneDay = _secondsOneDay * 1000;
    static {
        _decimalFormat.setRoundingMode(RoundingMode.DOWN);
        _decimalFormat.applyPattern(_numberPattern);
    }

    //TimeOfDay ::= OCTET STRING -- (SIZE (4 | 6))
    //wireshark-1.4.1/epan/dissectors/packet-mms.c
    //dissect_mms_TimeOfDay()
//    len = tvb_length_remaining(tvb, offset);
//
//    if(len == 4)
//    {
//        milliseconds = tvb_get_ntohl(tvb, offset);
//        ptime = time_msecs_to_str(milliseconds);
//
//        if(hf_index >= 0)
//        {
//            proto_tree_add_string(tree, hf_index, tvb, offset, len, ptime);
//        }
//        return offset;
//    }
//
//    if(len == 6)
//    {
//        milliseconds = tvb_get_ntohl(tvb, offset);
//        days = tvb_get_ntohs(tvb, offset+4);
//
//        /* 5113 days between 01-01-1970 and 01-01-1984 */
//        /* 86400 seconds in one day */
//
//        ts.secs = (days + 5113) * 86400 + milliseconds / 1000;
//        ts.nsecs = (milliseconds % 1000) * G_GINT64_CONSTANT(1000000U);
//
//        ptime = abs_time_to_str(&ts, ABSOLUTE_TIME_UTC, TRUE);
//        if(hf_index >= 0)
//        {
//            proto_tree_add_string(tree, hf_index, tvb, offset, len, ptime);
//        }
//
//        return offset;
//    }
    //有两个时间概念需要区分，第一个MMS UTC时间，也就是timestamp(时间标签)类型，
    //值的格式应包括3部分：距离格林尼治标准时间1970年1月1日午夜的秒数(s)、秒的小数部分(f)、质量标记(q)。
    //第二个MMS Btime6(天的时间)，类型应是八位组串，该类型的值包括4个字节，值分为两个部分：
    //第一部分表示从当天午夜之后的毫秒数(日期不在该数值中)，
    //第二部分包含时间和日期，以从1984年1月1日之后的相对天数来表示。
    public String getValueAsString() {
        try {
            String str = BytesUtil.toHexString(getValue());
            int len = getTagOffset() + getTotalLen() - getValueOffset();
            Date date = null;
            long milliseconds = 0;//毫秒
            double microsecondPart = 0;//微妙
            if (len == 4) {
                milliseconds = Long.parseLong(str, 16);
                date = new Date(milliseconds);
            } else {
                /* 5113 days between 01-01-1970 and 01-01-1984 */
                /* 86400 seconds in one day */
                //test:
                //8c(tag) 06(len) 01 ec a9 e0 26 1e
                //2010-09-19 08:58:7.200 (days=9758 msec= 32287200)
                milliseconds = Long.parseLong(str.substring(0, 8), 16);
                long days = Long.parseLong(str.substring(8, 12), 16);
                date = new Date((days + 5113) * _millisecondsOneDay + milliseconds);
            }
            microsecondPart = ((double) (milliseconds % 1000)) / 1000;
            return _format.format(date) + _decimalFormat.format(microsecondPart).substring(1);
        } catch (Exception e) {
            return super.getValueAsString();
        }
    }
}
