package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.AlarmAckRule;
import org.hxzon.asn1.mms.common.Transitions;


public class AlterEventEnrollmentRequest extends BerSequence {
//	AlterEventEnrollment-Request ::= SEQUENCE
//	{
//	eventEnrollmentName		[0] ObjectName,
//	eventConditionTransitions	[1] IMPLICIT Transitions OPTIONAL,
//	alarmAcknowledgmentRule		[2] IMPLICIT AlarmAckRule OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ObjectName().init("eventEnrollmentName", "eventEnrollmentName", tag, stream);
		case Tag.CONTEXT | 1:
			return new Transitions().init("eventConditionTransitions", "eventConditionTransitions", tag, stream);
		case Tag.CONTEXT | 2:
			return new AlarmAckRule().init("alarmAcknowledgmentRule", "alarmAcknowledgmentRule", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
