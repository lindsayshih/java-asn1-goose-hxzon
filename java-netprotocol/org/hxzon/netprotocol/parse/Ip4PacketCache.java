package org.hxzon.netprotocol.parse;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hxzon.netprotocol.packet.Ip4Packet;

public class Ip4PacketCache {

    private static Map<Integer, Ip4PacketGroup> groups = new HashMap<Integer, Ip4PacketGroup>();

    public static void addIp4Packet(Ip4Packet ip4Packet) {
        int identification = ip4Packet.fetchIdentification().getValue();
        int protocolCode = ip4Packet.fetchProtocolCode().getValue();
        long sourceIp = ip4Packet.fetchSourceIp().getValue();
        long destIp = ip4Packet.fetchDestIp().getValue();
        int key = new HashCodeBuilder().append(identification).append(protocolCode).append(sourceIp).append(destIp).toHashCode();
        Ip4PacketGroup group = groups.get(key);
        if (group == null && ip4Packet.isMoreFragment()) {
            group = new Ip4PacketGroup(key);
            groups.put(key, group);
        }
        if (group != null) {
            group.addPacket(ip4Packet);
        }
    }
}
