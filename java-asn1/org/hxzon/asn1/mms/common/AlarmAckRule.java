package org.hxzon.asn1.mms.common;

import org.hxzon.asn1.core.type.ext.BerIntegerEx;

public class AlarmAckRule extends BerIntegerEx {
//	AlarmAckRule ::= INTEGER
//	{
//	none			(0),
//	simple			(1),
//	ack-active		(2),
//	ack-all			(3)
//	}
    public AlarmAckRule(){
        addValueString(0,"none(0)");
        addValueString(1,"simple(1)");
        addValueString(2,"ack-active(2)");
        addValueString(3,"ack-all(3)");
    }

}
