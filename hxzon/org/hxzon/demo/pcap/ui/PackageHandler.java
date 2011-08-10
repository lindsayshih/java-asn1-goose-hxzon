package org.hxzon.demo.pcap.ui;

import java.util.ArrayList;
import java.util.List;

import org.hxzon.demo.pcap.packet.Cotp;
import org.hxzon.demo.pcap.packet.GoosePacket;
import org.hxzon.demo.pcap.packet.JPcapPacket;
import org.hxzon.demo.pcap.packet.MmsPacket;
import org.hxzon.demo.pcap.packet.OsiPresentation;
import org.hxzon.demo.pcap.packet.OsiSession;
import org.hxzon.demo.pcap.packet.SmvPacket;
import org.hxzon.demo.pcap.packet.Tpkt;
import org.jnetpcap.Pcap;
import org.jnetpcap.packet.JHeader;
import org.jnetpcap.packet.JRegistry;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.protocol.tcpip.Tcp;

public class PackageHandler implements PcapPacketHandler {
	Tcp tcp = new Tcp();
	Tpkt tpkt = new Tpkt();
	Cotp cotp = new Cotp();
	OsiSession session = new OsiSession();
	OsiPresentation pres = new OsiPresentation();
	GoosePacket goose = new GoosePacket();
	SmvPacket smv = new SmvPacket();
	MmsPacket mms = new MmsPacket();
	private DisplayFrame display;
	private Pcap pcap;
	private List<JPcapPacket> mmss = new ArrayList<JPcapPacket>();
	private List<JPcapPacket> gooses = new ArrayList<JPcapPacket>();
	private List<JPcapPacket> smvs = new ArrayList<JPcapPacket>();
	private List<JPcapPacket> others = new ArrayList<JPcapPacket>();
	private List<JPcapPacket> all = new ArrayList<JPcapPacket>();
	private int i = 0;

	public PackageHandler(Pcap pcap_, DisplayFrame display_) {
		this.display = display_;
		this.pcap = pcap_;
		mmss.clear();
		gooses.clear();
		smvs.clear();
		others.clear();
		all.clear();
//		System.out.println(JRegistry.toDebugString());
		display.getPacketsTable().clearPackets();
		pcap.loop(-1, this, null);
	}


	@Override
	public void nextPacket(PcapPacket packet, Object user) {
		i++;
//		if (packet.hasHeader(tpkt)) {
//			System.out.println(i + "," + tpkt);
//		}
//		if (packet.hasHeader(cotp)) {
//			System.out.println(i + "," + cotp);
//		}
//		if (packet.hasHeader(session)) {
//			System.out.println(i + "," + session);
//		}
//		if(packet.hasHeader(pres)){
//			System.out.println(i+","+pres);
//		}
		JPcapPacket copy;
		if (packet.hasHeader(goose)) {
			copy = new JPcapPacket(packet, GoosePacket.class);
			gooses.add(copy);
			all.add(copy);
		} else if (packet.hasHeader(smv)) {
			copy = new JPcapPacket(packet, SmvPacket.class);
			smvs.add(copy);
			all.add(copy);
		} else if (packet.hasHeader(mms)) {
			copy = new JPcapPacket(packet, MmsPacket.class);
			mmss.add(copy);
			all.add(copy);
		} else {
			copy = new JPcapPacket(packet, JHeader.class);
			others.add(copy);
			all.add(copy);
		}
		display.getPacketsTable().addPacket(copy);
	}

}
