package org.hxzon.asn1.sv;

import java.util.ArrayList;
import java.util.List;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.type.BerOctetString;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.FakeBerConstruct;
import org.hxzon.asn1.core.type.ext.FakeBerNode;
import org.hxzon.util.BytesUtil;

public class Sv92AsduData extends BerOctetString implements FakeBerConstruct {
    public Sv92AsduData() {
        setName("asdu data");
        setDisplayString("asdu数据集");
    }

    private List<BerNode> fList;

    protected void readValue(BerInputStream stream) {
        super.readValue(stream);
        byte[] data = getValue();
        fList = new ArrayList<BerNode>(data.length / 4);
        FakeBerNode node;
        for (int i = 0; i < data.length; i += 8) {
            long value = BytesUtil.toSigned(data, i, 4);
            long quality = BytesUtil.toSigned(data, i + 4, 4);
            node = new Sv92AsduDataItem(value, quality);
            node.setTagOffset(super.getValueOffset() + i);
            node.setTotalLen(8);
            node.setName(String.valueOf(i / 8));
            node.setDisplayString(String.valueOf(i / 8));
            node.setParent(this);
            fList.add(node);
        }
    }

    public void updateDataDisplay(List<String> displays) {
        BerNode[] children = getChildren();
        int minIndex = Math.min(displays.size(), children.length);
        for (int i = 0; i < minIndex; i++) {
            children[i].setDisplayString(displays.get(i));
        }
    }

    @Override
    public BerNode[] getChildren() {
        return fList.toArray(new BerNode[fList.size()]);
    }

    public boolean remove(BerNode o) {
        return fList.remove(o);
    }

    public String getValueAsString() {
        return "";
    }

    public static class Sv92AsduDataItem extends FakeBerNode {

        private long value;
        private long quality;

        public Sv92AsduDataItem(long value, long quality) {
            this.value = value;
            this.quality = quality;
        }

        @Override
        public String getValueAsString() {
            return value + ",quality:" + quality;
        }

    }
}
