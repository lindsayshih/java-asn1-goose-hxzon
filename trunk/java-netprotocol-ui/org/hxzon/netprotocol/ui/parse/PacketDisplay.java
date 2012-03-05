package org.hxzon.netprotocol.ui.parse;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
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
    private PacketTree packetTree;
    private JTextPane dataPane;
    private JTextPane indexPane;
    private SimpleAttributeSet notSelected;
    private SimpleAttributeSet selected;
    private static final Font font = Font.decode("Courier New PLAIN 12");
    private byte[] dataByte;
    private String dataIndex;
    private String dataString;

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
        dataPane = new JTextPane();
        dataPane.setMinimumSize(new Dimension(350, 300));
        dataPane.setEditable(false);
//        for(Font font:GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()){
//            System.out.println(font);
//        }
//        System.out.println(hexPane.getFont());
        indexPane.setFont(font);
        dataPane.setFont(font);
//        System.out.println(hexPane.getFont());
        messagePane.setLayout(new BoxLayout(messagePane, BoxLayout.X_AXIS));
        messagePane.add(indexPane);
        messagePane.add(dataPane);
//		messagePane.setMinimumSize(new Dimension(410, 300));
        //tree
        packetTree = new PacketTree();
        packetTree.setMinimumSize(new Dimension(350, 300));
        packetTree.addTreeSelectionListener(new TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent e) {
                TreePath treePath = e.getPath();
                if (treePath == null) {
                    return;
                }
                PacketTreeNode node = (PacketTreeNode) treePath.getLastPathComponent();
                if (!node.isLeaf()) {
                    packetTree.expandPath(treePath);
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
                if (dataByte != node.getBytes()) {
                    dataByte = node.getBytes();
                    dataIndex = BytesUtil.toIndex(dataByte);
                    dataString = BytesUtil.toDisplayHexString(dataByte);
                    indexPane.setText(dataIndex);
                    dataPane.setText(dataString);
                }
                try {
                    StyledDocument doc = dataPane.getStyledDocument();
                    doc.setCharacterAttributes(0, doc.getLength(), notSelected, true);
                    doc.setCharacterAttributes(offset, end - offset, selected, true);
                    dataPane.select(offset, end);//let auto scroll
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });
        JSplitPane split = new JSplitPane();
        split.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        split.setLeftComponent(new JScrollPane(messagePane));
        split.setRightComponent(new JScrollPane(packetTree));
        split.setDividerLocation(380);
        split.setBorder(null);
        this.add(split, BorderLayout.CENTER);
    }

    public void updateData(Packet packet) {
        if (packet != null) {
            try {
                packetTree.updateModel(packet);//must before editPane.setText or throw exception
                packetTree.setSelectionRow(0);
            } catch (Exception e) {
                packetTree.updateModel(null);
                e.printStackTrace();
            }
        } else {
            packetTree.updateModel(null);
            indexPane.setText("");
            indexPane.select(0, 0);
            dataPane.setText("");
            dataPane.select(0, 0);
        }
    }

}
