package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.AcknowledgmentFilter;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class GetAlarmSummaryRequest extends BerSequence {
//	GetAlarmSummary-Request ::= SEQUENCE
//	{
//	enrollmentsOnly			[0] IMPLICIT BOOLEAN DEFAULT TRUE,
//	activeAlarmsOnly		[1] IMPLICIT BOOLEAN DEFAULT TRUE,
//	acknowledgmentFilter		[2] IMPLICIT INTEGER 
//		{
//		not-acked			(0),
//		acked				(1),
//		all				(2) 
//		} DEFAULT not-acked,
//	severityFilter			[3] IMPLICIT SEQUENCE
//		{
//		mostSevere			[0] IMPLICIT Unsigned8,
//		leastSevere			[1] IMPLICIT Unsigned8 
//		} OPTIONAL,
//	continueAfter			[5] ObjectName OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerBoolean("enrollmentsOnly", "enrollmentsOnly", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerBoolean("activeAlarmsOnly", "activeAlarmsOnly", tag, stream);
		case Tag.CONTEXT | 2:
			return new AcknowledgmentFilter().init("acknowledgmentFilter", "acknowledgmentFilter", tag, stream);
		case Tag.CONTEXT | 3:
			return new SeverityFilter().init("severityFilter", "severityFilter", tag, stream);
		case Tag.CONTEXT | 5:
			return new ObjectName().init("continueAfter", "continueAfter", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
