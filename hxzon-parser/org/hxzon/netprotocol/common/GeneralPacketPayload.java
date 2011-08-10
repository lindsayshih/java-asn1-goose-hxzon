package org.hxzon.netprotocol.common;

public interface GeneralPacketPayload {
	public int getOffset();

	public int getLength();

	public void setSrcPacket(GeneralPacket srcPacket);

	public byte[] getSrcData();

	public byte[] getData();

	public GeneralPacket getSrcPacket();
}
