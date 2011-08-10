package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.choice.CSRequestDetail;
import org.hxzon.asn1.mms.choice.ConfirmedServiceRequest;
import org.hxzon.asn1.mms.choice.Modifier;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class ConfirmedRequestPdu extends BerSequence {

	public ConfirmedRequestPdu() {
		setName("confirmed request pdu");
		setDisplayString("confirmed request pdu");
	}

//		Confirmed-RequestPDU ::= SEQUENCE
//		{
//		invokeID				Unsigned32,
//		listOfModifier			SEQUENCE OF Modifier OPTIONAL,
//		confirmedServiceRequest	ConfirmedServiceRequest,
//		cs-request-detail		[79] CS-Request-Detail OPTIONAL
//		}

	@Override
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.UNIVERSAL | Tag.INTEGER:
			return Asn1Utils.createBerUnsigned32("invokeID", "invokeID", tag, stream);
		case Tag.UNIVERSAL | Tag.SEQUENCE:
			return Asn1Utils.createBerSequenceOf("seq of modifier", "list of modifier", tag, stream, Modifier.class);
		case Tag.CONTEXT | 79:
			return new CSRequestDetail().init(tag, stream, true);
		default:
			return new ConfirmedServiceRequest().init(tag, stream, false);
		}
	}

}
