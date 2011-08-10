package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class ConfirmedErrorPdu extends BerSequence {
	public ConfirmedErrorPdu() {
	}

//	Confirmed-ErrorPDU ::= SEQUENCE 
//	{
//	invokeID 			[0]	IMPLICIT Unsigned32,
//	modifierPosition	[1]	IMPLICIT Unsigned32 OPTIONAL,
//	serviceError		[2]	IMPLICIT ServiceError
//	}

	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerUnsignedInteger("invokeID", "invokeID", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerUnsignedInteger("modifierPosition", "modifierPosition", tag, stream);
		case Tag.CONTEXT | 2:
			return new ServiceError().init("serviceError", "serviceError", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
