package org.hxzon.netprotocol.ui.statistics;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.hxzon.ui.util.UIUtil;

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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StatisticsPanel contentPane = new StatisticsPanel();
        this.add(contentPane, BorderLayout.CENTER);
        this.pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UIUtil.setupUILookAndFeel();
                JFrame packetStatistics = new StatisticsFrame();
                packetStatistics.setVisible(true);
            }
        });
    }

}
