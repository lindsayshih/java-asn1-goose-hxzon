package org.hxzon.asn1.smv;

import java.util.ArrayList;
import java.util.List;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.FakeBerConstruct;
import org.hxzon.netprotocol.common.GeneralPacket;
import org.hxzon.netprotocol.common.GeneralPacketPayload;
import org.hxzon.util.BytesUtil;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerOctetString;

public class Smv91Pdu extends BerOctetString implements FakeBerConstruct, GeneralPacketPayload {
	public Smv91Pdu() {
		setName("smv9-1");
		setDisplayString("9-1采样值");
	}

	private List<BerNode> fList;

	protected void readValue(BerInputStream stream) {
		super.readValue(stream);
		byte[] value = getValue();
		int asduNum = BytesUtil.toInt(value, 0, 2);
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

	private GeneralPacket srcPacket;

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
	public GeneralPacket getSrcPacket() {
		return srcPacket;
	}

	@Override
	public void setSrcPacket(GeneralPacket srcPacket) {
		this.srcPacket = srcPacket;
	}

}
