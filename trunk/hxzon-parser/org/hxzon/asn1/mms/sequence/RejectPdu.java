package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.RejectReason;


public class RejectPdu extends BerSequence {
	public RejectPdu() {
	}

//	RejectPDU ::= SEQUENCE
//	{
//	originalInvokeID		[0] IMPLICIT Unsigned32 OPTIONAL,
//	rejectReason 			    CHOICE 
//		{
//		confirmed-requestPDU		[1] IMPLICIT INTEGER 
//			{
//			other					(0),
//			unrecognized-service			(1),
//			unrecognized-modifier			(2),
//			invalid-invokeID			(3),
//			invalid-argument			(4),
//			invalid-modifier			(5),
//			max-serv-outstanding-exceeded		(6),
//			max-recursion-exceeded			(8),
//			value-out-of-range			(9)
//			},
//
//		confirmed-responsePDU		[2] IMPLICIT INTEGER 
//			{
//			other					(0),
//			unrecognized-service			(1),
//			invalid-invokeID			(2),
//			invalid-result				(3),
//			max-recursion-exceeded			(5),
//			value-out-of-range			(6) 	
//			},	
//		
//		confirmed-errorPDU		[3] IMPLICIT INTEGER 
//			{
//			other					(0),
//			unrecognized-service			(1),
//			invalid-invokeID			(2),
//			invalid-serviceError			(3),
//			value-out-of-range			(4) 	 
//			} ,			
//			
//		unconfirmedPDU			[4] IMPLICIT INTEGER
//			{
//			other					(0),
//			unrecognized-service			(1),
//			invalid-argument			(2),
//			max-recursion-exceeded			(3),
//			value-out-of-range			(4) 	
//			},
//
//		pdu-error			[5] IMPLICIT INTEGER
//			{
//			unknown-pdu-type			(0),
//			invalid-pdu				(1),
//			illegal-acse-mapping			(2)
//			},
//
//		cancel-requestPDU		[6] IMPLICIT INTEGER
//			{
//			other					(0),
//			invalid-invokeID			(1)	
//			},	
//
//		cancel-responsePDU	        [7] IMPLICIT INTEGER
//			{
//			other					(0),
//			invalid-invokeID			(1)	
//			},
//
//		cancel-errorPDU			[8] IMPLICIT INTEGER
//			{
//			other					(0),
//			invalid-invokeID			(1),
//			invalid-serviceError			(2),
//			value-out-of-range			(3) 	
//			},
//
//		conclude-requestPDU		[9] IMPLICIT INTEGER
//			{
//			other					(0),
//			invalid-argument			(1)	
//			},	
//
//		conclude-responsePDU	        [10] IMPLICIT INTEGER
//			{
//			other					(0),
//			invalid-result				(1)	
//			},
//
//		conclude-errorPDU		[11] IMPLICIT INTEGER
//			{
//			other					(0),
//			invalid-serviceError			(1),
//			value-out-of-range			(2) 	
//			}
//		}
//	}

	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerUnsigned32("originalInvokeID", "originalInvokeID", tag, stream);
		default:
			return new RejectReason().init("rejectReason", "rejectReason", tag, stream, false);
		}
	}

}
