package org.hxzon.netprotocol.ui.parse;

import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.pcap.PcapFile;
import org.hxzon.pcap.PcapHandlerListener;
import org.hxzon.pcap.PcapPacket;

public class PacketHandlerListener implements PcapHandlerListener {
    private DisplayFrame2 display;
    private int i = 0;

    public PacketHandlerListener(DisplayFrame2 display_) {
        this.display = display_;
//		System.out.println(JRegistry.toDebugString());
        display.getPacketsTable().clearPackets();
    }

    @Override
    public void addPcapPacket(PcapPacket pcapPacket, PcapFile ownerFile) {
        i++;
        Packet packet = new Packet();
        packet.setSrcData(pcapPacket.getPacketData());
        display.getPacketsTable().addPacket(packet);
    }

    public void startPcapFile(PcapFile pcapFile) {

    }

    public void endPcapFile(PcapFile pcapFile) {

    }

    public void endAll() {

    }

}
