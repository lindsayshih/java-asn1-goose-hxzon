package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.ExtendedObjectClass;
import org.hxzon.asn1.mms.choice.ObjectScope;
import org.hxzon.asn1.mms.common.Identifier;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class GetNameListRequest extends BerSequence {
	public GetNameListRequest() {
		setName("get name list request");
		setDisplayString("get name list request");
	}

//	GetNameList-Request ::= SEQUENCE
//	{
//	extendedObjectClass [0] CHOICE
//		{
//		objectClass		[0] IMPLICIT INTEGER
//			{
//			nammedVariable		(0),
//			scatteredAccess		(1),
//			namedVariableList	(2),
//			namedType		(3),
//			semaphore		(4),
//			eventCondition		(5),
//			eventAction		(6),
//			eventEnrollment		(7),
//			journal			(8),
//			domain			(9),
//			programInvocation	(10),
//			operatorStation		(11)
//			}
//		},
//	objectScope 		[1] CHOICE
//		{
//		vmdSpecific		[0] IMPLICIT NULL,
//		domainSpecific		[1] IMPLICIT Identifier,
//		aaSpecific		[2] IMPLICIT NULL
//		},
//	continueAfter 	[2] IMPLICIT Identifier OPTIONAL
//	}

	@Override
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ExtendedObjectClass().init(tag, stream, true);
		case Tag.CONTEXT | 1:
			return new ObjectScope().init(tag, stream, true);
		case Tag.CONTEXT | 2:
			return new Identifier().init("continue after", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
