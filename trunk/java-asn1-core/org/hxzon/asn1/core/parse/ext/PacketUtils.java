package org.hxzon.asn1.core.parse.ext;

import org.hxzon.netprotocol.packet.Ip4Packet;
import org.hxzon.netprotocol.packet.TcpPacket;
import org.hxzon.netprotocol.packet.TpktPacket;
import org.hxzon.netprotocol.packet.UdpPacket;
import org.hxzon.netprotocol.packet.VlanPacket;
import org.hxzon.netprotocol.ui.parse.DisplayFrame;
import org.hxzon.util.BytesUtil;

public class PacketUtils {
    public static String ethernetType(byte[] data) {
        String ethernetType = BytesUtil.toHexString(data, 12, 2);
        if (VlanPacket.EthernetType_Vlan.equalsIgnoreCase(ethernetType)) {
            ethernetType = BytesUtil.toHexString(data, 16, 2);
        }
        return ethernetType;
    }

    public static int ethernetHeaderLen(byte[] data) {
        String ethernetType = BytesUtil.toHexString(data, 12, 2);
        if (VlanPacket.EthernetType_Vlan.equalsIgnoreCase(ethernetType)) {
            return 14 + 4;
        }
        return 14;
    }

    public static boolean isIp4Packet(byte[] data) {
        return Ip4Packet.EthernetType_Ip4.equalsIgnoreCase(ethernetType(data));
    }

    public static String ipType(byte[] data) {
        String ipType = BytesUtil.toHexString(data, ethernetHeaderLen(data) + 10, 2);
        return ipType;
    }

    public static int ipHeaderIndex(byte[] data) {
        return ethernetHeaderLen(data);
    }

    public static int ipHeaderLen(byte[] data) {
        return 4 * BytesUtil.toInt(data, ipHeaderIndex(data), 1, 4, 4);
    }

    public static boolean isTcpPacket(byte[] data) {
        return TcpPacket.IpType_Tcp.equalsIgnoreCase(ipType(data));
    }

    public static boolean isUdpPacket(byte[] data) {
        return UdpPacket.IpType_Udp.equalsIgnoreCase(ipType(data));
    }

    public static int tcpHeaderIndex(byte[] data) {
        return ipHeaderIndex(data) + ipHeaderLen(data);
    }

    public static int tcpHeaderLen(byte[] data) {
        return 4 * BytesUtil.toInt(data, tcpHeaderIndex(data) + 12, 1, 0, 4);
    }

    public static long tcpSourcePort(byte[] data) {
        return BytesUtil.toSigned(data, tcpHeaderIndex(data), 2);
    }

    public static long tcpDestPort(byte[] data) {
        return BytesUtil.toSigned(data, tcpHeaderIndex(data) + 2, 2);
    }

    public static boolean isTpktPacket(byte[] data) {
        return 102 == tcpSourcePort(data) || 102 == tcpDestPort(data);
    }

    public static int tpktHeaderIndex(byte[] data) {
        return tcpHeaderIndex(data) + tcpHeaderLen(data);
    }

    public static int tpktHeaderLen(byte[] data) {
        return TpktPacket.HeaderLength;
    }

    public static int cotpHeaderIndex(byte[] data) {
        return tpktHeaderIndex(data) + tpktHeaderLen(data);
    }

    public static int cotpHeaderLen(byte[] data) {
        return 3;
    }

    public static int osiSessionHeaderIndex(byte[] data) {
        return cotpHeaderIndex(data) + cotpHeaderLen(data);
    }

    public static int osiSessionHeaderLen(byte[] data) {
        return 4;
    }

    public static void test() {
        byte[] data = BytesUtil.fromHexString(DisplayFrame.testMms1);
        System.out.println("ethernet type:" + ethernetType(data));
        System.out.println("ip header len:" + ipHeaderLen(data));
        System.out.println("tcp header len:" + tcpHeaderLen(data));
        System.out.println("is tpkt packet:" + isTpktPacket(data));
    }

    public static void main(String[] args) {
        test();
    }
}
