package org.hxzon.asn1;

public class FakeBerInteger extends FakeBerNode {

	private long value;

	public FakeBerInteger(long value) {
		this.value = value;
	}

	public long getValue() {
		return value;
	}

	public String getValueAsString() {
		return String.valueOf(getValue());
	}

	@Override
	public String getType() {
		return "FakeBerInteger";
	}

}
