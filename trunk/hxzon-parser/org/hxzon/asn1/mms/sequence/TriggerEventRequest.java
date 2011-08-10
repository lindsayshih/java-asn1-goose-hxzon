package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.Priority;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class TriggerEventRequest extends BerSequence {
//	TriggerEvent-Request ::= SEQUENCE
//	{
//	eventConditionName		[0] ObjectName,
//	priority			[1] IMPLICIT Priority OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ObjectName().init("eventConditionName", "eventConditionName", tag, stream);
		case Tag.CONTEXT | 1:
			return new Priority().init("priority", "priority", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
