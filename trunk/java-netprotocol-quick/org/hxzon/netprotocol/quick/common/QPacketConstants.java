package org.hxzon.netprotocol.quick.common;

public interface QPacketConstants {

    public static final int EthernetHeaderLen = 14;
    public static final int VlanHeaderLen = 4;

    public static final int GooseHeaderLen = 8;
    public static final int SmvHeaderLen = 8;

    public static final int UdpHeaderLength = 8;

    public static final String EthernetType_Vlan = "8100";
    public static final String EthernetType_Goose = "88b8";
    public static final String EthernetType_Smv = "88ba";
    public static final String EthernetType_Ip4 = "0800";

    public static final String PacketTypeDesc_Ethernet = "ethernet";
    public static final String PacketTypeDesc_Vlan = "vlan";
    public static final String PacketTypeDesc_Goose = "goose";
    public static final String PacketTypeDesc_Sv = "smv";
    public static final String PacketTypeDesc_Ip4 = "ip4";

    public static final String IpType_Tcp = "06";
    public static final String IpType_Udp = "11";

    public static final String IpTypeDesc_Tcp = "tcp";
    public static final String IpTypeDesc_Udp = "udp";
}
