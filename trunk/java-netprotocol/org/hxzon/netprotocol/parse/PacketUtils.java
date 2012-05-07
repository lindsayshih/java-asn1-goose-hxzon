package org.hxzon.netprotocol.parse;

import org.hxzon.netprotocol.packet.ArpPacket;
import org.hxzon.netprotocol.packet.CotpPacket;
import org.hxzon.netprotocol.packet.EthernetPacket;
import org.hxzon.netprotocol.packet.GoosePacket;
import org.hxzon.netprotocol.packet.Ip4Packet;
import org.hxzon.netprotocol.packet.OsiSessionPacket;
import org.hxzon.netprotocol.packet.PtpPacket;
import org.hxzon.netprotocol.packet.RarpPacket;
import org.hxzon.netprotocol.packet.SvPacket;
import org.hxzon.netprotocol.packet.TcpPacket;
import org.hxzon.netprotocol.packet.TpktPacket;
import org.hxzon.netprotocol.packet.UdpPacket;
import org.hxzon.netprotocol.packet.VlanPacket;
import org.hxzon.util.BytesUtil;

public class PacketUtils {
    public static void initPacket() {
        new EthernetPacket();
        new VlanPacket();
        new GoosePacket();
        new SvPacket();
        new Ip4Packet();
        new TcpPacket();
        new UdpPacket();
        new TpktPacket();
        new CotpPacket();
        new OsiSessionPacket();
        new ArpPacket();
        new RarpPacket();
        new PtpPacket();
    }

    public static int ethernetType(byte[] data) {
        int ethernetType = BytesUtil.toInt(data, 12, 2, 0);
        if (VlanPacket.EthernetType_Vlan == ethernetType) {
            ethernetType = BytesUtil.toInt(data, 16, 2, 0);
        }
        return ethernetType;
    }

    public static int ethernetHeaderLen(byte[] data) {
        int ethernetType = BytesUtil.toInt(data, 12, 2, 0);
        if (VlanPacket.EthernetType_Vlan == ethernetType) {
            return 14 + 4;
        }
        return 14;
    }

    public static boolean isIp4Packet(byte[] data) {
        return Ip4Packet.EthernetType_Ip4 == ethernetType(data);
    }

    public static int ipType(byte[] data) {
        return BytesUtil.toInt(data, ethernetHeaderLen(data) + 10, 2, 0);
    }

    public static int ipHeaderIndex(byte[] data) {
        return ethernetHeaderLen(data);
    }

    public static int ipHeaderLen(byte[] data) {
        return 4 * BytesUtil.toInt(data, ipHeaderIndex(data), 1, 4, 4);
    }

    public static boolean isTcpPacket(byte[] data) {
        return TcpPacket.IpType_Tcp == ipType(data);
    }

    public static boolean isUdpPacket(byte[] data) {
        return UdpPacket.IpType_Udp == ipType(data);
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

}
