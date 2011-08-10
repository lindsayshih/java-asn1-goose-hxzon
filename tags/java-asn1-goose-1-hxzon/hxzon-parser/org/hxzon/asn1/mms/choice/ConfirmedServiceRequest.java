package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerNull;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.mms.common.FileName;
import org.hxzon.asn1.mms.common.Identifier;
import org.hxzon.asn1.mms.sequence.AcknowledgeEventNotificationRequest;
import org.hxzon.asn1.mms.sequence.AlterEventConditionMonitoringRequest;
import org.hxzon.asn1.mms.sequence.AlterEventEnrollmentRequest;
import org.hxzon.asn1.mms.sequence.CreateJournalRequest;
import org.hxzon.asn1.mms.sequence.CreateProgramInvocationRequest;
import org.hxzon.asn1.mms.sequence.DefineEventActionRequest;
import org.hxzon.asn1.mms.sequence.DefineEventConditionRequest;
import org.hxzon.asn1.mms.sequence.DefineEventEnrollmentRequest;
import org.hxzon.asn1.mms.sequence.DefineNamedTypeRequest;
import org.hxzon.asn1.mms.sequence.DefineNamedVariableListRequest;
import org.hxzon.asn1.mms.sequence.DefineNamedVariableRequest;
import org.hxzon.asn1.mms.sequence.DefineScatteredAccessRequest;
import org.hxzon.asn1.mms.sequence.DefineSemaphoreRequest;
import org.hxzon.asn1.mms.sequence.DeleteJournalRequest;
import org.hxzon.asn1.mms.sequence.DeleteNamedTypeRequest;
import org.hxzon.asn1.mms.sequence.DeleteNamedVariableListRequest;
import org.hxzon.asn1.mms.sequence.DeleteVariableAccessRequest;
import org.hxzon.asn1.mms.sequence.FileDirectoryRequest;
import org.hxzon.asn1.mms.sequence.FileOpenRequest;
import org.hxzon.asn1.mms.sequence.FileRenameRequest;
import org.hxzon.asn1.mms.sequence.GetAlarmEnrollmentSummaryRequest;
import org.hxzon.asn1.mms.sequence.GetAlarmSummaryRequest;
import org.hxzon.asn1.mms.sequence.GetCapabilityListRequest;
import org.hxzon.asn1.mms.sequence.GetEventEnrollmentAttributesRequest;
import org.hxzon.asn1.mms.sequence.GetNameListRequest;
import org.hxzon.asn1.mms.sequence.InitializeJournalRequest;
import org.hxzon.asn1.mms.sequence.InitiateDownloadSequenceRequest;
import org.hxzon.asn1.mms.sequence.InputRequest;
import org.hxzon.asn1.mms.sequence.KillRequest;
import org.hxzon.asn1.mms.sequence.LoadDomainContentRequest;
import org.hxzon.asn1.mms.sequence.ObtainFileRequest;
import org.hxzon.asn1.mms.sequence.OutputRequest;
import org.hxzon.asn1.mms.sequence.ReadJournalRequest;
import org.hxzon.asn1.mms.sequence.ReadRequest;
import org.hxzon.asn1.mms.sequence.RelinquishControlRequest;
import org.hxzon.asn1.mms.sequence.RenameRequest;
import org.hxzon.asn1.mms.sequence.ReportPoolSemaphoreStatusRequest;
import org.hxzon.asn1.mms.sequence.ReportSemaphoreEntryStatusRequest;
import org.hxzon.asn1.mms.sequence.RequestDomainDownloadRequest;
import org.hxzon.asn1.mms.sequence.RequestDomainUploadRequest;
import org.hxzon.asn1.mms.sequence.ResetRequest;
import org.hxzon.asn1.mms.sequence.ResumeRequest;
import org.hxzon.asn1.mms.sequence.StartRequest;
import org.hxzon.asn1.mms.sequence.StopRequest;
import org.hxzon.asn1.mms.sequence.StoreDomainContentRequest;
import org.hxzon.asn1.mms.sequence.TakeControlRequest;
import org.hxzon.asn1.mms.sequence.TerminateDownloadSequenceRequest;
import org.hxzon.asn1.mms.sequence.TriggerEventRequest;
import org.hxzon.asn1.mms.sequence.WriteJournalRequest;
import org.hxzon.asn1.mms.sequence.WriteRequest;


