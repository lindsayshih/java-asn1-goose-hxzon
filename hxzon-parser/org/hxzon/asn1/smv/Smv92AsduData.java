package org.hxzon.asn1.smv;

import java.util.ArrayList;
import java.util.List;

import org.hxzon.asn1.FakeBerConstruct;
import org.hxzon.asn1.FakeBerNode;
import org.hxzon.util.BytesUtil;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerOctetString;

public class Smv92AsduData extends BerOctetString implements FakeBerConstruct {
	public Smv92AsduData() {
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
			node = new Smv92AsduDataItem(value, quality);
			node.setTagOffset(super.getValueOffset() + i);
			node.setTotalLen(8);
			node.setName(String.valueOf(i / 8));
			node.setDisplayString(String.valueOf(i / 8));
			fList.add(node);
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

	public static class Smv92AsduDataItem extends FakeBerNode {

		private long value;
		private long quality;

		public Smv92AsduDataItem(long value, long quality) {
			this.value = value;
			this.quality = quality;
		}

		@Override
		public String getValueAsString() {
			return value + ",quality:" + quality;
		}

	}
}
