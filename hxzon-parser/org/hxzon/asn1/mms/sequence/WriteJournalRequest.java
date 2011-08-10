package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.ObjectName;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class WriteJournalRequest extends BerSequence {
//	WriteJournal-Request ::= SEQUENCE
//	{
//	journalName			[0] ObjectName,
//	listOfJournalEntry		[1] IMPLICIT SEQUENCE OF EntryContent
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ObjectName().init("journalName", "journalName", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerSequenceOf("listOfJournalEntry", "listOfJournalEntry", tag, stream, EntryContent.class);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
