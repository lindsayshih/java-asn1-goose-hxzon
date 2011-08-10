package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.mms.choice.EventTime;
import org.hxzon.asn1.mms.common.EEState;


public class AlterEventEnrollmentResponse extends BerSequence {
//	AlterEventEnrollment-Response ::= SEQUENCE
//	{
//	currentState		[0] CHOICE
//		{
//		state			[0] IMPLICIT EE-State,
//		undefined		[1] IMPLICIT NULL
//		},
//	transitionTime		[1] EventTime
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new CurrentState().init("currentState", "currentState", tag, stream, true);
		case Tag.CONTEXT | 1:
			return new EventTime().init("transitionTime", "transitionTime", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

	public static class CurrentState extends BerChoice {
		public BerNode create(int tag, BerInputStream stream) {
			switch (tag) {
			case Tag.CONTEXT | 0:
				return new EEState().init("state", "state", tag, stream);
			case Tag.CONTEXT | 1:
				return Asn1Utils.createBerNull("undefined", "undefined", tag, stream);
			default:
				return Asn1Utils.createUnknown(tag, stream);
			}
		}
	}

}
