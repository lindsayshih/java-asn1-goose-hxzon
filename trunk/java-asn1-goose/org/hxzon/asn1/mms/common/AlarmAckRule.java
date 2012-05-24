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
    static {
        addValueString(0, "none(0)", AlarmAckRule.class);
        addValueString(1, "simple(1)", AlarmAckRule.class);
        addValueString(2, "ack-active(2)", AlarmAckRule.class);
        addValueString(3, "ack-all(3)", AlarmAckRule.class);
    }

    public AlarmAckRule() {
    }

}
