package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerInteger;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class ReportSemaphoreStatusResponse extends BerSequence {
//	ReportSemaphoreStatus-Response ::= SEQUENCE
//	{
//	mmsDeletable		[0] IMPLICIT BOOLEAN,
//	class			[1] IMPLICIT INTEGER
//		{
//		token 	(0),
//		pool   	(1)
//		},
//	numberOfTokens		[2] IMPLICIT Unsigned16,
//	numberOfOwnedTokens 	[3] IMPLICIT Unsigned16,
//	numberOfHungTokens	[4] IMPLICIT Unsigned16
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerBoolean("mmsDeletable", "mmsDeletable", tag, stream);
		case Tag.CONTEXT | 1:
			return new ReportSemaphoreStatusResponseClazz().init("class", "class", tag, stream);
		case Tag.CONTEXT | 2:
			return Asn1Utils.createBerUnsignedInteger("numberOfTokens", "numberOfTokens", tag, stream);
		case Tag.CONTEXT | 3:
			return Asn1Utils.createBerUnsignedInteger("numberOfOwnedTokens", "numberOfOwnedTokens", tag, stream);
		case Tag.CONTEXT | 4:
			return Asn1Utils.createBerUnsignedInteger("numberOfHungTokens", "numberOfHungTokens", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

	public static class ReportSemaphoreStatusResponseClazz extends BerInteger {

	}

}
