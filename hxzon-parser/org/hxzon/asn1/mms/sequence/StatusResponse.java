package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerInteger;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

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

	public static class VmdLogicalStatus extends BerInteger {
		public String getValueAsString() {
			switch ((int) getValue()) {
			case 0:
				return "state-changes-allowed(0)";
			case 1:
				return "no-state-changes-allowed(1)";
			case 2:
				return "limited-services-allowed(2)";
			case 3:
				return "support-services-allowed(3)";
			default:
				return "";
			}
		}
	}

	public static class VmdPhysicalStatus extends BerInteger {
		public String getValueAsString() {
			switch ((int) getValue()) {
			case 0:
				return "operational(0)";
			case 1:
				return "partially-operational(1)";
			case 2:
				return "inoperable(2)";
			case 3:
				return "needs-commissioning(3)";
			default:
				return "";
			}
		}
	}

}
