package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.ExecutionArgument;
import org.hxzon.asn1.mms.common.Identifier;
import org.hxzon.asn1.mms.common.ProgramInvocationState;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class GetProgramInvocationAttributesResponse extends BerSequence {
//	GetProgramInvocationAttributes-Response ::= SEQUENCE
//	{
//	state			[0] IMPLICIT ProgramInvocationState,
//	listOfDomainNames	[1] IMPLICIT SEQUENCE OF Identifier,				
//	mmsDeletable		[2] IMPLICIT BOOLEAN,
//	reusable		[3] IMPLICIT BOOLEAN,
//	monitor			[4] IMPLICIT BOOLEAN,
//	startArgument		[5] IMPLICIT VisibleString,
//	executionArgument	CHOICE {
//	    simpleString	  [1] IMPLICIT VisibleString,
//	    encodedString	  EXTERNALt
//	    } OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ProgramInvocationState().init("state", "state", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerSequenceOf("listOfDomainNames", "listOfDomainNames", tag, stream, Identifier.class);
		case Tag.CONTEXT | 2:
			return Asn1Utils.createBerBoolean("mmsDeletable", "mmsDeletable", tag, stream);
		case Tag.CONTEXT | 3:
			return Asn1Utils.createBerBoolean("reusable", "reusable", tag, stream);
		case Tag.CONTEXT | 4:
			return Asn1Utils.createBerBoolean("monitor", "monitor", tag, stream);
		case Tag.CONTEXT | 5:
			return Asn1Utils.createBerVisibleString("startArgument", "startArgument", tag, stream);
		default:
			return new ExecutionArgument().init("executionArgument", "executionArgument", tag, stream, false);
		}
	}

}
