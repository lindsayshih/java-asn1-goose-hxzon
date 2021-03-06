package test.hxzon.asn1;

import org.hxzon.netprotocol.parse.PacketUtils;
import org.hxzon.netprotocol.quick.common.QIPacket;
import org.hxzon.netprotocol.quick.common.QIProtocolField;
import org.hxzon.netprotocol.quick.common.QPacketConstants;
import org.hxzon.netprotocol.quick.field.QProtocolStringField;
import org.hxzon.netprotocol.quick.packet.QEthernetPacket;
import org.hxzon.netprotocol.quick.packet.QGoosePacket;
import org.hxzon.netprotocol.quick.packet.QSvPacket;
import org.hxzon.netprotocol.quick.packet.QVlanPacket;
import org.hxzon.ui.util.UIUtil;

public class TestQPacketDecoder {

    public static void main(String[] args) {
        byte[] data = UIUtil.readExample("sv92.2.hex.txt");
        QEthernetPacket ethernetPacket = new QEthernetPacket();
        int ethernetType = PacketUtils.ethernetType(data);
        int ethernetHeaderLen = PacketUtils.ethernetHeaderLen(data);
        QProtocolStringField ethernetTypeField = QEthernetPacket.fetchEthernetType(data, 0);
        if (QPacketConstants.EthernetType_Vlan.equalsIgnoreCase(ethernetTypeField.getValue())) {
            QVlanPacket vlanPacket = new QVlanPacket();
            vlanPacket.addField(QVlanPacket.fetchEthernetType(data, QPacketConstants.EthernetHeaderLen));
            ethernetPacket.setPayload(vlanPacket);
        }
        ethernetPacket.addField(ethernetTypeField);
        if (QPacketConstants.EthernetType_Goose == ethernetType) {
            QGoosePacket goosePacket = new QGoosePacket();
            goosePacket.addField(QGoosePacket.fetchAppId(data, ethernetHeaderLen));
            goosePacket.addField(QGoosePacket.fetchPduLen(data, ethernetHeaderLen));
            if (ethernetPacket.getPayload() == null) {
                ethernetPacket.setPayload(goosePacket);
            } else {
                ethernetPacket.getPayload().setPayload(goosePacket);
            }
        } else if (QPacketConstants.EthernetType_Smv == ethernetType) {
            QSvPacket smvPacket = new QSvPacket();
            smvPacket.addField(QSvPacket.fetchAppId(data, ethernetHeaderLen));
            smvPacket.addField(QSvPacket.fetchPduLen(data, ethernetHeaderLen));
            if (ethernetPacket.getPayload() == null) {
                ethernetPacket.setPayload(smvPacket);
            } else {
                ethernetPacket.getPayload().setPayload(smvPacket);
            }
        }
        for (QIPacket packet = ethernetPacket; packet != null; packet = packet.getPayload()) {
            System.out.println(packet.getDesc());
            for (QIProtocolField field : packet.getFields()) {
                System.out.println(field.getDesc() + ":" + field.getValueAsString());
            }
        }
    }

    public static void test() {
        byte[] data = UIUtil.readExample("mms.1.hex.txt");
        System.out.println("ethernet type:" + PacketUtils.ethernetType(data));
        System.out.println("ip header len:" + PacketUtils.ipHeaderLen(data));
        System.out.println("tcp header len:" + PacketUtils.tcpHeaderLen(data));
        System.out.println("is tpkt packet:" + PacketUtils.isTpktPacket(data));
    }
}
