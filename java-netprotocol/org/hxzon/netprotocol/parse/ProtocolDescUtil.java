package org.hxzon.netprotocol.parse;

import java.util.HashMap;
import java.util.Map;

import org.hxzon.netprotocol.common.IPacketPayload;

public class ProtocolDescUtil {

    private static Map<Class<? extends IPacketPayload>, String> descs = new HashMap<Class<? extends IPacketPayload>, String>();

    public static void putDesc(Class<? extends IPacketPayload> payload, String desc) {
        descs.put(payload, desc);
    }

    public static String getDesc(Class<? extends IPacketPayload> payload) {
        return descs.get(payload);
    }
}
