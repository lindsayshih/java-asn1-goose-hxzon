package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.BerVisibleString;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.TimeOfDay;


public class ReadJournalRequest extends BerSequence {
//	ReadJournal-Request ::= SEQUENCE
//	{
//	journalName			[0] ObjectName,
//	rangeStartSpecification	[1] CHOICE
//		{
//		startingTime			[0] IMPLICIT TimeOfDay,
//		startingEntry			[1] IMPLICIT OCTET STRING
//		} OPTIONAL,
//	rangeStopSpecification	[2] CHOICE
//		{
//		endingTime			[0] IMPLICIT TimeOfDay,
//		numberOfEntries		[1] IMPLICIT Integer32
//		} OPTIONAL,
//	listOfVariables		[4] IMPLICIT SEQUENCE OF VisibleString OPTIONAL,
//	entryToStartAfter	[5] IMPLICIT SEQUENCE
//		{
//		timeSpecification		[0] IMPLICIT TimeOfDay,
//		entrySpecification		[1] IMPLICIT OCTET STRING
//		}
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ObjectName().init("journalName", "journalName", tag, stream);
		case Tag.CONTEXT | 1:
			return new RangeStartSpecification().init("rangeStartSpecification", "rangeStartSpecification", tag, stream, true);
		case Tag.CONTEXT | 2:
			return new RangeStopSpecification().init("rangeStopSpecification", "rangeStopSpecification", tag, stream, true);
		case Tag.CONTEXT | 4:
			return Asn1Utils.createBerSequenceOf("listOfVariables", "listOfVariables", tag, stream, BerVisibleString.class);
		case Tag.CONTEXT | 5:
			return new EntryToStartAfter().init("entryToStartAfter", "entryToStartAfter", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

	public static class RangeStartSpecification extends BerChoice {
		public BerNode create(int tag, BerInputStream stream) {
			switch (tag) {
			case Tag.CONTEXT | 0:
				return new TimeOfDay().init("startingTime", "startingTime", tag, stream);
			case Tag.CONTEXT | 1:
				return Asn1Utils.createBerOctetString("startingEntry", "startingEntry", tag, stream);
			default:
				return Asn1Utils.createUnknown(tag, stream);
			}
		}
	}

	public static class RangeStopSpecification extends BerChoice {
		public BerNode create(int tag, BerInputStream stream) {
			switch (tag) {
			case Tag.CONTEXT | 0:
				return new TimeOfDay().init("endingTime", "endingTime", tag, stream);
			case Tag.CONTEXT | 1:
				return Asn1Utils.createBerInteger32("numberOfEntries", "numberOfEntries", tag, stream);
			default:
				return Asn1Utils.createUnknown(tag, stream);
			}
		}
	}

	public static class EntryToStartAfter extends BerSequence {
		public BerNode create(int tag, BerInputStream stream) {
			switch (tag) {
			case Tag.CONTEXT | 0:
				return new TimeOfDay().init("timeSpecification", "timeSpecification", tag, stream);
			case Tag.CONTEXT | 1:
				return Asn1Utils.createBerOctetString("entrySpecification", "entrySpecification", tag, stream);
			default:
				return Asn1Utils.createUnknown(tag, stream);
			}
		}
	}

}
