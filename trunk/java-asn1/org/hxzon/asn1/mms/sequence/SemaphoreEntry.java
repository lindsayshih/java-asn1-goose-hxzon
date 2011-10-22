package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerIntegerEx;
import org.hxzon.asn1.mms.common.Identifier;
import org.hxzon.asn1.mms.common.Priority;

public class SemaphoreEntry extends BerSequence {
//	SemaphoreEntry ::= SEQUENCE
//	{	
//	entryId				[0] IMPLICIT OCTET STRING,
//	entryClass			[1] IMPLICIT INTEGER
//		{
//		simple		(0),
//		modifier 	(1)
//		},
//	applicationReference		[2] ApplicationReference,
//	namedToken			[3] IMPLICIT Identifier OPTIONAL,
//	priority			[4] IMPLICIT Priority DEFAULT 64,
//	remainingTimeOut		[5] IMPLICIT Unsigned32 OPTIONAL,
//	abortOnTimeOut			[6] IMPLICIT BOOLEAN OPTIONAL,
//	relinquishIfConnectionLost	[7] IMPLICIT BOOLEAN DEFAULT TRUE
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return Asn1Utils.createBerOctetString("entryId", "entryId", tag, stream);
        case Tag.CONTEXT | 1:
            return new EntryClass().init("entryClass", "entryClass", tag, stream);
        case Tag.CONTEXT | 2:
            return new ApplicationReference().init("applicationReference", "applicationReference", tag, stream);
        case Tag.CONTEXT | 3:
            return new Identifier().init("namedToken", "namedToken", tag, stream);
        case Tag.CONTEXT | 4:
            return new Priority().init("priority", "priority", tag, stream);
        case Tag.CONTEXT | 5:
            return Asn1Utils.createBerUnsigned32("remainingTimeOut", "remainingTimeOut", tag, stream);
        case Tag.CONTEXT | 6:
            return Asn1Utils.createBerBoolean("abortOnTimeOut", "abortOnTimeOut", tag, stream);
        case Tag.CONTEXT | 7:
            return Asn1Utils.createBerBoolean("relinquishIfConnectionLost", "relinquishIfConnectionLost", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

    public static class EntryClass extends BerIntegerEx {
        //  entryClass          [1] IMPLICIT INTEGER
//      {
//      simple      (0),
//      modifier    (1)
//      },
        public EntryClass() {
            addValueString(0, "simple(0)");
            addValueString(1, "modifier(1)");
        }
    }

}
