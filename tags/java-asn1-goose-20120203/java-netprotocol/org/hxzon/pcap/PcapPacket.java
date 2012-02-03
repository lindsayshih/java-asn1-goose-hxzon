package org.hxzon.pcap;

import org.hxzon.util.BytesUtil;

public class PcapPacket {
//	Timestamp：时间戳高位，精确到seconds     
//	Timestamp：时间戳低位，精确到microseconds
//	Caplen：当前数据区的长度，即抓取到的数据帧长度，由此可以得到下一个数据帧的位置。
//	Len：离线数据长度：网络中实际数据帧的长度，一般不大于caplen，多数情况下和Caplen数值相等。
    private long _seconds;
    private long _microSeconds;
    private long _capLen;
    private long _packetLen;
    private byte[] _packetData;
    private byte[] _origPcapPacketHeader;

    public void init(byte[] pcapPacketHeader, boolean reverse) {
        this._origPcapPacketHeader = pcapPacketHeader;
        if (reverse) {
            byte[] tmp = BytesUtil.reverse(pcapPacketHeader, 0, 4);
            _seconds = BytesUtil.toUnsigned(tmp);
            tmp = BytesUtil.reverse(pcapPacketHeader, 4, 4);
            _microSeconds = BytesUtil.toUnsigned(tmp);
            tmp = BytesUtil.reverse(pcapPacketHeader, 8, 4);
            _capLen = BytesUtil.toUnsigned(tmp);
            tmp = BytesUtil.reverse(pcapPacketHeader, 12, 4);
            _packetLen = BytesUtil.toUnsigned(tmp);
//			if (capLen < 0) {
//				capLen = BytesUtil.toUnsigned(pcapPacketHeader, 8, 4);
//			}
//			if (packetLen < 0) {
//				packetLen = BytesUtil.toUnsigned(pcapPacketHeader, 12, 4);
//			}
        } else {
            _seconds = BytesUtil.toUnsigned(pcapPacketHeader, 0, 4);
            _microSeconds = BytesUtil.toUnsigned(pcapPacketHeader, 4, 4);
            _capLen = BytesUtil.toUnsigned(pcapPacketHeader, 8, 4);
            _packetLen = BytesUtil.toUnsigned(pcapPacketHeader, 12, 4);
        }

    }

    public long getSeconds() {
        return _seconds;
    }

    public void setSeconds(long seconds) {
        this._seconds = seconds;
    }

    public long getMicroSeconds() {
        return _microSeconds;
    }

    public void setMicroSeconds(long microSeconds) {
        this._microSeconds = microSeconds;
    }

    public long getCapLen() {
        return _capLen;
    }

    public void setCapLen(long capLen) {
        this._capLen = capLen;
    }

    public long getPacketLen() {
        return _packetLen;
    }

    public void setPacketLen(long packetLen) {
        this._packetLen = packetLen;
    }

    public byte[] getPacketData() {
        return _packetData;
    }

    public void setPacketData(byte[] packetData) {
        this._packetData = packetData;
    }

}
