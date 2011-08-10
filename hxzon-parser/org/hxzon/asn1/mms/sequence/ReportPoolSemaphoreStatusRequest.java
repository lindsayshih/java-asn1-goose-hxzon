package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.Identifier;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class ReportPoolSemaphoreStatusRequest extends BerSequence {
//	ReportPoolSemaphoreStatus-Request ::= SEQUENCE
//	{
//	semaphoreName		[0] ObjectName,
//	nameToStartAfter	[1] IMPLICIT Identifier OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ObjectName().init("semaphoreName", "semaphoreName", tag, stream);
		case Tag.CONTEXT | 1:
			return new Identifier().init("nameToStartAfter", "nameToStartAfter", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
