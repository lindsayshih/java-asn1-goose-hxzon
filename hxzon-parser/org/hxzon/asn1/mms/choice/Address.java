package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.BerChoice;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.Tag;

public class Address extends BerChoice {

	public Address() {
		setName("address");
	}

//	Address ::= CHOICE
//	{
//	numericAddress		[0] IMPLICIT Unsigned32,
//	symbolicAddress		[1] IMPLICIT VisibleString,
//	unconstrainedAddress	[2] IMPLICIT OCTET STRING
//	}

	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerUnsignedInteger("numeric address", "numeric address", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerVisibleString("symbolic address", "symbolic address", tag, stream);
		case Tag.CONTEXT | 2:
			return Asn1Utils.createBerOctetString("unconstrained address", "unconstrained address", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
