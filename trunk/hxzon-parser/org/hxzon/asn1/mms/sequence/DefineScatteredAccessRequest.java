package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.ObjectName;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

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
