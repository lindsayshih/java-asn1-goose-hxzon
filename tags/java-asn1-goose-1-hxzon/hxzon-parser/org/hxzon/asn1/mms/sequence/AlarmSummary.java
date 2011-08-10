package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerInteger;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.EventTime;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.ECState;


public class AlarmSummary extends BerSequence {
//	AlarmSummary ::= SEQUENCE
//	{
//	eventConditionName			[0] ObjectName,
//	severity				[1] IMPLICIT Unsigned8,
//	currentState				[2] IMPLICIT EC-State,
//	unacknowledgedState			[3] IMPLICIT INTEGER
//		{
//		none		(0),
//		active		(1),
//		idle		(2),
//		both		(3)
//		},
//	timeOfLastTransitionToActive		[5] EventTime OPTIONAL,
//	timeOfLastTransitionToIdle		[6] EventTime OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ObjectName().init("eventConditionName", "eventConditionName", tag, stream, true);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerUnsigned8("severity", "severity", tag, stream);
		case Tag.CONTEXT | 2:
			return new ECState().init("currentState", "currentState", tag, stream);
		case Tag.CONTEXT | 3:
			return new UnacknowledgedState().init("unacknowledgedState", "unacknowledgedState", tag, stream);
		case Tag.CONTEXT | 5:
			return new EventTime().init("timeOfLastTransitionToActive", "timeOfLastTransitionToActive", tag, stream);
		case Tag.CONTEXT | 6:
			return new EventTime().init("timeOfLastTransitionToIdle", "timeOfLastTransitionToIdle", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

	public static class UnacknowledgedState extends BerInteger {
//		unacknowledgedState			[3] IMPLICIT INTEGER
//		{
//		none		(0),
//		active		(1),
//		idle		(2),
//		both		(3)
//		},
	}

}
