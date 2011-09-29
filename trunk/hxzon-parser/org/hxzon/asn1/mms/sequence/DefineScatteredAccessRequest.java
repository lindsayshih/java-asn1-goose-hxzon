package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.ObjectName;

public class DefineScatteredAccessRequest extends BerSequence {
//	DefineScatteredAccess-Request ::= SEQUENCE
//	{
//	scatteredAccessName		[0] ObjectName,
//	scatteredAccessDescription	[1] IMPLICIT ScatteredAccessDescription
//	}

    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new ObjectName().init("scatteredAccessName", "scatteredAccessName", tag, stream, true);
        case Tag.CONTEXT | 1:
            return new ScatteredAccessDescription().init("scatteredAccessDescription", "scatteredAccessDescription", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
