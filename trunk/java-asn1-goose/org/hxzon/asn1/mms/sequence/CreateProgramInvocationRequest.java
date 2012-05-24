package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.common.Identifier;

public class CreateProgramInvocationRequest extends BerSequence {
//	CreateProgramInvocation-Request ::= SEQUENCE
//	{
//	programInvocationName 	[0] IMPLICIT Identifier,
//	listOfDomainName		[1] IMPLICIT SEQUENCE OF Identifier,
//	reusable			[2] IMPLICIT BOOLEAN DEFAULT TRUE,
//	monitorType			[3] IMPLICIT BOOLEAN OPTIONAL
//		-- TRUE indicates PERMANENT monitoring
//		-- FALSE indicates CURRENT monitoring
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new Identifier().init("programInvocationName", "programInvocationName", tag, stream);
        case Tag.CONTEXT | 1:
            return Asn1Utils.createBerSequenceOf("listOfDomainName", "listOfDomainName", tag, stream, Identifier.class);
        case Tag.CONTEXT | 2:
            return Asn1Utils.createBerBoolean("reusable", "reusable", tag, stream);
        case Tag.CONTEXT | 3:
            return Asn1Utils.createBerBoolean("monitorType", "monitorType", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
