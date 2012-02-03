package org.hxzon.asn1.core.type.ext;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hxzon.asn1.core.type.BerOctetString;
import org.hxzon.util.BytesUtil;

public class UtcTime extends BerOctetString {
    private static final SimpleDateFormat _format = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
    private static final DecimalFormat _decimalFormat = new DecimalFormat();
    private static final String _numberPattern = "000000";
    static {
//        _decimalFormat.setRoundingMode(RoundingMode.DOWN);
        _decimalFormat.applyPattern(_numberPattern);
    }

    //前4个字节是从1970年1月1日0时0分0秒开始的秒数，紧跟的3个字节是秒的小数部分，最后一个字节是时间品质和精度。
    //秒值=0x49 56 dc 03 = 1230429187s；
    //秒的小数部分=(0x6d 0e 56) / (2^24) = 0.426000s；
    //时间品质=0x50=0101 0000B：时钟错误，精度为16（25微秒，T3级时钟）。
    //84 08 49 56 dc 03 6d 0e 56 50
    //参见：61850-7-2：5.5.3.7.2，61850-7-2：5.5.3.7.3，61850-8-1：8.1.3.6。
    public String getValueAsString() {
        try {
            String str = BytesUtil.toHexString(getValue());
            long seconds = Long.parseLong(str.substring(0, 8), 16);
            long millis = Long.parseLong(str.substring(8, 14), 16);
//            double millisD = millis / Math.pow(2, 24);
            double millisD = (int) ((double) millis * 1000000.0 / (double) 0x00ffffff);
//		Date date = new Date(seconds * 1000 + millisD * 1000);
            Date date = new Date(seconds * 1000);
//            return _format.format(date) + _decimalFormat.format(millisD).substring(1) + "," + str.substring(14);
            return _format.format(date) + "." + _decimalFormat.format(millisD) + "," + str.substring(14);
        } catch (Exception e) {
            return super.getValueAsString();
        }
    }

//  ST_RET pts_asn1r_get_utc_time (ASN1_DEC_CTXT *ac, MMS_UTC_TIME *dest)
//  {
//
//
//  /* Read the number of seconds since January 1, 1970 (4 bytes) */
//  dest->secs =  (((ST_UINT32) *(ac->asn1r_field_ptr++)) << 24) & 0xFF000000L;
//  dest->secs |= (((ST_UINT32) *(ac->asn1r_field_ptr++)) << 16) & 0x00FF0000L;
//  dest->secs |= (((ST_UINT32) *(ac->asn1r_field_ptr++)) << 8)  & 0x0000FF00L;
//  dest->secs |=  ((ST_UINT32) *(ac->asn1r_field_ptr++))        & 0x000000FFL;
//
//  /* read fraction of a second (3 bytes) */
//  dest->fraction =  (((ST_UINT32) *(ac->asn1r_field_ptr++)) << 16) & 0x00FF0000L;
//  dest->fraction |= (((ST_UINT32) *(ac->asn1r_field_ptr++)) << 8)  & 0x0000FF00L;
//  dest->fraction |=  ((ST_UINT32) *(ac->asn1r_field_ptr++))        & 0x000000FFL;
//
//
//
//  /* read the quality flags (1 byte) */
//  dest->qflags =  ((ST_UINT32) *(ac->asn1r_field_ptr++));
//
//  dest->fraction_decode = (ST_INT32) ((ST_DOUBLE) dest->fraction * 1000000.0/(ST_DOUBLE)0x00FFFFFF);
//
//  //MMS_BTOD btod;
//
//  //asn1_convert_utc_to_btod(dest, &btod);
//
//  //printf("asn1r_get_utc_time =  %d\n",
//    //  (ST_INT32) ((ST_DOUBLE) dest->fraction * 1000000.0/(ST_DOUBLE)0x00FFFFFF));
//
//
//  return (SD_SUCCESS);
//  }
}
