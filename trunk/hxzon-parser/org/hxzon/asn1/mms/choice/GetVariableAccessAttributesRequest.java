package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;

public class GetVariableAccessAttributesRequest extends BerChoice {
//	GetVariableAccessAttributes-Request ::= CHOICE
//	{
//	name		[0] ObjectName,
//	address		[1] Address
//	}

    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new ObjectName().init(tag, stream, true);
        case Tag.CONTEXT | 1:
            return new Address().init(tag, stream, true);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
