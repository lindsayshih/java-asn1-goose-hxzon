package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.VariableSpecification;
import org.hxzon.asn1.mms.common.Identifier;


public class ScatteredAccessDescription extends BerSequence {
//	ScatteredAccessDescription ::= SEQUENCE OF SEQUENCE 
//	{
//	componentName		[0] IMPLICIT Identifier OPTIONAL,
//	variableSpecification	[1] VariableSpecification,
//	alternateAccess		[2] IMPLICIT AlternateAccess OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new Identifier().init("componentName", "componentName", tag, stream);
		case Tag.CONTEXT | 1:
			return new VariableSpecification().init("variableSpecification", "variableSpecification", tag, stream);
		case Tag.CONTEXT | 2:
			return new AlternateAccess().init("alternateAccess", "alternateAccess", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
