package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;


public class FileDirectoryResponse extends BerSequence {
//	FileDirectory-Response ::= SEQUENCE {
//		listOfDirectoryEntry	[0] SEQUENCE OF DirectoryEntry,
//		moreFollows		[1] IMPLICIT BOOLEAN DEFAULT FALSE
//		}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerSequenceOf("listOfDirectoryEntry", "listOfDirectoryEntry", tag, stream, DirectoryEntry.class);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerBoolean("moreFollows", "moreFollows", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
