package org.hxzon.netprotocol.ui.parse;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

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

import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.util.BytesUtil;

public class PacketDisplay extends JPanel {
    private static final long serialVersionUID = 1L;
    private PacketTree messageTree;
    private JTextPane hexPane;
    private JTextPane indexPane;
    private SimpleAttributeSet notSelected;
    private SimpleAttributeSet selected;
    private static final Font font = Font.decode("Courier New PLAIN 12");

    public PacketDisplay() {
        super(new BorderLayout());
        notSelected = new SimpleAttributeSet();
        selected = new SimpleAttributeSet(notSelected);
        StyleConstants.setForeground(selected, new DefaultTreeCellRenderer().getTextSelectionColor());
        StyleConstants.setBackground(selected, new DefaultTreeCellRenderer().getBackgroundSelectionColor());
        //hex panel
        JPanel messagePane = new JPanel();
        indexPane = new JTextPane();
        indexPane.setMinimumSize(new Dimension(30, 300));
        indexPane.setEditable(false);
        hexPane = new JTextPane();
        hexPane.setMinimumSize(new Dimension(350, 300));
        hexPane.setEditable(false);
//        for(Font font:GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()){
//            System.out.println(font);
//        }
//        System.out.println(hexPane.getFont());
        indexPane.setFont(font);
        hexPane.setFont(font);
//        System.out.println(hexPane.getFont());
        messagePane.setLayout(new BoxLayout(messagePane, BoxLayout.X_AXIS));
        messagePane.add(indexPane);
        messagePane.add(hexPane);
//		messagePane.setMinimumSize(new Dimension(410, 300));
        //tree
        messageTree = new PacketTree();
        messageTree.setMinimumSize(new Dimension(350, 300));
        messageTree.addTreeSelectionListener(new TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent e) {
                TreePath treePath = e.getPath();
                if (treePath == null) {
                    return;
                }
                PacketTreeNode node = (PacketTreeNode) treePath.getLastPathComponent();
                if (!node.isLeaf()) {
                    messageTree.expandPath(treePath);
                }
                //
                int offset = node.getOffset();//byte offset
                int len = node.getLen();//byte len
                int end = offset + len;//byte end
                //
                int wordSplitLen = 1;
                int charLenForByte = 2 + wordSplitLen;
                int lineSplitLen = 1;
                int byteNumInOneLine = 16;
                //
                offset = offset * charLenForByte;
                end = end * charLenForByte;
                offset += offset / (byteNumInOneLine * charLenForByte) * lineSplitLen;
                end += end / (byteNumInOneLine * charLenForByte) * lineSplitLen;
                //fix bug when len=0 make end=offset
                if (end > offset) {
                    end -= wordSplitLen;
                }
                try {
                    StyledDocument doc = hexPane.getStyledDocument();
                    doc.setCharacterAttributes(0, doc.getLength(), notSelected, true);
                    doc.setCharacterAttributes(offset, end - offset, selected, true);
                    hexPane.select(offset, end);//let auto scroll
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });
        JSplitPane split = new JSplitPane();
        split.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        split.setLeftComponent(new JScrollPane(messagePane));
        split.setRightComponent(new JScrollPane(messageTree));
        split.setDividerLocation(380);
        split.setBorder(null);
        this.add(split, BorderLayout.CENTER);
    }

    public void updateData(Packet packet) {
        if (packet != null) {
            byte[] data = packet.getSrcData();
            try {
                messageTree.updateModel(packet);//must before editPane.setText or throw exception
            } catch (Exception e) {
                messageTree.updateModel(null);
                e.printStackTrace();
            }
            indexPane.setText(BytesUtil.toIndex(data));
            indexPane.select(0, 0);
            String hex = BytesUtil.toDisplayHexString(data);
            hexPane.setText(hex);
            hexPane.select(0, 0);
        } else {
            messageTree.updateModel(null);
            indexPane.setText("");
            indexPane.select(0, 0);
            hexPane.setText("");
            hexPane.select(0, 0);
        }
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
