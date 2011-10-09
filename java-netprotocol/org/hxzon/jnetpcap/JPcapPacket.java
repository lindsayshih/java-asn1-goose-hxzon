package org.hxzon.jnetpcap;

import org.jnetpcap.PcapHeader;
import org.jnetpcap.nio.JBuffer;
import org.jnetpcap.packet.JHeader;
import org.jnetpcap.packet.PcapPacket;

public class JPcapPacket extends PcapPacket {
    private Class<? extends JHeader> clazz;

    public JPcapPacket(byte[] data, Class<? extends JHeader> clazz) {
        super(POINTER);
        PcapHeader pcapHeader = new PcapHeader();
        super.transferHeaderAndDataFrom(pcapHeader, new JBuffer(data));
//		super.getDefaultScanner().scan(this, Ethernet.ID);
        this.clazz = clazz;
    }

    public JPcapPacket(PcapPacket src, Class<? extends JHeader> clazz) {
        super(src);
        this.clazz = clazz;
    }

    public JPcapPacket(PcapPacket src) {
        super(src);
    }

    public Class<? extends JHeader> getType() {
        return clazz;
    }

    public byte[] getBytes() {
        byte[] data = new byte[this.size()];//size not getTotalSize
        this.transferTo(data);
        return data;
        //or
//		ByteBuffer buffer=ByteBuffer.allocate(this.getTotalSize());
//		this.transferTo(buffer);
//		buffer.flip();
//		byte[] data=new byte[buffer.remaining()];
//		buffer.get(data);
//		return data;
        //state and data(state and data must match when init)
//		byte[] data=new byte[this.getTotalSize()];
//		super.transferStateAndDataTo(data);
//		return data;
    }
}
