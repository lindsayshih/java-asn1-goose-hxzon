package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.mms.choice.CSRequestDetail;
import org.hxzon.asn1.mms.choice.UnconfirmedService;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class UnconfirmedPdu extends BerSequence {
	public UnconfirmedPdu() {
		setName("unconfirmed pdu");
		setDisplayString("unconfirmed pdu");
	}

//	Unconfirmed-PDU ::= SEQUENCE
//	{
//        unconfirmedService		UnconfirmedService,
//	cs-request-detail		[79] CS-Request-Detail OPTIONAL
//	}

	@Override
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 79:
			return new CSRequestDetail().init(tag, stream, true);
		default:
			return new UnconfirmedService().init(tag, stream, false);
		}
	}

}
