package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.ObjectName;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

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
