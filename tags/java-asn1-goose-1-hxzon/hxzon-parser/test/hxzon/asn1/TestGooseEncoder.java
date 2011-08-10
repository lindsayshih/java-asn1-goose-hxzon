package test.hxzon.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.BitSet;
import java.util.Calendar;

import org.hxzon.util.BytesUtil;

import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerOutputStream;
import com.chaosinmotion.asn1.BerVisibleString;
import com.chaosinmotion.asn1.Tag;
import com.turkcelltech.jac.ASN1Boolean;
import com.turkcelltech.jac.ASN1Integer;
import com.turkcelltech.jac.BitString;
import com.turkcelltech.jac.OctetString;
import com.turkcelltech.jac.Sequence;

public class TestGooseEncoder {
//    IECGoosePdu ::= SEQUENCE {
//        gocbRef     [0] IMPLICIT VisibleString,
//        timeAllowedtoLive [1] IMPLICIT INTEGER,
//        datSet     [2] IMPLICIT VisibleString,
//        goID     [3] IMPLICIT VisibleString OPTIONAL,
//        t      [4] IMPLICIT UtcTime,
//        stNum     [5] IMPLICIT INTEGER,
//        sqNum     [6] IMPLICIT INTEGER,
//        test     [7] IMPLICIT BOOLEAN DEFAULT FALSE,
//        confRev     [8] IMPLICIT INTEGER,
//        ndsCom     [9] IMPLICIT BOOLEAN DEFAULT FALSE,
//        numDatSetEntries [10] IMPLICIT INTEGER,
//        allData     [11] IMPLICIT SEQUENCE OF Data --,
//        -- security    [12] ANY OPTIONAL
//                -- reserved for digital signature
//        }
//        UtcTime ::= OCTET STRING -- format and size defined in 8.1.3.6.
//        TimeOfDay ::= OCTET STRING -- (SIZE (4 | 6))
//        FloatingPoint ::= OCTET STRING
//        Data ::= CHOICE {
//        -- context tag 0 is reserved for AccessResult
//        array    [1] IMPLICIT SEQUENCE OF Data,
//        structure   [2] IMPLICIT SEQUENCE OF Data,
//        boolean    [3] IMPLICIT BOOLEAN,
//        bit-string   [4] IMPLICIT BIT STRING,
//        integer    [5] IMPLICIT INTEGER,
//        unsigned   [6] IMPLICIT INTEGER,
//        floating-point [7] IMPLICIT FloatingPoint,
//        real   [8] IMPLICIT REAL,
//        octet-string [9] IMPLICIT OCTET STRING,
//        visible-string [10] IMPLICIT VisibleString,
//        binary-time   [12] IMPLICIT TimeOfDay,
//        bcd     [13] IMPLICIT INTEGER,
//        booleanArray [14] IMPLICIT BIT STRING
//        }

//    0000   01 0c cd 01 00 03 01 0c cd 01 10 10 81 00 00 01  ................
//    0010   88 b8 00 03 00 e4 00 00 00 00 61 81 d9 80 1f 58  ..........a....X
//    0020   37 32 31 32 5f 31 4a 44 5f 47 4f 50 52 4f 54 2f  7212_1JD_GOPROT/
//    0030   4c 4c 4e 30 24 47 4f 24 67 6f 63 62 54 78 81 02  LLN0$GO$gocbTx..
//    0040   27 10 82 1f 58 37 32 31 32 5f 31 4a 44 5f 47 4f  '...X7212_1JD_GO
//    0050   50 52 4f 54 2f 4c 4c 4e 30 24 64 73 47 6f 6f 73  PROT/LLN0$dsGoos
//    0060   65 54 78 83 11 58 37 32 31 32 5f 47 4f 4f 53 45  eTx..X7212_GOOSE
//    0070   5f 54 58 5f 49 44 84 08 00 00 00 00 00 00 00 00  _TX_ID..........
//    0080   85 01 0a 86 03 32 80 04 87 01 00 88 01 00 89 01  .....2..........
//    0090   00 8a 01 20 ab 60 83 01 00 84 01 00 83 01 00 84  ... .`..........
//    00a0   01 00 83 01 00 84 01 00 83 01 00 84 01 00 83 01  ................
//    00b0   00 84 01 00 83 01 00 84 01 00 83 01 00 84 01 00  ................
//    00c0   83 01 00 84 01 00 83 01 00 84 01 00 83 01 00 84  ................
//    00d0   01 00 83 01 00 84 01 00 83 01 00 84 01 00 83 01  ................
//    00e0   00 84 01 00 83 01 00 84 01 00 83 01 00 84 01 00  ................
//    00f0   83 01 00 84 01 00                                ......

//    61 81 d9 80 1f 58
//    37 32 31 32 5f 31 4a 44 5f 47 4f 50 52 4f 54 2f
//    4c 4c 4e 30 24 47 4f 24 67 6f 63 62 54 78 81 02
//    27 10 82 1f 58 37 32 31 32 5f 31 4a 44 5f 47 4f
//    50 52 4f 54 2f 4c 4c 4e 30 24 64 73 47 6f 6f 73
//    65 54 78 83 11 58 37 32 31 32 5f 47 4f 4f 53 45
//    5f 54 58 5f 49 44 84 08 00 00 00 00 00 00 00 00
//    85 01 0a 86 03 32 80 04 87 01 00 88 01 00 89 01
//    00 8a 01 20 ab 60 83 01 00 84 01 00 83 01 00 84
//    01 00 83 01 00 84 01 00 83 01 00 84 01 00 83 01
//    00 84 01 00 83 01 00 84 01 00 83 01 00 84 01 00
//    83 01 00 84 01 00 83 01 00 84 01 00 83 01 00 84
//    01 00 83 01 00 84 01 00 83 01 00 84 01 00 83 01
//    00 84 01 00 83 01 00 84 01 00 83 01 00 84 01 00
//    83 01 00 84 01 00                              
    public static void main(String[] args) throws IOException {
//        BerSequence goose = new BerSequence();
//        goose.addElement(new BerVisibleString(0,"X7212_1JD_GOPROT/LLN0$GO$gocbTx"));
//        goose.addElement(new BerInteger(1,10000));
//        goose.addElement(new BerVisibleString(2,"X7212_1JD_GOPROT/LLN0$dsGooseTx"));
//        goose.addElement(new BerVisibleString(3,"X7212_GOOSE_TX_ID"));//  GOOSEID*:   
//        goose.addElement(new BerUTCTime(4,new Date()));
//        goose.addElement(new BerInteger(5,10));
//        goose.addElement(new BerInteger(6,3309572));
//        goose.addElement(new BerBoolean(7,false));
//        goose.addElement(new BerInteger(8,0));
//        goose.addElement(new BerBoolean(9,false));
//        goose.addElement(new BerInteger(10,32));
//        BerSequence dataset = new BerSequence(11);
//        for (int i = 0; i < 32; i++) {
//            dataset.addElement(new BerBoolean(false));
//            dataset.addElement(new BerNull());
//        }
//        goose.addElement(dataset);
        
      Sequence goose2 = new Sequence();
      goose2.setTagClass(Tag.APPLICATION);
      goose2.setTagNumber(1);
      BerNode gocbRef=new BerVisibleString("X7212_1JD_GOPROT/LLN0$GO$gocbTx");
      gocbRef.setTagClass(Tag.CONTEXT);
      gocbRef.setTagNumber(0);
      goose2.addElement(gocbRef);
      BerNode timeAllowedtoLive=new ASN1Integer(10000);
      timeAllowedtoLive.setTagClass(Tag.CONTEXT);
      timeAllowedtoLive.setTagNumber(1);
      goose2.addElement(timeAllowedtoLive);
      BerNode datSet=new BerVisibleString(2,"X7212_1JD_GOPROT/LLN0$dsGooseTx");
      datSet.setTagClass(Tag.CONTEXT);
      datSet.setTagNumber(2);
      goose2.addElement(datSet);
      BerNode goID=new BerVisibleString(3,"X7212_GOOSE_TX_ID");
      goID.setTagClass(Tag.CONTEXT);
      goID.setTagNumber(3);
      goose2.addElement(goID);
      //前4个字节是从1970年1月1日0时0分0秒开始的秒数，紧跟的3个字节是秒的小数部分，最后一个字节是时间品质和精度。
      //秒值=0x49 56 dc 03 = 1230429187s；
      //秒的小数部分=(0x6d 0e 56) / (2^24) = 0.426000s；
      //时间品质=0x50=0101 0000B：时钟错误，精度为16（25微秒，T3级时钟）。
      //84 08 49 56 dc 03 6d 0e 56 50
      //参见：61850-7-2：5.5.3.7.2，61850-7-2：5.5.3.7.3，61850-8-1：8.1.3.6。
      Calendar date=Calendar.getInstance();
      date.set(2000,3,1,6,55,47);
      date.set(Calendar.MILLISECOND, 232997);
      long millis=date.getTimeInMillis();
      long secends=millis/1000;
      millis=millis%1000;
      String utcTime=Long.toHexString(secends)+Long.toHexString(millis)+"0a";
      BerNode t=new OctetString(BytesUtil.fromHexString(utcTime));//new UTCTime(new Date());
      t.setTagClass(Tag.CONTEXT);
      t.setTagNumber(4);
      goose2.addElement(t);
      BerNode stNum=new ASN1Integer(10);
      stNum.setTagClass(Tag.CONTEXT);
      stNum.setTagNumber(5);
      goose2.addElement(stNum);
      BerNode sqNum=new ASN1Integer(3309572);
      sqNum.setTagClass(Tag.CONTEXT);
      sqNum.setTagNumber(6);
      goose2.addElement(sqNum);
      BerNode test=new ASN1Boolean(false);
      test.setTagClass(Tag.CONTEXT);
      test.setTagNumber(7);
      goose2.addElement(test);
      BerNode confRev=new ASN1Integer(0);
      confRev.setTagClass(Tag.CONTEXT);
      confRev.setTagNumber(8);
      goose2.addElement(confRev);
      BerNode ndsCom=new ASN1Boolean(false);
      ndsCom.setTagClass(Tag.CONTEXT);
      ndsCom.setTagNumber(9);
      goose2.addElement(ndsCom);
      BerNode numDatSetEntries=new ASN1Integer(32);
      numDatSetEntries.setTagClass(Tag.CONTEXT);
      numDatSetEntries.setTagNumber(10);
      goose2.addElement(numDatSetEntries);
      Sequence datasetChoice2 = new Sequence();//new Choice();
      datasetChoice2.setTagClass(Tag.CONTEXT);
      datasetChoice2.setTagNumber(11);
      for (int i = 0; i < 16; i++) {
          BerNode tmp=new ASN1Boolean(false);
          tmp.setTagClass(Tag.CONTEXT);
          tmp.setTagNumber(3);
          datasetChoice2.addElement(tmp);
          tmp=new BitString(new BitSet(0));
          tmp.setTagClass(Tag.CONTEXT);
          tmp.setTagNumber(4);
          datasetChoice2.addElement(tmp);
      }
//      SequenceOf dataset2=new SequenceOf(datasetChoice2);
//      dataset2.setTagClass(Tag.CONTEXT);
//      dataset2.setTagNumber(11);
      goose2.addElement(datasetChoice2);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        BerOutputStream out = new BerOutputStream(stream);
        goose2.writeElement(out);
        stream.close();

        String reverse = BytesUtil.toHexString(stream.toByteArray());
        System.out.println(reverse);
    }

}
