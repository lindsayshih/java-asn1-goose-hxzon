package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.BerVisibleString;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.common.DomainState;
import org.hxzon.asn1.mms.common.Identifier;


public class GetDomainAttributesResponse extends BerSequence {
//	GetDomainAttributes-Response ::= SEQUENCE
//	{
//	listOfCapabilities		[0] IMPLICIT SEQUENCE OF VisibleString,
//	state				[1] IMPLICIT DomainState,
//	mmsDeletable			[2] IMPLICIT BOOLEAN,
//	sharable			[3] IMPLICIT BOOLEAN,
//	listOfProgramInvocations	[4] IMPLICIT SEQUENCE OF Identifier, 	-- PI Names
//	uploadInProgress		[5] IMPLICIT Integer8
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerSequenceOf("listOfCapabilities", "listOfCapabilities", tag, stream, BerVisibleString.class);
		case Tag.CONTEXT | 1:
			return new DomainState().init("state", "state", tag, stream);
		case Tag.CONTEXT | 2:
			return Asn1Utils.createBerBoolean("mmsDeletable", "mmsDeletable", tag, stream);
		case Tag.CONTEXT | 3:
			return Asn1Utils.createBerBoolean("sharable", "sharable", tag, stream);
		case Tag.CONTEXT | 4:
			return Asn1Utils.createBerSequenceOf("listOfProgramInvocations", "listOfProgramInvocations", tag, stream, Identifier.class);
		case Tag.CONTEXT | 5:
			return Asn1Utils.createBerInteger8("uploadInProgress", "uploadInProgress", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
