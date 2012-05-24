package org.hxzon.asn1.osipresentation;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.BerParser;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.util.BytesUtil;

public class OsiPresentationParser extends BerParser {
    public static final OsiPresentationParser parser = new OsiPresentationParser();

    protected OsiPresentationParser() {

    }

    @Override
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.APPLICATION | 1:
            return new OsiPresentation().init("iso 8823 osi presentation", "iso 8823 osi presentation", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

    public BerNode parsePresentation(byte[] data, int offset) {
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
