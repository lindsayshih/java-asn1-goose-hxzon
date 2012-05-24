package org.hxzon.demo.pcap.ui;

import javax.swing.tree.DefaultMutableTreeNode;

import org.hxzon.demo.asn1.BytesUtils;
import org.hxzon.demo.pcap.packet.GoosePacket;
import org.hxzon.demo.pcap.packet.MmsPacket;
import org.hxzon.demo.pcap.packet.SmvPacket;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.protocol.lan.Ethernet;
import org.jnetpcap.protocol.lan.IEEE802dot1q;
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.protocol.network.Ip6;
import org.jnetpcap.protocol.tcpip.Tcp;

import com.chaosinmotion.asn1.BerConstruct;
import com.chaosinmotion.asn1.BerNode;

public class PacketTreeNode extends DefaultMutableTreeNode {
	private int offset;
	private int len;

	public PacketTreeNode(PcapPacket packet) {
		Ethernet ethernet = new Ethernet();
		IEEE802dot1q vlan = new IEEE802dot1q();
		Ip4 ip4 = new Ip4();
		Ip6 ip6 = new Ip6();
		Tcp tcp = new Tcp();
		GoosePacket goose = new GoosePacket();
		SmvPacket smv = new SmvPacket();
		MmsPacket mms = new MmsPacket();
		if (packet.hasHeader(ethernet)) {
			this.add(new PacketTreeNode(ethernet));
		}
		if (packet.hasHeader(vlan)) {
			this.add(new PacketTreeNode(vlan));
		}
		if (packet.hasHeader(ip4)) {
			this.add(new PacketTreeNode(ip4));
		}
		if (packet.hasHeader(ip6)) {
			this.add(new PacketTreeNode(ip6));
		}
		if (packet.hasHeader(goose)) {
			this.add(new PacketTreeNode(goose));
			this.add(new PacketTreeNode(goose.goosepdu()));
		}
		if (packet.hasHeader(smv)) {
			this.add(new PacketTreeNode(smv));
			this.add(new PacketTreeNode(smv.smvpdu()));
		}
		if (packet.hasHeader(tcp)) {
			this.add(new PacketTreeNode(tcp));
		}
	}

	public PacketTreeNode(Ethernet packet) {
		super("ethernet");
		this.len = packet.getHeaderLength();
		this.offset = packet.getHeaderOffset();
		this.add("destMac", BytesUtils.bytesToHexStringForDisplay(packet.destination()), offset, 6);
		this.add("srcMac", BytesUtils.bytesToHexStringForDisplay(packet.source()), offset + 6, 6);
		this.add("type", packet.typeDescription(), offset + 12, 2);
	}

	public PacketTreeNode(IEEE802dot1q packet) {
		super("vlan");
		this.len = packet.getHeaderLength();
		this.offset = packet.getHeaderOffset();
		this.add("type:" + packet.type(), offset + 2, 2);
	}

	public PacketTreeNode(Ip4 packet) {
		super("ip4");
//		super(packet.toString());
		this.len = packet.getHeaderLength();
		this.offset = packet.getHeaderOffset();
		this.add("srcIP:" + BytesUtils.bytesToHexStringForDisplay(packet.source()));
		this.add("destIP:" + BytesUtils.bytesToHexStringForDisplay(packet.destination()));
		this.add("head length:" + packet.hlenDescription());
		this.add("diffserv:" + packet.tos());
	}

	public PacketTreeNode(Ip6 packet) {
		super("ip6");
		this.len = packet.getHeaderLength();
		this.offset = packet.getHeaderOffset();
		this.add("srcIP:" + BytesUtils.bytesToHexStringForDisplay(packet.source()));
		this.add("destIP:" + BytesUtils.bytesToHexStringForDisplay(packet.destination()));
		this.add("head length:" + packet.length());
		this.add("");
	}

	public PacketTreeNode(Tcp packet) {
		super("tcp");
		this.len = packet.getHeaderLength();
		this.offset = packet.getHeaderOffset();
		this.add("srcPort:" + packet.source());
		this.add("destProt:" + packet.destination());
		this.add("sequence number:" + packet.seq());
		this.add("header length:" + packet.hlen() * 4);
		this.add("flags:" + packet.flagsCompactString());
		this.add("window size:" + packet.window());
		this.add("check sum:" + packet.checksum());
		this.add("option:");
	}

	public PacketTreeNode(GoosePacket packet) {
		super("goose");
		this.len = packet.getHeaderLength();
		this.offset = packet.getHeaderOffset();
		this.add("appID:" + packet.appID(), offset, 2);
		this.add("pduLen:" + packet.pduLen(), offset + 2, 2);
		this.add("reserved1:" + packet.reserved1(), offset + 4, 2);
		this.add("reserved2:" + packet.reserved2(), offset + 6, 2);
//		this.add(new PacketTreeNode(packet.goosepdu()));
	}

	public PacketTreeNode(SmvPacket packet) {
		super("smv");
		this.len = packet.getHeaderLength();
		this.offset = packet.getHeaderOffset();
		this.add("appID:" + packet.appID(), offset, 2);
		this.add("pduLen:" + packet.pduLen(), offset + 2, 2);
		this.add("reserved1:" + packet.reserved1(), offset + 4, 2);
		this.add("reserved2:" + packet.reserved2(), offset + 6, 2);
//		this.add(new PacketTreeNode(packet.smvpdu()));
	}

	public PacketTreeNode(BerNode asn1) {
		super(asn1.getName());
		this.len = asn1.getLen();
		this.offset = asn1.getOffset();
		if (asn1 instanceof BerConstruct) {
			for (BerNode child : ((BerConstruct) asn1).toArray()) {
				this.add(new PacketTreeNode(child));
			}
		}
	}

	public PacketTreeNode(String value) {
		super(value);
	}

	public PacketTreeNode(String value, int offset, int len) {
		super(value);
		this.offset = offset;
		this.len = len;
	}

	public void add(String value) {
		super.add(new PacketTreeNode(value));
	}

	public void add(String value, int offset, int len) {
		super.add(new PacketTreeNode(value, offset, len));
	}

	public void add(String label, String value) {
		super.add(new PacketTreeNode(label + ":" + value));
	}

	public void add(String label, String value, int offset, int len) {
		super.add(new PacketTreeNode(label + ":" + value, offset, len));
	}

	public PacketTreeNode getParent() {
		return (PacketTreeNode) super.getParent();
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}
}
