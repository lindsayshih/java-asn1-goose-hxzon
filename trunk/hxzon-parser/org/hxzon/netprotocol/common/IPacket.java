package org.hxzon.netprotocol.common;

import java.util.List;

import org.hxzon.netprotocol.parse.ProtocolField;

public interface IPacket extends IPacketPayload {
	public int getOffset();

	public int getHeaderLength();

	public int getPayloadOffset();

	public int getPayloadLength();

	public List<ProtocolField> getHeaderFields();

	public void setSrcPacket(IPacket srcPacket);

	public byte[] getSrcData();

	public byte[] getData();

	public IPacket getSrcPacket();

	public IPacketPayload getPayload();

	public IPacket getLastPacket();
}
