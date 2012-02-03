package org.hxzon.demo.pcap.packet;

import org.jnetpcap.packet.JHeader;
import org.jnetpcap.packet.JPacket;
import org.jnetpcap.packet.JRegistry;
import org.jnetpcap.packet.RegistryHeaderErrors;
import org.jnetpcap.packet.annotate.Bind;
import org.jnetpcap.packet.annotate.Field;
import org.jnetpcap.packet.annotate.Header;
import org.jnetpcap.protocol.tcpip.Tcp;

@Header(length = 4 )
public class Tpkt extends JHeader {
	static {
		try {
			JRegistry.register(Tpkt.class);
		} catch (RegistryHeaderErrors e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Tpkt() {

	}

	@Bind(to = Tcp.class)
	public static boolean bindToTcp(JPacket packet, Tcp tcp) {
		return tcp.source() == 102;
	}
//	|      version(1) |    reserved(1)   | packet length(2) |tpdu|
	@Field(offset = 0, length = BYTE)
	public int version() {
		return super.getUByte(0);
	}

	@Field(offset = 1 * BYTE, length = BYTE)
	public int reserved() {
		return super.getUByte(1);
	}

	@Field(offset = 2 * BYTE, length = 2 * BYTE)
	public int length() {
		return super.getUShort(2);
	}

	public String toString() {
		return "tpkt:version=" + version() + ",reserved=" + reserved() + ",length=" + length();
	}
}
