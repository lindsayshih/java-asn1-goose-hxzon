package org.hxzon.demo.pcap.packet;

import org.jnetpcap.packet.JHeader;
import org.jnetpcap.packet.JPacket;
import org.jnetpcap.packet.JRegistry;
import org.jnetpcap.packet.RegistryHeaderErrors;
import org.jnetpcap.packet.annotate.Bind;
import org.jnetpcap.packet.annotate.Header;

@Header(length = 0)
public class MmsPacket extends JHeader{
	static {
		try {
			JRegistry.register(MmsPacket.class);
		} catch (RegistryHeaderErrors e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MmsPacket(JPacket orig) {
//		super(orig);
	}

	public MmsPacket() {

	}

	public static boolean isMmsPacket(JPacket orig) {
		return false;
	}

	@Bind(to = OsiPresentation.class)
	public static boolean bindToOsiPresentation(JPacket packet, OsiPresentation pres) {
		return true;
	}

	public String toString() {
		return "MMS";
	}

}
