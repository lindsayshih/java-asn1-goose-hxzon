package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerIntegerEx;
import org.hxzon.asn1.mms.choice.ObjectName;

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
            return Asn1Utils.createBerSequenceOf("eventEnrollmentNames", "eventEnrollmentNames", tag, stream, ObjectName.class, false);
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

    public static class ScopeOfRequest extends BerIntegerEx {
        //  scopeOfRequest      [0] IMPLICIT INTEGER 
//      {
//      specific    (0),
//      client      (1),
//      ec      (2),
//      ea      (3)
//      } DEFAULT client,
        static {
            addValueString(0, "specific(0)", ScopeOfRequest.class);
            addValueString(1, "client(1)", ScopeOfRequest.class);
            addValueString(2, "ec(2)", ScopeOfRequest.class);
            addValueString(3, "ea(3)", ScopeOfRequest.class);

        }

        public ScopeOfRequest() {
        }
    }

}
