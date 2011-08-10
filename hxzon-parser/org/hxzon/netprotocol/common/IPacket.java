package org.hxzon.netprotocol.common;

import java.util.List;

import org.hxzon.netprotocol.parse.ProtocolField;

public interface IPacket extends IPacketPayload {

	public int getHeaderLength();

	public int getPayloadOffset();

	public int getPayloadLength();

	public List<ProtocolField> getHeaderFields();

	public IPacket getSrcPacket();

	public IPacketPayload getPayload();

	public IPacket getLastPacket();

	public String getType();
}
