package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.mms.sequence.ScatteredAccessDescription;
import org.hxzon.asn1.mms.sequence.VariableDescription;

public class VariableSpecification extends BerChoice {

    public VariableSpecification() {
        setName("variable specification");
        setDisplayString("variable specification");
    }

//	VariableSpecification ::= CHOICE
//	{
//	name				[0] ObjectName,
//	address				[1] Address,
//	variableDescription		[2] IMPLICIT SEQUENCE
//		{
//		address			Address,
//		typeSpecification	TypeSpecification
//		},
//	scatteredAccessDescription	[3] IMPLICIT ScatteredAccessDescription,
//	invalidated			[4] IMPLICIT NULL
//	}

    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new ObjectName().init(tag, stream, true);
        case Tag.CONTEXT | 1:
            return new Address().init(tag, stream, true);
        case Tag.CONTEXT | 2:
            return new VariableDescription().init(tag, stream);
        case Tag.CONTEXT | 3:
//			return new ScatteredAccessDescription().init("scatteredAccessDescription", "scatteredAccessDescription", tag, stream);
            return Asn1Utils.createBerSequenceOf("scatteredAccessDescription", "scatteredAccessDescription", tag, stream, ScatteredAccessDescription.class);
        case Tag.CONTEXT | 4:
            return Asn1Utils.createBerNull("invalidated", "invalidated", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
