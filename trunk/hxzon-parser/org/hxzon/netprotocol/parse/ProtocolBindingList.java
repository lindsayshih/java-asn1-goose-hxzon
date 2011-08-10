package org.hxzon.netprotocol.parse;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hxzon.netprotocol.packet.Packet;

public class ProtocolBindingList {
	static Map<Class<? extends Packet>, List<ProtocolBinding>> map = new HashMap<Class<? extends Packet>, List<ProtocolBinding>>();

	public static <T extends Packet> void addBinding(ProtocolBinding<T> binding) {
		Class<T> packetType=(Class<T>)((ParameterizedType) binding.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
		List<ProtocolBinding> list = map.get(packetType);
		if (list == null) {
			list = new ArrayList<ProtocolBinding>();
			map.put(packetType, list);
		}
		list.add(binding);
	}

	public static <T extends Packet> List<ProtocolBinding> getBindings(Class<T> packetType) {
		return map.get(packetType);
	}

	public static <T extends Packet> void addBinding(List<ProtocolBinding> bindings) {
		Class<T> packetType=(Class<T>)((ParameterizedType) bindings.get(0).getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
		List<ProtocolBinding> list = map.get(packetType);
		if (list == null) {
			list = new ArrayList<ProtocolBinding>();
			map.put(packetType, list);
		}
		list.addAll(bindings);
	}

	public static Packet findBinding(Packet packet) {
		List<ProtocolBinding> list = map.get(packet.getClass());
		if (list != null) {
			for (ProtocolBinding binding : list) {
				Packet next = binding.match(packet);
				if (next != null) {
					next.setSrcPacket(packet);
					return next;
				}
			}
		}
		return null;
	}
	
	public static void scanPackage(Package packageName){
//		packageName.
	}

}
