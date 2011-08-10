package org.hxzon.netprotocol.ui;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.tree.TreeNode;

import org.hxzon.asn1.FakeBerConstruct;
import org.hxzon.netprotocol.common.IPacket;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.netprotocol.packet.NullPayload;
import org.hxzon.netprotocol.packet.OsiPresentationPacket;
import org.hxzon.netprotocol.parse.ProtocolField;

import com.chaosinmotion.asn1.BerConstruct;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.Tag;

public class PacketTreeNode implements TreeNode {
	private PacketTreeNode parent;
	private List<PacketTreeNode> children;
	private Object userObject;
	private String displayString;
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
				if (payload instanceof NullPayload) {

				} else {
					this.add(payload);
				}
			}
		} else {
			this.len = packet.getLength();
		}
	}

	public PacketTreeNode(ProtocolField field) {
		userObject = field;
		this.len = field.getLen();
		this.offset = field.getOffset();
		this.setDisplayString(field.getDisplayString() + ":" + field.getValueAsDisplay());
		children = new ArrayList<PacketTreeNode>(0);
	}

	public PacketTreeNode(BerNode asn1) {
//		this(asn1.getName() + ":" + asn1.getValueAsString()+":"+Tag.toString(asn1.getTag()));//
		userObject = asn1;
		this.len = asn1.getTotalLen();
		this.offset = asn1.getTagOffset();
		this.setDisplayString(asn1.getDisplayString() + ":" + asn1.getValueAsString() + ":\t" + Tag.toString(asn1.getTag()));
		children = new ArrayList<PacketTreeNode>();
	}

	public PacketTreeNode(String value) {
		children = new ArrayList<PacketTreeNode>();
		userObject = value;
	}

	public PacketTreeNode(String value, int offset, int len) {
		children = new ArrayList<PacketTreeNode>();
		this.userObject = value;
		this.offset = offset;
		this.len = len;
	}

	public void add(IPacketPayload packet) {
		if (packet instanceof OsiPresentationPacket) {
			this.add(((OsiPresentationPacket) packet));
		} else if (packet instanceof IPacket) {
			IPacket gpacket = (IPacket) packet;
			PacketTreeNode node = new PacketTreeNode(gpacket);
			this.implAddChildNode(node);

			for (ProtocolField field : gpacket.getHeaderFields()) {
				node.add(field);
			}
//				this.add(new PacketTreeNode(packet));
		} else if (packet instanceof BerNode) {
			add((BerNode) packet);
		}
//		this.implAddChildNode(new PacketTreeNode(packet));
	}

	public void add(OsiPresentationPacket packet) {
//		PacketTreeNode node = new PacketTreeNode(packet);
//		this.implAddChildNode(node);
//		node.add(packet.fetchPresentation());
		this.add(packet.fetchPresentation());
		this.add(packet.fetchPresentationPayload());
	}

	public void add(String value) {
		implAddChildNode(new PacketTreeNode(value));
	}

	public void add(String value, int offset, int len) {
		implAddChildNode(new PacketTreeNode(value, offset, len));
	}

	public void add(String label, String value) {
		implAddChildNode(new PacketTreeNode(label + ":" + value));
	}

	public void add(String label, String value, int offset, int len) {
		implAddChildNode(new PacketTreeNode(label + ":" + value, offset, len));
	}

	public void add(BerNode asn1) {
		if (asn1 == null) {
			return;
		}
		PacketTreeNode node = new PacketTreeNode(asn1);
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
		this.implAddChildNode(new PacketTreeNode(field));
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
