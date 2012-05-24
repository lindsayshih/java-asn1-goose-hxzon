package org.hxzon.pcap;

import java.util.ArrayList;
import java.util.List;

import org.hxzon.util.BytesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PcapFile {
    private static final Logger logger = LoggerFactory.getLogger(PcapFile.class);
    public static final String Magic_Identical = "a1b2c3d4";// (identical)
    public static final String Magic_Swapped = "d4c3b2a1";// (swapped)
//	Pcap文件头24B各字段说明：
//	Magic：4B：0x1A 2B 3C 4D:用来标示文件的开始
//	Major：2B，0x02 00:当前文件主要的版本号     
//	Minor：2B，0x04 00当前文件次要的版本号
//	ThisZone：4B当地的标准时间；全零
//	SigFigs：4B时间戳的精度；全零
//	SnapLen：4B最大的存储长度    
//	LinkType：4B链路类型
    private boolean _reverse = false;
    private String _magic;
    private long _major;
    private long _minor;
    private long _thisZone;
    private long _sigFigs;
    private long _snapLen;
    private long _linkType;
    private byte[] _origHeaderBytes;
    private List<PcapPacket> _pcapPackets = new ArrayList<PcapPacket>();

    public void init(byte[] header) {
        this._origHeaderBytes = header;
        _magic = BytesUtil.toHexString(header, 0, 4);
        if (Magic_Swapped.equals(_magic)) {
            _reverse = true;
        }
        _major = BytesUtil.toUnsigned(header, 4, 2);
        _minor = BytesUtil.toUnsigned(header, 6, 2);
        _thisZone = BytesUtil.toUnsigned(header, 8, 4);
        _sigFigs = BytesUtil.toUnsigned(header, 12, 4);
        _snapLen = BytesUtil.toUnsigned(header, 16, 4);
        _linkType = BytesUtil.toUnsigned(header, 20, 4);
        logger.debug("magic:" + _magic);
    }

    public String getMagic() {
        return _magic;
    }

    public void setMagic(String magic) {
        this._magic = magic;
    }

    public long getMajor() {
        return _major;
    }

    public void setMajor(long major) {
        this._major = major;
    }

    public long getMinor() {
        return _minor;
    }

    public void setMinor(long minor) {
        this._minor = minor;
    }

    public long getThisZone() {
        return _thisZone;
    }

    public void setThisZone(long thisZone) {
        this._thisZone = thisZone;
    }

    public long getSigFigs() {
        return _sigFigs;
    }

    public void setSigFigs(long sigFigs) {
        this._sigFigs = sigFigs;
    }

    public long getSnapLen() {
        return _snapLen;
    }

    public void setSnapLen(long snapLen) {
        this._snapLen = snapLen;
    }

    public long getLinkType() {
        return _linkType;
    }

    public void setLinkType(long linkType) {
        this._linkType = linkType;
    }

    public List<PcapPacket> getPcapPackets() {
        return this._pcapPackets;
    }

    public void addPcapPacket(PcapPacket pcapPacket) {
        this._pcapPackets.add(pcapPacket);
    }

    public boolean isReverse() {
        return _reverse;
    }

}
