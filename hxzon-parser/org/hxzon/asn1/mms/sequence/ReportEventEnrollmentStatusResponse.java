package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.common.AlarmAckRule;
import org.hxzon.asn1.mms.common.EEDuration;
import org.hxzon.asn1.mms.common.EEState;
import org.hxzon.asn1.mms.common.Transitions;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class ReportEventEnrollmentStatusResponse extends BerSequence {
//	ReportEventEnrollmentStatus-Response ::= SEQUENCE
//	{
//	eventConditionTransitions	[0] IMPLICIT Transitions,
//	notificationLost		[1] IMPLICIT BOOLEAN DEFAULT FALSE,
//	duration			[2] IMPLICIT EE-Duration,
//	alarmAcknowledgmentRule		[3] IMPLICIT AlarmAckRule OPTIONAL,
//	currentState			[4] IMPLICIT EE-State
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new Transitions().init("eventConditionTransitions", "eventConditionTransitions", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerBoolean("notificationLost", "notificationLost", tag, stream);
		case Tag.CONTEXT | 2:
			return new EEDuration().init("duration", "duration", tag, stream);
		case Tag.CONTEXT | 3:
			return new AlarmAckRule().init("alarmAcknowledgmentRule", "alarmAcknowledgmentRule", tag, stream);
		case Tag.CONTEXT | 4:
			return new EEState().init("currentState", "currentState", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
