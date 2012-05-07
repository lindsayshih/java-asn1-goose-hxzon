package org.hxzon.netprotocol.packet;

import java.util.List;

import org.hxzon.netprotocol.field.ProtocolBitField;
import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.field.ProtocolHexStringField;
import org.hxzon.netprotocol.field.ProtocolInt31Field;
import org.hxzon.netprotocol.packet.PtpPacket.PtpCorrectionField;
import org.hxzon.netprotocol.packet.PtpPacket.PtpPortIdField;
import org.hxzon.netprotocol.packet.PtpPacket.PtpSequenceIdField;
import org.hxzon.netprotocol.packet.PtpPacket.PtpV2TimestampField;
import org.hxzon.util.BitUtil;

public class PtpV2Packet extends Packet {

    public static final int EthernetType_Ptp = 0x88f7;
    public static final int HeaderLength = 34;
    private ProtocolBitField _transportSpecific;
    private ProtocolBitField _messageType;
    private ProtocolBitField _ptpVersion;
    private ProtocolInt31Field _messageLength;
    private ProtocolInt31Field _domainNumber;
    private ProtocolInt31Field _reserved1;
    private ProtocolInt31Field _flags;
    private PtpCorrectionField _correctionField;
    private ProtocolInt31Field _reserved2;
    private ProtocolHexStringField _clockIdentity;
    private PtpPortIdField _sourcePortIdentity;
    private PtpSequenceIdField _sequenceId;
    private ProtocolInt31Field _control;
    private ProtocolInt31Field _logMessageInterval;

    protected int expectHeaderLength() {
        //include header,body,extension field
        return fetchMessageLength().getValue();
    }

    protected ProtocolField[] expectHeaderFields() {
        return new ProtocolField[] { fetchTransportSpecific(), fetchMessageType(), fetchPtpVersion(), fetchMessageLength(), fetchDomainNumber(),//
                fetchReserved1(), fetchFlags(), fetchCorrectionField(), fetchReserved2(), fetchClockIdentity(), fetchSourcePortIdentity(),//
                fetchSequenceId(), fetchControl(), fetchLogMessageInterval() };
    }

    public List<ProtocolField> getHeaderFields() {
        List<ProtocolField> headerFields = super.getHeaderFields();
        int messageType = fetchMessageType().getValue();
        addExtensionFields(messageType, headerFields);
        return headerFields;
    }

    public ProtocolBitField fetchTransportSpecific() {
        if (_transportSpecific == null) {
            _transportSpecific = new ProtocolBitField("transportSpecific", "传输特性", 0, 0, 4, this) {
                public String getValueAsString() {
                    if (getValue() == 0) {
                        return "ethernet or udp/ipv6";
                    } else {
                        return "udp/ipv4";
                    }
                }
            };
        }
        return _transportSpecific;
    }

    public static final int MessageType_Sync = 0;
    public static final int MessageType_DelayReq = 1;
    public static final int MessageType_PDelayReq = 2;
    public static final int MessageType_PDelayResp = 3;
    public static final int MessageType_FollowUp = 8;
    public static final int MessageType_DelayResp = 9;
    public static final int MessageType_PDelayRespFollowUp = 10;
    public static final int MessageType_Announce = 11;
    public static final int MessageType_Signaling = 12;
    public static final int MessageType_Management = 13;

    private String messageTypeDescription(int messageType) {
        String append = "(" + messageType + ")";
        switch (messageType) {
        case MessageType_Sync:
            return "sync" + append;
        case MessageType_DelayReq:
            return "delay req" + append;
        case MessageType_PDelayReq:
            return "pdelay req" + append;
        case MessageType_PDelayResp:
            return "pdelay resp" + append;
        case MessageType_FollowUp:
            return "follow up" + append;
        case MessageType_DelayResp:
            return "delay resp" + append;
        case MessageType_PDelayRespFollowUp:
            return "pdelay resp follow up" + append;
        case MessageType_Announce:
            return "announce" + append;
        case MessageType_Signaling:
            return "signaling" + append;
        case MessageType_Management:
            return "management" + append;
        default:
            return "reserved" + append;
        }
    }

