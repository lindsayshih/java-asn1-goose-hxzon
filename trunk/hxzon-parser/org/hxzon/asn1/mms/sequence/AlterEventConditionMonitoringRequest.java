package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.Priority;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class AlterEventConditionMonitoringRequest extends BerSequence {
//	AlterEventConditionMonitoring-Request ::= SEQUENCE
//	{
//	eventConditionName		[0] ObjectName,
//	enabled				[1] IMPLICIT BOOLEAN OPTIONAL,
//	priority			[2] IMPLICIT Priority OPTIONAL,
//	alarmSummaryReports		[3] IMPLICIT BOOLEAN OPTIONAL,
//        evaluationInterval		[4] IMPLICIT Unsigned32 OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ObjectName().init("eventConditionName", "eventConditionName", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerBoolean("enabled", "enabled", tag, stream);
		case Tag.CONTEXT | 2:
			return new Priority().init("priority", "priority", tag, stream);
		case Tag.CONTEXT | 3:
			return Asn1Utils.createBerBoolean("alarmSummaryReports", "alarmSummaryReports", tag, stream);
		case Tag.CONTEXT | 4:
			return Asn1Utils.createBerUnsigned32("evaluationInterval", "evaluationInterval", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
