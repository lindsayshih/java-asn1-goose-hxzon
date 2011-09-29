package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.mms.common.InputResponse;
import org.hxzon.asn1.mms.sequence.AlterEventEnrollmentResponse;
import org.hxzon.asn1.mms.sequence.DeleteNamedTypeResponse;
import org.hxzon.asn1.mms.sequence.DeleteNamedVariableListResponse;
import org.hxzon.asn1.mms.sequence.DeleteVariableAccessResponse;
import org.hxzon.asn1.mms.sequence.DownloadSegmentResponse;
import org.hxzon.asn1.mms.sequence.FileDirectoryResponse;
import org.hxzon.asn1.mms.sequence.FileOpenResponse;
import org.hxzon.asn1.mms.sequence.FileReadResponse;
import org.hxzon.asn1.mms.sequence.GetAlarmEnrollmentSummaryResponse;
import org.hxzon.asn1.mms.sequence.GetAlarmSummaryResponse;
import org.hxzon.asn1.mms.sequence.GetCapabilityListResponse;
import org.hxzon.asn1.mms.sequence.GetDomainAttributesResponse;
import org.hxzon.asn1.mms.sequence.GetEventActionAttributesResponse;
import org.hxzon.asn1.mms.sequence.GetEventConditionAttributesResponse;
import org.hxzon.asn1.mms.sequence.GetEventEnrollmentAttributesResponse;
import org.hxzon.asn1.mms.sequence.GetNameListResponse;
import org.hxzon.asn1.mms.sequence.GetNamedTypeAttributesResponse;
import org.hxzon.asn1.mms.sequence.GetNamedVariableListAttributesResponse;
import org.hxzon.asn1.mms.sequence.GetProgramInvocationAttributesResponse;
import org.hxzon.asn1.mms.sequence.GetScatteredAccessAttributesResponse;
import org.hxzon.asn1.mms.sequence.GetVariableAccessAttributesResponse;
import org.hxzon.asn1.mms.sequence.IdentifyResponse;
import org.hxzon.asn1.mms.sequence.InitiateUploadSequenceResponse;
import org.hxzon.asn1.mms.sequence.ReadJournalResponse;
import org.hxzon.asn1.mms.sequence.ReadResponse;
import org.hxzon.asn1.mms.sequence.ReportEventConditionStatusResponse;
import org.hxzon.asn1.mms.sequence.ReportEventEnrollmentStatusResponse;
import org.hxzon.asn1.mms.sequence.ReportJournalStatusResponse;
import org.hxzon.asn1.mms.sequence.ReportPoolSemaphoreStatusResponse;
import org.hxzon.asn1.mms.sequence.ReportSemaphoreEntryStatusResponse;
import org.hxzon.asn1.mms.sequence.ReportSemaphoreStatusResponse;
import org.hxzon.asn1.mms.sequence.StatusResponse;
import org.hxzon.asn1.mms.sequence.UploadSegmentResponse;