    public ProtocolBitField fetchMessageType() {
        if (_messageType == null) {
            _messageType = new ProtocolBitField("messageType", "报文类型", 0, 4, 4, this) {
                public String getValueAsString() {
                    return messageTypeDescription(getValue());
                }
            };
        }
        return _messageType;
    }

    public ProtocolBitField fetchPtpVersion() {
        if (_ptpVersion == null) {
            _ptpVersion = new ProtocolBitField("ptpVersion", "协议版本", 1, 4, 4, this);
        }
        return _ptpVersion;
    }

    public ProtocolInt31Field fetchMessageLength() {
        if (_messageLength == null) {
            _messageLength = new ProtocolInt31Field("messageLength", "报文长度", 2, 2, true, this);
        }
        return _messageLength;
    }

    public ProtocolInt31Field fetchDomainNumber() {
        if (_domainNumber == null) {
            _domainNumber = new ProtocolInt31Field("domainNumber", "时间域编号", 4, 1, true, this);
        }
        return _domainNumber;
    }

    public ProtocolInt31Field fetchReserved1() {
        if (_reserved1 == null) {
            _reserved1 = new ProtocolInt31Field("reserved1", "保留1", 5, 1, true, this);
        }
        return _reserved1;
    }

    public static final int Flags_PtpSecurity = 1 << 15;
    public static final int Flags_PtpProfileSpecific2 = 1 << 14;
    public static final int Flags_PtpProfileSpecific1 = 1 << 13;
    public static final int Flags_PtpUnicast = 1 << 10;
    public static final int Flags_PtpTwoStep = 1 << 9;
    public static final int Flags_PtpAlternateMaster = 1 << 8;
    public static final int Flags_FrequencyTraceable = 1 << 5;
    public static final int Flags_TimeTraceable = 1 << 4;
    public static final int Flags_PtpTimescale = 1 << 3;
    public static final int Flags_PtpUtcReasonable = 1 << 2;
    public static final int Flags_PtpLi59 = 1 << 1;
    public static final int Flags_PtpLi61 = 1 << 0;

    private String flagsDescription(int flags) {
        StringBuilder sb = new StringBuilder();
        if (BitUtil.isSet(flags, Flags_PtpSecurity)) {
            sb.append("ptpSecurity,");
        }
        if (BitUtil.isSet(flags, Flags_PtpProfileSpecific2)) {
            sb.append("ptpProfileSpecific2,");
        }
        if (BitUtil.isSet(flags, Flags_PtpProfileSpecific1)) {
            sb.append("ptpProfileSpecific1,");
        }
        if (BitUtil.isSet(flags, Flags_PtpUnicast)) {
            sb.append("ptpUnicast,");
        }
        if (BitUtil.isSet(flags, Flags_PtpTwoStep)) {
            sb.append("ptpTwoStep,");
        }
        if (BitUtil.isSet(flags, Flags_PtpAlternateMaster)) {
            sb.append("ptpAlternateMaster,");
        }
        if (BitUtil.isSet(flags, Flags_FrequencyTraceable)) {
            sb.append("frequencyTraceable,");
        }
        if (BitUtil.isSet(flags, Flags_TimeTraceable)) {
            sb.append("timeTraceable,");
        }
        if (BitUtil.isSet(flags, Flags_PtpTimescale)) {
            sb.append("ptpTimescale,");
        }
        if (BitUtil.isSet(flags, Flags_PtpUtcReasonable)) {
            sb.append("ptpUtcReasonable,");
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
            _flags = new ProtocolInt31Field("flags", "标志", 6, 2, true, this) {
                public String getValueAsString() {
                    return flagsDescription(getValue());
                }
            };
        }
        return _flags;
    }

