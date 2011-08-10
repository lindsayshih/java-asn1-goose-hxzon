package test.hxzon.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.goose.GoosePduParser;
import org.hxzon.util.BytesUtil;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;

public class TestGooseDecoder {

	//goose
//    0000   01 0c cd 01 00 01 08 00 c0 a8 01 16 88 b8 00 03  ................
//    0010   01 56 00 00 00 00 61 82 01 4a 80 1e 62 61 79 4a  .V....a..J..bayJ
//    0020   46 5a 36 30 30 52 50 49 54 2f 4c 4c 4e 30 24 47  FZ600RPIT/LLN0$G
//    0030   4f 24 50 75 62 5f 53 65 6c 66 81 02 27 10 82 19  O$Pub_Self..'...
//    0040   62 61 79 4a 46 5a 36 30 30 52 50 49 54 2f 4c 4c  bayJFZ600RPIT/LL
//    0050   4e 30 24 64 73 53 65 6c 66 83 15 52 50 49 54 2f  N0$dsSelf..RPIT/
//    0060   4c 4c 4e 30 24 47 4f 24 50 75 62 5f 53 65 6c 66  LLN0$GO$Pub_Self
//    0070   84 08 49 e4 6e a6 00 00 68 6a 85 01 01 86 01 7e  ..I.n...hj.....~
//    0080   87 01 00 88 01 01 89 01 00 8a 01 47 ab 81 d5 83  ...........G....
//    0090   01 00 83 01 00 83 01 00 83 01 00 83 01 00 83 01  ................
//    00a0   00 83 01 00 83 01 00 83 01 00 83 01 00 83 01 00  ................
//    00b0   83 01 00 83 01 00 83 01 00 83 01 00 83 01 00 83  ................
//    00c0   01 00 83 01 00 83 01 00 83 01 00 83 01 00 83 01  ................
//    00d0   00 83 01 00 83 01 00 83 01 00 83 01 00 83 01 00  ................
//    00e0   83 01 00 83 01 00 83 01 00 83 01 00 83 01 00 83  ................
//    00f0   01 00 83 01 00 83 01 00 83 01 00 83 01 00 83 01  ................
//    0100   00 83 01 00 83 01 00 83 01 00 83 01 00 83 01 00  ................
//    0110   83 01 00 83 01 00 83 01 00 83 01 00 83 01 00 83  ................
//    0120   01 00 83 01 00 83 01 00 83 01 00 83 01 00 83 01  ................
//    0130   00 83 01 00 83 01 00 83 01 00 83 01 00 83 01 00  ................
//    0140   83 01 00 83 01 00 83 01 00 83 01 00 83 01 00 83  ................
//    0150   01 00 83 01 00 83 01 00 83 01 00 83 01 00 83 01  ................
//    0160   00 83 01 00                                      ....

