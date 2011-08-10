package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerInteger;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.ObjectName;


public class ReportSemaphoreEntryStatusRequest extends BerSequence {
//	ReportSemaphoreEntryStatus-Request ::=SEQUENCE
//	{
//	semaphoreName		[0] ObjectName,
//	state			[1] IMPLICIT INTEGER
//		{
//		queued	(0),
//		owner	(1),
//		hung	(2)
//		} ,
//	entryIdToStartAfter	[2] IMPLICIT OCTET STRING OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ObjectName().init("semaphoreName", "semaphoreName", tag, stream);
		case Tag.CONTEXT | 1:
			return new State().init("state", "state", tag, stream);
		case Tag.CONTEXT | 2:
			return Asn1Utils.createBerOctetString("entryIdToStartAfter", "entryIdToStartAfter", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

	public static class State extends BerInteger {

	}

}
