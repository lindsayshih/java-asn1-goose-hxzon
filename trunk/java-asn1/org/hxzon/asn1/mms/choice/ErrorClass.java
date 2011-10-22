package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.core.type.ext.BerIntegerEx2;

public class ErrorClass extends BerChoice {
//	errorClass	[0] CHOICE
//	{ 
    public static class ErrorClassInteger extends BerIntegerEx2 {
        public ErrorClassInteger() {
            addDisplayString(0, "vmd-state");
            addValueString(0, 0, "other(0)");
            addValueString(0, 1, "vmd-state-conflict(1)");
            addValueString(0, 2, "vmd-operational-problem(2)");
            addValueString(0, 3, "domain-transfer-problem(3)");
            addValueString(0, 4, "state-machine-id-invalid(4)");
//	vmd-state 	[0] IMPLICIT INTEGER  	
//		{	
//		other 					(0),			       
//		vmd-state-conflict 			(1),		
//		vmd-operational-problem 		(2), 
//		domain-transfer-problem 		(3),	
//		state-machine-id-invalid 		(4)	
//              	},
            addDisplayString(1, "application-reference");
            addValueString(1, 0, "other(0)");
            addValueString(1, 2, "aplication-unreachable(1)");
            addValueString(1, 3, "application-reference-invalid(3)");
            addValueString(1, 4, "context-unsupported(4)");
//	application-reference 	[1] IMPLICIT INTEGER
//	       	{
//		other 					(0),
//		aplication-unreachable 			(1),
//		connection-lost 			(2),
//		application-reference-invalid 		(3),
//		context-unsupported 			(4)
//		},
            addDisplayString(2, "definition");
            addValueString(2, 0, "other(0)");
            addValueString(2, 1, "object-undefined(1)");
            addValueString(2, 2, "invalid-address(2)");
            addValueString(2, 3, "type-unsupported(3)");
            addValueString(2, 4, "type-inconsistent(4)");
            addValueString(2, 5, "object-exists(5)");
            addValueString(2, 6, "object-attribute-inconsistent(6)");
//	definition 			[2] IMPLICIT INTEGER
//		{
//		other 					(0),
//		object-undefined 			(1),
//		invalid-address 			(2),
//		type-unsupported 			(3),
//		type-inconsistent 			(4),
//		object-exists 				(5),
//		object-attribute-inconsistent  	        (6)
//		},
            addDisplayString(3, "resource");
            addValueString(3, 0, "other(0)");
            addValueString(3, 1, "memory-unavailable(1)");
            addValueString(3, 2, "processor-resource-unavailable(2)");
            addValueString(3, 3, "mass-storage-unavailable(3)");
            addValueString(3, 4, "capability-unavailable(4)");
            addValueString(3, 5, "capability-unknown(5)");
//	resource 			[3] IMPLICIT INTEGER
//		{
//		other 					(0),
//		memory-unavailable			(1),
//		processor-resource-unavailable		(2),
//		mass-storage-unavailable		(3),
//		capability-unavailable			(4),
//		capability-unknown			(5)
//	       	},
            addDisplayString(4, "service");
            addValueString(4, 0, "other(0)");
            addValueString(4, 1, "primitives-out-of-sequence(1)");
            addValueString(4, 2, "object-sate-conflict(2)");
            addValueString(4, 3, "pdu-size(3)");
            addValueString(4, 4, "continuation-invalid(4)");
            addValueString(4, 5, "object-constraint-conflict(5)");
//	service 			[4] IMPLICIT INTEGER
//		{	
//		other 					(0),
//		primitives-out-of-sequence		(1),
//		object-sate-conflict			(2),
//		pdu-size				(3),
//		continuation-invalid			(4),
//		object-constraint-conflict		(5)
//	      	},
            addDisplayString(5, "service-preempt");
            addValueString(5, 0, "other(0)");
            addValueString(5, 1, "timeout(1)");
            addValueString(5, 2, "deadlock(2)");
            addValueString(5, 3, "cancel(3)");
//	service-preempt 		[5] IMPLICIT INTEGER
//	      	{	
//		other					(0),
//		timeout					(1),
//		deadlock				(2),
//		cancel					(3)
//	      	},
            addDisplayString(6, "time-resolution");
            addValueString(6, 0, "other(0)");
            addValueString(6, 1, "unsupportable-time-resolution(1)");
//	time-resolution 		[6] IMPLICIT INTEGER
//	      	{	
//		other					(0),
//		unsupportable-time-resolution 		(1)
//	      	},
            addDisplayString(7, "access");
            addValueString(7, 0, "other(0)");
            addValueString(7, 1, "object-access-unsupported(1)");
            addValueString(7, 2, "object-non-existent(2)");
            addValueString(7, 3, "object-access-denied(3)");
            addValueString(7, 4, "object-invalidated(4)");
//	access	 			[7] IMPLICIT INTEGER
//	      	{
//		other					(0),
//		object-access-unsupported		(1),
//		object-non-existent			(2),
//		object-access-denied			(3),
//		object-invalidated			(4)
//	 	},
            addDisplayString(8, "initiate");
            addValueString(8, 0, "other(0)");
            addValueString(8, 1, "version-incompatible(1)");
            addValueString(8, 2, "max-segment-insufficient(2)");
            addValueString(8, 3, "max-services-outstanding-calling-insufficient(3)");
            addValueString(8, 4, "max-services-outstanding-called-insufficient(4)");
            addValueString(8, 5, "service-CBB-insufficient(5)");
            addValueString(8, 6, "parameter-CBB-insufficient(6)");
            addValueString(8, 7, "nesting-level-insufficient(7)");
//	initiate 			[8] IMPLICIT INTEGER
//	     	{
//		other					(0),
//		version-incompatible			(1),
//		max-segment-insufficient		(2),
//		max-services-outstanding-calling-insufficient (3),
//		max-services-outstanding-called-insufficient  (4),
//		service-CBB-insufficient		(5),
//		parameter-CBB-insufficient		(6),
//		nesting-level-insufficient		(7)
//		},
            addDisplayString(9, "conclude");
            addValueString(9, 0, "other(0)");
            addValueString(9, 1, "further-communication-required(1)");
//	conclude 			[9] IMPLICIT INTEGER
//	     	{
//		other					(0),
//		further-communication-required 		(1)
//		},
            addDisplayString(10, "cancel ");
            addValueString(10, 0, "other(0)");
            addValueString(10, 1, "invoke-id-unknown(1)");
            addValueString(10, 2, "cancel-not-possible(2)");
//	cancel 				[10] IMPLICIT INTEGER
//	     	{
//		other					(0),
//		invoke-id-unknown			(1),
//		cancel-not-possible			(2)
//		},
            addDisplayString(11, "file");
            addValueString(11, 0, "other(0)");
            addValueString(11, 1, "filename-ambiguous(1)");
            addValueString(11, 2, "file-busy(2)");
            addValueString(11, 3, "filename-syntax-error(3)");
            addValueString(11, 4, "content-type-invalid(4)");
            addValueString(11, 5, "position-invalid(5)");
            addValueString(11, 6, "file-acces-denied(6)");
            addValueString(11, 7, "file-non-existent(7)");
            addValueString(11, 8, "duplicate-filename(8)");
            addValueString(11, 9, "insufficient-space-in-filestore(9)");
//	file 				[11] IMPLICIT INTEGER
//	     	{
//		other					(0),
//		filename-ambiguous			(1),
//		file-busy				(2),
//		filename-syntax-error			(3),
//		content-type-invalid			(4),
//		position-invalid			(5),
//		file-acces-denied			(6),
//		file-non-existent			(7),
//		duplicate-filename			(8),
//		insufficient-space-in-filestore		(9)
//		},
            addDisplayString(12, "others");
            addValueString(12, "others");
//	others	 		        [12] IMPLICIT INTEGER
//        },
        }
    }

    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
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
        case Tag.CONTEXT | 12:
            return new ErrorClassInteger().init(tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
