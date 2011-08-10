package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.choice.VariableSpecification;
import org.hxzon.asn1.mms.common.ECClass;
import org.hxzon.asn1.mms.common.Priority;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class DefineEventConditionRequest extends BerSequence {
//	DefineEventCondition-Request ::= SEQUENCE
//	{
//	eventConditionName		[0] ObjectName,
//	class				[1] IMPLICIT EC-Class,
//	prio-rity			[2] IMPLICIT Priority DEFAULT 64,
//	severity			[3] IMPLICIT Unsigned8 DEFAULT 64,
//	alarmSummaryReports		[4] IMPLICIT BOOLEAN OPTIONAL,
//	monitoredVariable		[6] VariableSpecification OPTIONAL,
//	evaluationInterval		[7] IMPLICIT Unsigned32 OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ObjectName().init("eventConditionName", "eventConditionName", tag, stream);
		case Tag.CONTEXT | 1:
			return new ECClass().init("class", "class", tag, stream);
		case Tag.CONTEXT | 2:
			return new Priority().init("priority", "priority", tag, stream);
		case Tag.CONTEXT | 3:
			return Asn1Utils.createBerUnsigned8("severity", "severity", tag, stream);
		case Tag.CONTEXT | 4:
			return Asn1Utils.createBerBoolean("alarmSummaryReports", "alarmSummaryReports", tag, stream);
		case Tag.CONTEXT | 6:
			return new VariableSpecification().init("monitoredVariable", "monitoredVariable", tag, stream, true);
		case Tag.CONTEXT | 7:
			return Asn1Utils.createBerUnsigned32("evaluationInterval", "evaluationInterval", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