public class ConfirmedServiceResponse extends BerChoice {
    public ConfirmedServiceResponse() {
        setName("ConfirmedServiceResponse");
        setDisplayString("ConfirmedServiceResponse");
    }

//	ConfirmedServiceResponse  ::= CHOICE
//	{
//	status							[0]	IMPLICIT Status-Response,
//	getNameList						[1]	IMPLICIT GetNameList-Response,
//	identify						[2]	IMPLICIT Identify-Response,
//	rename							[3]	IMPLICIT Rename-Response,
//	read							[4]	IMPLICIT Read-Response,
//	write							[5]	IMPLICIT Write-Response,
//	getVariableAccessAttributes		[6]	IMPLICIT GetVariableAccessAttributes-Response,
//	defineNamedVariable				[7]	IMPLICIT DefineNamedVariable-Response,
//	defineScatteredAccess			[8]	IMPLICIT DefineScatteredAccess-Response,
//	getScatteredAccessAttributes	[9]	IMPLICIT GetScatteredAccessAttributes-Response,
//	deleteVariableAccess			[10]	IMPLICIT DeleteVariableAccess-Response,	
//	defineNamedVariableList			[11]	IMPLICIT DefineNamedVariableList-Response,
//	getNamedVariableListAttributes	[12]	IMPLICIT GetNamedVariableListAttributes-Response,
//	deleteNamedVariableList			[13]	IMPLICIT DeleteNamedVariableList-Response,
//	defineNamedType					[14]	IMPLICIT DefineNamedType-Response,	
//	getNamedTypeAttributes			[15]	IMPLICIT GetNamedTypeAttributes-Response,
//	deleteNamedType					[16]	IMPLICIT DeleteNamedType-Response,
//	input							[17]	IMPLICIT Input-Response,
//	output							[18]	IMPLICIT Output-Response,
//	takeControl						[19]	TakeControl-Response,
//	relinquishControl				[20]	IMPLICIT RelinquishControl-Response,
//	defineSemaphore					[21]	IMPLICIT DefineSemaphore-Response,
//	deleteSemaphore					[22]	IMPLICIT DeleteSemaphore-Response,
//	reportSemaphoreStatus			[23]	IMPLICIT ReportSemaphoreStatus-Response,
//	reportPoolSemaphoreStatus		[24]	IMPLICIT ReportPoolSemaphoreStatus-Response,
//	reportSemaphoreEntryStatus		[25]	IMPLICIT ReportSemaphoreEntryStatus-Response,
//	initiateDownloadSequence		[26]	IMPLICIT InitiateDownloadSequence-Response,
//	downloadSegment					[27]	IMPLICIT DownloadSegment-Response,
//	terminateDownloadSequence		[28]	IMPLICIT TerminateDownloadSequence-Response,
//	initiateUploadSequence			[29]	IMPLICIT InitiateUploadSequence-Response,
//	uploadSegment					[30]	IMPLICIT UploadSegment-Response,
//	terminateUploadSequence			[31]	IMPLICIT TerminateUploadSequence-Response,
//	requestDomainDownLoad			[32]	IMPLICIT RequestDomainDownload-Response,
//	requestDomainUpload				[33]	IMPLICIT RequestDomainUpload-Response,
//	loadDomainContent				[34]	IMPLICIT LoadDomainContent-Response,
//	storeDomainContent				[35]	IMPLICIT StoreDomainContent-Response,
//	deleteDomain					[36]	IMPLICIT DeleteDomain-Response,
//	getDomainAttributes				[37]	IMPLICIT GetDomainAttributes-Response,
//	createProgramInvocation			[38]	IMPLICIT CreateProgramInvocation-Response,
//	deleteProgramInvocation			[39]	IMPLICIT DeleteProgramInvocation-Response,
//	start							[40]	IMPLICIT Start-Response,
//	stop							[41]	IMPLICIT Stop-Response,
//	resume							[42]	IMPLICIT Resume-Response,
//	reset							[43]	IMPLICIT Reset-Response,
//	kill							[44]	IMPLICIT Kill-Response,
//	getProgramInvocationAttributes	[45]	IMPLICIT GetProgramInvocationAttributes-Response,
//	obtainFile						[46]	IMPLICIT ObtainFile-Response,
//	fileOpen						[72]	IMPLICIT FileOpen-Response,
//	defineEventCondition			[47]	IMPLICIT DefineEventCondition-Response,
//	deleteEventCondition			[48]	IMPLICIT DeleteEventCondition-Response,
//	getEventConditionAttributes		[49]	IMPLICIT GetEventConditionAttributes-Response,
//	reportEventConditionStatus		[50]	IMPLICIT ReportEventConditionStatus-Response,
//	alterEventConditionMonitoring	[51]	IMPLICIT AlterEventConditionMonitoring-Response,
//	triggerEvent					[52]	IMPLICIT TriggerEvent-Response,
//	defineEventAction				[53]	IMPLICIT DefineEventAction-Response,
//	deleteEventAction				[54]	IMPLICIT DeleteEventAction-Response,
//	getEventActionAttributes		[55]	IMPLICIT GetEventActionAttributes-Response,
//	reportActionStatus				[56]	IMPLICIT ReportEventActionStatus-Response,
//	defineEventEnrollment			[57]	IMPLICIT DefineEventEnrollment-Response,
//	deleteEventEnrollment			[58]	IMPLICIT DeleteEventEnrollment-Response,
//	alterEventEnrollment			[59]	IMPLICIT AlterEventEnrollment-Response,
//	reportEventEnrollmentStatus		[60]	IMPLICIT ReportEventEnrollmentStatus-Response,
//	getEventEnrollmentAttributes	[61]	IMPLICIT GetEventEnrollmentAttributes-Response,
//	acknowledgeEventNotification	[62]	IMPLICIT AcknowledgeEventNotification-Response,
//	getAlarmSummary					[63]	IMPLICIT GetAlarmSummary-Response,
//	getAlarmEnrollmentSummary		[64]	IMPLICIT GetAlarmEnrollmentSummary-Response,
//	readJournal						[65]	IMPLICIT ReadJournal-Response,
//	writeJournal					[66]	IMPLICIT WriteJournal-Response,
//	initializeJournal				[67]	IMPLICIT InitializeJournal-Response,
//	reportJournalStatus				[68]	IMPLICIT ReportJournalStatus-Response,
//	createJournal					[69]	IMPLICIT CreateJournal-Response,
//	deleteJournal					[70]	IMPLICIT DeleteJournal-Response,
//	getCapabilityList				[71]	IMPLICIT GetCapabilityList-Response,
//	fileRead						[73]	IMPLICIT FileRead-Response,
//	fileClose						[74]	IMPLICIT FileClose-Response,
//	fileRename						[75]	IMPLICIT FileRename-Response,
//	fileDelete						[76]	IMPLICIT FileDelete-Response,
//	fileDirectory					[77]	IMPLICIT FileDirectory-Response
//-- XXX this one is neither in this ASN nor in the IMPORTS
//--	additionalService				[78]	AdditionalService-Response
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new StatusResponse().init("status", "status", tag, stream);
        case Tag.CONTEXT | 1:
            return new GetNameListResponse().init("getNameList", "getNameList", tag, stream);
        case Tag.CONTEXT | 2:
            return new IdentifyResponse().init("identify", "identify", tag, stream);
        case Tag.CONTEXT | 3:
            //Rename-Response ::= NULL
            return Asn1Utils.createBerNull("rename", "rename", tag, stream);
        case Tag.CONTEXT | 4:
            return new ReadResponse().init("read", "read", tag, stream);
        case Tag.CONTEXT | 5:
            return Asn1Utils.createBerSequenceOf("write", "write", tag, stream, WriteResponse.class);
        case Tag.CONTEXT | 6:
            return new GetVariableAccessAttributesResponse().init("getVariableAccessAttributes", "getVariableAccessAttributes", tag, stream);
        case Tag.CONTEXT | 7:
            //DefineNamedVariable-Response ::= NULL
            return Asn1Utils.createBerNull("defineNamedVariable", "defineNamedVariable", tag, stream);
        case Tag.CONTEXT | 8:
            //DefineScatteredAccess-Response ::= NULL
            return Asn1Utils.createBerNull("defineScatteredAccess", "defineScatteredAccess", tag, stream);
        case Tag.CONTEXT | 9:
            return new GetScatteredAccessAttributesResponse().init("getScatteredAccessAttributes", "getScatteredAccessAttributes", tag, stream);
        case Tag.CONTEXT | 10:
            return new DeleteVariableAccessResponse().init("deleteVariableAccess", "deleteVariableAccess", tag, stream);
        case Tag.CONTEXT | 11:
            //DefineNamedVariableList-Response ::= NULL
            return Asn1Utils.createBerNull("defineNamedVariableList", "defineNamedVariableList", tag, stream);
        case Tag.CONTEXT | 12:
            return new GetNamedVariableListAttributesResponse().init("getNamedVariableListAttributes", "getNamedVariableListAttributes", tag, stream);
        case Tag.CONTEXT | 13:
            return new DeleteNamedVariableListResponse().init("deleteNamedVariableList", "deleteNamedVariableList", tag, stream);
        case Tag.CONTEXT | 14:
            //DefineNamedType-Response ::= NULL
            return Asn1Utils.createBerNull("defineNamedType", "defineNamedType", tag, stream);
        case Tag.CONTEXT | 15:
            return new GetNamedTypeAttributesResponse().init("getNamedTypeAttributes", "getNamedTypeAttributes", tag, stream);
        case Tag.CONTEXT | 16:
            return new DeleteNamedTypeResponse().init("deleteNamedType", "deleteNamedType", tag, stream);
        case Tag.CONTEXT | 17:
            return new InputResponse().init("input", "input", tag, stream);
        case Tag.CONTEXT | 18:
            //Output-Response ::= NULL
            return Asn1Utils.createBerNull("output", "output", tag, stream);
        case Tag.CONTEXT | 19:
            return new TakeControlResponse().init("takeControl", "takeControl", tag, stream, true);
        case Tag.CONTEXT | 20:
            //RelinquishControl-Response ::= NULL
            return Asn1Utils.createBerNull("relinquishControl", "relinquishControl", tag, stream);
        case Tag.CONTEXT | 21:
            //DefineSemaphore-Response ::= NULL
            return Asn1Utils.createBerNull("defineSemaphore", "defineSemaphore", tag, stream);
        case Tag.CONTEXT | 22:
            //DeleteSemaphore-Response ::= NULL
            return Asn1Utils.createBerNull("deleteSemaphore", "deleteSemaphore", tag, stream);
        case Tag.CONTEXT | 23:
            return new ReportSemaphoreStatusResponse().init("reportSemaphoreStatus", "reportSemaphoreStatus", tag, stream);
        case Tag.CONTEXT | 24:
            return new ReportPoolSemaphoreStatusResponse().init("reportPoolSemaphoreStatus", "reportPoolSemaphoreStatus", tag, stream);
        case Tag.CONTEXT | 25:
            return new ReportSemaphoreEntryStatusResponse().init("reportSemaphoreEntryStatus", "reportSemaphoreEntryStatus", tag, stream);
        case Tag.CONTEXT | 26:
            //InitiateDownloadSequence-Response ::= NULL
            return Asn1Utils.createBerNull("initiateDownloadSequence", "initiateDownloadSequence", tag, stream);
        case Tag.CONTEXT | 27:
            return new DownloadSegmentResponse().init("downloadSegment", "downloadSegment", tag, stream);
        case Tag.CONTEXT | 28:
            //TerminateDownloadSequence-Response ::= NULL
            return Asn1Utils.createBerNull("terminateDownloadSequence", "terminateDownloadSequence", tag, stream);
        case Tag.CONTEXT | 29:
            return new InitiateUploadSequenceResponse().init("initiateUploadSequence", "initiateUploadSequence", tag, stream);
        case Tag.CONTEXT | 30:
            return new UploadSegmentResponse().init("uploadSegment", "uploadSegment", tag, stream);
        case Tag.CONTEXT | 31:
            //TerminateUploadSequence-Response ::= NULL
            return Asn1Utils.createBerNull("terminateUploadSequence", "terminateUploadSequence", tag, stream);
        case Tag.CONTEXT | 32:
            //RequestDomainDownload-Response ::= NULL
            return Asn1Utils.createBerNull("requestDomainDownLoad", "requestDomainDownLoad", tag, stream);
        case Tag.CONTEXT | 33:
            //RequestDomainUpload-Response ::= NULL
            return Asn1Utils.createBerNull("requestDomainUpload", "requestDomainUpload", tag, stream);
        case Tag.CONTEXT | 34:
            //LoadDomainContent-Response ::= NULL
            return Asn1Utils.createBerNull("loadDomainContent", "loadDomainContent", tag, stream);
        case Tag.CONTEXT | 35:
            //StoreDomainContent-Response ::= NULL
            return Asn1Utils.createBerNull("storeDomainContent", "storeDomainContent", tag, stream);
        case Tag.CONTEXT | 36:
            //DeleteDomain-Response ::= NULL
            return Asn1Utils.createBerNull("deleteDomain", "deleteDomain", tag, stream);
        case Tag.CONTEXT | 37:
            return new GetDomainAttributesResponse().init("getDomainAttributes", "getDomainAttributes", tag, stream);
        case Tag.CONTEXT | 38:
            //CreateProgramInvocation-Response ::= NULL
            return Asn1Utils.createBerNull("createProgramInvocation", "createProgramInvocation", tag, stream);
        case Tag.CONTEXT | 39:
            //DeleteProgramInvocation-Response ::= NULL
            return Asn1Utils.createBerNull("deleteProgramInvocation", "deleteProgramInvocation", tag, stream);
        case Tag.CONTEXT | 40:
            //Start-Response ::= NULL
            return Asn1Utils.createBerNull("start", "start", tag, stream);
        case Tag.CONTEXT | 41:
            //Stop-Response ::= NULL
            return Asn1Utils.createBerNull("stop", "stop", tag, stream);
        case Tag.CONTEXT | 42:
            //Resume-Response ::= NULL
            return Asn1Utils.createBerNull("resume", "resume", tag, stream);
        case Tag.CONTEXT | 43:
            //Reset-Response ::= NULL
            return Asn1Utils.createBerNull("reset", "reset", tag, stream);
        case Tag.CONTEXT | 44:
            //Kill-Response ::= NULL
            return Asn1Utils.createBerNull("kill", "kill", tag, stream);
        case Tag.CONTEXT | 45:
            return new GetProgramInvocationAttributesResponse().init("getProgramInvocationAttributes", "getProgramInvocationAttributes", tag, stream);
        case Tag.CONTEXT | 46:
            //ObtainFile-Response ::= NULL
            return Asn1Utils.createBerNull("obtainFile", "obtainFile", tag, stream);
        case Tag.CONTEXT | 47:
            //DefineEventCondition-Response ::= NULL
            return Asn1Utils.createBerNull("defineEventCondition", "defineEventCondition", tag, stream);
        case Tag.CONTEXT | 48:
            //DeleteEventCondition-Response ::= Unsigned32	-- Candidates Not Deleted
            return Asn1Utils.createBerUnsigned32("deleteEventCondition", "deleteEventCondition", tag, stream);
        case Tag.CONTEXT | 49:
            return new GetEventConditionAttributesResponse().init("getEventConditionAttributes", "getEventConditionAttributes", tag, stream);
        case Tag.CONSTRUCTED | 50:
            return new ReportEventConditionStatusResponse().init("reportEventConditionStatus", "reportEventConditionStatus", tag, stream);
        case Tag.CONTEXT | 51:
            //AlterEventConditionMonitoring-Response ::= NULL
            return Asn1Utils.createBerNull("alterEventConditionMonitoring", "alterEventConditionMonitoring", tag, stream);
        case Tag.CONTEXT | 52:
            //TriggerEvent-Response ::= NULL
            return Asn1Utils.createBerNull("triggerEvent", "triggerEvent", tag, stream);
        case Tag.CONTEXT | 53:
            //DefineEventAction-Response ::= NULL
            return Asn1Utils.createBerNull("defineEventAction", "defineEventAction", tag, stream);
        case Tag.CONTEXT | 54:
            //DeleteEventAction-Response ::= Unsigned32	-- candidates not deleted
            return Asn1Utils.createBerUnsigned32("deleteEventAction", "deleteEventAction", tag, stream);
        case Tag.CONTEXT | 55:
            return new GetEventActionAttributesResponse().init("getEventActionAttributes", "getEventActionAttributes", tag, stream);
        case Tag.CONTEXT | 56:
            //ReportEventActionStatus-Response ::=  Unsigned32 -- Number of Event Enrollments
            return Asn1Utils.createBerUnsigned32("reportActionStatus", "reportActionStatus", tag, stream);
        case Tag.CONTEXT | 57:
            //DefineEventEnrollment-Response ::= NULL
        case Tag.CONTEXT | 58:
            //DeleteEventEnrollment-Response ::= Unsigned32	-- candidates not deleted
        case Tag.CONTEXT | 59:
            return new AlterEventEnrollmentResponse().init("alterEventEnrollment", "alterEventEnrollment", tag, stream);
        case Tag.CONTEXT | 60:
            return new ReportEventEnrollmentStatusResponse().init("reportEventEnrollmentStatus", "reportEventEnrollmentStatus", tag, stream);
        case Tag.CONTEXT | 61:
            return new GetEventEnrollmentAttributesResponse().init("getEventEnrollmentAttributes", "getEventEnrollmentAttributes", tag, stream);
        case Tag.CONTEXT | 62:
            //AcknowledgeEventNotification-Response ::= NULL
            return Asn1Utils.createBerNull("acknowledgeEventNotification", "acknowledgeEventNotification", tag, stream);
        case Tag.CONTEXT | 63:
            return new GetAlarmSummaryResponse().init("getAlarmSummary", "getAlarmSummary", tag, stream);
        case Tag.CONTEXT | 64:
            return new GetAlarmEnrollmentSummaryResponse().init("getAlarmEnrollmentSummary", "getAlarmEnrollmentSummary", tag, stream);
        case Tag.CONTEXT | 65:
            return new ReadJournalResponse().init("readJournal", "readJournal", tag, stream);
        case Tag.CONTEXT | 66:
            //WriteJournal-Response ::= NULL
            return Asn1Utils.createBerNull("writeJournal", "writeJournal", tag, stream);
        case Tag.CONTEXT | 67:
            //InitializeJournal-Response ::= Unsigned32	-- entries deleted
            return Asn1Utils.createBerUnsigned32("initializeJournal", "initializeJournal", tag, stream);
        case Tag.CONTEXT | 68:
            return new ReportJournalStatusResponse().init("reportJournalStatus", "reportJournalStatus", tag, stream);
        case Tag.CONTEXT | 69:
            //CreateJournal-Response ::= NULL
            return Asn1Utils.createBerNull("createJournal", "createJournal", tag, stream);
        case Tag.CONTEXT | 70:
            //DeleteJournal-Response ::= NULL
            return Asn1Utils.createBerNull("deleteJournal", "deleteJournal", tag, stream);
        case Tag.CONTEXT | 71:
            return new GetCapabilityListResponse().init("getCapabilityList", "getCapabilityList", tag, stream);
        case Tag.CONTEXT | 72:
            return new FileOpenResponse().init("fileOpen", "fileOpen", tag, stream);
        case Tag.CONTEXT | 73:
            return new FileReadResponse().init("fileRead", "fileRead", tag, stream);
        case Tag.CONTEXT | 74:
            //FileClose-Response ::= NULL
            return Asn1Utils.createBerNull("fileClose", "fileClose", tag, stream);
        case Tag.CONTEXT | 75:
            //FileRename-Response ::= NULL
            return Asn1Utils.createBerNull("fileRename", "fileRename", tag, stream);
        case Tag.CONTEXT | 76:
            //FileDelete-Response ::= NULL
            return Asn1Utils.createBerNull("fileDelete", "fileDelete", tag, stream);
        case Tag.CONTEXT | 77:
            return new FileDirectoryResponse().init("fileDirectory", "fileDirectory", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
