package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.EventTime;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.ECState;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class AcknowledgeEventNotificationRequest extends BerSequence {
//	AcknowledgeEventNotification-Request ::= SEQUENCE
//	{
//	eventEnrollmentName		[0] ObjectName,
//	acknowledgedState		[2] IMPLICIT EC-State,
//	timeOfAcknowledgedTransition	[3] EventTime
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ObjectName().init("eventEnrollmentName", "eventEnrollmentName", tag, stream);
		case Tag.CONTEXT | 2:
			return new ECState().init("acknowledgedState", "acknowledgedState", tag, stream);
		case Tag.CONTEXT | 3:
			return new EventTime().init("timeOfAcknowledgedTransition", "timeOfAcknowledgedTransition", tag, stream, true);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
