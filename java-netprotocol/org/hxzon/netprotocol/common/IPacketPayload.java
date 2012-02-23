package org.hxzon.netprotocol.common;

public interface IPacketPayload {

    public int getOffset();

//    public void setOffset(int offset);

    public int getLength();

//    public void setLength(int len);

    public byte[] getSrcData();

//    public void setSrcData(byte[] srcData);

    public byte[] getData();

    public IPacket getSrcPacket();

    public void setSrcPacket(IPacket srcPacket);

    public String getName();

    public String getProtocolTypeDesc();
}
