package org.hxzon.demo.pcap.packet;

import java.io.IOException;

import org.hxzon.demo.asn1.goose.GoosePdu;
import org.hxzon.demo.asn1.goose.GoosePduParser;
import org.jnetpcap.packet.JHeader;
import org.jnetpcap.packet.JPacket;
import org.jnetpcap.packet.JRegistry;
import org.jnetpcap.packet.RegistryHeaderErrors;
import org.jnetpcap.packet.annotate.Bind;
import org.jnetpcap.packet.annotate.Field;
import org.jnetpcap.packet.annotate.Header;
import org.jnetpcap.protocol.lan.Ethernet;
import org.jnetpcap.protocol.lan.IEEE802dot1q;

@Header(length = 8)
public class GoosePacket extends JHeader {
	static {
		try {
			JRegistry.register(GoosePacket.class);
		} catch (RegistryHeaderErrors e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	JPacket orig;

	public GoosePacket(JPacket orig) {
//		super.peer(orig);
		this.orig = orig;
		orig.hasHeader(this);
	}

	public GoosePacket() {

	}

	public static boolean isGoosePacket(JPacket orig) {
		if (orig.hasHeader(Ethernet.ID)) {
			Ethernet ethernet = new Ethernet();
			orig.getHeader(ethernet);
			return ethernet.type() == 0x88b8;
		}
		return false;
	}

	@Bind(to = Ethernet.class)
	public static boolean bindToEthernet(JPacket packet, Ethernet eth) {
		return eth.type() == 0x88b8;
	}

	@Bind(to = IEEE802dot1q.class)
	public static boolean bindToIEEE802dot1q(JPacket packet, IEEE802dot1q vlan) {
		return vlan.type() == 0x88b8;
	}

	public String toString() {
		return "Goose:appId=" + appID() + ",pduLen=" + pduLen();
	}

	@Field(offset = 0, length = 16)
	public int appID() {
		return super.getUShort(0);
	}

	@Field(offset = 2 * BYTE, length = 16)
	public int pduLen() {
		return super.getUShort(2);
	}

	@Field(offset = 4 * BYTE, length = 16)
	public int reserved1() {
		return super.getUShort(4);
	}

	@Field(offset = 6 * BYTE, length = 16)
	public int reserved2() {
		return super.getUShort(6);
	}

	public GoosePdu goosepdu() {
//		System.out.println(BytesUtils.bytesToHexStringForDisplay(goosepdu.getData()));
		return new GoosePduParser().parseGoose(super.getPayload(),super.getPayloadOffset());
	}

}
