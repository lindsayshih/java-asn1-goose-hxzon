package org.hxzon.netprotocol.field;

import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.util.BytesUtil;

public class ProtocolIpField extends ProtocolByteArrayField{

	public ProtocolIpField(String name,String display, int offset, int len, Packet srcPacket) {
		super(name,display, offset, len, srcPacket);
	}

	public String getValueAsString(){
		String tmp="";
		for(int i=0;i<4;i++){
			tmp+=BytesUtil.toUInt(getValue()[i])+".";
		}
		return tmp;
	}
}