    public PtpCorrectionField fetchCorrectionField() {
        if (_correctionField == null) {
            _correctionField = new PtpCorrectionField("correctionField", "时间修正", 8, 8, this);
        }
        return _correctionField;
    }

    public ProtocolInt31Field fetchReserved2() {
        if (_reserved1 == null) {
            _reserved1 = new ProtocolInt31Field("reserved2", "保留2", 16, 4, true, this);
        }
        return _reserved2;
    }

    public ProtocolHexStringField fetchClockIdentity() {
        if (_clockIdentity == null) {
            _clockIdentity = new ProtocolHexStringField("clockIdentity", "时钟设备ID", 20, 8, this);
        }
        return _clockIdentity;
    }

    public PtpPortIdField fetchSourcePortIdentity() {
        if (_sourcePortIdentity == null) {
            _sourcePortIdentity = new PtpPortIdField("sourcePortIdentity", "源端口ID", 28, 2, this);
        }
        return _sourcePortIdentity;
    }

    public PtpSequenceIdField fetchSequenceId() {
        if (_sequenceId == null) {
            _sequenceId = new PtpSequenceIdField("sequenceId", "序列号", 30, 2, this);
        }
        return _sequenceId;
    }

    //for compatibility with hardware designed to conform to version 1 of this standard
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

    public ProtocolInt31Field fetchLogMessageInterval() {
        if (_logMessageInterval == null) {
            _logMessageInterval = new ProtocolInt31Field("logMessageInterval", "日志消息间隔", 33, 1, true, this);
        }
        return _logMessageInterval;
    }

    //v2 announce
    private PtpV2TimestampField _originTimestamp;
    private ProtocolInt31Field _announce_currentUtcOffset;
    private ProtocolInt31Field _announce_reserved;
    private ProtocolInt31Field _announce_grandmasterPriority1;
    private ProtocolInt31Field _announce_grandmasterClockClass;
    private ProtocolInt31Field _announce_grandmasterClockAccuracy;
    private ProtocolInt31Field _announce_grandmasterClockVariance;
    private ProtocolInt31Field _announce_grandmasterPriority2;
    private ProtocolHexStringField _announce_grandmasterIdentity;
    private ProtocolInt31Field _announce_stepRemoved;
    private ProtocolHexStringField _announce_timeSource;

    public PtpV2TimestampField fetchOriginTimestamp() {
        if (_originTimestamp == null) {
            _originTimestamp = new PtpV2TimestampField("originTimestamp", "originTimestamp", 34, 10, this);
        }
        return _originTimestamp;
    }

    public ProtocolInt31Field fetchAnnounceCurrentUtcOffset() {
        if (_announce_currentUtcOffset == null) {
            _announce_currentUtcOffset = new ProtocolInt31Field("currentUtcOffset", "currentUtcOffset", 44, 2, true, this);
        }
        return _announce_currentUtcOffset;
    }

    public ProtocolInt31Field fetchAnnounceReserved() {
        if (_announce_reserved == null) {
            _announce_reserved = new ProtocolInt31Field("reserved", "保留", 46, 1, true, this);
        }
        return _announce_reserved;
    }

    public ProtocolInt31Field fetchAnnounceGrandmasterPriority1() {
        if (_announce_grandmasterPriority1 == null) {
            _announce_grandmasterPriority1 = new ProtocolInt31Field("grandmasterPriority1", "grandmaster优先级1", 47, 1, true, this);
        }
        return _announce_grandmasterPriority1;
    }

    public ProtocolInt31Field fetchAnnounceGrandmasterClockClass() {
        if (_announce_grandmasterClockClass == null) {
            _announce_grandmasterClockClass = new ProtocolInt31Field("grandmasterClockClass", "grandmasterClockClass", 48, 1, true, this);
        }
        return _announce_grandmasterClockClass;
    }

