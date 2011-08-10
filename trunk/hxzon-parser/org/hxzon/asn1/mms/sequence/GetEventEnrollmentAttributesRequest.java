package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.ObjectName;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerInteger;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class GetEventEnrollmentAttributesRequest extends BerSequence {
//	GetEventEnrollmentAttributes-Request ::= SEQUENCE
//	{
//	scopeOfRequest		[0] IMPLICIT INTEGER 
//		{
//		specific	(0),
//		client		(1),
//		ec		(2),
//		ea		(3)
//		} DEFAULT client,
//	eventEnrollmentNames	[1] IMPLICIT SEQUENCE OF ObjectName OPTIONAL,
//	clientApplication	[2] ApplicationReference OPTIONAL,
//	eventConditionName	[3] ObjectName OPTIONAL,
//	eventActionName		[4] ObjectName OPTIONAL,
//	continueAfter		[5] ObjectName OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ScopeOfRequest().init("scopeOfRequest", "scopeOfRequest", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerSequenceOf("eventEnrollmentNames", "eventEnrollmentNames", tag, stream, ObjectName.class);
		case Tag.CONTEXT | 2:
			return new ApplicationReference().init("clientApplication", "clientApplication", tag, stream);
		case Tag.CONTEXT | 3:
			return new ObjectName().init("eventConditionName", "eventConditionName", tag, stream);
		case Tag.CONTEXT | 4:
			return new ObjectName().init("eventActionName", "eventActionName", tag, stream);
		case Tag.CONTEXT | 5:
			return new ObjectName().init("continueAfter", "continueAfter", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

	public static class ScopeOfRequest extends BerInteger {

	}

}
