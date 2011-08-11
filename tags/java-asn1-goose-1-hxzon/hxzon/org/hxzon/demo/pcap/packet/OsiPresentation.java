package org.hxzon.demo.pcap.packet;

import org.jnetpcap.packet.JHeader;
import org.jnetpcap.packet.JPacket;
import org.jnetpcap.packet.JRegistry;
import org.jnetpcap.packet.RegistryHeaderErrors;
import org.jnetpcap.packet.annotate.Bind;
import org.jnetpcap.packet.annotate.Field;
import org.jnetpcap.packet.annotate.Header;

@Header(length = 9)
//2
public class OsiPresentation extends JHeader {
	static {
		try {
			JRegistry.register(OsiPresentation.class);
		} catch (RegistryHeaderErrors e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public OsiPresentation() {

	}

	@Bind(to = OsiSession.class)
	public static boolean bindToOsiSession(JPacket packet, OsiSession session) {
		return true;
	}

//
	@Field(offset = 0, length = BYTE)
	public int spduType() {
		return super.getUByte(0);
	}

	@Field(offset = 1 * BYTE, length = 2 * BYTE)
	public int length() {
		return super.getUByte(2);
	}

	public String toString() {
		return "osi presentation:spduType=" + spduType() + ",length=" + length();
	}
}
