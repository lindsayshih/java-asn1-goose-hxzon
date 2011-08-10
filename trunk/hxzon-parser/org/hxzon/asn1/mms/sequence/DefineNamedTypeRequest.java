package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.UnknownBerNode;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.choice.TypeSpecification;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;

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
