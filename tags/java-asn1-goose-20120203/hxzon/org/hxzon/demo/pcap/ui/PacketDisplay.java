package org.hxzon.demo.pcap.ui;

import java.awt.Dimension;
import java.nio.ByteBuffer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

import org.hxzon.demo.asn1.BytesUtils;
import org.hxzon.demo.pcap.packet.JPcapPacket;

public class PacketDisplay extends JSplitPane {
	private PacketTree messageTree;
	private JTextPane hexPane;
	private JTextPane indexPane;
	private SimpleAttributeSet notSelected;
	private SimpleAttributeSet selected;
	
	public PacketDisplay() {
		notSelected = new SimpleAttributeSet();
        selected = new SimpleAttributeSet(notSelected);
        StyleConstants.setForeground(selected, new DefaultTreeCellRenderer().getTextSelectionColor());
        StyleConstants.setBackground(selected, new DefaultTreeCellRenderer().getBackgroundSelectionColor());
		JPanel messagePane = new JPanel();
		indexPane = new JTextPane();
		indexPane.setPreferredSize(new Dimension(60, 300));
		indexPane.setEditable(false);
		hexPane = new JTextPane();
		hexPane.setPreferredSize(new Dimension(350, 300));
		hexPane.setEditable(false);
		messagePane.setLayout(new BoxLayout(messagePane, BoxLayout.X_AXIS));
		messagePane.add(indexPane);
		messagePane.add(hexPane);
		messageTree = new PacketTree();
		messageTree.setPreferredSize(new Dimension(200,300));
		messageTree.addTreeSelectionListener(new TreeSelectionListener() {

			public void valueChanged(TreeSelectionEvent e) {
				TreePath treePath = e.getPath();
				if (treePath == null) {
					return;
				}
				PacketTreeNode node = (PacketTreeNode) treePath
						.getLastPathComponent();
				if(!node.isLeaf()){
					messageTree.expandPath(treePath);
				}
				int offset = node.getOffset();
                int len = node.getLen();
                int end = offset + len;
                offset = offset * 2 + offset;
                end = end * 2 + end;
                offset += offset / 48;
                end += end / 48 - 1;
//                hexPane.requestFocus();
//                hexPane.select(offset, end);
                StyledDocument doc=hexPane.getStyledDocument();
                doc.setCharacterAttributes(0, doc.getLength(), notSelected, true);
                doc.setCharacterAttributes(offset, end - offset, selected, true);
                hexPane.select(offset, end);//let auto scroll
			}

		});
		this.setLeftComponent(new JScrollPane(messageTree));
		this.setRightComponent(new JScrollPane(messagePane));
//		this
	}

	public void updateData(JPcapPacket packet) {
		byte[] data=packet.getBytes();
		indexPane.setText(BytesUtils.bytesToIndex(data));
		String hex = BytesUtils.bytesToHexStringForDisplay(data);
		hexPane.setText(hex);
		messageTree.setModel(packet);
	}

	public JTree getMessageTree() {
		return messageTree;
	}

	public JTextPane getHexPane() {
		return hexPane;
	}

	public JTextPane getIndexPane() {
		return indexPane;
	}
}
