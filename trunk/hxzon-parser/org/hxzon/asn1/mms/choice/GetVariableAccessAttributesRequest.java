package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.BerChoice;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.Tag;

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
