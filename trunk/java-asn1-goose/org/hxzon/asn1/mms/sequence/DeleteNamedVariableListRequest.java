package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.Identifier;
import org.hxzon.asn1.mms.common.ScopeOfDelete;

public class DeleteNamedVariableListRequest extends BerSequence {
//	DeleteNamedVariableList-Request ::= SEQUENCE
//	{
//	scopeOfDelete		[0] IMPLICIT INTEGER
//		{
//		specific			(0),
//		aa-specific			(1),
//		domain				(2),
//		vmd				(3) 
//		} DEFAULT specific,
//	listOfVariableListName	[1] IMPLICIT SEQUENCE OF ObjectName OPTIONAL,
//	domainName			[2] IMPLICIT Identifier OPTIONAL
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new ScopeOfDelete().init("scopeOfDelete", "scopeOfDelete", tag, stream);
        case Tag.CONTEXT | 1:
            return Asn1Utils.createBerSequenceOf("listOfVariableListName", "listOfVariableListName", tag, stream, ObjectName.class, false);
        case Tag.CONTEXT | 2:
            return new Identifier().init("domainName", "domainName", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
