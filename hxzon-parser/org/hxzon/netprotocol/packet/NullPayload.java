package org.hxzon.netprotocol.packet;

import org.hxzon.netprotocol.common.GeneralPacket;
import org.hxzon.netprotocol.common.GeneralPacketPayload;

public class NullPayload implements GeneralPacketPayload {

	GeneralPacket srcPacket;

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
	public GeneralPacket getSrcPacket() {
		return srcPacket;
	}

	@Override
	public void setSrcPacket(GeneralPacket srcPacket) {
		this.srcPacket = srcPacket;
	}

}
