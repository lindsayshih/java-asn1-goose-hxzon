package org.hxzon.netprotocol.quick.common;

public interface QIProtocolField {

	public String getDesc();

	public void setDesc(String desc);

	public String getName();

	public void setName(String name);

	public int getOffset();

	public void setOffset(int offset);

	public int getLen();

	public void setLen(int len);
	
	public String getValueAsString();
}
