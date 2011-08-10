package org.hxzon.demo.pcap.ui;

import java.awt.event.ActionEvent;
import java.util.prefs.Preferences;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jnetpcap.Pcap;

public class DisplayFrame extends JFrame {

	private PacketTable packetsTable;
	private PacketDisplay packetDisplay;

	public DisplayFrame() {
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
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
		this.add(toolBar);
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		packetsTable = new PacketTable(this);

		contentPane.add(new JScrollPane(packetsTable));
		packetDisplay = new PacketDisplay();
		contentPane.add((packetDisplay));//new JScrollPane
		this.add(contentPane);
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
