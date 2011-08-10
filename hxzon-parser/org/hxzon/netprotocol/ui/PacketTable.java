package org.hxzon.netprotocol.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.util.BytesUtil;

public class PacketTable extends JTable {
	private DisplayFrame display;

	public PacketTable(DisplayFrame display_) {
		super(new PacketTableModel());
		this.display = display_;
//		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.getSelectionModel().addListSelectionListener(new ListSelectionAction() {

			public void whenSelect(Object source, int i) {
				if (i == -1) {
					display.getPacketDisplay().updateData(null);
				} else {
					Packet packet = getModel().getPacket(i);
					display.getPacketDisplay().updateData(packet);
				}
//		                    	System.out.println(i);
			}

			public boolean selectOne() {
				return true;
			}
		});
	}

	public void addPacket(Packet packet) {
		this.getModel().addPacket(packet);
	}

	public void addPackets(List<Packet> packets) {
		this.getModel().addPackets(packets);
	}

	public void clearPackets() {
		this.getModel().clearPackets();
	}

	public PacketTableModel getModel() {
		return (PacketTableModel) super.getModel();
	}

	public static class PacketTableModel extends AbstractTableModel {
		private final List<Packet> packets = new ArrayList<Packet>();

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
				return rowIndex + 1;
			case 1:
				return packets.get(rowIndex).getLastPayloadType();
			default:
				return null;
			}
		}

		public Packet getPacket(int i) {
			return packets.get(i);
		}

		public void addPacket(Packet packet) {
			this.packets.add(packet);
			this.fireTableDataChanged();
		}

		public void addPackets(List<Packet> packets) {
			this.packets.addAll(packets);
			this.fireTableDataChanged();
		}

		public void clearPackets() {
			this.packets.clear();
			this.fireTableDataChanged();
		}

	}

	
}
