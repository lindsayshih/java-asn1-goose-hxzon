package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.ConfirmedServiceResponse;
import org.hxzon.asn1.mms.choice.EventConditionName;
import org.hxzon.asn1.mms.choice.EventTime;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.AlarmAckRule;
import org.hxzon.asn1.mms.common.ECState;

public class EventNotification extends BerSequence {
    public EventNotification() {
        setName("eventNotification");
        setDisplayString("eventNotification");
    }

//	EventNotification ::= SEQUENCE
//	{
//	eventEnrollmentName		[0] ObjectName,
//	eventConditionName		[1] CHOICE
//		{
//		eventCondition			[0] ObjectName,
//		undefined			[1] IMPLICIT NULL
//		},
//	severity			[2] IMPLICIT Unsigned8,
//	currentState			[3] IMPLICIT EC-State OPTIONAL,
//	transitionTime			[4] EventTime,
//	notificationLost		[6] IMPLICIT BOOLEAN DEFAULT FALSE,
//	alarmAcknowledgmentRule		[7] IMPLICIT AlarmAckRule OPTIONAL,
//	actionResult			[8] IMPLICIT SEQUENCE
//		{
//		eventActioName			ObjectName,
//		eventActionResult		CHOICE
//			{
//			success			[0] ConfirmedServiceResponse,
//			failure			[1] IMPLICIT ServiceError
//			}
//		} OPTIONAL
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new ObjectName().init("eventEnrollmentName", "eventEnrollmentName", tag, stream, true);
        case Tag.CONTEXT | 1:
            return new EventConditionName().init("eventConditionName", "eventConditionName", tag, stream, true);
        case Tag.CONTEXT | 2:
            return Asn1Utils.createBerUnsigned8("severity", "severity", tag, stream);
        case Tag.CONTEXT | 3:
            return new ECState().init("currentState", "currentState", tag, stream);
        case Tag.CONTEXT | 4:
            return new EventTime().init("transitionTime", "transitionTime", tag, stream);
        case Tag.CONTEXT | 6:
            return Asn1Utils.createBerBoolean("notificationLost", "notificationLost", tag, stream);
        case Tag.CONTEXT | 7:
            return new AlarmAckRule().init("alarmAcknowledgmentRule", "alarmAcknowledgmentRule", tag, stream);
        case Tag.CONTEXT | 8:
            return new ActionResult().init("actionResult", "actionResult", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

    public static class ActionResult extends BerSequence {
//		actionResult			[8] IMPLICIT SEQUENCE
//		{
//		eventActioName			ObjectName,
//		eventActionResult		CHOICE
//			{
//			success			[0] ConfirmedServiceResponse,
//			failure			[1] IMPLICIT ServiceError
//			}
//		} OPTIONAL
        public BerNode create(int tag, BerInputStream stream) {
            switch (tag) {
            case Tag.CONTEXT | 0:
                return new ConfirmedServiceResponse().init("success", "success", tag, stream);
            case Tag.CONTEXT | 1:
                return new ServiceError().init("failure", "failure", tag, stream);
            default:
                return new ObjectName().init("eventActioName", "eventActioName", tag, stream);
            }
        }
    }

}
