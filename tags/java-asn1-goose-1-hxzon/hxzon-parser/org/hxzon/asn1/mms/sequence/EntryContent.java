package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.mms.choice.Data;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.ECState;
import org.hxzon.asn1.mms.common.TimeOfDay;


public class EntryContent extends BerSequence {
//	EntryContent ::= SEQUENCE
//	{
//	occurenceTime		[0] IMPLICIT TimeOfDay,
//	additionalDetail	[1] JOU-Additional-Detail OPTIONAL,
//		-- additionalDetail shall be omitted
//		-- from abstract syntax defined in this standard
//	entryForm		 CHOICE
//		{
//		data			[2] IMPLICIT SEQUENCE
//			{
//			event			[0] IMPLICIT SEQUENCE
//				{
//				eventConditionName	[0] ObjectName,
//				currentState		[1] IMPLICIT EC-State
//				} OPTIONAL,
//			listOfVariables	[1] IMPLICIT SEQUENCE OF SEQUENCE
//				{
//				variableTag		[0] IMPLICIT VisibleString,
//				valueSpecification	[1] Data
//				} OPTIONAL
//			},
//		annotation		[3] IMPLICIT VisibleString
//		}
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new TimeOfDay().init("occurenceTime", "occurenceTime", tag, stream);
		case Tag.CONTEXT | 1:
			//JOU-Additional-Detail ::= NULL	-- Defined by Companion Standard
			return Asn1Utils.createBerNull("additionalDetail", "additionalDetail", tag, stream);
		default:
			return new EntryForm().init("entryForm", "entryForm", tag, stream, false);
		}
	}

	public static class EntryForm extends BerChoice {
		public BerNode create(int tag, BerInputStream stream) {
			switch (tag) {
			case Tag.CONTEXT | 2:
				return new EntryFormData().init("data", "data", tag, stream);
			case Tag.CONTEXT | 3:
				return Asn1Utils.createBerVisibleString("annotation", "annotation", tag, stream);
			default:
				return Asn1Utils.createUnknown(tag, stream);
			}
		}
	}

//	data			[2] IMPLICIT SEQUENCE
//	{
//	event			[0] IMPLICIT SEQUENCE
//		{
//		eventConditionName	[0] ObjectName,
//		currentState		[1] IMPLICIT EC-State
//		} OPTIONAL,
//	listOfVariables	[1] IMPLICIT SEQUENCE OF SEQUENCE
//		{
//		variableTag		[0] IMPLICIT VisibleString,
//		valueSpecification	[1] Data
//		} OPTIONAL
//	},	
	public static class EntryFormData extends BerSequence {
		public BerNode create(int tag, BerInputStream stream) {
			switch (tag) {
			case Tag.CONTEXT | 0:
				return new BerSequence() {
					public BerNode create(int tag, BerInputStream stream) {
						switch (tag) {
						case Tag.CONTEXT | 0:
							return new ObjectName().init("eventConditionName", "eventConditionName", tag, stream);
						case Tag.CONTEXT | 1:
							return new ECState().init("currentState", "currentState", tag, stream);
						default:
							return Asn1Utils.createUnknown(tag, stream);
						}
					}
				}.init("event", "event", tag, stream);
			case Tag.CONTEXT | 1:
				return Asn1Utils.createBerSequenceOf("listOfVariables", "listOfVariables", tag, stream, new BerSequence() {
					public BerNode create(int tag, BerInputStream stream) {
						switch (tag) {
						case Tag.CONTEXT | 0:
							return Asn1Utils.createBerVisibleString("variableTag", "variableTag", tag, stream);
						case Tag.CONTEXT | 1:
							return new Data().init("variableTag", "variableTag", tag, stream);
						default:
							return Asn1Utils.createUnknown(tag, stream);
						}
					}
				}.getClass());
			default:
				return Asn1Utils.createUnknown(tag, stream);
			}
		}
	}

}
