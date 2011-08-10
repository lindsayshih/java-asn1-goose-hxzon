package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.CSRequestDetail;
import org.hxzon.asn1.mms.choice.ConfirmedServiceResponse;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

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
			return Asn1Utils.createBerUnsignedInteger("invokeID", "invokeID", tag, stream);
		case Tag.CONTEXT | 79:
			return new CSRequestDetail().init(tag, stream, false);
		default:
			return new ConfirmedServiceResponse().init(tag, stream, false);
		}
	}

}
