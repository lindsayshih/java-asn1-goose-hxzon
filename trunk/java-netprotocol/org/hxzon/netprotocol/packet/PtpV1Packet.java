package org.hxzon.netprotocol.packet;

import java.util.List;

import org.hxzon.netprotocol.field.ProtocolAsciiStringField;
import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.field.ProtocolInt31Field;
import org.hxzon.netprotocol.field.ProtocolInt63Field;
import org.hxzon.netprotocol.packet.PtpPacket.PtpClockIdField;
import org.hxzon.netprotocol.packet.PtpPacket.PtpCommunicationTechnologyField;
import org.hxzon.netprotocol.packet.PtpPacket.PtpPortIdField;
import org.hxzon.netprotocol.packet.PtpPacket.PtpSequenceIdField;
import org.hxzon.netprotocol.packet.PtpPacket.PtpUuidField;
import org.hxzon.netprotocol.packet.PtpPacket.PtpV1TimestampField;
import org.hxzon.util.BitUtil;

public class PtpV1Packet extends Packet {

    public static final int EthernetType_Ptp = 0x88f7;
    public static final int HeaderLength = 34;
    private ProtocolInt31Field _ptpVersion;
    private ProtocolInt31Field _networkVersion;
    private ProtocolAsciiStringField _subdomain;
    private ProtocolInt31Field _messageType;
    private PtpCommunicationTechnologyField _sourceCommunicationTechnology;
    private PtpUuidField _sourceUuid;
    private PtpPortIdField _sourcePortId;
    private PtpSequenceIdField _sequenceId;
    private ProtocolInt31Field _control;
    private ProtocolInt31Field _reserved;
    private ProtocolInt31Field _flags;
    private ProtocolInt31Field _reserved2;

    protected int expectHeaderLength() {
        return super.getTotalLength();
    }

    protected ProtocolField[] expectHeaderFields() {
        return new ProtocolField[] { fetchPtpVersion(), fetchNetworkVersion(), fetchSubdomain(), fetchMessageType(),//
                fetchSourceCommunicationTechnology(), fetchSourceUuid(), fetchSourcePortId(),//
                fetchSequenceId(), fetchControl(), fetchReserved(), fetchFlags() };
    }

    public List<ProtocolField> getHeaderFields() {
        if (_headerFields == null) {
            _headerFields = super.getHeaderFields();
            int control = fetchControl().getValue();
            addExtensionFields(control, _headerFields);
        }
        return _headerFields;
    }

    //----------------------------
    public ProtocolInt31Field fetchPtpVersion() {
        if (_ptpVersion == null) {
            _ptpVersion = new ProtocolInt31Field("ptpVersion", "协议版本", 0, 2, true, this);
        }
        return _ptpVersion;
    }

    public ProtocolInt31Field fetchNetworkVersion() {
        if (_networkVersion == null) {
            _networkVersion = new ProtocolInt31Field("networkVersion", "网络版本", 2, 2, true, this);
        }
        return _networkVersion;
    }

    public ProtocolAsciiStringField fetchSubdomain() {
        if (_subdomain == null) {
            _subdomain = new ProtocolAsciiStringField("subdomain", "subdomain", 4, 16, this);
        }
        return _subdomain;
    }

    public ProtocolInt31Field fetchMessageType() {
        if (_messageType == null) {
            _messageType = new ProtocolInt31Field("messageType", "报文类型", 20, 1, true, this) {
                public String getValueAsString() {
                    switch (getValue()) {
                    case 1:
                        return "事件报文";
                    case 2:
                        return "通用报文";
                    default:
                        return "未知";
                    }
                }
            };
        }
        return _messageType;
    }

    public PtpCommunicationTechnologyField fetchSourceCommunicationTechnology() {
        if (_sourceCommunicationTechnology == null) {
            _sourceCommunicationTechnology = new PtpCommunicationTechnologyField("sourceCommunicationTechnology", "sourceCommunicationTechnology", 21, 1, this);
        }
        return _sourceCommunicationTechnology;
    }

    public PtpUuidField fetchSourceUuid() {
        if (_sourceUuid == null) {
            _sourceUuid = new PtpUuidField("sourceUuid", "源UUID", 22, 6, this);
        }
        return _sourceUuid;
    }

