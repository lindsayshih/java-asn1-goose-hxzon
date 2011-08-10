package org.hxzon.netprotocol.ui;

import org.hxzon.netprotocol.jnetpcap.JPcapPacket;
import org.hxzon.netprotocol.packet.Packet;
import org.jnetpcap.Pcap;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;

public class PackageHandler implements PcapPacketHandler {
	private DisplayFrame display;
	private Pcap pcap;
	private int i = 0;

	public PackageHandler(Pcap pcap_, DisplayFrame display_) {
		this.display = display_;
		this.pcap = pcap_;
//		System.out.println(JRegistry.toDebugString());
		display.getPacketsTable().clearPackets();
		pcap.loop(-1, this, null);
	}


	@Override
	public void nextPacket(PcapPacket pcapPacket, Object user) {
		i++;
		Packet packet=new Packet();
		packet.setSrcData(new JPcapPacket(pcapPacket).getBytes());
		display.getPacketsTable().addPacket(packet);
	}

}
