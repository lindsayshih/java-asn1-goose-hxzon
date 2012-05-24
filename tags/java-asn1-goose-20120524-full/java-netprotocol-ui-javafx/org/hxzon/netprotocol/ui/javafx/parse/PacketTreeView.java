package org.hxzon.netprotocol.ui.javafx.parse;

import javafx.scene.control.TreeView;

import org.hxzon.netprotocol.packet.Packet;

public class PacketTreeView extends TreeView<Object> {

    public PacketTreeView() {
        this.setShowRoot(false);
    }

    public void updateData(Packet packet) {
        if (packet == null) {
            this.setRoot(null);
        } else {
            this.setRoot(new PacketTreeItem(packet));
        }
    }
}
