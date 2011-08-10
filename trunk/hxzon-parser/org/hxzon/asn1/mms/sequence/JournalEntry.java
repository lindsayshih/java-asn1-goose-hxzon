package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class JournalEntry extends BerSequence {
//	JournalEntry ::= SEQUENCE
//	{
//	entryIdentifier		[0] IMPLICIT OCTET STRING,
//	originatingApplication		[1] ApplicationReference,
//	entryContent			[2] IMPLICIT EntryContent
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerOctetString("entryIdentifier", "entryIdentifier", tag, stream);
		case Tag.CONTEXT | 1:
			return new ApplicationReference().init("originatingApplication", "originatingApplication", tag, stream);
		case Tag.CONTEXT | 2:
			return new EntryContent().init("entryContent", "entryContent", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
