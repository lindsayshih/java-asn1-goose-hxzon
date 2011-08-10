package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.EventTime;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.AlarmAckRule;
import org.hxzon.asn1.mms.common.ECState;
import org.hxzon.asn1.mms.common.EEState;


public class AlarmEnrollmentSummary extends BerSequence {
//	AlarmEnrollmentSummary ::= SEQUENCE
//	{
//	eventEnrollmentName		[0] ObjectName,
//	clientApplication		[2] ApplicationReference OPTIONAL,
//	severity			[3] IMPLICIT Unsigned8,
//	currentState			[4] IMPLICIT EC-State,
//	notificationLost		[6] IMPLICIT BOOLEAN DEFAULT FALSE,
//	alarmAcknowledgmentRule		[7] IMPLICIT AlarmAckRule OPTIONAL,
//	enrollementState		[8] IMPLICIT EE-State OPTIONAL,
//	timeOfLastTransitionToActive	[9] EventTime OPTIONAL,
//	timeActiveAcknowledged		[10] EventTime OPTIONAL,
//	timeOfLastTransitionToIdle	[11] EventTime OPTIONAL,
//	timeIdleAcknowledged		[12] EventTime OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ObjectName().init("eventEnrollmentName", "eventEnrollmentName", tag, stream, true);
		case Tag.CONTEXT | 2:
			return new ApplicationReference().init("clientApplication", "clientApplication", tag, stream);
		case Tag.CONTEXT | 3:
			return Asn1Utils.createBerUnsigned8("severity", "severity", tag, stream);
		case Tag.CONTEXT | 4:
			return new ECState().init("currentState", "currentState", tag, stream);
		case Tag.CONTEXT | 6:
			return Asn1Utils.createBerBoolean("notificationLost", "notificationLost", tag, stream);
		case Tag.CONTEXT | 7:
			return new AlarmAckRule().init("alarmAcknowledgmentRule", "alarmAcknowledgmentRule", tag, stream);
		case Tag.CONTEXT | 8:
			return new EEState().init("enrollementState", "enrollementState", tag, stream);
		case Tag.CONTEXT | 9:
			return new EventTime().init("timeOfLastTransitionToActive", "timeOfLastTransitionToActive", tag, stream);
		case Tag.CONTEXT | 10:
			return new EventTime().init("timeActiveAcknowledged", "timeActiveAcknowledged", tag, stream);
		case Tag.CONTEXT | 11:
			return new EventTime().init("timeOfLastTransitionToIdle", "timeOfLastTransitionToIdle", tag, stream);
		case Tag.CONTEXT | 12:
			return new EventTime().init("timeIdleAcknowledged", "timeIdleAcknowledged", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
