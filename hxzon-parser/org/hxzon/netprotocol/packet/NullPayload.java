package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.common.IPacket;
import org.hxzon.netprotocol.common.IPacketPayload;

public class NullPayload implements IPacketPayload {

	IPacket srcPacket;

	@Override
	public byte[] getData() {
		return new byte[0];
	}

	@Override
	public int getLength() {
		return 0;
	}

	@Override
	public int getOffset() {
		return 0;
	}

	@Override
	public byte[] getSrcData() {
		return srcPacket.getSrcData();
	}

	@Override
	public IPacket getSrcPacket() {
		return srcPacket;
	}

	@Override
	public void setSrcPacket(IPacket srcPacket) {
		this.srcPacket = srcPacket;
	}

}
