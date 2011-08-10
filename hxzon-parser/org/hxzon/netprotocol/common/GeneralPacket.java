package org.hxzon.netprotocol.common;

import java.util.List;

import org.hxzon.netprotocol.parse.ProtocolField;

public interface GeneralPacket extends GeneralPacketPayload {
	public int getOffset();

	public int getHeaderLength();

	public int getPayloadOffset();

	public int getPayloadLength();

	public List<ProtocolField> getHeaderFields();

	public void setSrcPacket(GeneralPacket srcPacket);

	public byte[] getSrcData();

	public byte[] getData();

	public GeneralPacket getSrcPacket();

	public GeneralPacketPayload getPayload();

	public GeneralPacket getLastPacket();
}