    public PtpPortIdField fetchSourcePortId() {
        if (_sourcePortId == null) {
            _sourcePortId = new PtpPortIdField("sourcePortId", "源端口ID", 28, 2, this);
        }
        return _sourcePortId;
    }

    public PtpSequenceIdField fetchSequenceId() {
        if (_sequenceId == null) {
            _sequenceId = new PtpSequenceIdField("sequenceId", "序列号", 30, 2, this);
        }
        return _sequenceId;
    }

    public ProtocolInt31Field fetchControl() {
        if (_control == null) {
            _control = new ProtocolInt31Field("control", "控制", 32, 1, true, this) {
                public String getValueAsString() {
                    return PtpPacket.controlDescription(getValue());
                }
            };
        }
        return _control;
    }

    public ProtocolInt31Field fetchReserved() {
        if (_reserved == null) {
            _reserved = new ProtocolInt31Field("reserved", "保留", 33, 1, true, this);
        }
        return _reserved;
    }

    public static final int Flags_PtpSyncBurst = 1 << 6;
    public static final int Flags_PtpParentStats = 1 << 5;
    public static final int Flags_PtpExtSync = 1 << 4;
    public static final int Flags_PtpAssist = 1 << 3;
    public static final int Flags_PtpBoundaryClock = 1 << 2;
    public static final int Flags_PtpLi59 = 1 << 1;
    public static final int Flags_PtpLi61 = 1 << 0;

    public String flagsDescription(int flags) {
        StringBuilder sb = new StringBuilder();
        if (BitUtil.isSet(flags, Flags_PtpSyncBurst)) {
            sb.append("ptpSyncBurst,");
        }
        if (BitUtil.isSet(flags, Flags_PtpParentStats)) {
            sb.append("ptpParentStats,");
        }
        if (BitUtil.isSet(flags, Flags_PtpExtSync)) {
            sb.append("ptpExtSync,");
        }
        if (BitUtil.isSet(flags, Flags_PtpAssist)) {
            sb.append("ptpAssist,");
        }
        if (BitUtil.isSet(flags, Flags_PtpBoundaryClock)) {
            sb.append("ptpboundaryClock,");
        }
        if (BitUtil.isSet(flags, Flags_PtpLi59)) {
            sb.append("ptpLi59,");
        }
        if (BitUtil.isSet(flags, Flags_PtpLi61)) {
            sb.append("ptpLi61");
        }
        return sb.toString();
    }

    public ProtocolInt31Field fetchFlags() {
        if (_flags == null) {
            _flags = new ProtocolInt31Field("flags", "标志", 34, 2, true, this) {
                public String getValueAsString() {
                    return flagsDescription(getValue());
                }
            };
        }
        return _flags;
    }

    public ProtocolInt31Field fetchReserved2() {
        if (_reserved2 == null) {
            _reserved2 = new ProtocolInt31Field("reserved2", "保留2", 36, 4, true, this);
        }
        return _reserved2;
    }

    //v1 sync/delay req
    private PtpV1TimestampField _sync_originTimestamp;
    private ProtocolInt31Field _sync_epochNumber;
    private ProtocolInt31Field _sync_currentUtcOffset;
    private PtpCommunicationTechnologyField _sync_grandmasterCommunicationTechnology;
    private PtpUuidField _sync_grandmasterClockUuid;
    private PtpPortIdField _sync_grandmasterPortId;
    private PtpSequenceIdField _sync_grandmasterSequenceId;
    private ProtocolInt31Field _sync_grandmasterClockStratum;
    private PtpClockIdField _sync_grandmasterClockIdentifier;
    private ProtocolInt31Field _sync_grandmasterClockVariance;
    private ProtocolInt31Field _sync_grandmasterClockPreferred;
    private ProtocolInt31Field _sync_grandmasterClockIsBoundaryClock;
    private ProtocolInt31Field _sync_syncInterval;
    private ProtocolInt31Field _sync_localClockVariance;
    private ProtocolInt31Field _sync_localStepsRemoved;
    private ProtocolInt31Field _sync_localClockStratum;
    private PtpClockIdField _sync_localClockIdentifier;
    private PtpCommunicationTechnologyField _sync_parentCommunicationTechnology;
    private PtpUuidField _sync_parentUuid;
    private PtpPortIdField _sync_parentPort;
    private ProtocolInt31Field _sync_estimatedMasterVariance;
    private ProtocolInt31Field _sync_estimatedMasterDrift;
    private ProtocolInt31Field _sync_utcReasonable;

