package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.type.BerInteger;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;


public class RejectReason extends BerChoice {
//	rejectReason 			    CHOICE 
//	{
//	confirmed-requestPDU		[1] IMPLICIT INTEGER 
//		{
//		other					(0),
//		unrecognized-service			(1),
//		unrecognized-modifier			(2),
//		invalid-invokeID			(3),
//		invalid-argument			(4),
//		invalid-modifier			(5),
//		max-serv-outstanding-exceeded		(6),
//		max-recursion-exceeded			(8),
//		value-out-of-range			(9)
//		},
//
//	confirmed-responsePDU		[2] IMPLICIT INTEGER 
//		{
//		other					(0),
//		unrecognized-service			(1),
//		invalid-invokeID			(2),
//		invalid-result				(3),
//		max-recursion-exceeded			(5),
//		value-out-of-range			(6) 	
//		},	
//	
//	confirmed-errorPDU		[3] IMPLICIT INTEGER 
//		{
//		other					(0),
//		unrecognized-service			(1),
//		invalid-invokeID			(2),
//		invalid-serviceError			(3),
//		value-out-of-range			(4) 	 
//		} ,			
//		
//	unconfirmedPDU			[4] IMPLICIT INTEGER
//		{
//		other					(0),
//		unrecognized-service			(1),
//		invalid-argument			(2),
//		max-recursion-exceeded			(3),
//		value-out-of-range			(4) 	
//		},
//
//	pdu-error			[5] IMPLICIT INTEGER
//		{
//		unknown-pdu-type			(0),
//		invalid-pdu				(1),
//		illegal-acse-mapping			(2)
//		},
//
//	cancel-requestPDU		[6] IMPLICIT INTEGER
//		{
//		other					(0),
//		invalid-invokeID			(1)	
//		},	
//
//	cancel-responsePDU	        [7] IMPLICIT INTEGER
//		{
//		other					(0),
//		invalid-invokeID			(1)	
//		},
//
//	cancel-errorPDU			[8] IMPLICIT INTEGER
//		{
//		other					(0),
//		invalid-invokeID			(1),
//		invalid-serviceError			(2),
//		value-out-of-range			(3) 	
//		},
//
//	conclude-requestPDU		[9] IMPLICIT INTEGER
//		{
//		other					(0),
//		invalid-argument			(1)	
//		},	
//
//	conclude-responsePDU	        [10] IMPLICIT INTEGER
//		{
//		other					(0),
//		invalid-result				(1)	
//		},
//
//	conclude-errorPDU		[11] IMPLICIT INTEGER
//		{
//		other					(0),
//		invalid-serviceError			(1),
//		value-out-of-range			(2) 	
//		}
//	}
	public static final String[] numberName=new String[]{"--","confirmed-requestPDU","confirmed-responsePDU","confirmed-errorPDU",
		"unconfirmedPDU","pdu-error","cancel-requestPDU",
		"cancel-responsePDU","cancel-errorPDU","conclude-requestPDU",
		"conclude-responsePDU","conclude-errorPDU"};
	public static final String[][] numberDescription = new String[][] {
		new String[]{"--"},
//		confirmed-requestPDU		[1] IMPLICIT INTEGER 
//		{
//		other(0),
//		unrecognized-service(1),
//		unrecognized-modifier(2),
//		invalid-invokeID(3),
//		invalid-argument(4),
//		invalid-modifier(5),
//		max-serv-outstanding-exceeded(6),
//		max-recursion-exceeded(8),
//		value-out-of-range(9)
//		},
			new String[] { "other(0)", "unrecognized-service(1)", "unrecognized-modifier(2)", "invalid-invokeID(3)", "invalid-argument(4)", "invalid-modifier(5)", "max-serv-outstanding-exceeded(6)",
					"--", "max-recursion-exceeded(8)", "value-out-of-range(9)" },
//		confirmed-responsePDU		[2] IMPLICIT INTEGER 
//		{
//		other(0),
//		unrecognized-service(1),
//		invalid-invokeID(2),
//		invalid-result(3),
//		max-recursion-exceeded(5),
//		value-out-of-range(6) 	
//		},
			new String[] { "other(0)", "unrecognized-service(1)", "invalid-invokeID(2)", "invalid-result(3)", "--", "max-recursion-exceeded(5)", "value-out-of-range(6)" },
//	confirmed-errorPDU		[3] IMPLICIT INTEGER 
//		{
//		other(0),
//		unrecognized-service(1),
//		invalid-invokeID(2),
//		invalid-serviceError(3),
//		value-out-of-range(4) 	 
//		} ,	
			new String[] { "other(0)", "unrecognized-service(1)", "invalid-invokeID(2)", "invalid-serviceError(3)", "value-out-of-range(4)", "--" },
//	unconfirmedPDU			[4] IMPLICIT INTEGER
//		{
//		other(0),
//		unrecognized-service(1),
//		invalid-argument(2),
//		max-recursion-exceeded(3),
//		value-out-of-range(4) 	
//		},
			new String[] { "other(0)", "unrecognized-service(1)", "invalid-argument(2)", "max-recursion-exceeded(3)", "value-out-of-range(4)" },
//	pdu-error			[5] IMPLICIT INTEGER
//		{
//		unknown-pdu-type(0),
//		invalid-pdu(1),
//		illegal-acse-mapping(2)
//		},
			new String[] { "unknown-pdu-type(0)", "invalid-pdu(1)", "illegal-acse-mapping(2)" },
//	cancel-requestPDU		[6] IMPLICIT INTEGER
//		{
//		other(0),
//		invalid-invokeID(1)	
//		},	
			new String[] { "other(0)", "invalid-invokeID(1)", },
//	cancel-responsePDU	        [7] IMPLICIT INTEGER
//		{
//		other(0),
//		invalid-invokeID(1)	
//		},
			new String[] { "other(0)", "invalid-invokeID(1)" },
//	cancel-errorPDU			[8] IMPLICIT INTEGER
//		{
//		other(0),
//		invalid-invokeID(1),
//		invalid-serviceError(2),
//		value-out-of-range(3) 	
//		},
			new String[] { "other(0)", "invalid-invokeID(1)", "invalid-serviceError(2)", "value-out-of-range(3)" },
//	conclude-requestPDU		[9] IMPLICIT INTEGER
//		{
//		other(0),
//		invalid-argument(1)	
//		},	
			new String[] { "other(0)", "invalid-argument(1)" },
//	conclude-responsePDU	        [10] IMPLICIT INTEGER
//		{
//		other(0),
//		invalid-result(1)	
//		},
			new String[] { "other(0)", "invalid-result(1)" },
//	conclude-errorPDU		[11] IMPLICIT INTEGER
//		{
//		other(0),
//		invalid-serviceError(1),
//		value-out-of-range(2) 	
//		}
			new String[] { "other(0)", "invalid-serviceError(1)", "value-out-of-range(2)" } };

	public static class RejectReasonInteger extends BerInteger {
		public String getValueAsString() {
			return numberDescription[getTag() & Tag.TAGNUMBER_MASK][(int) getValue()];
		}
	}

	public BerNode create(int tag, BerInputStream stream) {
		int tagNumber = tag & Tag.TAGNUMBER_MASK;
		return new RejectReasonInteger().init(numberName[tagNumber], numberName[tagNumber], tag, stream);
	}
}
