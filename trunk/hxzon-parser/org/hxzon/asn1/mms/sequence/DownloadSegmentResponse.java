package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;

public class DownloadSegmentResponse extends BerSequence {
//	DownloadSegment-Response ::= SEQUENCE
//	{
//	loadData	CHOICE {
//	   non-coded		[0] IMPLICIT OCTET STRING,
//	   coded		EXTERNALt
//	   },
//	moreFollows	[1] IMPLICIT BOOLEAN DEFAULT TRUE
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 1:
            return Asn1Utils.createBerBoolean("moreFollows", "moreFollows", tag, stream);
        default:
            return new LoadData().init("loadData", "loadData", tag, stream, false);
        }
    }

    public static class LoadData extends BerChoice {
        public BerNode create(int tag, BerInputStream stream) {
            switch (tag) {
            case Tag.CONTEXT | 0:
                return Asn1Utils.createBerOctetString("non-coded", "non-coded", tag, stream);
            default:
                //TODO
                return Asn1Utils.createUnknown(tag, stream);
            }
        }
    }

}