    public PtpV1TimestampField fetchSyncOriginTimestamp() {
        if (_sync_originTimestamp == null) {
            _sync_originTimestamp = new PtpV1TimestampField("originTimestamp", "originTimestamp", 40, 8, this);
        }
        return _sync_originTimestamp;
    }

    public ProtocolInt31Field fetchEpochNumber() {
        if (_sync_epochNumber == null) {
            _sync_epochNumber = new ProtocolInt31Field("epochNumber", "epochNumber", 48, 2, true, this);
        }
        return _sync_epochNumber;
    }

    public ProtocolInt31Field fetchCurrentUtcOffset() {
        if (_sync_currentUtcOffset == null) {
            _sync_currentUtcOffset = new ProtocolInt31Field("currentUtcOffset", "currentUtcOffset", 50, 2, true, this);
        }
        return _sync_currentUtcOffset;
    }

    public PtpCommunicationTechnologyField fetchGrandmasterCommunicationTechnology() {
        if (_sync_grandmasterCommunicationTechnology == null) {
            _sync_grandmasterCommunicationTechnology = new PtpCommunicationTechnologyField("grandmasterCommunicationTechnology", "grandmasterCommunicationTechnology", 53, 1, this);//1 byte reserved
        }
        return _sync_grandmasterCommunicationTechnology;
    }

    public PtpUuidField fetchGrandmasterClockUuid() {
        if (_sync_grandmasterClockUuid == null) {
            _sync_grandmasterClockUuid = new PtpUuidField("grandmasterClockUuid", "grandmasterClockUUID", 54, 6, this);
        }
        return _sync_grandmasterClockUuid;
    }

    public PtpPortIdField fetchGrandmasterPortId() {
        if (_sync_grandmasterPortId == null) {
            _sync_grandmasterPortId = new PtpPortIdField("grandmasterPortId", "grandmaster端口ID", 60, 2, this);
        }
        return _sync_grandmasterPortId;
    }

    public PtpSequenceIdField fetchGrandmasterSequenceId() {
        if (_sync_grandmasterSequenceId == null) {
            _sync_grandmasterSequenceId = new PtpSequenceIdField("grandmasterSequenceId", "grandmaster序列号", 62, 2, this);
        }
        return _sync_grandmasterSequenceId;
    }

    public ProtocolInt31Field fetchGrandmasterClockStratum() {
        if (_sync_grandmasterClockStratum == null) {
            _sync_grandmasterClockStratum = new ProtocolInt31Field("grandmasterClockStratum", "grandmasterClockStratum", 67, 1, true, this);//3 byte reserved
        }
        return _sync_grandmasterClockStratum;
    }

    public PtpClockIdField fetchGrandmasterClockIdentifier() {
        if (_sync_grandmasterClockIdentifier == null) {
            _sync_grandmasterClockIdentifier = new PtpClockIdField("grandmasterClockIdentifier", "grandmasterClockID", 68, 4, this);
        }
        return _sync_grandmasterClockIdentifier;
    }

    public ProtocolInt31Field fetchGrandmasterClockVariance() {
        if (_sync_grandmasterClockVariance == null) {
            _sync_grandmasterClockVariance = new ProtocolInt31Field("grandmasterClockVariance", "grandmasterClockVariance", 74, 2, false, this);//2 byte reserved
        }
        return _sync_grandmasterClockVariance;
    }

    public ProtocolInt31Field fetchGrandmasterClockPreferred() {
        if (_sync_grandmasterClockPreferred == null) {
            _sync_grandmasterClockPreferred = new ProtocolInt31Field("grandmasterPreferred", "grandmasterPreferred", 77, 1, true, this);//1 byte reserved
        }
        return _sync_grandmasterClockPreferred;
    }

    public ProtocolInt31Field fetchGrandmasterClockIsBoundaryClock() {
        if (_sync_grandmasterClockIsBoundaryClock == null) {
            _sync_grandmasterClockIsBoundaryClock = new ProtocolInt31Field("grandmasterIsBoundaryClock", "grandmasterIsBoundaryClock", 79, 1, true, this);//1 byte reserved
        }
        return _sync_grandmasterClockIsBoundaryClock;
    }

