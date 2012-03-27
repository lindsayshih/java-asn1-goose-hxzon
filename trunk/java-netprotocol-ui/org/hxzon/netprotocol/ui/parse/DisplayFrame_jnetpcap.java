package org.hxzon.netprotocol.ui.parse;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.prefs.Preferences;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.netprotocol.parse.PacketUtils;
import org.hxzon.ui.util.ListSelectionAction;
import org.hxzon.ui.util.UIUtil;
import org.jnetpcap.Pcap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisplayFrame_jnetpcap extends JFrame {
    private static final Logger logger = LoggerFactory.getLogger(DisplayFrame_jnetpcap.class);
    private static final long serialVersionUID = 1L;
    static {
        PacketUtils.initPacket();
    }
    private PacketTable packetsTable;
    private PacketDisplay packetDisplay;

    public DisplayFrame_jnetpcap() {
        super("java-asn1-goose parser");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel toolBar = new JPanel();
        Action openFile = new AbstractAction("打开文件") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                Preferences prefs = Preferences.userNodeForPackage(this.getClass());
                String filePath = prefs.get("openFile", "");
                JFileChooser chooser = new JFileChooser(filePath);
                int option = chooser.showOpenDialog(DisplayFrame_jnetpcap.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    filePath = chooser.getSelectedFile().getAbsolutePath();
                    prefs.put("openFile", filePath);
                    StringBuilder errbuf = new StringBuilder();
                    Pcap pcap = Pcap.openOffline(filePath, errbuf);
                    if (pcap != null) {
                        new PacketHandler_jnetpcap(pcap, DisplayFrame_jnetpcap.this);
                    } else {
                        logger.error(errbuf.toString());
                    }
                }
            }

        };
        Action prePacket = new AbstractAction("样例") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                packetsTable.clearPackets();
                for (Packet packet : UIUtil.examplePackets) {
                    packetsTable.addPacket(packet);
                }
            }

        };
        toolBar.add(new JButton(openFile));
        toolBar.add(new JButton(prePacket));
        this.add(toolBar, BorderLayout.NORTH);
        JSplitPane contentPane = new JSplitPane();
        contentPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        packetsTable = new PacketTable();
        packetsTable.getSelectionModel().addListSelectionListener(new ListSelectionAction() {

            public void whenSelect(Object source, int i) {
                if (i == -1) {
                    packetDisplay.updateData(null);
                } else {
                    Packet packet = packetsTable.getModel().getPacket(i);
                    packetDisplay.updateData(packet);
                }
//		                    	System.out.println(i);
            }

            public boolean selectOne() {
                return true;
            }
        });

        contentPane.setTopComponent(new JScrollPane(packetsTable));
        packetDisplay = new PacketDisplay();
        contentPane.setBottomComponent((packetDisplay));
        this.add(contentPane, BorderLayout.CENTER);
        this.pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UIUtil.setupUILookAndFeel();
                JFrame packageDisplay = new DisplayFrame_jnetpcap();
                packageDisplay.setVisible(true);
            }
        });
    }

    public PacketTable getPacketsTable() {
        return packetsTable;
    }

    public PacketDisplay getPacketDisplay() {
        return packetDisplay;
    }

}
