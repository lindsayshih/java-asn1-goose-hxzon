package org.hxzon.netprotocol.ui.parse;

import org.hxzon.jnetpcap.JPcapPacket;
import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.util.DebugUtil;
import org.jnetpcap.Pcap;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;

public class PacketHandler_jnetpcap implements PcapPacketHandler<Object> {
    private DisplayFrame_jnetpcap display;
    private Pcap pcap;
    private int i = 0;

    public PacketHandler_jnetpcap(Pcap pcap_, DisplayFrame_jnetpcap display_) {
        this.display = display_;
        this.pcap = pcap_;
//		System.out.println(JRegistry.toDebugString());
        display.getPacketsTable().clearPackets();
        long startTime = System.currentTimeMillis();
        pcap.loop(-1, this, null);
        long endTime = System.currentTimeMillis();
        long spanTime = endTime - startTime;
        DebugUtil.debug("packet num:" + i);
        DebugUtil.debug("packet handler-span time:" + spanTime);
    }

    @Override
    public void nextPacket(PcapPacket pcapPacket, Object user) {
        i++;
        Packet packet = new Packet();
        packet.setSrcData(new JPcapPacket(pcapPacket).getBytes());
        display.getPacketsTable().addPacket(packet);
    }

}