public class ConfirmedServiceRequest extends BerChoice {

	public ConfirmedServiceRequest() {
		setName("ConfirmedServiceRequest");
		setDisplayString("ConfirmedServiceRequest");
	}

//		ConfirmedServiceRequest  ::= CHOICE 
//		{
//	        status						[0]	IMPLICIT Status-Request,
//		getNameList						[1] IMPLICIT GetNameList-Request,
//		identify						[2]	IMPLICIT Identify-Request,
//		rename							[3]	IMPLICIT Rename-Request,
//		read							[4]	IMPLICIT Read-Request,
//		write							[5]	IMPLICIT Write-Request,
//		getVariableAccessAttributes		[6]	GetVariableAccessAttributes-Request,
//		defineNamedVariable				[7]	IMPLICIT DefineNamedVariable-Request,
//		defineScatteredAccess			[8]	IMPLICIT DefineScatteredAccess-Request,
//		getScatteredAccessAttributes	[9]	IMPLICIT GetScatteredAccessAttributes-Request,
//		deleteVariableAccess			[10] IMPLICIT DeleteVariableAccess-Request,	
//		defineNamedVariableList			[11] IMPLICIT DefineNamedVariableList-Request,
//		getNamedVariableListAttributes	[12] IMPLICIT GetNamedVariableListAttributes-Request,
//		deleteNamedVariableList			[13] IMPLICIT DeleteNamedVariableList-Request,
//		defineNamedType					[14] IMPLICIT DefineNamedType-Request,	
//		getNamedTypeAttributes			[15] IMPLICIT GetNamedTypeAttributes-Request,
//		deleteNamedType					[16] IMPLICIT DeleteNamedType-Request,
//		input							[17] IMPLICIT Input-Request,
//		output							[18] IMPLICIT Output-Request,
//		takeControl						[19] IMPLICIT TakeControl-Request,
//		relinquishControl				[20] IMPLICIT RelinquishControl-Request,
//		defineSemaphore					[21] IMPLICIT DefineSemaphore-Request,
//		deleteSemaphore					[22] IMPLICIT DeleteSemaphore-Request,
//		reportSemaphoreStatus			[23] IMPLICIT ReportSemaphoreStatus-Request,
//		reportPoolSemaphoreStatus		[24] IMPLICIT ReportPoolSemaphoreStatus-Request,
//		reportSemaphoreEntryStatus		[25] IMPLICIT ReportSemaphoreEntryStatus-Request,
//		initiateDownloadSequence		[26] IMPLICIT InitiateDownloadSequence-Request,
//		downloadSegment					[27] IMPLICIT DownloadSegment-Request,
//		terminateDownloadSequence		[28] IMPLICIT TerminateDownloadSequence-Request,
//		initiateUploadSequence			[29] IMPLICIT InitiateUploadSequence-Request,
//		uploadSegment					[30] IMPLICIT UploadSegment-Request,
//		terminateUploadSequence			[31] IMPLICIT TerminateUploadSequence-Request,
//		requestDomainDownload			[32] IMPLICIT RequestDomainDownload-Request,
//		requestDomainUpload				[33] IMPLICIT RequestDomainUpload-Request,
//		loadDomainContent				[34] IMPLICIT LoadDomainContent-Request,
//		storeDomainContent				[35] IMPLICIT StoreDomainContent-Request,
//		deleteDomain					[36] IMPLICIT DeleteDomain-Request,
//		getDomainAttributes				[37] IMPLICIT GetDomainAttributes-Request,
//		createProgramInvocation			[38] IMPLICIT CreateProgramInvocation-Request,
//		deleteProgramInvocation			[39] IMPLICIT DeleteProgramInvocation-Request,
//		start							[40] IMPLICIT Start-Request,
//		stop							[41] IMPLICIT Stop-Request,
//		resume							[42] IMPLICIT Resume-Request,
//		reset							[43] IMPLICIT Reset-Request,
//		kill							[44] IMPLICIT Kill-Request,
//		getProgramInvocationAttributes	[45] IMPLICIT GetProgramInvocationAttributes-Request,
//		obtainFile						[46] IMPLICIT ObtainFile-Request,
//		defineEventCondition			[47] IMPLICIT DefineEventCondition-Request,
//		deleteEventCondition			[48] DeleteEventCondition-Request,
//		getEventConditionAttributes		[49] GetEventConditionAttributes-Request,
//		reportEventConditionStatus		[50] ReportEventConditionStatus-Request,
//		alterEventConditionMonitoring	[51] IMPLICIT AlterEventConditionMonitoring-Request,
//		triggerEvent					[52] IMPLICIT TriggerEvent-Request,
//		defineEventAction				[53] IMPLICIT DefineEventAction-Request,
//		deleteEventAction				[54] DeleteEventAction-Request,
//		getEventActionAttributes		[55] GetEventActionAttributes-Request,
//		reportEventActionStatus			[56] ReportEventActionStatus-Request,
//		defineEventEnrollment			[57] IMPLICIT DefineEventEnrollment-Request,
//		deleteEventEnrollment			[58] DeleteEventEnrollment-Request,
//		alterEventEnrollment			[59] IMPLICIT AlterEventEnrollment-Request,
//		reportEventEnrollmentStatus		[60] ReportEventEnrollmentStatus-Request,
//		getEventEnrollmentAttributes	[61] IMPLICIT GetEventEnrollmentAttributes-Request,
//		acknowledgeEventNotification	[62] IMPLICIT AcknowledgeEventNotification-Request,
//		getAlarmSummary					[63] IMPLICIT GetAlarmSummary-Request,
//		getAlarmEnrollmentSummary		[64] IMPLICIT GetAlarmEnrollmentSummary-Request,
//		readJournal						[65] IMPLICIT ReadJournal-Request,
//		writeJournal					[66] IMPLICIT WriteJournal-Request,
//		initializeJournal				[67] IMPLICIT InitializeJournal-Request,
//		reportJournalStatus				[68] IMPLICIT ReportJournalStatus-Request,
//		createJournal					[69] IMPLICIT CreateJournal-Request,
//		deleteJournal					[70] IMPLICIT DeleteJournal-Request,
//		getCapabilityList				[71] IMPLICIT GetCapabilityList-Request,
//		fileOpen						[72] IMPLICIT FileOpen-Request,
//		fileRead						[73] IMPLICIT FileRead-Request,
//		fileClose						[74] IMPLICIT FileClose-Request,
//		fileRename						[75] IMPLICIT FileRename-Request,
//		fileDelete						[76] IMPLICIT FileDelete-Request,
//		fileDirectory					[77] IMPLICIT FileDirectory-Request
//	-- XXX this one is neither in this ASN nor in the IMPORTS
//	--	additionalService				[78] AdditionalService-Request
//		}

