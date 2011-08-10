package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.CSRequestDetail;
import org.hxzon.asn1.mms.choice.ConfirmedServiceResponse;


public class ConfirmedResponsePdu extends BerSequence {
	public ConfirmedResponsePdu() {
		setName("confirmed-ResponsePDU");
		setDisplayString("confirmed-ResponsePDU");
	}

//	Confirmed-ResponsePDU ::= SEQUENCE 
//	{
//	invokeID			Unsigned32,
//	confirmedServiceResponse	ConfirmedServiceResponse,
//	cs-request-detail		[79] CS-Request-Detail OPTIONAL
//	}

	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.UNIVERSAL | Tag.INTEGER:
			return Asn1Utils.createBerUnsigned32("invokeID", "invokeID", tag, stream);
		case Tag.CONTEXT | 79:
			return new CSRequestDetail().init(tag, stream, false);
		default:
			return new ConfirmedServiceResponse().init(tag, stream, false);
		}
	}

}
