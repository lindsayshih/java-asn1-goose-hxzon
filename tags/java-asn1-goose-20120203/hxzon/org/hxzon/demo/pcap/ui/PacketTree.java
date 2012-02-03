package org.hxzon.demo.pcap.ui;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import org.jnetpcap.packet.PcapPacket;

public class PacketTree extends JTree {

	public PacketTree() {
		super.setRootVisible(false);
		super.setModel(null);
	}

	public void setModel(PcapPacket packet) {
		super.setModel(new DefaultTreeModel(new PacketTreeNode(packet), false));
	}
}
