package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.AlarmAckRule;
import org.hxzon.asn1.mms.common.Transitions;


public class DefineEventEnrollmentRequest extends BerSequence {
//	DefineEventEnrollment-Request ::= SEQUENCE
//	{
//	eventEnrollmentName		[0] ObjectName,
//	eventConditionName		[1] ObjectName,
//	eventConditionTransition	[2] IMPLICIT Transitions,
//	alarmAcknowledgementRule	[3] IMPLICIT AlarmAckRule,
//	eventActionName			[4] ObjectName OPTIONAL,
//	clientApplication		[5] ApplicationReference OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ObjectName().init("eventEnrollmentName", "eventEnrollmentName", tag, stream);
		case Tag.CONTEXT | 1:
			return new ObjectName().init("eventConditionName", "eventConditionName", tag, stream);
		case Tag.CONTEXT | 2:
			return new Transitions().init("eventConditionTransition", "eventConditionTransition", tag, stream);
		case Tag.CONTEXT | 3:
			return new AlarmAckRule().init("alarmAcknowledgementRule", "alarmAcknowledgementRule", tag, stream);
		case Tag.CONTEXT | 4:
			return new ObjectName().init("eventActionName", "eventActionName", tag, stream);
		case Tag.CONTEXT | 5:
			return new ApplicationReference().init("clientApplication", "clientApplication", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
