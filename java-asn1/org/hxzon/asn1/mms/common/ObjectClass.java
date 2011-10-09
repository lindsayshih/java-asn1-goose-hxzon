package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.BerInteger;

public class ObjectClass extends BerInteger {
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

    public String getValueAsString() {
        switch ((int) getValue()) {
        case 0:
            return "nammedVariable";
        case 1:
            return "scatteredAccess";
        case 2:
            return "namedVariableList";
        case 3:
            return "namedType";
        case 4:
            return "semaphore";
        case 5:
            return "eventCondition";
        case 6:
            return "eventAction";
        case 7:
            return "eventEnrollment";
        case 8:
            return "journal";
        case 9:
            return "domain";
        case 10:
            return "programInvocation";
        case 11:
            return "operatorStation";
        default:
            return "unknown";
        }
    }
}
