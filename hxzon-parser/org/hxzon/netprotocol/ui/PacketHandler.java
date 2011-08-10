package org.hxzon.netprotocol.ui;

import org.hxzon.jnetpcap.JPcapPacket;
import org.hxzon.netprotocol.packet.Packet;
import org.jnetpcap.Pcap;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacketHandler implements PcapPacketHandler {
	private static Logger logger = LoggerFactory.getLogger(PacketHandler.class);
	private DisplayFrame display;
	private Pcap pcap;
	private int i = 0;

	public PacketHandler(Pcap pcap_, DisplayFrame display_) {
		this.display = display_;
		this.pcap = pcap_;
//		System.out.println(JRegistry.toDebugString());
		display.getPacketsTable().clearPackets();
		long startTime = System.currentTimeMillis();
		pcap.loop(-1, this, null);
		long endTime = System.currentTimeMillis();
		long spanTime = endTime - startTime;
		logger.debug("packet handler-span time:" + spanTime);
	}

	@Override
	public void nextPacket(PcapPacket pcapPacket, Object user) {
		i++;
		Packet packet = new Packet();
		packet.setSrcData(new JPcapPacket(pcapPacket).getBytes());
		display.getPacketsTable().addPacket(packet);
	}

}
