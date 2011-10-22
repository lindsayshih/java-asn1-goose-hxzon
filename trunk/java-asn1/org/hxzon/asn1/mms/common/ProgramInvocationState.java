package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.ext.BerIntegerEx;

public class ProgramInvocationState extends BerIntegerEx {
//	ProgramInvocationState ::= INTEGER
//	{
//	non-existent		(0),
//	unrunable		(1),
//	idle			(2),
//	running			(3),
//	stopped			(4),
//	starting		(5),
//	stopping		(6),
//	resuming		(7),
//	resetting		(8)
//	}
//	-- Companion Standard may add additional values

    public ProgramInvocationState() {
        addValueString(0, "non-existent(0)");
        addValueString(1, "unrunable(1)");
        addValueString(2, "idle(2)");
        addValueString(3, "running(3)");
        addValueString(4, "stopped(4)");
        addValueString(5, "starting(5)");
        addValueString(6, "stopping(6)");
        addValueString(7, "resuming(7)");
        addValueString(8, "resetting(8)");
    }
}
