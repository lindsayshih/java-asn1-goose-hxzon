package org.hxzon.asn1.sv;

import java.util.ArrayList;
import java.util.List;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerOctetString;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.FakeBerConstruct;
import org.hxzon.util.BytesUtil;

public class Sv91Pdu extends BerOctetString implements FakeBerConstruct {
    public Sv91Pdu() {
        setId("smv9-1");
        setName("9-1采样值");
    }

    private List<BerNode> fList;

    protected void readValue(BerInputStream stream) {
        super.readValue(stream);
        byte[] value = getValue();
        int asduNum = (int) BytesUtil.toSigned(value, 0, 2);
        fList = new ArrayList<BerNode>(asduNum + 1);
        BerNode numberOfAsdu = Asn1Utils.createFakeBerInteger("number of asdu", "asdu条目数", asduNum, this.getValueOffset() + 0, 2);
        fList.add(numberOfAsdu);
        for (int i = 0; i < asduNum; i++) {
            BerNode node = new Sv91Asdu(this, 2 + i * 46);
            fList.add(node);
        }
    }

    public String getValueAsString() {
//		return "number of asdu:" + numberOfAsdu;
        return "";
    }

    @Override
    public BerNode[] getChildren() {
        return fList.toArray(new BerNode[fList.size()]);
    }

    public boolean remove(BerNode o) {
        return fList.remove(o);
    }

}