    public ProtocolInt31Field fetchAnnounceGrandmasterClockAccuracy() {
        if (_announce_grandmasterClockAccuracy == null) {
            _announce_grandmasterClockAccuracy = new ProtocolInt31Field("grandmasterClockAccuracy", "grandmasterClockAccuracy", 49, 1, true, this);
        }
        return _announce_grandmasterClockAccuracy;
    }

    public ProtocolInt31Field fetchAnnounceGrandmasterClockVariance() {
        if (_announce_grandmasterClockVariance == null) {
            _announce_grandmasterClockVariance = new ProtocolInt31Field("grandmasterClockVariance", "grandmasterClockVariance", 50, 2, true, this);
        }
        return _announce_grandmasterClockVariance;
    }

    public ProtocolInt31Field fetchAnnounceGrandmasterPriority2() {
        if (_announce_grandmasterPriority2 == null) {
            _announce_grandmasterPriority2 = new ProtocolInt31Field("grandmasterPriority2", "grandmaster优先级2", 52, 1, true, this);
        }
        return _announce_grandmasterPriority2;
    }

    public ProtocolHexStringField fetchAnnounceGrandmasterIdentity() {
        if (_announce_grandmasterIdentity == null) {
            _announce_grandmasterIdentity = new ProtocolHexStringField("grandmasterIdentity", "grandmasterID", 53, 8, this);
        }
        return _announce_grandmasterIdentity;
    }

    public ProtocolInt31Field fetchAnnounceStepRemoved() {
        if (_announce_stepRemoved == null) {
            _announce_stepRemoved = new ProtocolInt31Field("stepRemoved", "时钟路径跳数", 61, 2, true, this);
        }
        return _announce_stepRemoved;
    }

    public ProtocolHexStringField fetchAnnounceTimeSource() {
        if (_announce_timeSource == null) {
            _announce_timeSource = new ProtocolHexStringField("timeSource", "时间源类型", 63, 1, this);
        }
        return _announce_timeSource;
    }

    //v2 sync :originTimestamp
    //v2 delay_req :originTimestamp
    //v2 follow_up
    private PtpV2TimestampField _followUp_preciseOriginTimestamp;

    private PtpV2TimestampField fetchFollowUpPreciseOriginTimestamp() {
        if (_followUp_preciseOriginTimestamp == null) {
            _followUp_preciseOriginTimestamp = new PtpV2TimestampField("preciseOriginTimestamp", "preciseOriginTimestamp", 34, 10, this);
        }
        return _followUp_preciseOriginTimestamp;
    }

    //v2 delay_resp
    private PtpV2TimestampField _delayResp_receiveTimestamp;
    private ProtocolHexStringField _delayResp_requestingPortIdentity;

    private PtpV2TimestampField fetchDelayRespReceiveTimestamp() {
        if (_delayResp_receiveTimestamp == null) {
            _delayResp_receiveTimestamp = new PtpV2TimestampField("receiveTimestamp", "receiveTimestamp", 34, 10, this);
        }
        return _delayResp_receiveTimestamp;
    }

    private ProtocolHexStringField fetchDelayRespRequestingPortIdentity() {
        if (_delayResp_requestingPortIdentity == null) {
            _delayResp_requestingPortIdentity = new ProtocolHexStringField("requestingPortIdentity", "发送端口ID", 44, 10, this);
        }
        return _delayResp_requestingPortIdentity;
    }

    //v2 pdelay_req :originTimestamp
    private ProtocolHexStringField _pdelayReq_reserved;

    public ProtocolHexStringField fetchPdelayReqReserved() {
        if (_pdelayReq_reserved == null) {
            _pdelayReq_reserved = new ProtocolHexStringField("reserved", "保留", 44, 10, this);
        }
        return _pdelayReq_reserved;
    }

