package org.hxzon.asn1.mms;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerParser;

public class MmsPduParser extends BerParser {
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
	public static final MmsPduParser mmsParser = new MmsPduParser();

//	public static final int State_ConfirmedRequestPdu = 1;
//	public static final int State_ConfirmedResponsePdu = 2;
//	public static final int State_ConfirmedErrorPdu = 3;
//	public static final int State_UnconfirmedPdu = 4;
//	public static final int State_RejectPdu = 5;
//	public static final int State_CancelRequestPdu = 6;
//	public static final int State_CancelResponsePdu = 7;
//	public static final int State_CancelErrorPdu = 8;
//	public static final int State_InitiateRequestPdu = 9;
//	public static final int State_InitiateResponsePdu = 10;
//	public static final int State_InitiateErrorPdu = 11;
//	public static final int State_ConcludeRequestPdu = 12;
//	public static final int State_ConcludeResponsePdu = 13;
//	public static final int State_ConcludeErrorPdu = 14;

	@Override
	public BerNode create(int tag, BerInputStream stream, int state) {
		return new MmsPdu().init(tag, stream);
	}

}
