package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerNull;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.mms.common.Identifier;

public class ObjectScope extends BerChoice {

    public ObjectScope() {
        setId("object scope");
        setName("object scope");
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

    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new BerNull().init("vmd specific", "vmd specific", tag, stream);
        case Tag.CONTEXT | 1:
            return new Identifier().init("domain specific", "domain specific", tag, stream);
        case Tag.CONTEXT | 2:
            return new BerNull().init("aaSpecific", "aaSpecific", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }
}
