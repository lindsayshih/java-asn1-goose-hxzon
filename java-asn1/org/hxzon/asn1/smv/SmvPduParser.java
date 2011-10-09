package org.hxzon.asn1.smv;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.BerParser;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.util.BytesUtil;

public class SmvPduParser extends BerParser {
    protected SmvPduParser() {

    }

    public static final SmvPduParser parser = new SmvPduParser();

    @Override
    public BerNode create(int tag, BerInputStream stream, int state) {
        switch (tag) {
        case Tag.APPLICATION | 0:
            return new Smv92Pdu().init(tag, stream);
        case Tag.CONTEXT | 0:
            return new Smv91Pdu().init(tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

    public BerNode parseSmv(byte[] data, int offset) {
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