    public ProtocolInt31Field fetchSyncInterval() {
        if (_sync_syncInterval == null) {
            _sync_syncInterval = new ProtocolInt31Field("syncInterval", "syncInterval", 83, 1, true, this);//3 byte reserved
        }
        return _sync_syncInterval;
    }

    public ProtocolInt31Field fetchLocalClockVariance() {
        if (_sync_localClockVariance == null) {
            _sync_localClockVariance = new ProtocolInt31Field("localClockVariance", "localClockVariance", 86, 2, false, this);//2 byte reserved
        }
        return _sync_localClockVariance;
    }

    public ProtocolInt31Field fetchLocalStepsRemoved() {
        if (_sync_localStepsRemoved == null) {
            _sync_localStepsRemoved = new ProtocolInt31Field("localStepsRemoved", "localStepsRemoved", 90, 2, true, this);//2 byte reserved
        }
        return _sync_localStepsRemoved;
    }

    public ProtocolInt31Field fetchLocalClockStratum() {
        if (_sync_localClockStratum == null) {
            _sync_localClockStratum = new ProtocolInt31Field("localClockStratum", "localClockStratum", 95, 1, true, this);//3 byte reserved
        }
        return _sync_localClockStratum;
    }

    public PtpClockIdField fetchLocalClockIdentifier() {
        if (_sync_localClockIdentifier == null) {
            _sync_localClockIdentifier = new PtpClockIdField("localClockIdentifier", "localClockID", 96, 4, this);
        }
        return _sync_localClockIdentifier;
    }

    public PtpCommunicationTechnologyField fetchParentCommunicationTechnology() {
        if (_sync_parentCommunicationTechnology == null) {
            _sync_parentCommunicationTechnology = new PtpCommunicationTechnologyField("parentCommunicationTechnology", "parentCommunicationTechnology", 101, 1, this);//1 byte reserved
        }
        return _sync_parentCommunicationTechnology;
    }

    public PtpUuidField fetchParentUuid() {
        if (_sync_parentUuid == null) {
            _sync_parentUuid = new PtpUuidField("parentUuid", "parentUUID", 102, 6, this);
        }
        return _sync_parentUuid;
    }

    public PtpPortIdField fetchParentPort() {
        if (_sync_parentPort == null) {
            _sync_parentPort = new PtpPortIdField("parentPort", "parentPort", 110, 2, this);//2 byte reserved
        }
        return _sync_parentPort;
    }

    public ProtocolInt31Field fetchEstimatedMasterVariance() {
        if (_sync_estimatedMasterVariance == null) {
            _sync_estimatedMasterVariance = new ProtocolInt31Field("estimatedMasterVariance", "estimatedMasterVariance", 114, 2, true, this);//2 byte reserved
        }
        return _sync_estimatedMasterVariance;
    }

    public ProtocolInt31Field fetchEstimatedMasterDrift() {
        if (_sync_estimatedMasterDrift == null) {
            _sync_estimatedMasterDrift = new ProtocolInt31Field("estimatedMasterDrift", "estimatedMasterDrift", 116, 4, true, this);
        }
        return _sync_estimatedMasterDrift;
    }

    public ProtocolInt31Field fetchUtcReasonable() {
        if (_sync_utcReasonable == null) {
            _sync_utcReasonable = new ProtocolInt31Field("utcReasonable", "utcReasonable", 123, 1, true, this) {//3 byte reserved
                public String getValueAsString() {
                    return getValue() == 0 ? "FALSE" : "TRUE";
                }
            };
        }
        return _sync_utcReasonable;
    }

    //v1 follow up
    private ProtocolInt31Field _followUp_reserved;
    private PtpSequenceIdField _followUp_associatedSequenceId;
    private PtpV1TimestampField _followUp_preciseOriginTimestamp;

    public ProtocolInt31Field fetchFollowUpReserved() {
        if (_followUp_reserved == null) {
            _followUp_reserved = new ProtocolInt31Field("reserved", "保留", 40, 2, true, this);
        }
        return _followUp_reserved;
    }

