package org.hxzon.demo.pcap.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.hxzon.demo.asn1.BytesUtils;
import org.hxzon.demo.pcap.packet.GoosePacket;
import org.hxzon.demo.pcap.packet.JPcapPacket;
import org.jnetpcap.packet.PcapPacket;

public class PacketTable extends JTable {
	private DisplayFrame display;

	public PacketTable(DisplayFrame display_) {
		super(new PacketTableModel());
		this.display = display_;
		addPacket(testPacket);
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int i = getSelectedRow();
				JPcapPacket packet = getModel().getPacket(i);
				display.getPacketDisplay().updateData(packet);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

		});
	}

	public void addPacket(JPcapPacket packet){
		this.getModel().addPacket(packet);
	}
	
	public void addPackets(List<JPcapPacket> packets){
		this.getModel().addPackets(packets);
	}
	
	public void clearPackets(){
		this.getModel().clearPackets();
	}
	
	public PacketTableModel getModel(){
		return (PacketTableModel)super.getModel();
	}

	public static class PacketTableModel extends AbstractTableModel {
		private final List<JPcapPacket> packets=new ArrayList<JPcapPacket>();

		public PacketTableModel() {
		}

		@Override
		public int getColumnCount() {
			return 2;
		}

		@Override
		public int getRowCount() {
			return packets.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch (columnIndex) {
			case 0:
				return rowIndex;
			case 1:
				return packets.get(rowIndex).getType().getSimpleName();
			default:
				return null;
			}
		}
		
		public JPcapPacket getPacket(int i){
			return packets.get(i);
		}
		
		public void addPacket(JPcapPacket packet){
			this.packets.add(packet);
			this.fireTableDataChanged();
		}
		
		public void addPackets(List<JPcapPacket> packets){
			this.packets.addAll(packets);
			this.fireTableDataChanged();
		}
		
		public void clearPackets(){
			this.packets.clear();
			this.fireTableDataChanged();
		}

	}
	public static String testGoose="01 0c cd 01 00 05 01 0c "
		+"cd 01 10 10 81 00 80 01 88 b8 00 05 00 e3 00 00 "
		+"00 00 61 81 d8 80 20 58 37 32 31 32 5f 32 4c 42 "
		+"31 5f 47 4f 50 52 4f 54 2f 4c 4c 4e 30 24 47 4f "
		+"24 67 6f 63 62 54 78 81 01 08 82 20 58 37 32 31 "
		+"32 5f 32 4c 42 31 5f 47 4f 50 52 4f 54 2f 4c 4c "
		+"4e 30 24 64 73 47 6f 6f 73 65 54 78 83 11 58 37 "
		+"32 31 32 5f 47 4f 4f 53 45 5f 54 58 5f 49 44 84 "
		+"08 00 00 00 00 00 00 00 00 85 01 04 86 01 00 87 "
		+"01 00 88 01 20 89 01 00 8a 01 20 ab 60 83 01 00 "
		+"84 01 00 83 01 00 84 01 00 83 01 00 84 01 00 83 "
		+"01 00 84 01 00 83 01 00 84 01 00 83 01 00 84 01 "
		+"00 83 01 00 84 01 00 83 01 00 84 01 00 83 01 00 "
		+"84 01 00 83 01 00 84 01 00 83 01 00 84 01 00 83 "
		+"01 00 84 01 00 83 01 00 84 01 00 83 01 00 84 01 "
		+"00 83 01 00 84 01 00 83 01 01 84 01 00 ";
	public static String testState="82 84 f5 48 13 32 0b 00 f5 00 00 00 f5 00 00 00 "
		+"00 00 00 00 00 00 00 00 02 00 00 00 00 00 00 00 "
		+"12 15 00 00 00 00 02 00 01 01 00 00 cc 0d 00 05 "
		+"cc 0d 10 10 81 00 00 00 81 00 00 00 00 00 00 00 "
		+"00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 "
		+"00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 "
		+"00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 "
		+"03 02 20 00 00 00 00 00 f5 00 00 00 04 00 00 00 "
		+"01 00 00 00 00 08 00 00 00 00 00 00 0e 00 00 00 "
		+"e7 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 "
		+"09 00 00 00 00 08 00 00 0e 00 00 00 04 00 00 00 "
		+"e3 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 "
		+"15 00 00 00 00 08 00 00 12 00 00 00 08 00 00 00 "
		+"db 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 "
		+"00 00 00 00 00 08 00 00 1a 00 00 00 db 00 00 00 "
		+"00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 "
		+"00 00 00 00 00 00 00 00 ";
	static JPcapPacket testPacket;
	static {
//		PcapPacket src = new PcapPacket(BytesUtils.hexStringToBytes(testState+testGoose));
//		testPacket = new JPcapPacket(src, GoosePacket.class);
		testPacket = new JPcapPacket(BytesUtils.hexStringToBytes(testGoose),GoosePacket.class);
	}
}
