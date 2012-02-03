package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.ObjectName;

public class DefineNamedVariableListRequest extends BerSequence {
//	DefineNamedVariableList-Request ::= SEQUENCE
//	{
//	variableListName	ObjectName,
//	listOfVariable		[0] IMPLICIT SEQUENCE OF SEQUENCE
//		{
//		variableSpecification 	VariableSpecification,
//		alternateAccess		[5] IMPLICIT AlternateAccess OPTIONAL
//		}
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return Asn1Utils.createBerSequenceOf("listOfVariable", "listOfVariable", tag, stream, ListOfVariable.class);
        default:
//			return Asn1Utils.createUnknownTagBerNode(tag, stream);
            return new ObjectName().init("variableListName", "variableListName", tag, stream);
        }
    }

}
