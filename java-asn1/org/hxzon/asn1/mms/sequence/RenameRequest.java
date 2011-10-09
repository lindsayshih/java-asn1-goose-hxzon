package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.ExtendedObjectClass;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.Identifier;

public class RenameRequest extends BerSequence {
//	Rename-Request ::= SEQUENCE 
//	{
//	extendedObjectClass	[0] CHOICE {
//	objectClass			[0] IMPLICIT INTEGER
//		{
//		namedVariable		(0),
//		scatteredAccess		(1),
//		namedVariableList	(2),
//		namedType		(3),
//		semaphore		(4),
//		eventCondition		(5),
//		eventAction		(6),
//		eventEnrollment		(7),
//		journal			(8),
//		domain			(9),
//		programInvocation	(10),
//		operatorStation		(11)
//		}
//
//	    },
//	currentName 		[1] ObjectName,
//	newIdentifier		[2] IMPLICIT Identifier
//      	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new ExtendedObjectClass().init(tag, stream);
        case Tag.CONTEXT | 1:
            return new ObjectName().init("currentName", "currentName", tag, stream);
        case Tag.CONTEXT | 2:
            return new Identifier().init("newIdentifier", "newIdentifier", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
