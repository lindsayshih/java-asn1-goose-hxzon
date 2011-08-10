package org.hxzon.asn1.smv;

import java.util.ArrayList;
import java.util.List;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerOctetString;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.FakeBerConstruct;
import org.hxzon.netprotocol.common.IPacket;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.util.BytesUtil;


public class Smv91Pdu extends BerOctetString implements FakeBerConstruct, IPacketPayload {
	public Smv91Pdu() {
		setName("smv9-1");
		setDisplayString("9-1采样值");
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
			BerNode node = new Smv91Asdu(this, 2 + i * 46);
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

	private IPacket srcPacket;

	@Override
	public byte[] getData() {
		return BytesUtil.copyBytes(getSrcData(), getOffset(), getLength());
	}

	@Override
	public int getLength() {
		return this.getTotalLen();
	}

	@Override
	public int getOffset() {
		return this.getTagOffset();
	}

	@Override
	public byte[] getSrcData() {
		return this.srcPacket.getSrcData();
	}

	@Override
	public IPacket getSrcPacket() {
		return srcPacket;
	}

	@Override
	public void setSrcPacket(IPacket srcPacket) {
		this.srcPacket = srcPacket;
	}
	
	public String getType(){
		return "9-1采样值";
	}

}
