package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerIntegerEx;

public class StatusResponse extends BerSequence {
//	Status-Response ::= SEQUENCE {
//    vmdLogicalStatus	     [0] IMPLICIT INTEGER {
//      state-changes-allowed	  (0),
//      no-state-changes-allowed	  (1),
//      limited-services-allowed	  (2),
//      support-services-allowed	  (3)
//      },
//    vmdPhysicalStatus	     [1] IMPLICIT INTEGER {
//      operational		  (0),
//      partially-operational	  (1),
//      inoperable		  (2),
//      needs-commissioning	  (3)
//      },
//    localDetail		     [2] IMPLICIT BIT STRING(SIZE(0..128)) OPTIONAL
//
//    }

    @Override
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new VmdLogicalStatus().init("vmdLogicalStatus", "vmdLogicalStatus", tag, stream);
        case Tag.CONTEXT | 1:
            return new VmdPhysicalStatus().init("vmdPhysicalStatus", "vmdPhysicalStatus", tag, stream);
        case Tag.CONTEXT | 2:
            return Asn1Utils.createBerBitString("localDetail", "localDetail", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

    public static class VmdLogicalStatus extends BerIntegerEx {
        public VmdLogicalStatus() {
            addValueString(0, "state-changes-allowed(0)");
            addValueString(1, "no-state-changes-allowed(1)");
            addValueString(2, "limited-services-allowed(2)");
            addValueString(3, "support-services-allowed(3)");
        }
    }

    public static class VmdPhysicalStatus extends BerIntegerEx {
        public VmdPhysicalStatus() {
            addValueString(0, "operational(0)");
            addValueString(1, "partially-operational(1)");
            addValueString(2, "inoperable(2)");
            addValueString(3, "needs-commissioning(3)");
        }
    }

}
