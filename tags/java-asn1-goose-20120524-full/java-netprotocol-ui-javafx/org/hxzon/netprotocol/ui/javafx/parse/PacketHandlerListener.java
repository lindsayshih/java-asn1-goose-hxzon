package org.hxzon.netprotocol.ui.javafx.parse;

import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.pcap.PcapFile;
import org.hxzon.pcap.PcapHandlerListener;
import org.hxzon.pcap.PcapPacket;
import org.hxzon.util.DebugUtil;

public class PacketHandlerListener implements PcapHandlerListener {
    private DisplayApplication display;
    private int i = 0;

    public PacketHandlerListener(DisplayApplication display_) {
        this.display = display_;
//		System.out.println(JRegistry.toDebugString());
        display.getPacketTableView().getData().clear();
    }

    @Override
    public void addPcapPacket(PcapPacket pcapPacket, PcapFile ownerFile) {
        i++;
        Packet packet = new Packet();
        packet.setSrcData(pcapPacket.getPacketData());
        display.getPacketTableView().getData().add(packet);
    }

    public void startPcapFile(PcapFile pcapFile) {

    }

    public void endPcapFile(PcapFile pcapFile) {

    }

    public void endAll() {
        DebugUtil.debug("packet num:" + i);
    }

}
