package org.hxzon.netprotocol.ui.statistics;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class StatisticsFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    static {
//        new EthernetPacket();
//        new VlanPacket();
//        new GoosePacket();
//        new SmvPacket();
//        new Ip4Packet();
//        new TcpPacket();
//        new UdpPacket();
//        new TpktPacket();
//        new CotpPacket();
//        new OsiSessionPacket();
//        new OsiPresentationPacket();
    }

    public StatisticsFrame() {
        super("java-asn1-goose statistics");
        StatisticsPanel contentPane = new StatisticsPanel();
        this.add(contentPane, BorderLayout.CENTER);
        this.pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                JFrame packetStatistics = new StatisticsFrame();
                packetStatistics.setVisible(true);
            }
        });
    }

}
