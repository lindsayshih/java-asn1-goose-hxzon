package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.Address;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.choice.TypeSpecification;

public class DefineNamedVariableRequest extends BerSequence {
//	DefineNamedVariable-Request ::= SEQUENCE
//	{
//	variableName		[0] ObjectName,
//	address			[1] Address,
//	typeSpecification	[2] TypeSpecification OPTIONAL
//	}

    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new ObjectName().init("variableName", "variableName", tag, stream, true);
        case Tag.CONTEXT | 1:
            return new Address().init("address", "address", tag, stream, true);
        case Tag.CONTEXT | 2:
            return new TypeSpecification().init("typeSpecification", "typeSpecification", tag, stream, true);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
