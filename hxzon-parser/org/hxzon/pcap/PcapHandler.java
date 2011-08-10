package org.hxzon.pcap;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import org.hxzon.util.BytesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PcapHandler {
	private static final Logger logger = LoggerFactory.getLogger(PcapHandler.class);
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
//				byte[] second=new byte[4];
//				byte[] microSecond=new byte[4];
//				byte[] capLen=new byte[4];
//				byte[] packetLen=new byte[4];
				byte[] tmp = new byte[4];
				file.seek(file.getFilePointer() - 1);
				file.read(tmp);
				file.read(tmp);
//				int seconds = file.readInt();
//				int microSeconds = file.readInt();
				file.read(tmp);
				if (pcapFile.isReverse()) {
					tmp = BytesUtil.reverse(tmp, 0, 4);
				}
				int capLen = (int) BytesUtil.toUnsigned(tmp, 0, 4);
				file.read(tmp);
				if (pcapFile.isReverse()) {
					tmp = BytesUtil.reverse(tmp, 0, 4);
				}
				int packetLen = (int) BytesUtil.toUnsigned(tmp, 0, 4);
				point = file.getFilePointer();
//				logger.debug("capLen:"+capLen+",packetLen:"+packetLen);
				byte[] packetData = new byte[packetLen];
				file.read(packetData);
				PcapPacket pcapPacket = new PcapPacket();
//				pcapPacket.setSeconds(seconds);
//				pcapPacket.setMicroSeconds(microSeconds);
				pcapPacket.setCapLen(capLen);
				pcapPacket.setPacketLen(packetLen);
				pcapPacket.setPacketData(packetData);
				pcapFile.addPcapPacket(pcapPacket);
				fireListeners(pcapPacket);
				file.seek(point + capLen);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		long spanTime = endTime - startTime;
		logger.debug("packet handler-span time:" + spanTime);
	}
}
