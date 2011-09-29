package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.mms.choice.VariableSpecification;
import org.hxzon.asn1.mms.common.ECClass;
import org.hxzon.asn1.mms.common.Priority;

public class GetEventConditionAttributesResponse extends BerSequence {
//	GetEventConditionAttributes-Response ::= SEQUENCE
//	{
//	mmsDeletable			[0] IMPLICIT BOOLEAN DEFAULT FALSE,
//	class				[1] IMPLICIT EC-Class,
//	prio-rity			[2] IMPLICIT Priority DEFAULT 64,
//	severity			[3] IMPLICIT Unsigned8 DEFAULT 64,
//	alarmSummaryReports		[4] IMPLICIT BOOLEAN DEFAULT FALSE,
// 	monitoredVariable		[6] CHOICE
//		{
//		variableReference		[0] VariableSpecification,
//		undefined			[1] IMPLICIT NULL
//		} OPTIONAL,
//	evaluationInterval		[7] IMPLICIT Unsigned32 OPTIONAL
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return Asn1Utils.createBerBoolean("mmsDeletable", "mmsDeletable", tag, stream);
        case Tag.CONTEXT | 1:
            return new ECClass().init("class", "class", tag, stream);
        case Tag.CONTEXT | 2:
            return new Priority().init("priority", "priority", tag, stream);
        case Tag.CONTEXT | 3:
            return Asn1Utils.createBerUnsigned8("severity", "severity", tag, stream);
        case Tag.CONTEXT | 4:
            return Asn1Utils.createBerBoolean("alarmSummaryReports", "alarmSummaryReports", tag, stream);
        case Tag.CONTEXT | 6:
            return new MonitoredVariable().init("monitoredVariable", "monitoredVariable", tag, stream);
        case Tag.CONTEXT | 7:
            return Asn1Utils.createBerUnsigned32("evaluationInterval", "evaluationInterval", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

    public static class MonitoredVariable extends BerChoice {
        public BerNode create(int tag, BerInputStream stream) {
            switch (tag) {
            case Tag.CONTEXT | 0:
                return new VariableSpecification().init("variableReference", "variableReference", tag, stream, true);
            case Tag.CONTEXT | 1:
                return Asn1Utils.createBerNull("undefined", "undefined", tag, stream);
            default:
                return Asn1Utils.createUnknown(tag, stream);
            }
        }
    }

}
