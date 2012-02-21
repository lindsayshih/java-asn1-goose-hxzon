package org.hxzon.ui.util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.util.BytesUtil;

public class UIUtil {

    public static void setupUILookAndFeel() {
//        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (Exception e) {
//        }
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
    }

    public static String testGoose1 = "01 0c cd 01 00 05 01 0c " + "cd 01 10 10 81 00 80 01 88 b8 00 05 00 e3 00 00 " + "00 00 61 81 d8 80 20 58 37 32 31 32 5f 32 4c 42 "
            + "31 5f 47 4f 50 52 4f 54 2f 4c 4c 4e 30 24 47 4f " + "24 67 6f 63 62 54 78 81 01 08 82 20 58 37 32 31 " + "32 5f 32 4c 42 31 5f 47 4f 50 52 4f 54 2f 4c 4c "
            + "4e 30 24 64 73 47 6f 6f 73 65 54 78 83 11 58 37 " + "32 31 32 5f 47 4f 4f 53 45 5f 54 58 5f 49 44 84 " + "08 00 00 00 00 00 00 00 00 85 01 04 86 01 00 87 "
            + "01 00 88 01 20 89 01 00 8a 01 20 ab 60 83 01 00 " + "84 01 00 83 01 00 84 01 00 83 01 00 84 01 00 83 " + "01 00 84 01 00 83 01 00 84 01 00 83 01 00 84 01 "
            + "00 83 01 00 84 01 00 83 01 00 84 01 00 83 01 00 " + "84 01 00 83 01 00 84 01 00 83 01 00 84 01 00 83 " + "01 00 84 01 00 83 01 00 84 01 00 83 01 00 84 01 "
            + "00 83 01 00 84 01 00 83 01 01 84 01 05 ";
    public static String testGoose2 = "01 0c cd 01 00 12 00 00 23 06 04 38 88 b8 00 12 " + "01 01 00 00 00 00 61 81 f6 80 22 52 45 43 36 37 " + "30 5f 42 5a 54 31 4c 44 30 2f 4c 4c 4e 30 24 47 "
            + "4f 24 47 53 45 43 6f 6e 74 72 6f 6c 31 81 02 15 " + "7c 82 1a 52 45 43 36 37 30 5f 42 5a 54 31 4c 44 " + "30 2f 4c 4c 4e 30 24 47 4f 4f 53 45 31 83 0f 52 "
            + "45 43 36 37 30 5f 42 5a 54 31 5f 54 58 31 84 08 " + "47 9f 84 40 56 c8 b5 0a 85 01 11 86 03 06 fe 6a " + "87 01 00 88 01 01 89 01 00 8a 01 20 ab 81 80 83 "
            + "01 00 84 03 03 00 00 83 01 00 84 03 03 00 00 83 " + "01 00 84 03 03 00 00 83 01 00 84 03 03 00 00 83 " + "01 00 84 03 03 00 00 83 01 00 84 03 03 00 00 83 "
            + "01 00 84 03 03 00 00 83 01 00 84 03 03 00 00 83 " + "01 00 84 03 03 00 00 83 01 00 84 03 03 00 00 83 " + "01 00 84 03 03 00 00 83 01 00 84 03 03 00 00 83 "
            + "01 00 84 03 03 00 00 83 01 00 84 03 03 00 00 83 " + "01 00 84 03 03 00 00 83 01 00 84 03 03 00 00 ";
    public static String testMms1 = "00 50 04 07 76 d6 00 0c 02 b0 89 3a 08 00 45 00"
            + "00 9a 3d 63 90 21 40 06 db 58 ac 1e 04 02 ac 1e"//test fragment offset(13bits)//51 10=4368//2030=8240//9021=4129
            + "05 64 00 66 05 6b 9c 41 29 05 dc 4f 5c b0 50 18" + "39 08 6d 60 00 00 03 00 00 72 02 f0 80 01 00 01"
            + "00 61 65 30 63 02 01 03 a0 5e a3 5c a0 5a a1 05"//begin 61 65
            + "80 03 52 50 54 a0 51 8a 19 46 37 31 34 4c 44 30" + "2f 4c 4c 4e 30 24 72 63 62 4d 65 61 73 46 6c 74" + "30 31 84 03 06 51 00 86 01 71 89 08 00 06 10 ae"
            + "00 00 00 00 84 09 04 00 00 00 00 00 00 14 00 87" + "05 08 40 be 66 66 91 08 47 c2 7c 6e 17 4f c3 0a" + "84 02 02 40 84 02 02 40                        ";
    public static String testMms2 = "00 50 04 07 76 d6 00 0c 02 b0 89 3a 08 00 45 00" + "00 9a 3d 63 90 21 40 06 db 58 ac 1e 04 02 ac 1e"//test fragment offset(13bits)//51 10=4368//2030=8240//9021=4129
            + "05 64 00 66 05 6b 9c 41 29 05 dc 4f 5c b0 50 18" + "39 08 6d 60 00 00 03 00 00 72 02 f0 80 01 00 01" + "00 " + "61 18 30 16 02 01 03 a0 11 a0 0f 02 02 01 5d"//mms begin a0 0f
            + "a1 09 a0 03 80 01 09 a1 02 80 00               ";
    public static String testMms3 = "00 01 7a 88 ff 0b 08 01 c6 78 00 2f 81 00 00 66" + "08 00 45 00 00 e9 c7 68 40 00 40 06 e4 bc c6 78 " + "00 15 c6 78 00 c8 00 66 08 08 92 4a ee 6a 7d ad "
            + "a8 56 80 18 20 00 2d 0b 00 00 01 01 08 0a 00 7e " + "44 80 00 02 3d bb 03 00 00 b5 02 f0 80 01 00 01 " + "00 61 81 a7 30 81 a4 02 01 03 a0 81 9e a3 81 9b "
            + "a0 81 98 a1 05 80 03 52 50 54 a0 81 8e 8a 0c 45 " + "31 51 31 52 65 6c 61 79 41 69 6e 84 03 06 3c 00 " + "8c 06 00 dc b6 94 26 1b 8a 1d 50 4c 31 30 30 37 "
            + "50 43 53 39 36 31 31 2f 4c 4c 4e 30 24 64 73 52 " + "65 6c 61 79 41 69 6e 84 03 02 80 00 8a 24 50 4c " + "31 30 30 37 50 43 53 39 36 31 31 2f 52 65 6c 79 "
            + "4d 4d 58 55 32 24 4d 58 24 50 50 56 24 70 68 73 " + "41 42 a2 23 a2 12 a2 07 87 05 08 42 cb 4f c8 a2 " + "07 87 05 08 00 00 00 00 84 03 03 00 00 91 08 4c "
            + "91 96 80 99 99 90 0a 84 02 02 40 ";
    public static String testMms4 = "00 10 18 97 87 03 08 01 c6 78 00 29 08 00 45 00 " + "00 48 7d a0 40 00 40 06 2f 41 c6 78 00 29 c6 78 " + "00 b5 00 66 d0 ed cf d3 79 f5 7c 69 32 11 50 18 "
            + "40 00 05 48 00 00 03 00 00 20 02 f0 80 01 00 01 " + "00 61 13 30 11 02 01 03 a0 0c a1 0a 02 03 66 0b " + "b9 a5 03 80 01 0a ";
    public static String testMms5 = "00 10 18 97 87 03 08 01 c6 78 01 39 08 00 45 00 " + "00 4a 42 9e 40 00 40 06 69 31 c6 78 01 39 c6 78 " + "00 b5 00 66 d0 bc a6 90 29 87 58 6a dd 97 50 18 "
            + "20 00 97 ee 00 00 03 00 00 22 02 f0 80 01 00 01 " + "00 61 15 30 13 02 01 03 a0 0e a2 0c 80 03 66 0b " + "af a2 05 a0 03 87 01 02 ";
    public static String testMms6 = "18 a9 05 6e f2 a8 08 01 c6 78 00 25 08 00 45 00 " + "01 1d 68 f6 40 00 40 06 43 1a c6 78 00 25 c6 78 " + "00 b5 00 66 aa 00 00 8a 4b e2 13 de c1 1d 50 18 "
            + "40 00 9b de 00 00 03 00 00 f5 02 f0 80 01 00 01 " + "00 61 81 e7 30 81 e4 02 01 03 a0 81 de a3 81 db " + "a0 81 d8 a1 05 80 03 52 50 54 a0 81 ce 8a 07 75 "
            + "72 63 62 41 69 6e 84 03 06 38 00 8c 06 00 e6 23 " + "04 26 1b 8a 13 43 47 31 31 30 31 43 31 2f 4c 4c " + "4e 30 24 64 73 41 69 6e 84 07 07 57 d5 f0 00 00 "
            + "00 87 05 08 42 84 5c 29 87 05 08 42 84 5c 29 87 " + "05 08 40 9f ae 14 87 05 08 40 9f ae 14 87 05 08 " + "41 b0 28 f6 87 05 08 41 b0 28 f6 87 05 08 42 7e "
            + "5c 29 87 05 08 40 65 1e b8 87 05 08 40 65 1e b8 " + "87 05 08 40 65 1e b8 87 05 08 40 65 1e b8 87 05 " + "08 40 09 99 99 87 05 08 40 09 99 99 87 05 08 40 "
            + "e5 70 a4 84 02 02 40 84 02 02 40 84 02 02 40 84 " + "02 02 40 84 02 02 40 84 02 02 40 84 02 02 40 84 " + "02 02 40 84 02 02 40 84 02 02 40 84 02 02 40 84 "
            + "02 02 40 84 02 02 40 84 02 02 40";
    public static String testMms7 = "00 10 18 97 4a a2 08 01 c6 78 00 20 08 00 45 00 " + "00 52 05 33 40 00 40 06 a7 ac c6 78 00 20 c6 78 " + "00 b6 00 66 c4 02 88 e1 f3 2a 8e 82 21 3a 50 18 "
            + "40 00 00 4d 00 00 03 00 00 2a 02 f0 80 01 00 01 " + "00 61 1d 30 1b 02 01 03 a0 16 a1 14 02 03 18 3b " + "5b a6 0d 80 01 00 a2 08 a7 06 02 01 20 02 01 08";
    public static String testSmv91 = "01 0c cd 04 01 03 08 ac 7d 01 26 64 81 00 80 00 " + "88 ba 40 00 00 c5 00 00 00 00 80 81 ba 00 04 00 " + "2c 02 01 00 03 01 f4 01 f4 16 8e 0f a0 00 00 00 "
            + "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " + "00 00 00 00 00 0f f0 40 1f 0e bf 64 00 00 2c 02 " + "01 00 03 01 f4 01 f4 16 8e 0f a0 00 00 00 00 00 "
            + "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " + "00 00 00 0f f0 40 1f 0e c0 64 00 00 2c 02 01 00 " + "03 01 f4 01 f4 16 8e 0f a0 00 00 00 00 00 00 00 "
            + "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " + "00 0f f0 40 1f 0e c1 64 00 00 2c 02 01 00 03 01 " + "f4 01 f4 16 8e 0f a0 00 00 00 00 00 00 00 00 00 "
            + "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 0f " + "f0 40 1f 0e c2 64 00   ";
    public static String testSmv92 = "01 0c cd 04 00 01 00 1c 23 3d 00 7a 81 00 80 0a" + "88 ba 40 00 02 89 00 00 00 00 " + "60 82 02 7d 80 01" + "05 a2 82 02 76 30 7c 80 0b 64 6f 6e 67 66 61 6e"
            + "67 73 6d 76 82 02 08 20 83 04 00 00 00 01 85 01" + "00 87 60 00 00 00 00 00 00 00 00 00 00 03 53 00" + "00 00 00 ff ff fc ad 00 00 00 00 00 00 00 00 00"
            + "00 00 00 00 00 00 00 00 00 00 00 00 00 03 53 00" + "00 00 00 ff ff fc ad 00 00 00 00 00 00 00 00 00" + "00 00 00 00 00 37 a1 00 00 00 00 ff ff c8 5f 00"
            + "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00" + "00 00 00 30 7c 80 0b 64 6f 6e 67 66 61 6e 67 73" + "6d 76 82 02 08 21 83 04 00 00 00 01 85 01 00 87"
            + "60 00 00 00 4d 00 00 00 00 00 00 03 29 00 00 00" + "00 ff ff fc 8a 00 00 00 00 00 00 00 4d 00 00 00" + "00 00 00 00 4d 00 00 00 00 00 00 03 29 00 00 00"
            + "00 ff ff fc 8a 00 00 00 00 00 00 05 0a 00 00 00" + "00 00 00 34 f0 00 00 00 00 ff ff c6 06 00 00 00" + "00 00 00 05 0a 00 00 00 00 00 00 05 0a 00 00 00"
            + "00 30 7c 80 0b 64 6f 6e 67 66 61 6e 67 73 6d 76" + "82 02 08 22 83 04 00 00 00 01 85 01 00 87 60 00" + "00 00 9a 00 00 00 00 00 00 02 fb 00 00 00 00 ff"
            + "ff fc 6b 00 00 00 00 00 00 00 9a 00 00 00 00 00" + "00 00 9a 00 00 00 00 00 00 02 fb 00 00 00 00 ff" + "ff fc 6b 00 00 00 00 00 00 0a 0c 00 00 00 00 00"
            + "00 31 ec 00 00 00 00 ff ff c4 08 00 00 00 00 00" + "00 0a 0c 00 00 00 00 00 00 0a 0c 00 00 00 00 30" + "7c 80 0b 64 6f 6e 67 66 61 6e 67 73 6d 76 82 02"
            + "08 23 83 04 00 00 00 01 85 01 00 87 60 00 00 00" + "e5 00 00 00 00 00 00 02 c8 00 00 00 00 ff ff fc" + "52 00 00 00 00 00 00 00 e5 00 00 00 00 00 00 00"
            + "e5 00 00 00 00 00 00 02 c8 00 00 00 00 ff ff fc" + "52 00 00 00 00 00 00 0e ff 00 00 00 00 00 00 2e" + "98 00 00 00 00 ff ff c2 69 00 00 00 00 00 00 0e"
            + "ff 00 00 00 00 00 00 0e ff 00 00 00 00 30 7c 80" + "0b 64 6f 6e 67 66 61 6e 67 73 6d 76 82 02 08 24" + "83 04 00 00 00 01 85 01 00 87 60 00 00 01 2f 00"
            + "00 00 00 00 00 02 91 00 00 00 00 ff ff fc 3f 00" + "00 00 00 00 00 01 2f 00 00 00 00 00 00 01 2f 00" + "00 00 00 00 00 02 91 00 00 00 00 ff ff fc 3f 00"
            + "00 00 00 00 00 13 da 00 00 00 00 00 00 2a fb 00" + "00 00 00 ff ff c1 2b 00 00 00 00 00 00 13 da 00" + "00 00 00 00 00 13 da 00 00 00 00               ";
    public static String testSmv92_2 = "01 0c cd 04 01 81 00 30 00 01 e2 01 81 00 80 79 " + "88 ba 40 11 00 ad 00 00 00 00 60 81 a2 80 01 01 " + "a2 81 9c 30 81 99 80 1a 4d 54 31 31 30 31 42 47 "
            + "4f 4c 44 2f 4c 4c 4e 30 24 47 4f 24 73 6d 76 63 " + "62 30 82 02 08 54 83 04 00 00 00 01 84 08 00 00 " + "00 00 00 00 00 00 85 01 00 86 02 64 00 87 60 00 "
            + "00 00 5f 00 00 00 00 00 00 00 4e 00 00 00 00 00 " + "00 00 5f 00 00 00 00 00 00 00 52 00 00 00 00 00 " + "00 00 05 00 00 00 00 00 00 00 04 00 00 00 00 00 "
            + "00 00 05 00 00 00 00 00 00 00 0a 00 00 00 00 00 " + "00 00 08 00 00 00 00 00 00 00 0b 00 00 00 00 00 " + "00 00 0b 00 00 00 00 00 00 00 0c 00 00 00 00";
    public static String testError1 = "00 50 04 07 76 d6 00 0c 02 b0 85 1c 08 00 45 00 " + "00 28 ae cf 00 00 40 06 6b 59 ac 1e 03 07 ac 1e " + "05 64 00 66 05 4a 52 4d f8 2c 53 2d 34 9a 50 10 "
            + "39 08 3e 33 00 00 03 00 00 72 02 f0 ";
    public static String testError2 = "00 00 00 00 00 00 00 00";
    public static String testError3 = "00 10 18 97 87 03 c0 00 c6 78 00 40 08 00 45 00 " + "00 57 2f af 40 00 40 06 7d 0c c6 78 00 40 c6 78 " + "00 b5 00 66 d0 e1 93 ca 96 db 2e 49 b2 61 50 18 "
            + "2e 10 8b e2 00 00 03 00 00 2f 02 f0 80 11 00 00 " + "00 00 00 00 00 cc 00 60 00 00 00 00 00 00 00 00 " + "00 10 00 00 00 c0 03 00 00 00 00 00 00 00 00 00 " + "00 00 00 00 00 ";
    public static String testIp4_1 = "01 00 5e 01 00 03 18 a9 05 6e f2 a9 08 00 45 00 " + "05 dc 78 66 20 00 01 11 74 78 c6 79 00 b5 e0 01 " + "00 03 23 31 23 30 06 18 de be 77 63 6b 00 00 00 "
            + "00 00 73 63 61 64 61 31 00 00 64 62 73 5f 33 37 " + "5f 31 31 00 00 00 00 00 00 00 61 6c 6c 00 00 00 " + "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 "
            + "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " + "00 00 00 00 00 00 00 00 00 00 48 00 01 00 01 00 " + "00 00 98 05 00 00 11 00 00 00 01 03 00 00 18 14 "
            + "10 08 94 83 95 4c 00 00 00 00 00 00 00 00 1b 1d " + "21 00 98 05 00 00 5e ce 92 4c 06 00 09 00 03 00 " + "80 02 73 63 61 64 61 31 00 00 00 00 00 00 00 00 "
            + "00 00 3b 14 00 00 10 e6 90 4c 05 00 00 00 7d bf " + "c9 49 04 00 00 00 61 ce 92 4c 3b 14 00 00 10 e6 " + "90 4c 05 00 00 00 7d bf c9 49 04 00 00 00 61 ce "
            + "92 4c 01 00 00 00 00 00 00 00 00 00 00 00 00 00 " + "00 00 00 00 00 00 00 00 00 00 00 00 00 00 02 00 " + "00 00 db 13 00 00 10 e6 90 4c 05 00 00 00 7d bf "
            + "c9 49 04 00 00 00 61 ce 92 4c 03 00 00 00 5d 00 " + "00 00 1b 8d 6e 49 00 00 00 00 00 00 00 00 00 00 " + "00 00 00 00 00 00 01 00 00 00 00 00 00 00 00 00 "
            + "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " + "00 00 02 00 00 00 db 13 00 00 10 e6 90 4c 05 00 " + "00 00 7d bf c9 49 04 00 00 00 61 ce 92 4c 03 00 "
            + "00 00 5d 00 00 00 1b 8d 6e 49 00 00 00 00 00 00 " + "00 00 00 00 00 00 00 00 00 00 a0 04 00 00 09 00 " + "1b 00 5b 00 00 00 01 00 00 00 00 00 00 00 00 00 "
            + "00 00 00 00 00 00 01 00 00 00 02 00 00 00 03 00 " + "00 00 04 00 00 00 05 00 00 00 06 00 00 00 07 00 " + "00 00 08 00 00 00 09 00 00 00 0a 00 00 00 0b 00 "
            + "00 00 0c 00 00 00 0d 00 00 00 0e 00 00 00 0f 00 " + "00 00 10 00 00 00 11 00 00 00 12 00 00 00 13 00 " + "00 00 14 00 00 00 15 00 00 00 16 00 00 00 17 00 "
            + "00 00 18 00 00 00 19 00 00 00 1a 00 00 00 1b 00 " + "00 00 1c 00 00 00 1d 00 00 00 1e 00 00 00 1f 00 " + "00 00 20 00 00 00 21 00 00 00 22 00 00 00 23 00 "
            + "00 00 24 00 00 00 25 00 00 00 26 00 00 00 27 00 " + "00 00 28 00 00 00 29 00 00 00 2a 00 00 00 2b 00 " + "00 00 2c 00 00 00 2d 00 00 00 2e 00 00 00 2f 00 "
            + "00 00 30 00 00 00 31 00 00 00 32 00 00 00 33 00 " + "00 00 34 00 00 00 35 00 00 00 36 00 00 00 37 00 " + "00 00 38 00 00 00 39 00 00 00 3a 00 00 00 3b 00 "
            + "00 00 3c 00 00 00 3d 00 00 00 3e 00 00 00 3f 00 " + "00 00 40 00 00 00 41 00 00 00 42 00 00 00 43 00 " + "00 00 44 00 00 00 45 00 00 00 46 00 00 00 47 00 "
            + "00 00 48 00 00 00 49 00 00 00 4a 00 00 00 4b 00 " + "00 00 4c 00 00 00 4d 00 00 00 4e 00 00 00 4f 00 " + "00 00 50 00 00 00 51 00 00 00 52 00 00 00 53 00 "
            + "00 00 54 00 00 00 55 00 00 00 56 00 00 00 57 00 " + "00 00 58 00 00 00 59 00 00 00 5a 00 00 00 00 00 " + "00 00 01 00 af 00 e0 02 00 00 00 00 00 00 05 00 "
            + "01 00 01 00 96 00 00 00 05 00 09 00 00 00 01 00 " + "00 00 00 00 00 00 f8 51 b1 fe 00 00 00 00 00 00 " + "00 00 d8 15 10 08 01 00 00 00 14 fc 09 28 2b 01 "
            + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 "
            + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 "
            + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 "
            + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 "
            + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 "
            + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 "
            + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 "
            + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 "
            + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 "
            + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 "
            + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 "
            + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 "
            + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 "
            + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 ";
    public static String testIp4_2 = "01 00 5e 01 00 03 18 a9 05 6e f2 a9 08 00 45 00 " + "00 64 78 66 00 b9 01 11 99 37 c6 79 00 b5 e0 01 " + "00 03 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 "
            + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 "
            + "00 00 14 fc 09 28 2b 01 00 00 14 fc 09 28 2b 01 " + "00 00 ";
    public static List<Packet> examplePackets = new ArrayList<Packet>();
    static {
        examplePackets.add(new Packet(BytesUtil.fromHexString(testGoose1)));
        examplePackets.add(new Packet(BytesUtil.fromHexString(testGoose2)));
        examplePackets.add(new Packet(BytesUtil.fromHexString(testMms1)));
        examplePackets.add(new Packet(BytesUtil.fromHexString(testMms2)));
        examplePackets.add(new Packet(BytesUtil.fromHexString(testMms3)));
        examplePackets.add(new Packet(BytesUtil.fromHexString(testMms4)));
        examplePackets.add(new Packet(BytesUtil.fromHexString(testMms5)));
        examplePackets.add(new Packet(BytesUtil.fromHexString(testMms6)));
        examplePackets.add(new Packet(BytesUtil.fromHexString(testMms7)));
        examplePackets.add(new Packet(BytesUtil.fromHexString(testSmv91)));
        examplePackets.add(new Packet(BytesUtil.fromHexString(testSmv92)));
        examplePackets.add(new Packet(BytesUtil.fromHexString(testSmv92_2)));
        examplePackets.add(new Packet(BytesUtil.fromHexString(testError1)));
        examplePackets.add(new Packet(BytesUtil.fromHexString(testError2)));
        examplePackets.add(new Packet(BytesUtil.fromHexString(testError3)));
        examplePackets.add(new Packet(BytesUtil.fromHexString(testIp4_1)));
        examplePackets.add(new Packet(BytesUtil.fromHexString(testIp4_2)));
    }
}