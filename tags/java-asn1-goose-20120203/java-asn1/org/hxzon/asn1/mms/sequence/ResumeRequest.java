package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.ExecutionArgument;
import org.hxzon.asn1.mms.common.Identifier;

public class ResumeRequest extends BerSequence {
//	Resume-Request ::= SEQUENCE
//	{
//	programInvocationName 	[0] IMPLICIT Identifier,
//	executionArgument	CHOICE {
//	    simpleString	  [1] IMPLICIT VisibleString,
//	    encodedString	  EXTERNALt
//	    } OPTIONAL
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new Identifier().init("programInvocationName", "programInvocationName", tag, stream);
        default:
            return new ExecutionArgument().init("executionArgument", "executionArgument", tag, stream);
        }
    }

}
