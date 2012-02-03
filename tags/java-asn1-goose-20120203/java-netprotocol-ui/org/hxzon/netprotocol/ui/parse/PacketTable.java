package org.hxzon.netprotocol.ui.parse;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import org.hxzon.netprotocol.packet.Packet;

public class PacketTable extends JTable {

    private static final long serialVersionUID = 1L;

    public PacketTable() {
        super(new PacketTableModel());
//		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
        private static final long serialVersionUID = 1L;
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
