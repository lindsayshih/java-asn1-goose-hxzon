package org.hxzon.pcap;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import org.hxzon.util.DebugUtil;

public class PcapHandler {
	private List<PcapPacketListener> listeners = new ArrayList<PcapPacketListener>();

	public void addListener(PcapPacketListener listener) {
		listeners.add(listener);
	}

	public void fireListeners(PcapPacket pcapPacket) {
		for (PcapPacketListener listener : listeners) {
			listener.addPcapPacket(pcapPacket);
		}
	}

	public void readFile(String filepath) {
		long startTime = System.currentTimeMillis();
		try {
			RandomAccessFile file = new RandomAccessFile(filepath, "r");
			PcapFile pcapFile = new PcapFile();
			byte[] pcapFileHeader = new byte[24];
			file.read(pcapFileHeader);
			pcapFile.init(pcapFileHeader);
			long point = 0;
			while (file.read() != -1) {
				byte[] pcapPacketHeader = new byte[16];
				file.seek(file.getFilePointer() - 1);
				file.read(pcapPacketHeader);
				PcapPacket pcapPacket = new PcapPacket();
				pcapPacket.init(pcapPacketHeader, pcapFile.isReverse());
				point = file.getFilePointer();
//				logger.debug("capLen:"+capLen+",packetLen:"+packetLen);
				byte[] packetData = new byte[(int)Math.min(pcapPacket.getCapLen(), pcapPacket.getPacketLen())];
				file.read(packetData);
				pcapPacket.setPacketData(packetData);
				pcapFile.addPcapPacket(pcapPacket);
				fireListeners(pcapPacket);
				file.seek(point + pcapPacket.getCapLen());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		long spanTime = endTime - startTime;
		DebugUtil.debug("packet handler-span time:" + spanTime);
	}
}
