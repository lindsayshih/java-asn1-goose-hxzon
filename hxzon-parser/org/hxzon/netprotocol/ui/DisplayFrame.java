package org.hxzon.netprotocol.ui;

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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.netprotocol.packet.CotpPacket;
import org.hxzon.netprotocol.packet.EthernetPacket;
import org.hxzon.netprotocol.packet.GoosePacket;
import org.hxzon.netprotocol.packet.Ip4Packet;
import org.hxzon.netprotocol.packet.OsiPresentationPacket;
import org.hxzon.netprotocol.packet.OsiSessionPacket;
import org.hxzon.netprotocol.packet.SmvPacket;
import org.hxzon.netprotocol.packet.TcpPacket;
import org.hxzon.netprotocol.packet.TpktPacket;
import org.hxzon.netprotocol.packet.UdpPacket;
import org.hxzon.netprotocol.packet.VlanPacket;
import org.jnetpcap.Pcap;

public class DisplayFrame extends JFrame {
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
		Asn1Utils.setNotAddChoiceNode(true);
	}
	private PacketTable packetsTable;
	private PacketDisplay packetDisplay;

	public DisplayFrame() {
		JPanel toolBar = new JPanel();
		Action openFile = new AbstractAction("打开文件") {

			@Override
			public void actionPerformed(ActionEvent e) {
				Preferences prefs = Preferences.userNodeForPackage(this.getClass());
				String filePath = prefs.get("openFile", "");
				JFileChooser chooser = new JFileChooser(filePath);
				int option = chooser.showOpenDialog(DisplayFrame.this);
				if (option == JFileChooser.APPROVE_OPTION) {
					filePath = chooser.getSelectedFile().getAbsolutePath();
					prefs.put("openFile", filePath);
						StringBuilder errbuf = new StringBuilder();  
						Pcap pcap = Pcap.openOffline(filePath, errbuf);
						if(pcap!=null){
						new PackageHandler(pcap,DisplayFrame.this);
						}else{
							System.out.println(errbuf);
						}
				}
			}

		};
		toolBar.add(new JButton(openFile));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.add(toolBar,BorderLayout.NORTH);
		JSplitPane contentPane = new JSplitPane();
		contentPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		packetsTable = new PacketTable(this);

		contentPane.setTopComponent(new JScrollPane(packetsTable));
		packetDisplay = new PacketDisplay();
		contentPane.setBottomComponent((packetDisplay));
		this.add(contentPane,BorderLayout.CENTER);
		this.pack();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
