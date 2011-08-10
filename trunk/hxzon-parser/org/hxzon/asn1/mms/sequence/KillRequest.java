package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.common.Identifier;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class KillRequest extends BerSequence {
//	Kill-Request ::= SEQUENCE
//	{
//	programInvocationName	[0] IMPLICIT Identifier
//	}

	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new Identifier().init("programInvocationName", "programInvocationName", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
