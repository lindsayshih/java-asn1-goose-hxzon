package org.hxzon.demo.pcap.packet;

import org.jnetpcap.nio.JBuffer;
import org.jnetpcap.packet.JHeader;
import org.jnetpcap.packet.JPacket;
import org.jnetpcap.packet.JRegistry;
import org.jnetpcap.packet.RegistryHeaderErrors;
import org.jnetpcap.packet.annotate.Bind;
import org.jnetpcap.packet.annotate.Field;
import org.jnetpcap.packet.annotate.Header;
import org.jnetpcap.packet.annotate.HeaderLength;

@Header()
public class Cotp extends JHeader {
	static {
		try {
			JRegistry.register(Cotp.class);
		} catch (RegistryHeaderErrors e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Cotp() {

	}

	@Bind(to = Tpkt.class)
	public static boolean bindToTpkt(JPacket packet, Tpkt tpkt) {
		return true;
	}

//	| header length(1) | code(4bit)  |credit(4bit) |TPDU-NR and EOT|   user data   |
//	TPDU Code
//
//	-------------------
//	CR = 0xE0, Connection Request
//
//	CC = 0xD0, Connection Confirm
//	DR = 0x80, Disconnection Request
//	DT = 0xF0, Data Transfer
//	ED = 0x70, Expected Data transfer
	@HeaderLength
	public static int headerLength(JBuffer buffer, int offset) {
		return 8 * (buffer.getUByte(offset));
	}

	@Field(offset = 0 * BYTE, length = BYTE)
	public int length() {
		return super.getUByte(0);
	}

	@Field(offset = 1 * BYTE, length = BYTE)
	public int pduType() {
		return super.getUByte(1);
	}

	@Field(offset = 2 * BYTE, length = BYTE)
	public int tpduNumber() {
		return super.getUByte(2);
	}

	public String toString() {
		return "cotp:length=" + length() + ",pduType=" + pduType() + ",tpduNumber=" + tpduNumber();
	}
}
