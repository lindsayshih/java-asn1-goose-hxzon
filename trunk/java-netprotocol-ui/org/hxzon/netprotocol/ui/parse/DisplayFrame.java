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

import org.hxzon.netprotocol.packet.CotpPacket;
import org.hxzon.netprotocol.packet.EthernetPacket;
import org.hxzon.netprotocol.packet.GoosePacket;
import org.hxzon.netprotocol.packet.Ip4Packet;
import org.hxzon.netprotocol.packet.OsiPresentationPacket;
import org.hxzon.netprotocol.packet.OsiSessionPacket;
import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.netprotocol.packet.SmvPacket;
import org.hxzon.netprotocol.packet.TcpPacket;
import org.hxzon.netprotocol.packet.TpktPacket;
import org.hxzon.netprotocol.packet.UdpPacket;
import org.hxzon.netprotocol.packet.VlanPacket;
import org.hxzon.pcap.PcapHandler;
import org.hxzon.ui.util.ListSelectionAction;
import org.hxzon.ui.util.UIUtil;

public class DisplayFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    static {
        new EthernetPacket();
        new VlanPacket();
        new GoosePacket();
        new SmvPacket();
        new Ip4Packet();
        new TcpPacket();
        new UdpPacket();
        new TpktPacket();
        new CotpPacket();
        new OsiSessionPacket();
        new OsiPresentationPacket();
    }
    private PacketTable packetsTable;
    private PacketDisplay packetDisplay;

    public DisplayFrame() {
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
                int option = chooser.showOpenDialog(DisplayFrame.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    filePath = chooser.getSelectedFile().getAbsolutePath();
                    prefs.put("openFile", filePath);
                    PcapHandler handler = new PcapHandler();
                    handler.addListener(new PacketHandlerListener(DisplayFrame.this));
                    handler.addFile(filePath);
                    handler.run();
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
                JFrame packageDisplay = new DisplayFrame();
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
