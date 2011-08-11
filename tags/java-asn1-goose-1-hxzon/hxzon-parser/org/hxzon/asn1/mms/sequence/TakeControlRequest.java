package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.Identifier;
import org.hxzon.asn1.mms.common.Priority;


public class TakeControlRequest extends BerSequence {
//	TakeControl-Request ::= SEQUENCE
//	{
//	semaphoreName			[0] ObjectName,
//	namedToken			[1] IMPLICIT Identifier OPTIONAL,
//	priority			[2] IMPLICIT Priority DEFAULT 64,
//	acceptableDelay			[3] IMPLICIT Unsigned32 OPTIONAL,
//	controlTimeOut			[4] IMPLICIT Unsigned32 OPTIONAL,
//	abortOnTimeOut			[5] IMPLICIT BOOLEAN OPTIONAL,
//	relinquishIfConnectionLost	[6] IMPLICIT BOOLEAN DEFAULT TRUE,
//	applicationToPreempt 		[7] IMPLICIT ApplicationReference OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ObjectName().init("semaphoreName", "semaphoreName", tag, stream);
		case Tag.CONTEXT | 1:
			return new Identifier().init("namedToken", "namedToken", tag, stream);
		case Tag.CONTEXT | 2:
			return new Priority().init("priority", "priority", tag, stream);
		case Tag.CONTEXT | 3:
			return Asn1Utils.createBerUnsigned32("acceptableDelay", "acceptableDelay", tag, stream);
		case Tag.CONTEXT | 4:
			return Asn1Utils.createBerUnsigned32("controlTimeOut", "controlTimeOut", tag, stream);
		case Tag.CONTEXT | 5:
			return Asn1Utils.createBerBoolean("abortOnTimeOut", "abortOnTimeOut", tag, stream);
		case Tag.CONTEXT | 6:
			return Asn1Utils.createBerBoolean("relinquishIfConnectionLost", "relinquishIfConnectionLost", tag, stream);
		case Tag.CONTEXT | 7:
			return new ApplicationReference().init("applicationToPreempt", "applicationToPreempt", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
