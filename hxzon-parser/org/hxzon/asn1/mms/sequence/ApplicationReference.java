package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class ApplicationReference extends BerSequence {
//	ApplicationReference ::= SEQUENCE
//	{
//	ap-title			[0] AP-title 	        OPTIONAL,
//	ap-invocation-id	[1] AP-invocation-identifier OPTIONAL,
//	ae-qualifier		[2] AE-qualifier	        OPTIONAL,
//	ae-invocation-id	[3] AE-invocation-identifier OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
//			return 
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
