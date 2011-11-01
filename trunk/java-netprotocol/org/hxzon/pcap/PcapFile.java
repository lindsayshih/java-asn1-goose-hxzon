package org.hxzon.pcap;

import java.util.ArrayList;
import java.util.List;

import org.hxzon.util.BytesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PcapFile {
    private static final Logger logger = LoggerFactory.getLogger(PcapFile.class);
    public static final String identical = "a1b2c3d4";// (identical)
    public static final String swapped = "d4c3b2a1";// (swapped)
//	Pcap文件头24B各字段说明：
//	Magic：4B：0x1A 2B 3C 4D:用来标示文件的开始
//	Major：2B，0x02 00:当前文件主要的版本号     
//	Minor：2B，0x04 00当前文件次要的版本号
//	ThisZone：4B当地的标准时间；全零
//	SigFigs：4B时间戳的精度；全零
//	SnapLen：4B最大的存储长度    
//	LinkType：4B链路类型
    private boolean reverse = false;
    private String magic;
    private long major;
    private long minor;
    private long thisZome;
    private long sigFigs;
    private long snapLen;
    private long linkType;
    private byte[] origHeaderBytes;
    private List<PcapPacket> pcapPackets = new ArrayList<PcapPacket>();

    public void init(byte[] header) {
        this.origHeaderBytes = header;
        magic = BytesUtil.toHexString(header, 0, 4);
        if (swapped.equals(magic)) {
            reverse = true;
        }
        major = BytesUtil.toUnsigned(header, 4, 2);
        minor = BytesUtil.toUnsigned(header, 6, 2);
        thisZome = BytesUtil.toUnsigned(header, 8, 4);
        sigFigs = BytesUtil.toUnsigned(header, 12, 4);
        snapLen = BytesUtil.toUnsigned(header, 16, 4);
        linkType = BytesUtil.toUnsigned(header, 20, 4);
        logger.debug("magic:" + magic);
    }

    public String getMagic() {
        return magic;
    }

    public void setMagic(String magic) {
        this.magic = magic;
    }

    public long getMajor() {
        return major;
    }

    public void setMajor(long major) {
        this.major = major;
    }

    public long getMinor() {
        return minor;
    }

    public void setMinor(long minor) {
        this.minor = minor;
    }

    public long getThisZone() {
        return thisZome;
    }

    public void setThisZone(long thisZone) {
        this.thisZome = thisZone;
    }

    public long getSigFigs() {
        return sigFigs;
    }

    public void setSigFigs(long sigFigs) {
        this.sigFigs = sigFigs;
    }

    public long getSnapLen() {
        return snapLen;
    }

    public void setSnapLen(long snapLen) {
        this.snapLen = snapLen;
    }

    public long getLinkType() {
        return linkType;
    }

    public void setLinkType(long linkType) {
        this.linkType = linkType;
    }

    public List<PcapPacket> getPcapPackets() {
        return this.pcapPackets;
    }

    public void addPcapPacket(PcapPacket pcapPacket) {
        this.pcapPackets.add(pcapPacket);
    }

    public boolean isReverse() {
        return reverse;
    }

}
