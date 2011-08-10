package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.EventTime;
import org.hxzon.asn1.mms.common.ECState;


public class ReportEventConditionStatusResponse extends BerSequence {
//	ReportEventConditionStatus-Response ::= SEQUENCE
//	{
//	currentState			[0] IMPLICIT EC-State,
//	numberOfEventEnrollments	[1] IMPLICIT Unsigned32,
//	enabled				[2] IMPLICIT BOOLEAN OPTIONAL,
//	timeOfLastTransitionToActive	[3] EventTime OPTIONAL,
//	timeOfLastTransitionToIdle	[4] EventTime OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ECState().init("currentState", "currentState", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerUnsigned32("numberOfEventEnrollments", "numberOfEventEnrollments", tag, stream);
		case Tag.CONTEXT | 2:
			return Asn1Utils.createBerBoolean("enabled", "enabled", tag, stream);
		case Tag.CONTEXT | 3:
			return new EventTime().init("timeOfLastTransitionToActive", "timeOfLastTransitionToActive", tag, stream);
		case Tag.CONTEXT | 4:
			return new EventTime().init("timeOfLastTransitionToIdle", "timeOfLastTransitionToIdle", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
