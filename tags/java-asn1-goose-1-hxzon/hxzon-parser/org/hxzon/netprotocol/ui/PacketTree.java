package org.hxzon.netprotocol.ui;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.ui.util.JTreeUtil;

public class PacketTree extends JTree {

	public PacketTree() {
		super.setRootVisible(false);
		super.setModel(null);
	}

	public void updateModel(Packet packet) {
		super.setModel(new DefaultTreeModel(new PacketTreeNode(packet), false));
		JTreeUtil.expandAll(this, true);
	}
}
