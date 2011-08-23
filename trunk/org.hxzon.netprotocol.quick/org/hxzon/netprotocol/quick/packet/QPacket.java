package org.hxzon.netprotocol.quick.packet;

import java.util.ArrayList;
import java.util.List;

import org.hxzon.netprotocol.quick.common.QIPacket;
import org.hxzon.netprotocol.quick.common.QIProtocolField;

public class QPacket implements QIPacket {
	private int offset;
	private int len;
	private String desc;
	private List<QIProtocolField> fields;
	private QIPacket payload;

	public void addField(QIProtocolField field) {
		if (fields == null) {
			fields = new ArrayList<QIProtocolField>();
		}
		fields.add(field);
	}

	public String defaultDesc() {
		return "";
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public String getDesc() {
		if (desc == null) {
			return defaultDesc();
		}
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<QIProtocolField> getFields() {
		return fields;
	}

	public void setFields(List<QIProtocolField> fields) {
		this.fields = fields;
	}

	public QIPacket getPayload() {
		return payload;
	}

	public void setPayload(QIPacket payload) {
		this.payload = payload;
	}

}
