package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;


public class InitiateResponsePdu extends BerSequence {
//	Initiate-ResponsePDU ::= SEQUENCE
//	{
//	localDetailCalled					[0] IMPLICIT Integer32 OPTIONAL,
//	negociatedMaxServOutstandingCalling	[1] IMPLICIT Integer16,
//	negociatedMaxServOutstandingCalled	[2] IMPLICIT Integer16,
//	negociatedDataStructureNestingLevel	[3] IMPLICIT Integer8 OPTIONAL,
//	mmsInitResponseDetail			[4] IMPLICIT InitResponseDetail
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerInteger32("localDetailCalling", "localDetailCalling", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerInteger16("negociatedMaxServOutstandingCalling", "negociatedMaxServOutstandingCalling", tag, stream);
		case Tag.CONTEXT | 2:
			return Asn1Utils.createBerInteger16("negociatedMaxServOutstandingCalled", "negociatedMaxServOutstandingCalled", tag, stream);
		case Tag.CONTEXT | 3:
			return Asn1Utils.createBerInteger8("negociatedDataStructureNestingLevel", "negociatedDataStructureNestingLevel", tag, stream);
		case Tag.CONTEXT | 4:
			return new InitResponseDetail().init("mmsInitResponseDetail", "mmsInitResponseDetail", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}
}
