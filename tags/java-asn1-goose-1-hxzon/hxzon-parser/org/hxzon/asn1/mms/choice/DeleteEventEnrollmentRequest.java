package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;


public class DeleteEventEnrollmentRequest extends BerChoice {
//	DeleteEventEnrollment-Request ::= CHOICE
//	{
//	specific	[0] IMPLICIT SEQUENCE OF ObjectName,
//	ec		[1] ObjectName,
//	ea		[2] ObjectName
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerSequenceOf("specific", "specific", tag, stream, ObjectName.class);
		case Tag.CONTEXT | 1:
			return new ObjectName().init("ec", "ec", tag, stream);
		case Tag.CONTEXT | 2:
			return new ObjectName().init("ea", "ea", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
