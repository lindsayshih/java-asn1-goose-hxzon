package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.Address;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.choice.TypeSpecification;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

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
