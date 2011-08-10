package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.BerChoice;
import org.hxzon.asn1.mms.sequence.EventNotification;
import org.hxzon.asn1.mms.sequence.InformationReport;
import org.hxzon.asn1.mms.sequence.UnsolicitedStatus;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.Tag;

public class UnconfirmedService extends BerChoice {

	public UnconfirmedService() {
		setName("unconfirmedService");
		setDisplayString("unconfirmedService");
	}

//	UnconfirmedService ::= CHOICE 
//	{
//	informationReport		[0]	IMPLICIT InformationReport,
//	unsolicitedStatus		[1]	IMPLICIT UnsolicitedStatus,
//	eventNotification 		[2]	IMPLICIT EventNotification
//-- XXX this one is neither in this ASN nor in the IMPORTS
//--	additionalService		[3]	AdditionalUnconfirmedService
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new InformationReport().init(tag, stream);
		case Tag.CONTEXT | 1:
			return new UnsolicitedStatus().init(tag, stream);
		case Tag.CONTEXT | 2:
			return new EventNotification().init(tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
