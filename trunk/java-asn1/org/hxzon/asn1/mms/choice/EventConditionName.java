package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;

public class EventConditionName extends BerChoice {
//	eventConditionName		[1] CHOICE
//	{
//	eventCondition			[0] ObjectName,
//	undefined			[1] IMPLICIT NULL
//	},
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new ObjectName().init("eventCondition", "eventCondition", tag, stream, true);
        case Tag.CONTEXT | 1:
            return Asn1Utils.createBerNull("undefined", "undefined", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }
}
