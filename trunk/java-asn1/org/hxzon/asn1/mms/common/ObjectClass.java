package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.ext.BerIntegerEx;

public class ObjectClass extends BerIntegerEx {
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
    public ObjectClass() {
        addValueString(0, "nammedVariable(0)");
        addValueString(1, "scatteredAccess(1)");
        addValueString(2, "namedVariableList(2)");
        addValueString(3, "namedType(3)");
        addValueString(4, "semaphore(4)");
        addValueString(5, "eventCondition(5)");
        addValueString(6, "eventAction(6)");
        addValueString(7, "eventEnrollment(7)");
        addValueString(8, "journal(8)");
        addValueString(9, "domain(9)");
        addValueString(10, "programInvocation(10)");
        addValueString(11, "operatorStation(11)");
    }
//		},
//	objectScope 		[1] CHOICE
//		{
//		vmdSpecific		[0] IMPLICIT NULL,
//		domainSpecific		[1] IMPLICIT Identifier,
//		aaSpecific		[2] IMPLICIT NULL
//		},
//	continueAfter 	[2] IMPLICIT Identifier OPTIONAL
//	}

}
