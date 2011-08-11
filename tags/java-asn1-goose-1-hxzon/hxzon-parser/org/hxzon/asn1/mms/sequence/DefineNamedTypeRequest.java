package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.UnknownBerNode;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.choice.TypeSpecification;


public class DefineNamedTypeRequest extends BerSequence {
//	DefineNamedType-Request ::= SEQUENCE 
//	{
//	typeName		ObjectName,
//	typeSpecification	TypeSpecification
//	}
	public BerNode create(int tag, BerInputStream stream) {
		BerNode node = new ObjectName().init("typeName", "typeName", tag, stream);
		if (((ObjectName) node).getRealNode() instanceof UnknownBerNode) {
			node = new TypeSpecification().init("typeSpecification", "typeSpecification", tag, stream);
		}
		return node;
//		switch(tag){
//		}
	}
}
