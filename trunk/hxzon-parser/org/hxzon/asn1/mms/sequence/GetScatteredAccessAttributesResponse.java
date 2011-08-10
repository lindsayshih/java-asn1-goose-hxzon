package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class GetScatteredAccessAttributesResponse extends BerSequence {
//	GetScatteredAccessAttributes-Response ::= SEQUENCE
//	{
//	mmsDeletable			[0] IMPLICIT BOOLEAN,
//	scatteredAccessDescription	[1] IMPLICIT ScatteredAccessDescription
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerBoolean("mmsDeletable", "mmsDeletable", tag, stream);
		case Tag.CONTEXT | 1:
			return new ScatteredAccessDescription().init("scatteredAccessDescription", "scatteredAccessDescription", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
