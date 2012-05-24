package org.hxzon.netprotocol.ui.parse;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.TreeNode;

import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.type.base.BerConstruct;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.core.type.ext.FakeBerConstruct;
import org.hxzon.netprotocol.common.IPacket;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.netprotocol.payload.BerNodePayload;
import org.hxzon.netprotocol.payload.DataPayload;

public class PacketTreeNode implements TreeNode {
    private boolean removeBerChoice = true;
    private PacketTreeNode parent;
    private List<PacketTreeNode> children;
    private Object userObject;
    private String displayString;
    private byte[] bytes;
    private int offset;
    private int len;

    private void implAddChildNode(PacketTreeNode node) {
        children.add(node);
        node.setParent(this);
    }

    public PacketTreeNode(IPacketPayload packet) {
        children = new ArrayList<PacketTreeNode>();
        if (packet == null) {
            userObject = "error";
            return;
        }
        userObject = packet;
        this.bytes = packet.getSrcData();
        this.offset = packet.getOffset();
        if (packet instanceof IPacket) {
            this.len = ((IPacket) packet).getHeaderLength();
        } else {
            this.len = packet.getLength();
        }
        this.setDisplayString(packet.getName() + "[" + this.len + "," + this.offset + "]");
        if (packet.getClass() == Packet.class) {
            this.add(((IPacket) packet).getPayload());
        }
    }

    public PacketTreeNode(ProtocolField field) {
        userObject = field;
        this.bytes = field.getPacket().getSrcData();
        this.len = field.getLen();
        this.offset = field.getOffset();
        this.setDisplayString(field.getDisplayString() + "[" + field.getOffset() + "," + field.getLen() + "]");
        children = new ArrayList<PacketTreeNode>(0);
    }

    public PacketTreeNode(BerNode asn1) {
        userObject = asn1;
        this.len = asn1.getTotalLen();
        this.offset = asn1.getTagOffset();
        this.setDisplayString(asn1.getDisplayString() + ":" + Tag.toString(asn1.getTag()) + "[" + this.len + "," + this.offset + "]");
        children = new ArrayList<PacketTreeNode>();
    }

//    public PacketTreeNode(String value) {
//        children = new ArrayList<PacketTreeNode>();
//        userObject = value;
//    }
//
//    public PacketTreeNode(String value, int offset, int len) {
//        children = new ArrayList<PacketTreeNode>();
//        this.userObject = value;
//        this.offset = offset;
//        this.len = len;
//    }

    public void add(IPacketPayload payload) {
        if (payload == null) {
            return;
        }
        while (payload instanceof IPacket) {
            IPacket packet = (IPacket) payload;
            PacketTreeNode node = new PacketTreeNode(packet);
            this.implAddChildNode(node);
            for (ProtocolField field : packet.getHeaderFields()) {
                node.add(field);
            }
            payload = ((IPacket) payload).getPayload();
        }
        if (payload instanceof BerNodePayload) {
            this.add(((BerNodePayload) payload).getBerNode(), payload.getSrcData());
        } else if (payload instanceof DataPayload) {
            this.implAddChildNode(new PacketTreeNode(payload));
            DataPayload dataPayload = (DataPayload) payload;
            if (dataPayload.getGroup() != null) {
                this.add(dataPayload.getGroup().getPayload());
            }
        } else {
        }
    }

    public void add(BerNode asn1, byte[] bytes) {
        if (asn1 == null) {
            return;
        }
        if (removeBerChoice && asn1 instanceof BerChoice && !((BerChoice) asn1).hasTag()) {
            asn1 = ((BerChoice) asn1).getLastRealNode();
        }
        PacketTreeNode node = new PacketTreeNode(asn1);
        this.implAddChildNode(node);
        node.bytes = bytes;
        node.len = asn1.getTotalLen();
        node.offset = asn1.getTagOffset();
        if (asn1 instanceof BerConstruct) {
            for (BerNode child : ((BerConstruct) asn1).getChildren()) {
                node.add(child, bytes);
            }
        }
        if (asn1 instanceof FakeBerConstruct) {
            for (BerNode child : ((FakeBerConstruct) asn1).getChildren()) {
                node.add(child, bytes);
            }
        }
    }

    public void add(ProtocolField field) {
        if (field == null) {
            return;
        }
        this.implAddChildNode(new PacketTreeNode(field));
    }

//    public void add(String value) {
//        implAddChildNode(new PacketTreeNode(value));
//    }
//
//    public void add(String value, int offset, int len) {
//        implAddChildNode(new PacketTreeNode(value, offset, len));
//    }
//
//    public void add(String label, String value) {
//        implAddChildNode(new PacketTreeNode(label + ":" + value));
//    }
//
//    public void add(String label, String value, int offset, int len) {
//        implAddChildNode(new PacketTreeNode(label + ":" + value, offset, len));
//    }

    //------------------------------
    public byte[] getBytes() {
        return bytes;
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

    @Override
    public Enumeration<PacketTreeNode> children() {
        final Iterator<PacketTreeNode> iter = children.iterator();
        return new Enumeration<PacketTreeNode>() {

            @Override
            public boolean hasMoreElements() {
                return iter.hasNext();
            }

            @Override
            public PacketTreeNode nextElement() {
                return iter.next();
            }

        };
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return children.get(childIndex);
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    @Override
    public int getIndex(TreeNode node) {
        return children.indexOf(node);
    }

    @Override
    public boolean isLeaf() {
        return children.isEmpty();
    }

    @Override
    public TreeNode getParent() {
        return parent;
    }

    protected void setParent(PacketTreeNode parent) {
        this.parent = parent;
    }

    public void setDisplayString(String displayString) {
        this.displayString = displayString;
    }

    public String toString() {
        return displayString != null ? displayString : userObject.toString();
    }
}
