package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;

public class ErrorClass extends BerChoice {
//	errorClass	[0] CHOICE
//	{ 
//	vmd-state 	[0] IMPLICIT INTEGER  	
//		{	
//		other 					(0),			       
//		vmd-state-conflict 			(1),		
//		vmd-operational-problem 		(2), 
//		domain-transfer-problem 		(3),	
//		state-machine-id-invalid 		(4)	
//              	},
//	application-reference 	[1] IMPLICIT INTEGER
//	       	{
//		other 					(0),
//		aplication-unreachable 			(1),
//		connection-lost 			(2),
//		application-reference-invalid 		(3),
//		context-unsupported 			(4)
//		},
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
//	resource 			[3] IMPLICIT INTEGER
//		{
//		other 					(0),
//		memory-unavailable			(1),
//		processor-resource-unavailable		(2),
//		mass-storage-unavailable		(3),
//		capability-unavailable			(4),
//		capability-unknown			(5)
//	       	},
//	service 			[4] IMPLICIT INTEGER
//		{	
//		other 					(0),
//		primitives-out-of-sequence		(1),
//		object-sate-conflict			(2),
//		pdu-size				(3),
//		continuation-invalid			(4),
//		object-constraint-conflict		(5)
//	      	},
//	service-preempt 		[5] IMPLICIT INTEGER
//	      	{	
//		other					(0),
//		timeout					(1),
//		deadlock				(2),
//		cancel					(3)
//	      	},
//	time-resolution 		[6] IMPLICIT INTEGER
//	      	{	
//		other					(0),
//		unsupportable-time-resolution 		(1)
//	      	},
//	access	 			[7] IMPLICIT INTEGER
//	      	{
//		other					(0),
//		object-access-unsupported		(1),
//		object-non-existent			(2),
//		object-access-denied			(3),
//		object-invalidated			(4)
//	 	},
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
//	conclude 			[9] IMPLICIT INTEGER
//	     	{
//		other					(0),
//		further-communication-required 		(1)
//		},
//	cancel 				[10] IMPLICIT INTEGER
//	     	{
//		other					(0),
//		invoke-id-unknown			(1),
//		cancel-not-possible			(2)
//		},
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
//	others	 		        [12] IMPLICIT INTEGER
//        },
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 12:
            return Asn1Utils.createBerIntegerX("others", "others", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }
}