	@Override
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerBoolean("status", "status", tag, stream);
		case Tag.CONTEXT | 1:
			return new GetNameListRequest().init("getNameList", "getNameList", tag, stream);
		case Tag.CONTEXT | 2:
			//Identify-Request ::= NULL
			return new BerNull().init("identify", "identify", tag, stream);
		case Tag.CONTEXT | 3:
			return new RenameRequest().init("rename", "rename", tag, stream);
		case Tag.CONTEXT | 4:
			return new ReadRequest().init("read", "read", tag, stream);
		case Tag.CONTEXT | 5:
			return new WriteRequest().init("write", "write", tag, stream);
		case Tag.CONTEXT | 6:
			return new GetVariableAccessAttributesRequest().init("getVariableAccessAttributes", "getVariableAccessAttributes", tag, stream, true);
		case Tag.CONTEXT | 7:
			return new DefineNamedVariableRequest().init("defineNamedVariable", "defineNamedVariable", tag, stream);
		case Tag.CONTEXT | 8:
			return new DefineScatteredAccessRequest().init("defineScatteredAccess", "defineScatteredAccess", tag, stream);
		case Tag.CONTEXT | 9:
			//GetScatteredAccessAttributes-Request ::= ObjectName	-- ScatteredAccessName
			return new ObjectName().init("getScatteredAccessAttributes", "getScatteredAccessAttributes", tag, stream, true);
		case Tag.CONTEXT | 10:
			return new DeleteVariableAccessRequest().init("deleteVariableAccess", "deleteVariableAccess", tag, stream);
		case Tag.CONTEXT | 11:
			return new DefineNamedVariableListRequest().init("defineNamedVariableList", "defineNamedVariableList", tag, stream);
		case Tag.CONTEXT | 12:
			//GetNamedVariableListAttributes-Request ::= ObjectName	-- VariableListName
			return new ObjectName().init("getNamedVariableListAttributes", "getNamedVariableListAttributes", tag, stream);
		case Tag.CONTEXT | 13:
			return new DeleteNamedVariableListRequest().init("deleteNamedVariableList", "deleteNamedVariableList", tag, stream);
		case Tag.CONTEXT | 14:
			return new DefineNamedTypeRequest().init("defineNamedType", "defineNamedType", tag, stream);
		case Tag.CONTEXT | 15:
			//GetNamedTypeAttributes-Request ::= ObjectName -- TypeName
			return new ObjectName().init("getNamedTypeAttributes", "getNamedTypeAttributes", tag, stream, true);
		case Tag.CONTEXT | 16:
			return new DeleteNamedTypeRequest().init("deleteNamedType", "deleteNamedType", tag, stream);
		case Tag.CONTEXT | 17:
			return new InputRequest().init("input", "input", tag, stream);
		case Tag.CONTEXT | 18:
			return new OutputRequest().init("output", "output", tag, stream);
		case Tag.CONTEXT | 19:
			return new TakeControlRequest().init("takeControl", "takeControl", tag, stream);
		case Tag.CONTEXT | 20:
			return new RelinquishControlRequest().init("relinquishControl", "relinquishControl", tag, stream);
		case Tag.CONTEXT | 21:
			return new DefineSemaphoreRequest().init("defineSemaphore", "defineSemaphore", tag, stream);
		case Tag.CONTEXT | 22:
			//DeleteSemaphore-Request ::= ObjectName		-- Semaphore Name
			return new ObjectName().init("deleteSemaphore", "deleteSemaphore", tag, stream);
		case Tag.CONTEXT | 23:
			//ReportSemaphoreStatus-Request ::= ObjectName	-- SemaphoreName
			return new ObjectName().init("reportSemaphoreStatus", "reportSemaphoreStatus", tag, stream);
		case Tag.CONTEXT | 24:
			return new ReportPoolSemaphoreStatusRequest().init("reportPoolSemaphoreStatus", "reportPoolSemaphoreStatus", tag, stream);
		case Tag.CONTEXT | 25:
			return new ReportSemaphoreEntryStatusRequest().init("reportSemaphoreEntryStatus", "reportSemaphoreEntryStatus", tag, stream);
		case Tag.CONTEXT | 26:
			return new InitiateDownloadSequenceRequest().init("initiateDownloadSequence", "initiateDownloadSequence", tag, stream);
		case Tag.CONTEXT | 27:
			//DownloadSegment-Request ::= Identifier
			return new Identifier().init("downloadSegment", "downloadSegment", tag, stream);
		case Tag.CONTEXT | 28:
			return new TerminateDownloadSequenceRequest().init("terminateDownloadSequence", "terminateDownloadSequence", tag, stream);
		case Tag.CONTEXT | 29:
			//InitiateUploadSequence-Request ::= Identifier 	-- Domain Name
			return new Identifier().init("initiateUploadSequence", "initiateUploadSequence", tag, stream);
		case Tag.CONTEXT | 30:
			//UploadSegment-Request ::= Integer32	-- ULSM Identifier
			return Asn1Utils.createBerInteger32("uploadSegment", "uploadSegment", tag, stream);
		case Tag.CONTEXT | 31:
			//TerminateUploadSequence-Request ::= Integer32	-- ULSM Identifer
			return Asn1Utils.createBerInteger32("terminateUploadSequence", "terminateUploadSequence", tag, stream);
		case Tag.CONTEXT | 32:
			return new RequestDomainDownloadRequest().init("requestDomainDownload", "requestDomainDownload", tag, stream);
		case Tag.CONTEXT | 33:
			return new RequestDomainUploadRequest().init("requestDomainUpload", "requestDomainUpload", tag, stream);
		case Tag.CONTEXT | 34:
			return new LoadDomainContentRequest().init("loadDomainContent", "loadDomainContent", tag, stream);
		case Tag.CONTEXT | 35:
			return new StoreDomainContentRequest().init("storeDomainContent", "storeDomainContent", tag, stream);
		case Tag.CONTEXT | 36:
			//DeleteDomain-Request ::= Identifier	-- Domain Name
			return new Identifier().init("deleteDomain", "deleteDomain", tag, stream);
		case Tag.CONTEXT | 37:
			//GetDomainAttributes-Request ::= Identifier	-- Domain Name
			return new Identifier().init("getDomainAttributes", "getDomainAttributes", tag, stream);
		case Tag.CONTEXT | 38:
			return new CreateProgramInvocationRequest().init("createProgramInvocation", "createProgramInvocation", tag, stream);
		case Tag.CONTEXT | 39:
			//DeleteProgramInvocation-Request   ::= Identifier	-- Program Invocation Name
			return new Identifier().init("deleteProgramInvocation", "deleteProgramInvocation", tag, stream);
		case Tag.CONTEXT | 40:
			return new StartRequest().init("start", "start", tag, stream);
		case Tag.CONTEXT | 41:
			return new StopRequest().init("stop", "stop", tag, stream);
		case Tag.CONTEXT | 42:
			return new ResumeRequest().init("resume", "resume", tag, stream);
		case Tag.CONTEXT | 43:
			return new ResetRequest().init("reset", "reset", tag, stream);
		case Tag.CONTEXT | 44:
			return new KillRequest().init("kill", "kill", tag, stream);
		case Tag.CONTEXT | 45:
			//GetProgramInvocationAttributes-Request ::= Identifier	-- Program Invocation Name
			return new Identifier().init("getProgramInvocationAttributes", "getProgramInvocationAttributes", tag, stream);
		case Tag.CONTEXT | 46:
			return new ObtainFileRequest().init("obtainFile", "obtainFile", tag, stream);
		case Tag.CONTEXT | 47:
			return new DefineEventConditionRequest().init("defineEventCondition", "defineEventCondition", tag, stream);
		case Tag.CONTEXT | 48:
			return new DeleteEventConditionRequest().init("deleteEventCondition", "deleteEventCondition", tag, stream);
		case Tag.CONTEXT | 49:
			//GetEventConditionAttributes-Request ::= ObjectName	-- Event Condition Name
			return new ObjectName().init("getEventConditionAttributes", "getEventConditionAttributes", tag, stream);
		case Tag.CONTEXT | 50:
			//ReportEventConditionStatus-Request ::= ObjectName	-- EventConditionName
			return new ObjectName().init("reportEventConditionStatus", "reportEventConditionStatus", tag, stream);
		case Tag.CONTEXT | 51:
			return new AlterEventConditionMonitoringRequest().init("alterEventConditionMonitoring", "alterEventConditionMonitoring", tag, stream);
		case Tag.CONTEXT | 52:
			return new TriggerEventRequest().init("triggerEvent", "triggerEvent", tag, stream);
		case Tag.CONTEXT | 53:
			return new DefineEventActionRequest().init("defineEventAction", "defineEventAction", tag, stream);
		case Tag.CONTEXT | 54:
			return new DeleteEventActionRequest().init("deleteEventAction", "deleteEventAction", tag, stream);
		case Tag.CONTEXT | 55:
			//GetEventActionAttributes-Request ::= ObjectName	-- Event Action Name
			return new ObjectName().init("getEventActionAttributes", "getEventActionAttributes", tag, stream);
		case Tag.CONTEXT | 56:
			//ReportEventActionStatus-Request ::= ObjectName	 -- EventActionName
			return new ObjectName().init("reportEventActionStatus", "reportEventActionStatus", tag, stream);
		case Tag.CONTEXT | 57:
			return new DefineEventEnrollmentRequest().init("defineEventEnrollment", "defineEventEnrollment", tag, stream);
		case Tag.CONTEXT | 58:
			return new DeleteEventEnrollmentRequest().init("deleteEventEnrollment", "deleteEventEnrollment", tag, stream);
		case Tag.CONTEXT | 59:
			return new AlterEventEnrollmentRequest().init("alterEventEnrollment", "alterEventEnrollment", tag, stream);
		case Tag.CONTEXT | 60:
			//ReportEventEnrollmentStatus-Request ::= ObjectName	-- Event Enrollment Name
			return new ObjectName().init("reportEventEnrollmentStatus", "reportEventEnrollmentStatus", tag, stream);
		case Tag.CONTEXT | 61:
			return new GetEventEnrollmentAttributesRequest().init("getEventEnrollmentAttributes", "getEventEnrollmentAttributes", tag, stream);
		case Tag.CONTEXT | 62:
			return new AcknowledgeEventNotificationRequest().init("acknowledgeEventNotification", "acknowledgeEventNotification", tag, stream);
		case Tag.CONTEXT | 63:
			return new GetAlarmSummaryRequest().init("getAlarmSummary", "getAlarmSummary", tag, stream);
		case Tag.CONTEXT | 64:
			return new GetAlarmEnrollmentSummaryRequest().init("getAlarmEnrollmentSummary", "getAlarmEnrollmentSummary", tag, stream);
		case Tag.CONTEXT | 65:
			return new ReadJournalRequest().init("readJournal", "readJournal", tag, stream);
		case Tag.CONTEXT | 66:
			return new WriteJournalRequest().init("writeJournal", "writeJournal", tag, stream);
		case Tag.CONTEXT | 67:
			return new InitializeJournalRequest().init("initializeJournal", "initializeJournal", tag, stream);
		case Tag.CONTEXT | 68:
			//ReportJournalStatus-Request ::= ObjectName	-- Journal Name
			return new ObjectName().init("reportJournalStatus", "reportJournalStatus", tag, stream);
		case Tag.CONTEXT | 69:
			return new CreateJournalRequest().init("createJournal", "createJournal", tag, stream);
		case Tag.CONTEXT | 70:
			return new DeleteJournalRequest().init("deleteJournal", "deleteJournal", tag, stream);
		case Tag.CONTEXT | 71:
			return new GetCapabilityListRequest().init("getCapabilityList", "getCapabilityList", tag, stream);
		case Tag.CONTEXT | 72:
			return new FileOpenRequest().init("fileOpen", "fileOpen", tag, stream);
		case Tag.CONTEXT | 73:
			//FileRead-Request ::= Integer32
			return Asn1Utils.createBerInteger32("fileRead", "fileRead", tag, stream);
		case Tag.CONTEXT | 74:
			//FileClose-Request ::= Integer32
			return Asn1Utils.createBerInteger32("fileClose", "fileClose", tag, stream);
		case Tag.CONTEXT | 75:
			return new FileRenameRequest().init("fileRename", "fileRename", tag, stream);
		case Tag.CONTEXT | 76:
			//FileDelete-Request ::= FileName
			return new FileName().init("fileDelete", "fileDelete", tag, stream);
		case Tag.CONTEXT | 77:
			return new FileDirectoryRequest().init("fileDirectory", "fileDirectory", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}
}
