package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class SeverityFilter extends BerSequence {
//	severityFilter			[3] IMPLICIT SEQUENCE
//	{
//	mostSevere			[0] IMPLICIT Unsigned8,
//	leastSevere			[1] IMPLICIT Unsigned8 
//	} OPTIONAL,
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerUnsigned8("mostSevere", "mostSevere", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerUnsigned8("leastSevere", "leastSevere", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
