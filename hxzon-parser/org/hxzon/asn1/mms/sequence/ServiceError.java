package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerInteger;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.mms.choice.ErrorClass;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.common.ProgramInvocationState;


public class ServiceError extends BerSequence {
//	ServiceError ::= SEQUENCE 
//	{	
//	errorClass	[0] CHOICE
//		{ 
//		vmd-state 	[0] IMPLICIT INTEGER  	
//			{	
//			other 					(0),			       
//			vmd-state-conflict 			(1),		
//			vmd-operational-problem 		(2), 
//			domain-transfer-problem 		(3),	
//			state-machine-id-invalid 		(4)	
//                  	},
//		application-reference 	[1] IMPLICIT INTEGER
//		       	{
//			other 					(0),
//			aplication-unreachable 			(1),
//			connection-lost 			(2),
//			application-reference-invalid 		(3),
//			context-unsupported 			(4)
//			},
//		definition 			[2] IMPLICIT INTEGER
//			{
//			other 					(0),
//			object-undefined 			(1),
//			invalid-address 			(2),
//			type-unsupported 			(3),
//			type-inconsistent 			(4),
//			object-exists 				(5),
//			object-attribute-inconsistent  	        (6)
//			},
//		resource 			[3] IMPLICIT INTEGER
//			{
//			other 					(0),
//			memory-unavailable			(1),
//			processor-resource-unavailable		(2),
//			mass-storage-unavailable		(3),
//			capability-unavailable			(4),
//			capability-unknown			(5)
//		       	},
//		service 			[4] IMPLICIT INTEGER
//			{	
//			other 					(0),
//			primitives-out-of-sequence		(1),
//			object-sate-conflict			(2),
//			pdu-size				(3),
//			continuation-invalid			(4),
//			object-constraint-conflict		(5)
//		      	},
//		service-preempt 		[5] IMPLICIT INTEGER
//		      	{	
//			other					(0),
//			timeout					(1),
//			deadlock				(2),
//			cancel					(3)
//		      	},
//		time-resolution 		[6] IMPLICIT INTEGER
//		      	{	
//			other					(0),
//			unsupportable-time-resolution 		(1)
//		      	},
//		access	 			[7] IMPLICIT INTEGER
//		      	{
//			other					(0),
//			object-access-unsupported		(1),
//			object-non-existent			(2),
//			object-access-denied			(3),
//			object-invalidated			(4)
//		 	},
//		initiate 			[8] IMPLICIT INTEGER
//		     	{
//			other					(0),
//			version-incompatible			(1),
//			max-segment-insufficient		(2),
//			max-services-outstanding-calling-insufficient (3),
//			max-services-outstanding-called-insufficient  (4),
//			service-CBB-insufficient		(5),
//			parameter-CBB-insufficient		(6),
//			nesting-level-insufficient		(7)
//			},
//		conclude 			[9] IMPLICIT INTEGER
//		     	{
//			other					(0),
//			further-communication-required 		(1)
//			},
//		cancel 				[10] IMPLICIT INTEGER
//		     	{
//			other					(0),
//			invoke-id-unknown			(1),
//			cancel-not-possible			(2)
//			},
//		file 				[11] IMPLICIT INTEGER
//		     	{
//			other					(0),
//			filename-ambiguous			(1),
//			file-busy				(2),
//			filename-syntax-error			(3),
//			content-type-invalid			(4),
//			position-invalid			(5),
//			file-acces-denied			(6),
//			file-non-existent			(7),
//			duplicate-filename			(8),
//			insufficient-space-in-filestore		(9)
//			},
//		others	 		        [12] IMPLICIT INTEGER
//	        },
//	additionalCode				[1] IMPLICIT INTEGER OPTIONAL,
//	additionalDescription 		[2] IMPLICIT VisibleString OPTIONAL,
//	serviceSpecificInformation	[3] CHOICE
//			{
//			obtainFile			[0] IMPLICIT ObtainFile-Error,
//			start				[1] IMPLICIT Start-Error,
//			stop				[2] IMPLICIT Stop-Error,
//			resume				[3] IMPLICIT Resume-Error,
//			reset				[4] IMPLICIT Reset-Error,
//			deleteVariableAccess		[5] IMPLICIT DeleteVariableAccess-Error,
//			deleteNamedVariableList		[6] IMPLICIT DeleteNamedVariableList-Error,
//			deleteNamedType			[7] IMPLICIT DeleteNamedType-Error,
//			defineEventEnrollment-Error	[8] DefineEventEnrollment-Error,
//			fileRename			[9] IMPLICIT FileRename-Error
//-- XXX this one is neither in this ASN nor in the IMPORTS
//--			additionalService		[10] AdditionalServiceError
//			} OPTIONAL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ErrorClass().init("errorClass", "errorClass", tag, stream, true);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerIntegerX("additionalCode", "additionalCode", tag, stream);
		case Tag.CONTEXT | 2:
			return Asn1Utils.createBerVisibleString("additionalDescription", "additionalDescription", tag, stream);
		case Tag.CONTEXT | 3:
			return new ServiceSpecificInformation().init("serviceSpecificInformation", "serviceSpecificInformation", tag, stream, true);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

//	serviceSpecificInformation	[3] CHOICE
//	{
//	obtainFile			[0] IMPLICIT ObtainFile-Error,
//	start				[1] IMPLICIT Start-Error,
//	stop				[2] IMPLICIT Stop-Error,
//	resume				[3] IMPLICIT Resume-Error,
//	reset				[4] IMPLICIT Reset-Error,
//	deleteVariableAccess		[5] IMPLICIT DeleteVariableAccess-Error,
//	deleteNamedVariableList		[6] IMPLICIT DeleteNamedVariableList-Error,
//	deleteNamedType			[7] IMPLICIT DeleteNamedType-Error,
//	defineEventEnrollment-Error	[8] DefineEventEnrollment-Error,
//	fileRename			[9] IMPLICIT FileRename-Error
//-- XXX this one is neither in this ASN nor in the IMPORTS
//--			additionalService		[10] AdditionalServiceError
//	} OPTIONAL	
	public static class ServiceSpecificInformation extends BerChoice {
		public BerNode create(int tag, BerInputStream stream) {
			switch (tag) {
			case Tag.CONTEXT | 0:
				return new ObtainFileError().init("obtainFile", "obtainFile", tag, stream);
			case Tag.CONTEXT | 1:
				//Start-Error ::= ProgramInvocationState
				return new ProgramInvocationState().init("start", "start", tag, stream);
			case Tag.CONTEXT | 2:
				//Stop-Error ::= ProgramInvocationState
				return new ProgramInvocationState().init("stop", "stop", tag, stream);
			case Tag.CONTEXT | 3:
				//Resume-Error ::= ProgramInvocationState
				return new ProgramInvocationState().init("resume", "resume", tag, stream);
			case Tag.CONTEXT | 4:
				//Reset-Error ::= ProgramInvocationState
				return new ProgramInvocationState().init("reset", "reset", tag, stream);
			case Tag.CONTEXT | 5:
				//DeleteVariableAccess-Error ::= Unsigned32	-- numberDeleted
				return Asn1Utils.createBerUnsigned32("deleteVariableAccess", "deleteVariableAccess", tag, stream);
			case Tag.CONTEXT | 6:
				//DeleteNamedVariableList-Error ::= Unsigned32	--	number Deleted
				return Asn1Utils.createBerUnsigned32("deleteNamedVariableList", "deleteNamedVariableList", tag, stream);
			case Tag.CONTEXT | 7:
				//DeleteNamedType-Error ::= Unsigned32	--	number Deleted
				return Asn1Utils.createBerUnsigned32("deleteNamedType", "deleteNamedType", tag, stream);
			case Tag.CONTEXT | 8:
				//DefineEventEnrollment-Error ::= ObjectName
				return new ObjectName().init("defineEventEnrollment-Error", "defineEventEnrollment-Error", tag, stream);
			case Tag.CONTEXT | 9:
				return new FileRenameError().init("fileRename", "fileRename", tag, stream);
			default:
				return Asn1Utils.createUnknown(tag, stream);
			}
		}
	}

//	ObtainFile-Error ::= INTEGER {
//		source-file	 (0),
//		destination-file (1)
//		}
	public static class ObtainFileError extends BerInteger {
		public String getValueAsString() {
			switch ((int) getValue()) {
			case 0:
				return "source-file	 (0)";
			case 1:
				return "destination-file (1)";
			default:
				return "";
			}
		}
	}

//	FileRename-Error ::= INTEGER {
//		source-file	 (0),
//		destination-file (1)
//		}
	public static class FileRenameError extends BerInteger {
		public String getValueAsString() {
			switch ((int) getValue()) {
			case 0:
				return "source-file	 (0)";
			case 1:
				return "destination-file (1)";
			default:
				return "";
			}
		}
	}

}
