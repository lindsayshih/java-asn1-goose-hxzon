package org.hxzon.netprotocol.packet;

import java.util.List;

import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.netprotocol.field.ProtocolAsciiStringField;
import org.hxzon.netprotocol.field.ProtocolBitField;
import org.hxzon.netprotocol.field.ProtocolByteArrayField;
import org.hxzon.netprotocol.field.ProtocolField;
import org.hxzon.netprotocol.field.ProtocolInt31Field;
import org.hxzon.netprotocol.parse.ProtocolBinding;
import org.hxzon.netprotocol.parse.ProtocolBindingList;
import org.hxzon.netprotocol.parse.ProtocolDescUtil;
import org.hxzon.netprotocol.payload.EmptyPayload;
import org.hxzon.netprotocol.payload.MissPayload;
import org.hxzon.util.BytesUtil;

public class PtpPacket extends Packet {
    static {
        ProtocolBindingList.addBinding(new ProtocolBinding<EthernetPacket>() {

            @Override
            public Packet match(EthernetPacket packet) {
                if (packet.fetchType().getValue() == EthernetType_Ptp) {
                    return new PtpPacket();
                } else {
                    return null;
                }
            }

        });
        ProtocolBindingList.addBinding(new ProtocolBinding<VlanPacket>() {

            @Override
            public Packet match(VlanPacket packet) {
                if (packet.fetchType().getValue() == EthernetType_Ptp) {
                    return new PtpPacket();
                } else {
                    return null;
                }
            }

        });
        ProtocolBindingList.addBinding(new ProtocolBinding<UdpPacket>() {

            @Override
            public Packet match(UdpPacket packet) {
                if (packet.fetchDestPort().getValue() == 319 || packet.fetchSourcePort().getValue() == 319 || //
                        packet.fetchDestPort().getValue() == 320 || packet.fetchSourcePort().getValue() == 320) {
                    return new PtpPacket();
                } else {
                    return null;
                }
            }

        });
        ProtocolDescUtil.putDesc(PtpPacket.class, "ptp(ieee1588)");
    }

    public static class PtpV2TimestampField extends ProtocolField {

        public PtpV2TimestampField(String name, String display, int offset, int len, Packet srcPacket) {
            setPacket(srcPacket);
            setName(name);
            setDisplayString(display);
            setSaveOffsetAndLen(srcPacket, offset, len);
            seconds = srcPacket.getHexValue(getOffset(), 6);
            nanoSeconds = srcPacket.getHexValue(getOffset() + 6, 4);
        }

        private long seconds;
        private long nanoSeconds;

        @Override
        public String getValueAsString() {
            return seconds + "." + nanoSeconds;
        }
    }

    public static class PtpV1TimestampField extends ProtocolField {

        public PtpV1TimestampField(String name, String display, int offset, int len, Packet srcPacket) {
            setPacket(srcPacket);
            setName(name);
            setDisplayString(display);
            setSaveOffsetAndLen(srcPacket, offset, len);
            seconds = srcPacket.getHexValue(getOffset(), 4);
            nanoSeconds = srcPacket.getHexValue(getOffset() + 4, 4);
        }

        private long seconds;
        private long nanoSeconds;

        @Override
        public String getValueAsString() {
            return seconds + "." + nanoSeconds;
        }
    }

    public static class PtpCorrectionField extends ProtocolField {
        public PtpCorrectionField(String name, String display, int offset, int len, Packet srcPacket) {
            setPacket(srcPacket);
            setName(name);
            setDisplayString(display);
            setSaveOffsetAndLen(srcPacket, offset, len);
            correctionNs = srcPacket.getHexValue(getOffset(), 6);
            subNs = srcPacket.getHexValue(getOffset() + 6, 2);
        }

        private long correctionNs;
        private long subNs;

        @Override
        public String getValueAsString() {
            return "correctionNs:" + correctionNs + ",subNs:" + subNs;
        }
    }

    public static class PtpUuidField extends ProtocolByteArrayField {

        public PtpUuidField(String name, String display, int offset, int len, Packet srcPacket) {
            super(name, display, offset, len, srcPacket);
        }

        public String getValueAsString() {
            byte[] value = getValue();
            StringBuilder sb = new StringBuilder();
            for (byte b : value) {
                sb.append(":" + BytesUtil.toHexString(b));
            }
            sb.deleteCharAt(0);
            return sb.toString();
        }

    }

    public static class PtpPortIdField extends ProtocolInt31Field {

        public PtpPortIdField(String name, String display, int offset, int len, Packet srcPacket) {
            super(name, display, offset, len, true, srcPacket);
        }

    }

    public static class PtpSequenceIdField extends ProtocolInt31Field {

        public PtpSequenceIdField(String name, String display, int offset, int len, Packet srcPacket) {
            super(name, display, offset, len, true, srcPacket);
        }

    }

    public static class PtpClockIdField extends ProtocolAsciiStringField {

        public PtpClockIdField(String name, String display, int offset, int len, Packet srcPacket) {
            super(name, display, offset, len, srcPacket);
        }

    }

    public static class PtpCommunicationTechnologyField extends ProtocolInt31Field {

        public PtpCommunicationTechnologyField(String name, String display, int offset, int len, Packet srcPacket) {
            super(name, display, offset, len, true, srcPacket);
        }

        public String getValueAsString() {
            switch (getValue()) {
            case 1:
                return "IEEE 802.3 (Ethernet) (1)";
            default:
                return "未知";
            }
        }

    }

    //--------------------------------------------------------
    public static final int EthernetType_Ptp = 0x88f7;
    public static final int HeaderLength = 34;
    private ProtocolBitField _ptpVersion;
    private Packet packet;

    private Packet fetchPacket() {
        if (packet == null) {
            int ptpVersion = fetchPtpVersion().getValue();
            if (ptpVersion == 2) {
                packet = new PtpV2Packet();
                packet.init(this.getSrcPacket());
            } else if (ptpVersion == 1) {
                packet = new PtpV1Packet();
                packet.init(this.getSrcPacket());
            }
        }
        return packet;
    }

    protected int expectHeaderLength() {
        //include header,body,extension field
        return fetchPacket().getHeaderLength();
    }

    public List<ProtocolField> getHeaderFields() {
        return fetchPacket().getHeaderFields();
    }

    public ProtocolBitField fetchPtpVersion() {
        if (_ptpVersion == null) {
            _ptpVersion = new ProtocolBitField("ptpVersion", "PTP版本", 1, 4, 4, this) {
                public String getValueAsString() {
                    return "ieee1588 v" + getValue();
                }
            };
        }
        return _ptpVersion;
    }

    //v1 use 0,1,2,3,4
    public static final int Control_Sync = 0;
    public static final int Control_DelayReq = 1;
    public static final int Control_FollowUp = 2;
    public static final int Control_DelayResp = 3;
    public static final int Control_Management = 4;
    public static final int Control_AllOthers = 5;

    public static String controlDescription(int control) {
        String append = "(" + control + ")";
        switch (control) {
        case Control_Sync:
            return "sync" + append;
        case Control_DelayReq:
            return "delay req" + append;
        case Control_FollowUp:
            return "follow up" + append;
        case Control_DelayResp:
            return "delay resp" + append;
        case Control_AllOthers:
            return "all others" + append;
        default:
            return "未知" + append;
        }
    }

    //------------------------------------
    public IPacketPayload exceptPayload() {
        if (_miss) {
            return new MissPayload();
        }
        return new EmptyPayload();
    }

    public String getProtocolTypeDesc() {
        int ptpVersion = fetchPtpVersion().getValue();
        return "ieee1588 v" + ptpVersion;
    }
}
