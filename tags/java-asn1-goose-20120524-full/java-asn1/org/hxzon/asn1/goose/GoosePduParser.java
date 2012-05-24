package org.hxzon.asn1.goose;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.BerParser;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.util.BytesUtil;

public class GoosePduParser extends BerParser {

    public static final GoosePduParser parser = new GoosePduParser();

    protected GoosePduParser() {

    }

    @Override
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.APPLICATION | 1:
            return new GoosePdu().init("goose pdu", "goose pdu", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

    public BerNode parseGoose(byte[] data, int offset) {
        ByteArrayInputStream inStream = new ByteArrayInputStream(BytesUtil.copyBytes(data, offset));
        BerInputStream in = new BerInputStream(inStream);
        in.setTagOffset(offset);
        try {
            return super.readPacket(in);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
