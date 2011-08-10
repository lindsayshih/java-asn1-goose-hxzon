package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.ObjectName;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class DefineSemaphoreRequest extends BerSequence {
//	DefineSemaphore-Request ::= SEQUENCE
//	{
//	semaphoreName		[0] ObjectName,
//	numbersOfTokens		[1] IMPLICIT Unsigned16
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ObjectName().init("semaphoreName", "semaphoreName", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerUnsignedInteger("numbersOfTokens", "numbersOfTokens", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
