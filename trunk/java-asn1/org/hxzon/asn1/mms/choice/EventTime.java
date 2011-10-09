package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;

public class EventTime extends BerChoice {
//	EventTime ::= CHOICE
//	{
//	timeOfDayT			[0] IMPLICIT TimeOfDay,
//	timeSequenceIdentifier		[1] IMPLICIT Unsigned32
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return Asn1Utils.createBerIecTimeOfDay("timeOfDayT", "timeOfDayT", tag, stream);
        case Tag.CONTEXT | 1:
            return Asn1Utils.createBerUnsigned32("timeSequenceIdentifier", "timeSequenceIdentifier", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
