package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.BerVisibleString;
import com.chaosinmotion.asn1.Tag;

public class InitiateUploadSequenceResponse extends BerSequence {
//	InitiateUploadSequence-Response ::= SEQUENCE
//	{
//	ulsmID			[0] IMPLICIT Integer32,
//	listOfCapabilities	[1] IMPLICIT SEQUENCE OF VisibleString
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerInteger32("ulsmID", "ulsmID", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerSequenceOf("listOfCapabilities", "listOfCapabilities", tag, stream, BerVisibleString.class);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
