package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;

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
            return Asn1Utils.createBerUnsigned32("numeric address", "numeric address", tag, stream);
        case Tag.CONTEXT | 1:
            return Asn1Utils.createBerVisibleString("symbolic address", "symbolic address", tag, stream);
        case Tag.CONTEXT | 2:
            return Asn1Utils.createBerOctetString("unconstrained address", "unconstrained address", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
