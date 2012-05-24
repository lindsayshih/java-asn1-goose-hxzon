package org.hxzon.netprotocol.parse;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hxzon.netprotocol.common.IPacketPayload;

public class ProtocolBindingList {
    static Map<Class<? extends IPacketPayload>, List<ProtocolBinding>> _map = new HashMap<Class<? extends IPacketPayload>, List<ProtocolBinding>>();

    public static <T extends IPacketPayload> void addBinding(ProtocolBinding<T> binding) {
        Class<T> packetType = (Class<T>) ((ParameterizedType) binding.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        List<ProtocolBinding> list = _map.get(packetType);
        if (list == null) {
            list = new ArrayList<ProtocolBinding>();
            _map.put(packetType, list);
        }
        list.add(binding);
    }

    public static <T extends IPacketPayload> List<ProtocolBinding> getBindings(Class<T> packetType) {
        return _map.get(packetType);
    }

    public static <T extends IPacketPayload> void addBinding(List<ProtocolBinding> bindings) {
        Class<T> packetType = (Class<T>) ((ParameterizedType) bindings.get(0).getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
        List<ProtocolBinding> list = _map.get(packetType);
        if (list == null) {
            list = new ArrayList<ProtocolBinding>();
            _map.put(packetType, list);
        }
        list.addAll(bindings);
    }

    public static IPacketPayload findBinding(IPacketPayload packet) {
        List<ProtocolBinding> list = _map.get(packet.getClass());
        if (list != null) {
            for (ProtocolBinding binding : list) {
                IPacketPayload next = binding.match(packet);
                if (next != null) {
                    return next;
                }
            }
        }
        return null;
    }

    public static void scanPackage(Package packageName) {
//		packageName.
    }

}
