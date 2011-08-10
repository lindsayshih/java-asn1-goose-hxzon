package test.hxzon.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.MmsPduParser;
import org.hxzon.util.BytesUtil;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;

public class TestMmsDecoder {

    //mms gooseandmms.pkt-45
//	0000   00 50 04 07 76 d6 00 0c 02 b0 89 3a 08 00 45 00  .P..v......:..E.
//	0010   00 9a 3d 63 00 00 40 06 db 58 ac 1e 04 02 ac 1e  ..=c..@..X......
//	0020   05 64 00 66 05 6b 9c 41 29 05 dc 4f 5c b0 50 18  .d.f.k.A)..O\.P.
//	0030   39 08 6d 60 00 00 03 00 00 72 02 f0 80 01 00 01  9.m`.....r......
//	0040   00 61 65 30 63 02 01 03 a0 5e a3 5c a0 5a a1 05  .ae0c....^.\.Z..
//	0050   80 03 52 50 54 a0 51 8a 19 46 37 31 34 4c 44 30  ..RPT.Q..F714LD0
//	0060   2f 4c 4c 4e 30 24 72 63 62 4d 65 61 73 46 6c 74  /LLN0$rcbMeasFlt
//	0070   30 31 84 03 06 51 00 86 01 71 89 08 00 06 10 ae  01...Q...q......
//	0080   00 00 00 00 84 09 04 00 00 00 00 00 00 14 00 87  ................
//	0090   05 08 40 be 66 66 91 08 47 c2 7c 6e 17 4f c3 0a  ..@.ff..G.|n.O..
//	00a0   84 02 02 40 84 02 02 40                          ...@...@

public static String mms1="a3 5c a0 5a a1 05"//a0 5e 
+"80 03 52 50 54 a0 51 8a 19 46 37 31 34 4c 44 30"
+"2f 4c 4c 4e 30 24 72 63 62 4d 65 61 73 46 6c 74"
+"30 31 84 03 06 51 00 86 01 71 89 08 00 06 10 ae"
+"00 00 00 00 84 09 04 00 00 00 00 00 00 14 00 87"
+"05 08 40 be 66 66 91 08 47 c2 7c 6e 17 4f c3 0a"
+"84 02 02 40 84 02 02 40                        ";

//unconfirmed 3
//informationReport{
//  VariableList RPT
//  AccessResults{
//vstring:F714LD0/LLN0$rcbMeasFlt01
//	bitstring:
//	unsinged:113
//    OSTRING: 00 06 10 ae 00 00 00 00 
//	bitstring:
//    FLOAT:  5.950000 
//    UTC 2008-02-25 08:29.34.091061  Timequality: 0a
//    BITS 0000 - 0015: 0 1 0 0 0 0 
//    BITS 0000 - 0015: 0 1 0 0 0 0 

//-------------------------------------------
//mms mmslibpcap.pkt-18
//0000   08 ac 7d ff ff ff 00 22 19 17 84 e8 08 00 45 00  ..}...."......E.
//0010   00 4d a4 65 40 00 80 06 c4 e3 64 64 64 01 64 64  .M.e@.....ddd.dd
//0020   64 98 05 a0 00 66 2b 2b 7f 0b 32 ca 07 9f 50 18  d....f++..2...P.
//0030   ff 99 91 a1 00 00 03 00 00 25 02 f0 80 01 00 01  .........%......
//0040   00 61 18 30 16 02 01 03 a0 11 a0 0f 02 02 01 5d  .a.0...........]
//0050   a1 09 a0 03 80 01 09 a1 02 80 00                 ...........
public static String mms2="a0 0f 02 02 01 5d"
+"a1 09 a0 03 80 01 09 a1 02 80 00               ";
//Conf Request (0)
//GetNameList (1)
//InvokeID: InvokeID:  349
//GetNameList{
//extendedObjectClass:{    OBJECT Class: Domain (9) 9}
//objectScope:{    VmdSpecific}
//}

    public static void main(String[] args) throws IOException {
        byte[] data=BytesUtil.fromHexString(mms1);
        String reverse=BytesUtil.toHexString(data);
        System.out.println(reverse);
        ByteArrayInputStream inStream = new ByteArrayInputStream(data);
        BerInputStream in = new BerInputStream(inStream);
        
        MmsPduParser parser=new MmsPduParser();
        BerNode node;
        while (null != (node = parser.readPacket(in))) {
            System.out.println(Asn1Utils.printBerNode(node));
        }
    }

}
