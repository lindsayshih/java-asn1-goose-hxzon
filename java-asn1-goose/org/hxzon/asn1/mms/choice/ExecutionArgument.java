package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;

public class ExecutionArgument extends BerChoice {
//	executionArgument	CHOICE {
//	    simpleString	  [1] IMPLICIT VisibleString,
//	    encodedString	  EXTERNALt
//	    }
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 1:
            return Asn1Utils.createBerVisibleString("simpleString", "simpleString", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }
}
