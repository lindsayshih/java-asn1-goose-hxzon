package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.BerChoice;
import org.hxzon.asn1.mms.choice.EventConditionName;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.EEClass;
import org.hxzon.asn1.mms.common.EEDuration;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class EventEnrollment extends BerSequence {
//	EventEnrollment ::= SEQUENCE
//	{
//	eventEnrollmentName		[0] ObjectName,
//	eventConditionName		[1] CHOICE
//		{
//		eventCondition			[0] ObjectName,
//		undefined			[1] IMPLICIT NULL
//		},
//	eventActionName			[2] CHOICE
//		{
//		eventAction			[0] ObjectName,
//		undefined			[1] IMPLICIT NULL
//		} OPTIONAL,
//	clientApplication		[3] ApplicationReference OPTIONAL,
//	mmsDeletable			[4] IMPLICIT BOOLEAN DEFAULT FALSE,
//	enrollmentClass			[5] IMPLICIT EE-Class,
//	duration			[6] IMPLICIT EE-Duration DEFAULT current,
//	invokeID			[7] IMPLICIT Unsigned32,
//	remainingAcceptableDelay	[8] IMPLICIT Unsigned32 OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ObjectName().init("eventEnrollmentName", "eventEnrollmentName", tag, stream, true);
		case Tag.CONTEXT | 1:
			return new EventConditionName().init("eventConditionName", "eventConditionName", tag, stream, true);
		case Tag.CONTEXT | 2:
			return new EventActionName().init("eventActionName", "eventActionName", tag, stream, true);
		case Tag.CONTEXT | 3:
			return new ApplicationReference().init("clientApplication", "clientApplication", tag, stream);
		case Tag.CONTEXT | 4:
			return Asn1Utils.createBerBoolean("mmsDeletable", "mmsDeletable", tag, stream);
		case Tag.CONTEXT | 5:
			return new EEClass().init("enrollmentClass", "enrollmentClass", tag, stream);
		case Tag.CONTEXT | 6:
			return new EEDuration().init("duration", "duration", tag, stream);
		case Tag.CONTEXT | 7:
			return Asn1Utils.createBerUnsigned32("invokeID", "invokeID", tag, stream);
		case Tag.CONTEXT | 8:
			return Asn1Utils.createBerUnsigned32("remainingAcceptableDelay", "remainingAcceptableDelay", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

	public static class EventActionName extends BerChoice {
//		eventActionName			[2] CHOICE
//		{
//		eventAction			[0] ObjectName,
//		undefined			[1] IMPLICIT NULL
//		} OPTIONAL,
		public BerNode create(int tag, BerInputStream stream) {
			switch (tag) {
			case Tag.CONTEXT | 0:
				return new ObjectName().init("eventAction", "eventAction", tag, stream, true);
			case Tag.CONTEXT | 1:
				return Asn1Utils.createBerNull("undefined", "undefined", tag, stream);
			default:
				return Asn1Utils.createUnknown(tag, stream);
			}
		}
	}

}