    public PtpSequenceIdField fetchFollowUpAssociatedSequenceId() {
        if (_followUp_associatedSequenceId == null) {
            _followUp_associatedSequenceId = new PtpSequenceIdField("associatedSequenceId", "associatedSequenceID", 42, 2, this);
        }
        return _followUp_associatedSequenceId;
    }

    public PtpV1TimestampField fetchFollowUpPreciseOriginTimestamp() {
        if (_followUp_preciseOriginTimestamp == null) {
            _followUp_preciseOriginTimestamp = new PtpV1TimestampField("preciseOriginTimestamp", "preciseOriginTimestampe", 44, 8, this);
        }
        return _followUp_preciseOriginTimestamp;
    }

    //v1 delay resp
    private PtpV1TimestampField _delayResp_delayReceiptTimestamp;
    private PtpCommunicationTechnologyField _delayResp_requestingSourceCommunicationTechnology;
    private PtpUuidField _delayResp_requestingSourceUuid;
    private PtpPortIdField _delayResp_requestingSourcePortId;
    private PtpSequenceIdField _delayResp_requestingSourceSequenceId;

    public PtpV1TimestampField fetchDelayRespDelayReceiptTimestamp() {
        if (_delayResp_delayReceiptTimestamp == null) {
            _delayResp_delayReceiptTimestamp = new PtpV1TimestampField("delayReceiptTimestamp", "delayReceiptTimestamp", 40, 8, this);
        }
        return _delayResp_delayReceiptTimestamp;
    }

    public PtpCommunicationTechnologyField fetchDelayRespRequestingSourceCommunicationTechnology() {
        if (_delayResp_requestingSourceCommunicationTechnology == null) {
            _delayResp_requestingSourceCommunicationTechnology = new PtpCommunicationTechnologyField("requestingSourceCommunicationTechnology", "requestingSourceCommunicationTechnology", 49, 1, this);//1 byte reserved
        }
        return _delayResp_requestingSourceCommunicationTechnology;
    }

    public PtpUuidField fetchDelayRespRequestingSourceUuid() {
        if (_delayResp_requestingSourceUuid == null) {
            _delayResp_requestingSourceUuid = new PtpUuidField("requestingSourceUuid", "requestingSourceUUID", 50, 6, this);
        }
        return _delayResp_requestingSourceUuid;
    }

    public PtpPortIdField fetchDelayRespRequestingSourcePortId() {
        if (_delayResp_requestingSourcePortId == null) {
            _delayResp_requestingSourcePortId = new PtpPortIdField("requestingSourcePortId", "requestingSourcePortID", 56, 2, this);
        }
        return _delayResp_requestingSourcePortId;
    }

    public PtpSequenceIdField fetchDelayRespRequestingSourceSequenceId() {
        if (_delayResp_requestingSourceSequenceId == null) {
            _delayResp_requestingSourceSequenceId = new PtpSequenceIdField("requestingSourceSequenceId", "requestingSource序列号", 58, 2, this);
        }
        return _delayResp_requestingSourceSequenceId;
    }

    //v2 management
    private ProtocolInt31Field _management_targetCommunicationTechnology;
    private PtpUuidField _management_targetUuid;
    private PtpPortIdField _management_targetPortId;
    private ProtocolInt63Field _management_startingBoundaryHops;
    private ProtocolInt63Field _management_boundaryHops;
    private ProtocolInt63Field _management_managementMessageKey;
    private ProtocolInt63Field _management_parameterLength;
    private ProtocolInt63Field _management_messageParameters;//TODO

    public ProtocolInt31Field fetchManagementTargetCommunicationTechnology() {
        if (_management_targetCommunicationTechnology == null) {
            _management_targetCommunicationTechnology = new ProtocolInt31Field("targetCommunicationTechnology", "targetCommunicationTechnology", 40, 1, true, this);
        }
        return _management_targetCommunicationTechnology;
    }

    public PtpUuidField fetchManagementTargetUuid() {
        if (_management_targetUuid == null) {
            _management_targetUuid = new PtpUuidField("targetUuid", "targetUuid", 41, 6, this);
        }
        return _management_targetUuid;
    }

    public PtpPortIdField fetchManagementTargetPortId() {
        if (_management_targetPortId == null) {
            _management_targetPortId = new PtpPortIdField("targetPortId", "targetPortId", 47, 6, this);
        }
        return _management_targetPortId;
    }

