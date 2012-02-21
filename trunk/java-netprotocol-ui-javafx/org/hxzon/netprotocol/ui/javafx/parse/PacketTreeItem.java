package org.hxzon.netprotocol.ui.javafx.parse;

import javafx.scene.control.TreeItem;

import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.type.base.BerConstruct;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.core.type.ext.FakeBerConstruct;
import org.hxzon.netprotocol.common.IPacket;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.packet.OsiPresentationPacket;

public class PacketTreeItem extends TreeItem<Object> {
    private boolean removeBerChoice = true;
//    private PacketTreeNode parent;
//    private ObservableList<TreeItem<Object>> children;
    private Object userObject;
    private String displayString;
    private int offset;
    private int len;

    private void implAddChildNode(PacketTreeItem node) {
        node.setExpanded(true);
        this.getChildren().add(node);
//        node.setParent(this);
    }

    public PacketTreeItem(IPacketPayload packet) {
        if (packet == null) {
            userObject = "error";
            return;
        }
        userObject = packet;
        this.setDisplayString(packet.getName());
        this.offset = packet.getOffset();
        if (packet instanceof IPacket) {
            IPacket gpacket = (IPacket) packet;
            this.len = gpacket.getHeaderLength();
            if (gpacket.getSrcPacket() == null) {
                IPacketPayload payload = gpacket.getPayload();
                while (payload instanceof IPacket) {
                    this.add((IPacket) payload);
                    payload = ((IPacket) payload).getPayload();
                }
//				if (payload instanceof NullPayload) {
//
//				} else {
                this.add(payload);
//				}
            }
        } else {
            this.len = packet.getLength();
        }
    }

    public PacketTreeItem(ProtocolField field) {
        userObject = field;
        this.len = field.getLen();
        this.offset = field.getOffset();
        this.setDisplayString(field.getDisplayString() + "[" + field.getOffset() + "," + field.getLen() + "]");
    }

    public PacketTreeItem(BerNode asn1) {
//		this(asn1.getName() + ":" + asn1.getValueAsString()+":"+Tag.toString(asn1.getTag()));//
        userObject = asn1;
        this.len = asn1.getTotalLen();
        this.offset = asn1.getTagOffset();
        this.setDisplayString(asn1.getDisplayString() + ":\t" + Tag.toString(asn1.getTag()));
    }

    public PacketTreeItem(String value) {
        userObject = value;
    }

    public PacketTreeItem(String value, int offset, int len) {
        this.userObject = value;
        this.offset = offset;
        this.len = len;
    }

    public void add(IPacketPayload packet) {
        if (packet instanceof OsiPresentationPacket) {
            this.add(((OsiPresentationPacket) packet));
        } else if (packet instanceof IPacket) {
            IPacket gpacket = (IPacket) packet;
            PacketTreeItem node = new PacketTreeItem(gpacket);
            this.implAddChildNode(node);

            for (ProtocolField field : gpacket.getHeaderFields()) {
                node.add(field);
            }
//				this.add(new PacketTreeNode(packet));
        } else if (packet instanceof BerNode) {
            add((BerNode) packet);
        } else {
            this.implAddChildNode(new PacketTreeItem(packet));
        }
//		this.implAddChildNode(new PacketTreeNode(packet));
    }

    public void add(OsiPresentationPacket packet) {
//		PacketTreeNode node = new PacketTreeNode(packet);
//		this.implAddChildNode(node);
//		node.add(packet.fetchPresentation());
//        for (BerNode node : packet.getUserData()) {
//            this.add(node);
//        }
    }

    public void add(String value) {
        implAddChildNode(new PacketTreeItem(value));
    }

    public void add(String value, int offset, int len) {
        implAddChildNode(new PacketTreeItem(value, offset, len));
    }

    public void add(String label, String value) {
        implAddChildNode(new PacketTreeItem(label + ":" + value));
    }

    public void add(String label, String value, int offset, int len) {
        implAddChildNode(new PacketTreeItem(label + ":" + value, offset, len));
    }

    public void add(BerNode asn1) {
        if (asn1 == null) {
            return;
        }
        if (removeBerChoice && asn1 instanceof BerChoice && !((BerChoice) asn1).hasTag()) {
            asn1 = ((BerChoice) asn1).getLastRealNode();
        }
        PacketTreeItem node = new PacketTreeItem(asn1);
        this.implAddChildNode(node);
        node.len = asn1.getTotalLen();
        node.offset = asn1.getTagOffset();
        if (asn1 instanceof BerConstruct) {
            for (BerNode child : ((BerConstruct) asn1).getChildren()) {
                node.add(child);
            }
        }
        if (asn1 instanceof FakeBerConstruct) {
            for (BerNode child : ((FakeBerConstruct) asn1).getChildren()) {
                node.add(child);
            }
        }
    }

    public void add(ProtocolField field) {
        if (field == null) {
            return;
        }
        this.implAddChildNode(new PacketTreeItem(field));
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

//    @Override
//    public ObservableList<TreeItem<Object>> getChildren() {
//        return children;
//    }

//    @Override
//    public boolean getAllowsChildren() {
//        return true;
//    }
//
//    @Override
//    public TreeNode getChildAt(int childIndex) {
//        return children.get(childIndex);
//    }
//
//    @Override
//    public int getChildCount() {
//        return children.size();
//    }
//
//    @Override
//    public int getIndex(TreeNode node) {
//        return children.indexOf(node);
//    }

//    protected void setParent(PacketTreeNode parent) {
//        this.parent = parent;
//    }

    public void setDisplayString(String displayString) {
        this.displayString = displayString;
        this.setValue(displayString);
    }

    public String toString() {
        return displayString != null ? displayString : userObject.toString();
    }

    public Object getData() {
        return userObject;
    }

    //fixed for bug
//    at javafx.scene.control.TreeItem.equals(TreeItem.java:661)
//    at javafx.scene.control.TreeItem.equals(TreeItem.java:658)
//    at java.util.AbstractList.equals(AbstractList.java:507)
//    at com.sun.javafx.collections.ObservableListWrapper.equals(ObservableListWrapper.java:136)
//    at javafx.scene.control.TreeItem.equals(TreeItem.java:661)
//    at javafx.scene.control.TreeItem.equals(TreeItem.java:658)
//    at java.util.AbstractList.equals(AbstractList.java:507)
//    at com.sun.javafx.collections.ObservableListWrapper.equals(ObservableListWrapper.java:136)
    public boolean equals(Object other) {
        return this == other;
    }

}
