package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.ObjectName;


public class CreateJournalRequest extends BerSequence {
//	CreateJournal-Request ::= SEQUENCE
//	{
//	journalName	[0] ObjectName
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ObjectName().init("journalName", "journalName", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
