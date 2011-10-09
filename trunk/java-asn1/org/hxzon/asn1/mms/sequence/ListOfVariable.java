package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.VariableSpecification;

public class ListOfVariable extends BerSequence {
    public ListOfVariable() {
        setName("listOfVariable");
    }

//	GetNamedVariableListAttributes-Response ::= SEQUENCE
//	{
//	mmsDeletable		[0] IMPLICIT BOOLEAN,
////	listOfVariable		[1] IMPLICIT SEQUENCE OF SEQUENCE 
////		{
////		variableSpecification 		VariableSpecification,
////		alternateAccess			[5] IMPLICIT AlternateAccess OPTIONAL
////		}
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 5:
            return new AlternateAccess().init(tag, stream);
        default:
            return new VariableSpecification().init(tag, stream, false);
        }
    }

}