    //v2 pdelay_resp
    private PtpV2TimestampField _pdelayResp_receiveReceiptTimestamp;
    private ProtocolHexStringField _pdelayResp_requestingPortIdentity;

    public PtpV2TimestampField fetchPdelayRespReceiveReceiptTimestamp() {
        if (_pdelayResp_receiveReceiptTimestamp == null) {
            _pdelayResp_receiveReceiptTimestamp = new PtpV2TimestampField("receiveReceiptTimestamp", "receiveReceiptTimestamp", 34, 10, this);
        }
        return _pdelayResp_receiveReceiptTimestamp;
    }

    public ProtocolHexStringField fetchPdelayRespRequestingPortIdentity() {
        if (_pdelayResp_requestingPortIdentity == null) {
            _pdelayResp_requestingPortIdentity = new ProtocolHexStringField("requestingPortIdentity", "发送端口ID", 44, 10, this);
        }
        return _pdelayResp_requestingPortIdentity;
    }

    //v2 pdelay_resp_follow_up
    private PtpV2TimestampField _pdelayRespFollowUp_responseOriginTimestamp;
    private ProtocolHexStringField _pdelayRespFollowUp_requestingPortIdentity;

    public PtpV2TimestampField fetchPdelayRespFollowUpResponseOriginTimestamp() {
        if (_pdelayRespFollowUp_responseOriginTimestamp == null) {
            _pdelayRespFollowUp_responseOriginTimestamp = new PtpV2TimestampField("responseOriginTimestamp", "responseOriginTimestamp", 34, 10, this);
        }
        return _pdelayRespFollowUp_responseOriginTimestamp;
    }

    public ProtocolHexStringField fetchPdelayRespFollowUpRequestingPortIdentity() {
        if (_pdelayRespFollowUp_requestingPortIdentity == null) {
            _pdelayRespFollowUp_requestingPortIdentity = new ProtocolHexStringField("requestingPortIdentity", "发送端口ID", 44, 10, this);
        }
        return _pdelayRespFollowUp_requestingPortIdentity;
    }

    //------------------------------------
    private void addExtensionFields(int messageType, List<ProtocolField> fields) {
        switch (messageType) {
        case MessageType_Sync:
            fields.add(fetchOriginTimestamp());
            break;
        case MessageType_DelayReq:
            fields.add(fetchOriginTimestamp());
            break;
        case MessageType_FollowUp:
            fields.add(fetchFollowUpPreciseOriginTimestamp());
            break;
        case MessageType_DelayResp:
            fields.add(fetchDelayRespReceiveTimestamp());
            fields.add(fetchDelayRespRequestingPortIdentity());
            break;
        case MessageType_PDelayReq:
            fields.add(fetchOriginTimestamp());
            fields.add(fetchPdelayReqReserved());
            break;
        case MessageType_PDelayResp:
            fields.add(fetchPdelayRespReceiveReceiptTimestamp());
            fields.add(fetchPdelayRespRequestingPortIdentity());
        case MessageType_PDelayRespFollowUp:
            fields.add(fetchPdelayRespFollowUpResponseOriginTimestamp());
            fields.add(fetchPdelayRespFollowUpRequestingPortIdentity());
        case MessageType_Announce:
            fields.add(fetchOriginTimestamp());
            fields.add(fetchAnnounceCurrentUtcOffset());
            fields.add(fetchAnnounceReserved());
            fields.add(fetchAnnounceGrandmasterPriority1());
            fields.add(fetchAnnounceGrandmasterClockClass());
            fields.add(fetchAnnounceGrandmasterClockAccuracy());
            fields.add(fetchAnnounceGrandmasterClockVariance());
            fields.add(fetchAnnounceGrandmasterPriority2());
            fields.add(fetchAnnounceGrandmasterIdentity());
            fields.add(fetchAnnounceStepRemoved());
            fields.add(fetchAnnounceTimeSource());
            break;
        }
    }

}
