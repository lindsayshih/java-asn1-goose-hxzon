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

import org.hxzon.asn1.core.parse.ext.Asn1Utils;
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
import org.hxzon.util.BytesUtil;

public class DisplayFrame2 extends JFrame {
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

	public DisplayFrame2() {
		JPanel toolBar = new JPanel();
		Action openFile = new AbstractAction("打开文件") {

			@Override
			public void actionPerformed(ActionEvent e) {
				Preferences prefs = Preferences.userNodeForPackage(this.getClass());
				String filePath = prefs.get("openFile", "");
				JFileChooser chooser = new JFileChooser(filePath);
				int option = chooser.showOpenDialog(DisplayFrame2.this);
				if (option == JFileChooser.APPROVE_OPTION) {
					filePath = chooser.getSelectedFile().getAbsolutePath();
					prefs.put("openFile", filePath);
					PcapHandler handler=new PcapHandler();
					handler.addListener(new PacketHandlerListener(DisplayFrame2.this));
					handler.readFile(filePath);
				}
			}

		};
		Action prePacket = new AbstractAction("样例") {

			@Override
			public void actionPerformed(ActionEvent e) {
				packetsTable.clearPackets();
				packetsTable.addPacket(new Packet(BytesUtil.fromHexString(testGoose)));
				packetsTable.addPacket(new Packet(BytesUtil.fromHexString(testSmv91)));
				packetsTable.addPacket(new Packet(BytesUtil.fromHexString(testSmv92)));
				packetsTable.addPacket(new Packet(BytesUtil.fromHexString(testMms1)));
				packetsTable.addPacket(new Packet(BytesUtil.fromHexString(testMms2)));
				packetsTable.addPacket(new Packet(BytesUtil.fromHexString(testError)));
				packetsTable.addPacket(new Packet(BytesUtil.fromHexString(testError2)));
			}

		};
		toolBar.add(new JButton(openFile));
		toolBar.add(new JButton(prePacket));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
				JFrame packageDisplay = new DisplayFrame2();
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

	public static String testGoose = "01 0c cd 01 00 05 01 0c " + "cd 01 10 10 81 00 80 01 88 b8 00 05 00 e3 00 00 " + "00 00 61 81 d8 80 20 58 37 32 31 32 5f 32 4c 42 "
			+ "31 5f 47 4f 50 52 4f 54 2f 4c 4c 4e 30 24 47 4f " + "24 67 6f 63 62 54 78 81 01 08 82 20 58 37 32 31 " + "32 5f 32 4c 42 31 5f 47 4f 50 52 4f 54 2f 4c 4c "
			+ "4e 30 24 64 73 47 6f 6f 73 65 54 78 83 11 58 37 " + "32 31 32 5f 47 4f 4f 53 45 5f 54 58 5f 49 44 84 " + "08 00 00 00 00 00 00 00 00 85 01 04 86 01 00 87 "
			+ "01 00 88 01 20 89 01 00 8a 01 20 ab 60 83 01 00 " + "84 01 00 83 01 00 84 01 00 83 01 00 84 01 00 83 " + "01 00 84 01 00 83 01 00 84 01 00 83 01 00 84 01 "
			+ "00 83 01 00 84 01 00 83 01 00 84 01 00 83 01 00 " + "84 01 00 83 01 00 84 01 00 83 01 00 84 01 00 83 " + "01 00 84 01 00 83 01 00 84 01 00 83 01 00 84 01 "
			+ "00 83 01 00 84 01 00 83 01 01 84 01 00 ";
	public static String testMms1 = "00 50 04 07 76 d6 00 0c 02 b0 89 3a 08 00 45 00"
			+ "00 9a 3d 63 90 21 40 06 db 58 ac 1e 04 02 ac 1e"//test fragment offset(13bits)//51 10=4368//2030=8240//9021=4129
			+ "05 64 00 66 05 6b 9c 41 29 05 dc 4f 5c b0 50 18" + "39 08 6d 60 00 00 03 00 00 72 02 f0 80 01 00 01"
			+ "00 61 65 30 63 02 01 03 a0 5e a3 5c a0 5a a1 05"//begin 61 65
			+ "80 03 52 50 54 a0 51 8a 19 46 37 31 34 4c 44 30" + "2f 4c 4c 4e 30 24 72 63 62 4d 65 61 73 46 6c 74" + "30 31 84 03 06 51 00 86 01 71 89 08 00 06 10 ae"
			+ "00 00 00 00 84 09 04 00 00 00 00 00 00 14 00 87" + "05 08 40 be 66 66 91 08 47 c2 7c 6e 17 4f c3 0a" + "84 02 02 40 84 02 02 40                        ";
	public static String testMms2 = "00 50 04 07 76 d6 00 0c 02 b0 89 3a 08 00 45 00" + "00 9a 3d 63 90 21 40 06 db 58 ac 1e 04 02 ac 1e"//test fragment offset(13bits)//51 10=4368//2030=8240//9021=4129
			+ "05 64 00 66 05 6b 9c 41 29 05 dc 4f 5c b0 50 18" + "39 08 6d 60 00 00 03 00 00 72 02 f0 80 01 00 01" + "00 " + "61 18 30 16 02 01 03 a0 11 a0 0f 02 02 01 5d"//mms begin a0 0f
			+ "a1 09 a0 03 80 01 09 a1 02 80 00               ";
	public static String testSmv91 = "01 0c cd 04 01 03 08 ac 7d 01 26 64 81 00 80 00 " + "88 ba 40 00 00 c5 00 00 00 00 80 81 ba 00 04 00 " + "2c 02 01 00 03 01 f4 01 f4 16 8e 0f a0 00 00 00 "
			+ "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " + "00 00 00 00 00 0f f0 40 1f 0e bf 64 00 00 2c 02 " + "01 00 03 01 f4 01 f4 16 8e 0f a0 00 00 00 00 00 "
			+ "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " + "00 00 00 0f f0 40 1f 0e c0 64 00 00 2c 02 01 00 " + "03 01 f4 01 f4 16 8e 0f a0 00 00 00 00 00 00 00 "
			+ "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " + "00 0f f0 40 1f 0e c1 64 00 00 2c 02 01 00 03 01 " + "f4 01 f4 16 8e 0f a0 00 00 00 00 00 00 00 00 00 "
			+ "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 0f " + "f0 40 1f 0e c2 64 00   ";
	public static String testSmv92 = "01 0c cd 04 00 01 00 1c 23 3d 00 7a 81 00 80 0a" + "88 ba 40 00 02 89 00 00 00 00 " + "60 82 02 7d 80 01" + "05 a2 82 02 76 30 7c 80 0b 64 6f 6e 67 66 61 6e"
			+ "67 73 6d 76 82 02 08 20 83 04 00 00 00 01 85 01" + "00 87 60 00 00 00 00 00 00 00 00 00 00 03 53 00" + "00 00 00 ff ff fc ad 00 00 00 00 00 00 00 00 00"
			+ "00 00 00 00 00 00 00 00 00 00 00 00 00 03 53 00" + "00 00 00 ff ff fc ad 00 00 00 00 00 00 00 00 00" + "00 00 00 00 00 37 a1 00 00 00 00 ff ff c8 5f 00"
			+ "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00" + "00 00 00 30 7c 80 0b 64 6f 6e 67 66 61 6e 67 73" + "6d 76 82 02 08 21 83 04 00 00 00 01 85 01 00 87"
			+ "60 00 00 00 4d 00 00 00 00 00 00 03 29 00 00 00" + "00 ff ff fc 8a 00 00 00 00 00 00 00 4d 00 00 00" + "00 00 00 00 4d 00 00 00 00 00 00 03 29 00 00 00"
			+ "00 ff ff fc 8a 00 00 00 00 00 00 05 0a 00 00 00" + "00 00 00 34 f0 00 00 00 00 ff ff c6 06 00 00 00" + "00 00 00 05 0a 00 00 00 00 00 00 05 0a 00 00 00"
			+ "00 30 7c 80 0b 64 6f 6e 67 66 61 6e 67 73 6d 76" + "82 02 08 22 83 04 00 00 00 01 85 01 00 87 60 00" + "00 00 9a 00 00 00 00 00 00 02 fb 00 00 00 00 ff"
			+ "ff fc 6b 00 00 00 00 00 00 00 9a 00 00 00 00 00" + "00 00 9a 00 00 00 00 00 00 02 fb 00 00 00 00 ff" + "ff fc 6b 00 00 00 00 00 00 0a 0c 00 00 00 00 00"
			+ "00 31 ec 00 00 00 00 ff ff c4 08 00 00 00 00 00" + "00 0a 0c 00 00 00 00 00 00 0a 0c 00 00 00 00 30" + "7c 80 0b 64 6f 6e 67 66 61 6e 67 73 6d 76 82 02"
			+ "08 23 83 04 00 00 00 01 85 01 00 87 60 00 00 00" + "e5 00 00 00 00 00 00 02 c8 00 00 00 00 ff ff fc" + "52 00 00 00 00 00 00 00 e5 00 00 00 00 00 00 00"
			+ "e5 00 00 00 00 00 00 02 c8 00 00 00 00 ff ff fc" + "52 00 00 00 00 00 00 0e ff 00 00 00 00 00 00 2e" + "98 00 00 00 00 ff ff c2 69 00 00 00 00 00 00 0e"
			+ "ff 00 00 00 00 00 00 0e ff 00 00 00 00 30 7c 80" + "0b 64 6f 6e 67 66 61 6e 67 73 6d 76 82 02 08 24" + "83 04 00 00 00 01 85 01 00 87 60 00 00 01 2f 00"
			+ "00 00 00 00 00 02 91 00 00 00 00 ff ff fc 3f 00" + "00 00 00 00 00 01 2f 00 00 00 00 00 00 01 2f 00" + "00 00 00 00 00 02 91 00 00 00 00 ff ff fc 3f 00"
			+ "00 00 00 00 00 13 da 00 00 00 00 00 00 2a fb 00" + "00 00 00 ff ff c1 2b 00 00 00 00 00 00 13 da 00" + "00 00 00 00 00 13 da 00 00 00 00               ";
	public static String testError = "00 50 04 07 76 d6 00 0c 02 b0 85 1c 08 00 45 00 " + "00 28 ae cf 00 00 40 06 6b 59 ac 1e 03 07 ac 1e " + "05 64 00 66 05 4a 52 4d f8 2c 53 2d 34 9a 50 10 "
			+ "39 08 3e 33 00 00 03 00 00 72 02 f0 ";
	public static String testError2 = "00 00 00 00 00 00 00 00";
}
