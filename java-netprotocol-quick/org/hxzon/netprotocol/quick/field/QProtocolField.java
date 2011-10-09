package org.hxzon.netprotocol.quick.field;

import org.hxzon.netprotocol.quick.common.QIProtocolField;

public abstract class QProtocolField implements QIProtocolField {
    private int offset;
    private int len;
    private String name;
    private String desc;

    public void init(int offset, int len, String name, String desc) {
        setOffset(offset);
        setLen(len);
        setName(name);
        setDesc(desc);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public abstract String getValueAsString();

}
