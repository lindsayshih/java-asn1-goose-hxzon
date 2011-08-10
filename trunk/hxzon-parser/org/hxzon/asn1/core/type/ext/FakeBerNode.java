package org.hxzon.asn1.core.type.ext;

import java.io.IOException;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.BerOutputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.type.base.BerNode;


public abstract class FakeBerNode extends BerNode {

	protected FakeBerNode() {
		super(Tag.NoTag);
	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	protected void readValue(BerInputStream stream) {
		// do nothing
	}

	@Override
	public void writeElement(BerOutputStream stream) throws IOException {
		// do nothing
	}

	public String getType() {
		return "FakeBerNode";
	}

	public FakeBerNode setTagOffset(int tagOffset) {
		return (FakeBerNode) super.setTagOffset(tagOffset);
	}

	public FakeBerNode setTotalLen(int totalLen) {
		return (FakeBerNode) super.setTotalLen(totalLen);
	}

	public FakeBerNode setLenOffset(int lenOffset) {
		return (FakeBerNode) super.setLenOffset(lenOffset);
	}

	public FakeBerNode setValueOffset(int valueOffset) {
		return (FakeBerNode) super.setValueOffset(valueOffset);
	}
}
