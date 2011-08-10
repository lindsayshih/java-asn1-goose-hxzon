package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.common.GeneralPacket;
import org.hxzon.netprotocol.common.GeneralPacketPayload;
import org.hxzon.util.BytesUtil;

public class UnknownPayload implements GeneralPacketPayload {
	private byte[] srcData;
	private int offset;
	private int length;
	private GeneralPacket srcPacket;

	public String toString() {
		return "payload";
	}

	@Override
	public byte[] getData() {
		return BytesUtil.copyBytes(srcData, offset, length);
	}

	@Override
	public int getLength() {
		return length;
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
	public GeneralPacket getSrcPacket() {
		return srcPacket;
	}

	@Override
	public void setSrcPacket(GeneralPacket srcPacket) {
		this.srcPacket = srcPacket;
		this.srcData = srcPacket.getSrcData();
		this.offset = srcPacket.getOffset() + srcPacket.getHeaderLength();
		this.length = this.srcData.length - this.offset;

	}
}
