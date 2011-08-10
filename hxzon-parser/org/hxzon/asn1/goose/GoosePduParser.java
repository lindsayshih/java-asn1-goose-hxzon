package org.hxzon.asn1.goose;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.util.BytesUtil;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerParser;
import com.chaosinmotion.asn1.Tag;

public class GoosePduParser extends BerParser {

	public static final GoosePduParser parser = new GoosePduParser();

	protected GoosePduParser() {

	}

	@Override
	public BerNode create(int tag, BerInputStream stream, int state) {
		switch (tag) {
		case Tag.APPLICATION | 1:
			return new GoosePdu().init("goose pdu", "goose pdu", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

	public GoosePdu parseGoose(byte[] data, int offset) {
		ByteArrayInputStream inStream = new ByteArrayInputStream(BytesUtil.copyBytes(data, offset));
		BerInputStream in = new BerInputStream(inStream);
		in.setTagOffset(offset);
		try {
			return (GoosePdu) super.readPacket(in);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
