package org.hxzon.asn1.mms;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.BerChoice;
import org.hxzon.asn1.mms.sequence.CancelErrorPdu;
import org.hxzon.asn1.mms.sequence.ConfirmedErrorPdu;
import org.hxzon.asn1.mms.sequence.ConfirmedRequestPdu;
import org.hxzon.asn1.mms.sequence.ConfirmedResponsePdu;
import org.hxzon.asn1.mms.sequence.InitiateRequestPdu;
import org.hxzon.asn1.mms.sequence.InitiateResponsePdu;
import org.hxzon.asn1.mms.sequence.RejectPdu;
import org.hxzon.asn1.mms.sequence.ServiceError;
import org.hxzon.asn1.mms.sequence.UnconfirmedPdu;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.Tag;

public class MmsPdu extends BerChoice {

	public MmsPdu() {
		setName("MMS");
		setDisplayString("MMS");
	}

//	MMSpdu ::= CHOICE
//	{
//	confirmed-RequestPDU	[0] 	IMPLICIT Confirmed-RequestPDU,
//	confirmed-ResponsePDU	[1] 	IMPLICIT Confirmed-ResponsePDU,
//	confirmed-ErrorPDU		[2] 	IMPLICIT Confirmed-ErrorPDU,
//	unconfirmed-PDU			[3] 	IMPLICIT Unconfirmed-PDU,
//	rejectPDU				[4] 	IMPLICIT RejectPDU,
//	cancel-RequestPDU		[5] 	IMPLICIT Cancel-RequestPDU,
//	cancel-ResponsePDU		[6] 	IMPLICIT Cancel-ResponsePDU,
//	cancel-ErrorPDU			[7] 	IMPLICIT Cancel-ErrorPDU,
//	initiate-RequestPDU		[8] 	IMPLICIT Initiate-RequestPDU,
//	initiate-ResponsePDU	[9] 	IMPLICIT Initiate-ResponsePDU,
//	initiate-ErrorPDU		[10] 	IMPLICIT Initiate-ErrorPDU,
//	conclude-RequestPDU		[11] 	IMPLICIT Conclude-RequestPDU,
//	conclude-ResponsePDU	[12] 	IMPLICIT Conclude-ResponsePDU,
//	conclude-ErrorPDU		[13] 	IMPLICIT Conclude-ErrorPDU
//	}
	@Override
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ConfirmedRequestPdu().init(tag, stream);
		case Tag.CONTEXT | 1:
			return new ConfirmedResponsePdu().init(tag, stream);
		case Tag.CONTEXT | 2:
			return new ConfirmedErrorPdu().init(tag, stream);
		case Tag.CONTEXT | 3:
			return new UnconfirmedPdu().init(tag, stream);
		case Tag.CONTEXT | 4:
			return new RejectPdu().init(tag, stream);
		case Tag.CONTEXT | 5:
			//Cancel-RequestPDU ::= Unsigned32	-- originalInvokeID
			return Asn1Utils.createBerUnsignedInteger("cancel-RequestPDU", "cancel-RequestPDU", tag, stream);
		case Tag.CONTEXT | 6:
			//Cancel-ResponsePDU ::= Unsigned32 	-- originalInvokeID
			return Asn1Utils.createBerUnsignedInteger("cancel-ResponsePDU", "cancel-ResponsePDU", tag, stream);
		case Tag.CONTEXT | 7:
			return new CancelErrorPdu().init("cancel-ErrorPDU", "cancel-ErrorPDU", tag, stream);
		case Tag.CONTEXT | 8:
			return new InitiateRequestPdu().init(tag, stream);
		case Tag.CONTEXT | 9:
			return new InitiateResponsePdu().init(tag, stream);
		case Tag.CONTEXT | 10:
			//Initiate-ErrorPDU ::= ServiceError
			return new ServiceError().init("initiate-ErrorPDU", "initiate-ErrorPDU", tag, stream);
		case Tag.CONTEXT | 11:
			//Conclude-RequestPDU ::= NULL
			return Asn1Utils.createBerNull("conclude-RequestPDU", "conclude-RequestPDU", tag, stream);
		case Tag.CONTEXT | 12:
			//Conclude-ResponsePDU ::= NULL
			return Asn1Utils.createBerNull("conclude-ResponsePDU", "conclude-ResponsePDU", tag, stream);
		case Tag.CONTEXT | 13:
			//Conclude-ErrorPDU ::= ServiceError
			return new ServiceError().init("conclude-ErrorPDU", "conclude-ErrorPDU", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
