package org.hxzon.pcap;

public class PcapPacket {
//	Timestamp：时间戳高位，精确到seconds     
//	Timestamp：时间戳低位，精确到microseconds
//	Caplen：当前数据区的长度，即抓取到的数据帧长度，由此可以得到下一个数据帧的位置。
//	Len：离线数据长度：网络中实际数据帧的长度，一般不大于caplen，多数情况下和Caplen数值相等。
	private long seconds;
	private long microSeconds;
	private long capLen;
	private long packetLen;
	private byte[] packetData;

	public long getSeconds() {
		return seconds;
	}

	public void setSeconds(long seconds) {
		this.seconds = seconds;
	}

	public long getMicroSeconds() {
		return microSeconds;
	}

	public void setMicroSeconds(long microSeconds) {
		this.microSeconds = microSeconds;
	}

	public long getCapLen() {
		return capLen;
	}

	public void setCapLen(long capLen) {
		this.capLen = capLen;
	}

	public long getPacketLen() {
		return packetLen;
	}

	public void setPacketLen(long packetLen) {
		this.packetLen = packetLen;
	}

	public byte[] getPacketData() {
		return packetData;
	}

	public void setPacketData(byte[] packetData) {
		this.packetData = packetData;
	}

}
