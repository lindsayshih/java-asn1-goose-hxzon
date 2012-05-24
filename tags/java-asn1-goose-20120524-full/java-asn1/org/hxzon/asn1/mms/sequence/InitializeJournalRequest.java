package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.ObjectName;

public class InitializeJournalRequest extends BerSequence {
//	InitializeJournal-Request ::= SEQUENCE
//	{
//	journalName			[0] ObjectName,
//	limitSpecification		[1] IMPLICIT SEQUENCE
//		{
//		limitingTime			[0] IMPLICIT TimeOfDay,
//		limitingEntry			[1] IMPLICIT OCTET STRING OPTIONAL
//		} OPTIONAL
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new ObjectName().init("journalName", "journalName", tag, stream);
        case Tag.CONTEXT | 1:
            return new LimitSpecification().init("limitSpecification", "limitSpecification", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

    public static class LimitSpecification extends BerSequence {
        public BerNode create(int tag, BerInputStream stream) {
            switch (tag) {
            case Tag.CONTEXT | 0:
                return Asn1Utils.createBerIecTimeOfDay("limitingTime", "limitingTime", tag, stream);
            case Tag.CONTEXT | 1:
                return Asn1Utils.createBerOctetString("limitingEntry", "limitingEntry", tag, stream);
            default:
                return Asn1Utils.createUnknown(tag, stream);
            }
        }
    }

}
