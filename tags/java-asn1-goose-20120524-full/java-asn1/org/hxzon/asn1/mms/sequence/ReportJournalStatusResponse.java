package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;

public class ReportJournalStatusResponse extends BerSequence {
//	ReportJournalStatus-Response ::= SEQUENCE
//	{
//	currentEntries		[0] IMPLICIT Unsigned32,
//	mmsDeletable		[1] IMPLICIT  BOOLEAN
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return Asn1Utils.createBerUnsigned32("currentEntries", "currentEntries", tag, stream);
        case Tag.CONTEXT | 1:
            return Asn1Utils.createBerBoolean("mmsDeletable", "mmsDeletable", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
