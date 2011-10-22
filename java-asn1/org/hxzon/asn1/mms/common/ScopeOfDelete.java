package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.ext.BerIntegerEx;

public class ScopeOfDelete extends BerIntegerEx {
//	DeleteVariableAccess-Request ::= SEQUENCE
//	{
//	scopeOfDelete		[0] IMPLICIT INTEGER
//		{
//		specific		(0),
//		aa-specific		(1),
//		domain			(2),
//		vmd			(3) 
//		} DEFAULT specific,
//	listOfName		[1] IMPLICIT SEQUENCE OF ObjectName OPTIONAL,
//	domainName		[2] IMPLICIT Identifier OPTIONAL
//	}
    public ScopeOfDelete() {
        addValueString(0, "specific(0)");
        addValueString(1, "aa-specific(1)");
        addValueString(2, "domain(2)");
        addValueString(3, "vmd(3)");
    }
}
