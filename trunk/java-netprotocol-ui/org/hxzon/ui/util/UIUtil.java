package org.hxzon.ui.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import org.apache.commons.io.FileUtils;
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

    public static List<Packet> examplePackets = new ArrayList<Packet>();
    public static String basePath;
    static {
        basePath = UIUtil.class.getResource("").toString().substring(5);
        examplePackets.add(new Packet(readExample("goose.1.hex.txt")));
        examplePackets.add(new Packet(readExample("goose.2.hex.txt")));
        examplePackets.add(new Packet(readExample("mms.1.hex.txt")));
        examplePackets.add(new Packet(readExample("mms.2.hex.txt")));
        examplePackets.add(new Packet(readExample("mms.3.hex.txt")));
        examplePackets.add(new Packet(readExample("mms.4.hex.txt")));
        examplePackets.add(new Packet(readExample("mms.5.hex.txt")));
        examplePackets.add(new Packet(readExample("mms.6.hex.txt")));
        examplePackets.add(new Packet(readExample("mms.7.hex.txt")));
        examplePackets.add(new Packet(readExample("mms.8.hex.txt")));
        examplePackets.add(new Packet(readExample("sv91.1.hex.txt")));
        examplePackets.add(new Packet(readExample("sv92.1.hex.txt")));
        examplePackets.add(new Packet(readExample("sv92.2.hex.txt")));
        examplePackets.add(new Packet(BytesUtil.fromHexString("00 00 00 00 00 00 00 00 ")));
        examplePackets.add(new Packet(readExample("cotp.1.miss.hex.txt")));
        examplePackets.add(new Packet(readExample("cotp.2.unknown.hex.txt")));
        examplePackets.add(new Packet(readExample("ip4.1.piece.1.hex.txt")));
        examplePackets.add(new Packet(readExample("ip4.1.piece.2.hex.txt")));
        examplePackets.add(new Packet(readExample("ip4.2.piece.1.hex.txt")));
        examplePackets.add(new Packet(readExample("ip4.2.piece.2.hex.txt")));
        examplePackets.add(new Packet(readExample("ip4.3.piece.1.hex.txt")));
        examplePackets.add(new Packet(readExample("ip4.3.piece.2.hex.txt")));
        examplePackets.add(new Packet(readExample("cotp.3.piece.1.hex.txt")));
        examplePackets.add(new Packet(readExample("cotp.3.piece.2.hex.txt")));
        examplePackets.add(new Packet(readExample("cotp.3.piece.3.hex.txt")));
        examplePackets.add(new Packet(readExample("arp.1.hex.txt")));
        examplePackets.add(new Packet(readExample("arp.2.hex.txt")));
        //
        examplePackets.add(new Packet(readExample("ptpV1.1.sync.hex.txt")));
        examplePackets.add(new Packet(readExample("ptpV1.2.delayReq.hex.txt")));
        examplePackets.add(new Packet(readExample("ptpV1.3.followUp.hex.txt")));
        examplePackets.add(new Packet(readExample("ptpV1.4.delayResp.hex.txt")));
        //
        examplePackets.add(new Packet(readExample("ptpV2.1.sync.hex.txt")));
        examplePackets.add(new Packet(readExample("ptpV2.10.sync.udp.hex.txt")));
        examplePackets.add(new Packet(readExample("ptpV2.11.followUp.hex.txt")));
        examplePackets.add(new Packet(readExample("ptpV2.4.followUp.udp.hex.txt")));
        examplePackets.add(new Packet(readExample("ptpV2.2.delayReq.udp.hex.txt")));
        examplePackets.add(new Packet(readExample("ptpV2.8.delayResp.hex.txt")));
        examplePackets.add(new Packet(readExample("ptpV2.3.pdelayReq.hex.txt")));
        examplePackets.add(new Packet(readExample("ptpV2.9.pdelayReq.udp.hex.txt")));
        examplePackets.add(new Packet(readExample("ptpV2.5.announce.hex.txt")));
        examplePackets.add(new Packet(readExample("ptpV2.7.announce.udp.hex.txt")));
        examplePackets.add(new Packet(readExample("ptpV2.6.pdelayReq.udp.hex.txt")));
    }

    public static byte[] readExample(String filename) {
        try {
            String hexStr = FileUtils.readFileToString(new File(basePath + filename));
            return BytesUtil.fromHexString(hexStr);
        } catch (IOException e) {
        }
        return new byte[0];
    }
}
