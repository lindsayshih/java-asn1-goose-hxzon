package org.hxzon.netprotocol.quick.common;

import java.util.List;

public interface QIPacket {

	public int getOffset();

	public void setOffset(int offset);

	public int getLen();

	public void setLen(int len);

	public String getDesc();

	public void setDesc(String desc);

	public List<QIProtocolField> getFields();

	public void setFields(List<QIProtocolField> fields);

	public void addField(QIProtocolField field);

	public QIPacket getPayload();

	public void setPayload(QIPacket payload);
}