	public static String goose1 = "80 1e 62 61 79 4a" + "46 5a 36 30 30 52 50 49 54 2f 4c 4c 4e 30 24 47" + "4f 24 50 75 62 5f 53 65 6c 66 81 02 27 10 82 19"
			+ "62 61 79 4a 46 5a 36 30 30 52 50 49 54 2f 4c 4c" + "4e 30 24 64 73 53 65 6c 66 83 15 52 50 49 54 2f" + "4c 4c 4e 30 24 47 4f 24 50 75 62 5f 53 65 6c 66"
			+ "84 08 49 e4 6e a6 00 00 68 6a 85 01 01 86 01 7e" + "87 01 00 88 01 01 89 01 00 8a 01 47 ab 81 d5 83" + "01 00 83 01 00 83 01 00 83 01 00 83 01 00 83 01"
			+ "00 83 01 00 83 01 00 83 01 00 83 01 00 83 01 00" + "83 01 00 83 01 00 83 01 00 83 01 00 83 01 00 83" + "01 00 83 01 00 83 01 00 83 01 00 83 01 00 83 01"
			+ "00 83 01 00 83 01 00 83 01 00 83 01 00 83 01 00" + "83 01 00 83 01 00 83 01 00 83 01 00 83 01 00 83" + "01 00 83 01 00 83 01 00 83 01 00 83 01 00 83 01"
			+ "00 83 01 00 83 01 00 83 01 00 83 01 00 83 01 00" + "83 01 00 83 01 00 83 01 00 83 01 00 83 01 00 83" + "01 00 83 01 00 83 01 00 83 01 00 83 01 00 83 01"
			+ "00 83 01 00 83 01 00 83 01 00 83 01 00 83 01 00" + "83 01 00 83 01 00 83 01 00 83 01 00 83 01 00 83" + "01 00 83 01 00 83 01 00 83 01 00 83 01 00 83 01"
			+ "00 83 01 00                                    ";
//  Control Block Reference*:   bayJFZ600RPIT/LLN0$GO$Pub_Self
//  Time Allowed to Live (msec):  10000
//  DataSetReference*:   bayJFZ600RPIT/LLN0$dsSelf
//  GOOSEID*:   RPIT/LLN0$GO$Pub_Self
//  Event Timestamp:  2009-04-14 11:08.22.000006  Timequality: 6a
//  StateNumber*:    1
//  SequenceNumber*:   Sequence Number:  126
//  Test*:    FALSE
//  Config Revision*:    1
//  Needs Commissioning*:    FALSE
//  Number Dataset Entries:  71
//-----------------------------------
//goose gooseandmms.pkt-506
//0000  01 0c cd 01 00 12 00 00  23 06 04 38 88 b8 00 12   ........ #..8....
//0010  01 01 00 00 00 00 61 81  f6 80 22 52 45 43 36 37   ......a. .."REC67
//0020  30 5f 42 5a 54 31 4c 44  30 2f 4c 4c 4e 30 24 47   0_BZT1LD 0/LLN0$G
//0030  4f 24 47 53 45 43 6f 6e  74 72 6f 6c 31 81 02 15   O$GSECon trol1...
//0040  7c 82 1a 52 45 43 36 37  30 5f 42 5a 54 31 4c 44   |..REC67 0_BZT1LD
//0050  30 2f 4c 4c 4e 30 24 47  4f 4f 53 45 31 83 0f 52   0/LLN0$G OOSE1..R
//0060  45 43 36 37 30 5f 42 5a  54 31 5f 54 58 31 84 08   EC670_BZ T1_TX1..
//0070  47 9f 84 40 56 c8 b5 0a  85 01 11 86 03 06 fe 6a   G..@V... .......j
//0080  87 01 00 88 01 01 89 01  00 8a 01 20 ab 81 80 83   ........ ... ....
//0090  01 00 84 03 03 00 00 83  01 00 84 03 03 00 00 83   ........ ........
//00a0  01 00 84 03 03 00 00 83  01 00 84 03 03 00 00 83   ........ ........
//00b0  01 00 84 03 03 00 00 83  01 00 84 03 03 00 00 83   ........ ........
//00c0  01 00 84 03 03 00 00 83  01 00 84 03 03 00 00 83   ........ ........
//00d0  01 00 84 03 03 00 00 83  01 00 84 03 03 00 00 83   ........ ........
//00e0  01 00 84 03 03 00 00 83  01 00 84 03 03 00 00 83   ........ ........
//00f0  01 00 84 03 03 00 00 83  01 00 84 03 03 00 00 83   ........ ........
//0100  01 00 84 03 03 00 00 83  01 00 84 03 03 00 00      ........ .......

	public static String goose2 = "61 81  f6 80 22 52 45 43 36 37" + "30 5f 42 5a 54 31 4c 44  30 2f 4c 4c 4e 30 24 47" + "4f 24 47 53 45 43 6f 6e  74 72 6f 6c 31 81 02 15"
			+ "7c 82 1a 52 45 43 36 37  30 5f 42 5a 54 31 4c 44" + "30 2f 4c 4c 4e 30 24 47  4f 4f 53 45 31 83 0f 52" + "45 43 36 37 30 5f 42 5a  54 31 5f 54 58 31 84 08"
			+ "47 9f 84 40 56 c8 b5 0a  85 01 11 86 03 06 fe 6a" + "87 01 00 88 01 01 89 01  00 8a 01 20 ab 81 80 83" + "01 00 84 03 03 00 00 83  01 00 84 03 03 00 00 83"
			+ "01 00 84 03 03 00 00 83  01 00 84 03 03 00 00 83" + "01 00 84 03 03 00 00 83  01 00 84 03 03 00 00 83" + "01 00 84 03 03 00 00 83  01 00 84 03 03 00 00 83"
			+ "01 00 84 03 03 00 00 83  01 00 84 03 03 00 00 83" + "01 00 84 03 03 00 00 83  01 00 84 03 03 00 00 83" + "01 00 84 03 03 00 00 83  01 00 84 03 03 00 00 83"
			+ "01 00 84 03 03 00 00 83  01 00 84 03 03 00 00   ";

//t: Jan 29, 2008 19:53:36.339000046 UTC or   Event Timestamp:  2008-01-29 19:53.36.339000  Timequality: 0a
//------------------------------
	public static void main(String[] args) throws IOException {
		byte[] data = BytesUtil.fromHexString(goose2);
//        String reverse=BytesUtil.toHexString(data);
//        System.out.println(reverse);
		ByteArrayInputStream inStream = new ByteArrayInputStream(data);
		BerInputStream in = new BerInputStream(inStream);

		GoosePduParser parser = GoosePduParser.parser;
		BerNode node;
		while (null != (node = parser.readPacket(in))) {
			System.out.println(node.toString());
		}
	}

}
