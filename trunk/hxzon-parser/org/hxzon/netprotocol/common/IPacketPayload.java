package org.hxzon.netprotocol.common;

public interface IPacketPayload {
	public int getOffset();

	public int getLength();

	public void setSrcPacket(IPacket srcPacket);

	public byte[] getSrcData();

	public byte[] getData();

	public IPacket getSrcPacket();
}
