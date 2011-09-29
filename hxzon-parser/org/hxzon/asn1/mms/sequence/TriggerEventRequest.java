package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.Priority;

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