    public ProtocolInt63Field fetchManagementStartingBoundaryHops() {
        if (_management_startingBoundaryHops == null) {
            _management_startingBoundaryHops = new ProtocolInt63Field("startingBoundaryHops", "startingBoundaryHops", 53, 6, true, this);
        }
        return _management_startingBoundaryHops;
    }

    public ProtocolInt63Field fetchManagementBoundaryHops() {
        if (_management_boundaryHops == null) {
            _management_boundaryHops = new ProtocolInt63Field("boundaryHops", "boundaryHops", 59, 6, true, this);
        }
        return _management_boundaryHops;
    }

    public ProtocolInt63Field fetchManagementManagementMessageKey() {
        if (_management_managementMessageKey == null) {
            _management_managementMessageKey = new ProtocolInt63Field("managementMessageKey", "managementMessageKey", 65, 8, true, this);
        }
        return _management_managementMessageKey;
    }

    public ProtocolInt63Field fetchManagementParameterLength() {
        if (_management_parameterLength == null) {
            _management_parameterLength = new ProtocolInt63Field("parameterLength", "parameterLength", 73, 6, true, this);
        }
        return _management_parameterLength;
    }

    //--------------------------------------------------------------------------------------
    private void addExtensionFields(int control, List<ProtocolField> fields) {
        switch (control) {
        case PtpPacket.Control_Sync:
        case PtpPacket.Control_DelayReq:
            addSyncFields(fields);
            break;
        case PtpPacket.Control_FollowUp:
            addFollowUpFields(fields);
            break;
        case PtpPacket.Control_DelayResp:
            addDelayRespFields(fields);
            break;
        case PtpPacket.Control_Management:
            addManagementFields(fields);
            break;
        }
    }

//
    private void addSyncFields(List<ProtocolField> fields) {
        fields.add(fetchSyncOriginTimestamp());
        fields.add(fetchEpochNumber());
        fields.add(fetchCurrentUtcOffset());
        fields.add(fetchGrandmasterCommunicationTechnology());
        fields.add(fetchGrandmasterClockUuid());
        fields.add(fetchGrandmasterPortId());
        fields.add(fetchGrandmasterSequenceId());
        fields.add(fetchGrandmasterClockStratum());
        fields.add(fetchGrandmasterClockIdentifier());
        fields.add(fetchGrandmasterClockVariance());
        fields.add(fetchGrandmasterClockPreferred());
        fields.add(fetchGrandmasterClockIsBoundaryClock());
        fields.add(fetchSyncInterval());
        fields.add(fetchLocalClockVariance());
        fields.add(fetchLocalStepsRemoved());
        fields.add(fetchLocalClockStratum());
        fields.add(fetchLocalClockIdentifier());
        fields.add(fetchParentCommunicationTechnology());
        fields.add(fetchParentUuid());
        fields.add(fetchParentPort());
        fields.add(fetchEstimatedMasterVariance());
        fields.add(fetchEstimatedMasterDrift());
        fields.add(fetchUtcReasonable());
    }

    private void addFollowUpFields(List<ProtocolField> fields) {
        fields.add(fetchFollowUpReserved());
        fields.add(fetchFollowUpAssociatedSequenceId());
        fields.add(fetchFollowUpPreciseOriginTimestamp());
    }

    private void addDelayRespFields(List<ProtocolField> fields) {
        fields.add(fetchDelayRespDelayReceiptTimestamp());
        fields.add(fetchDelayRespRequestingSourceCommunicationTechnology());
        fields.add(fetchDelayRespRequestingSourceUuid());
        fields.add(fetchDelayRespRequestingSourcePortId());
        fields.add(fetchDelayRespRequestingSourceSequenceId());
    }

    private void addManagementFields(List<ProtocolField> fields) {
        fields.add(fetchManagementTargetCommunicationTechnology());
        fields.add(fetchManagementTargetUuid());
        fields.add(fetchManagementTargetPortId());
        fields.add(fetchManagementStartingBoundaryHops());
        fields.add(fetchManagementBoundaryHops());
        fields.add(fetchManagementManagementMessageKey());
        fields.add(fetchManagementParameterLength());
    }
}
