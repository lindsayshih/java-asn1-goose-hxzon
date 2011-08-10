package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.BerChoice;
import org.hxzon.asn1.mms.common.TimeOfDay;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.Tag;

public class EventTime extends BerChoice {
//	EventTime ::= CHOICE
//	{
//	timeOfDayT			[0] IMPLICIT TimeOfDay,
//	timeSequenceIdentifier		[1] IMPLICIT Unsigned32
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new TimeOfDay().init("timeOfDayT", "timeOfDayT", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerUnsignedInteger("timeSequenceIdentifier", "timeSequenceIdentifier", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
