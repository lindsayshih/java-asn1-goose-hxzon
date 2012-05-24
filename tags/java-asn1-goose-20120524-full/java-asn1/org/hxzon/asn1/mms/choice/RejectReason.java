package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.core.type.ext.BerIntegerEx2;

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
    public static class RejectReasonInteger extends BerIntegerEx2 {
        static {
            addDisplayString(1, "confirmed-requestPDU");
            addValueString(1, 0, "other(0)");
            addValueString(1, 1, "unrecognized-service(1)");
            addValueString(1, 2, "unrecognized-modifier(2)");
            addValueString(1, 3, "invalid-invokeID(3)");
            addValueString(1, 4, "invalid-argument(4)");
            addValueString(1, 5, "invalid-modifier(5)");
            addValueString(1, 6, "max-serv-outstanding-exceeded(6)");
            addValueString(1, 7, null);
            addValueString(1, 8, "max-recursion-exceeded(8)");
            addValueString(1, 9, "value-out-of-range(9)");
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
            addDisplayString(2, "confirmed-responsePDU");
            addValueString(2, 0, "other(0)");
            addValueString(2, 1, "unrecognized-service(1)");
            addValueString(2, 2, "invalid-invokeID(2)");
            addValueString(2, 3, "invalid-result(3)");
            addValueString(2, 4, null);
            addValueString(2, 5, "max-recursion-exceeded(5)");
            addValueString(2, 6, "value-out-of-range(6)");
//	
//	confirmed-errorPDU		[3] IMPLICIT INTEGER 
//		{
//		other					(0),
//		unrecognized-service			(1),
//		invalid-invokeID			(2),
//		invalid-serviceError			(3),
//		value-out-of-range			(4) 	 
//		} ,
            addDisplayString(3, "confirmed-errorPDU");
            addValueString(3, 0, "other(0)");
            addValueString(3, 1, "unrecognized-service(1)");
            addValueString(3, 2, "invalid-invokeID(2)");
            addValueString(3, 3, "invalid-serviceError(3)");
            addValueString(3, 4, "value-out-of-range(4)");
//		
//	unconfirmedPDU			[4] IMPLICIT INTEGER
//		{
//		other					(0),
//		unrecognized-service			(1),
//		invalid-argument			(2),
//		max-recursion-exceeded			(3),
//		value-out-of-range			(4) 	
//		},
            addDisplayString(4, "unconfirmedPDU");
            addValueString(4, 0, "other(0)");
            addValueString(4, 1, "unrecognized-service(1)");
            addValueString(4, 2, "invalid-argument(2)");
            addValueString(4, 3, "max-recursion-exceeded(3)");
            addValueString(4, 4, "value-out-of-range(4)");
//
//	pdu-error			[5] IMPLICIT INTEGER
//		{
//		unknown-pdu-type			(0),
//		invalid-pdu				(1),
//		illegal-acse-mapping			(2)
//		},
            addDisplayString(5, "pdu-error");
            addValueString(5, 0, "unknown-pdu-type(0)");
            addValueString(5, 1, "invalid-pdu(1)");
            addValueString(5, 2, "illegal-acse-mapping(2)");
//
//	cancel-requestPDU		[6] IMPLICIT INTEGER
//		{
//		other					(0),
//		invalid-invokeID			(1)	
//		},
            addDisplayString(6, "cancel-requestPDU");
            addValueString(6, 0, "other(0)");
            addValueString(6, 1, "invalid-invokeID(1)");
//
//	cancel-responsePDU	        [7] IMPLICIT INTEGER
//		{
//		other					(0),
//		invalid-invokeID			(1)	
//		},
            addDisplayString(7, "cancel-responsePDU");
            addValueString(7, 0, "other(0)");
            addValueString(7, 1, "invalid-invokeID(1)");
//
//	cancel-errorPDU			[8] IMPLICIT INTEGER
//		{
//		other					(0),
//		invalid-invokeID			(1),
//		invalid-serviceError			(2),
//		value-out-of-range			(3) 	
//		},
            addDisplayString(8, "cancel-errorPDU");
            addValueString(8, 0, "other(0)");
            addValueString(8, 1, "invalid-invokeID(1)");
            addValueString(8, 2, "invalid-serviceError(2)");
            addValueString(8, 3, "value-out-of-range(3)");
//
//	conclude-requestPDU		[9] IMPLICIT INTEGER
//		{
//		other					(0),
//		invalid-argument			(1)	
//		},
            addDisplayString(9, "conclude-requestPDU");
            addValueString(9, 0, "other(0)");
            addValueString(9, 1, "invalid-argument(1)");
//
//	conclude-responsePDU	        [10] IMPLICIT INTEGER
//		{
//		other					(0),
//		invalid-result				(1)	
//		},
            addDisplayString(10, "conclude-responsePDU");
            addValueString(10, 0, "other(0)");
            addValueString(10, 1, "invalid-result(1)");
//
//	conclude-errorPDU		[11] IMPLICIT INTEGER
//		{
//		other					(0),
//		invalid-serviceError			(1),
//		value-out-of-range			(2) 	
//		}
            addDisplayString(11, "conclude-errorPDU");
            addValueString(11, 0, "other(0)");
            addValueString(11, 1, "invalid-serviceError(1)");
            addValueString(11, 2, "value-out-of-range(2)");
//	}

        }

        public static void addValueString(int tagNumber, int value, String valueString) {
            addValueString(tagNumber, value, valueString, RejectReasonInteger.class);
        }

        public static void addValueString(int tagNumber, String valueString) {
            addValueString(tagNumber, valueString, RejectReasonInteger.class);
        }

        public static void addDisplayString(int tagNumber, String displayString) {
            addDisplayString(tagNumber, displayString, RejectReasonInteger.class);
        }

        public RejectReasonInteger() {

        }
    }

    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 1:
        case Tag.CONTEXT | 2:
        case Tag.CONTEXT | 3:
        case Tag.CONTEXT | 4:
        case Tag.CONTEXT | 5:
        case Tag.CONTEXT | 6:
        case Tag.CONTEXT | 7:
        case Tag.CONTEXT | 8:
        case Tag.CONTEXT | 9:
        case Tag.CONTEXT | 10:
        case Tag.CONTEXT | 11:
            return new RejectReasonInteger().init(tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }
}
