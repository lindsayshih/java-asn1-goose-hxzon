package org.hxzon.netprotocol.payload;

import org.hxzon.netprotocol.common.IPacket;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.util.BytesUtil;

public class DataPayload implements IPacketPayload {
	private byte[] srcData;
	private int offset;
	private IPacket srcPacket;
	private boolean miss;

	@Override
	public byte[] getData() {
		return BytesUtil.copyBytes(srcData, offset, getLength());
	}

	@Override
	public int getLength() {
		return srcData.length - offset;
	}

	@Override
	public int getOffset() {
		return offset;
	}

	@Override
	public byte[] getSrcData() {
		return srcData;
	}

	@Override
	public IPacket getSrcPacket() {
		return srcPacket;
	}

	@Override
	public void setSrcPacket(IPacket srcPacket) {
		this.srcPacket = srcPacket;
		this.srcData = srcPacket.getSrcData();
		this.offset = srcPacket.getOffset() + srcPacket.getHeaderLength();
	}

	public String getDisplayString() {
		return "user data";
	}

	public String getType() {
		return "user data";
	}

}
