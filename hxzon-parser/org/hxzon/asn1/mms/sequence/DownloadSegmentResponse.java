package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.BerChoice;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

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
