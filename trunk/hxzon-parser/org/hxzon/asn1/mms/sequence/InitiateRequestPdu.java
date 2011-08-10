package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;


public class InitiateRequestPdu extends BerSequence {
//	Initiate-RequestPDU ::= SEQUENCE
//	{
//	localDetailCalling	        		[0] IMPLICIT Integer32 OPTIONAL,
//	proposedMaxServOutstandingCalling	[1] IMPLICIT Integer16,
//	proposedMaxServOutstandingCalled	[2] IMPLICIT Integer16,
//	proposedDataStructureNestingLevel	[3] IMPLICIT Integer8 OPTIONAL,
//	mmsInitRequestDetail				[4] IMPLICIT InitRequestDetail
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerInteger32("localDetailCalling", "localDetailCalling", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerInteger16("proposedMaxServOutstandingCalling", "proposedMaxServOutstandingCalling", tag, stream);
		case Tag.CONTEXT | 2:
			return Asn1Utils.createBerInteger16("proposedMaxServOutstandingCalled", "proposedMaxServOutstandingCalled", tag, stream);
		case Tag.CONTEXT | 3:
			return Asn1Utils.createBerInteger8("proposedDataStructureNestingLevel", "proposedDataStructureNestingLevel", tag, stream);
		case Tag.CONTEXT | 4:
			return new InitRequestDetail().init("mmsInitRequestDetail", "mmsInitRequestDetail", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
