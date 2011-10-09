package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.CSRequestDetail;
import org.hxzon.asn1.mms.choice.UnconfirmedService;

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
