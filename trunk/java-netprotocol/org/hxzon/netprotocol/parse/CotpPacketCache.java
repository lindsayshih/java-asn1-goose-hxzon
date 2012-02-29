package org.hxzon.netprotocol.parse;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hxzon.netprotocol.common.IPacket;
import org.hxzon.netprotocol.packet.CotpPacket;
import org.hxzon.netprotocol.packet.Ip4Packet;
import org.hxzon.netprotocol.packet.TcpPacket;

public class CotpPacketCache {

    private static Map<Integer, CotpPacketGroup> groups = new HashMap<Integer, CotpPacketGroup>();

    public static void addCotpPacket(CotpPacket cotpPacket) {
        Ip4Packet ip4Packet = null;
        TcpPacket tcpPacket = null;
        for (IPacket parent = cotpPacket.getSrcPacket();;) {
            if (parent instanceof Ip4Packet) {
                ip4Packet = (Ip4Packet) parent;
                break;
            } else if (parent instanceof TcpPacket) {
                tcpPacket = (TcpPacket) parent;
            }
            parent = parent.getSrcPacket();
        }
        if (ip4Packet == null || tcpPacket == null) {
            return;
        }
        int identification = ip4Packet.fetchIdentification().getValue();
        int protocolCode = ip4Packet.fetchProtocolCode().getValue();
        long sourceIp = ip4Packet.fetchSourceIp().getValue();
        long destIp = ip4Packet.fetchDestIp().getValue();
        int sourcePort = tcpPacket.fetchSourcePort().getValue();
        int destPort = tcpPacket.fetchDestPort().getValue();
        int key = new HashCodeBuilder().append(identification).append(protocolCode).append(sourceIp).append(destIp).append(sourcePort).append(destPort).toHashCode();
        CotpPacketGroup group = groups.get(key);
        if (group == null && !cotpPacket.isLastUnit()) {
            group = new CotpPacketGroup(key);
            groups.put(key, group);
        }
        if (group != null) {
            group.addPacket(cotpPacket);
        }
    }
}
