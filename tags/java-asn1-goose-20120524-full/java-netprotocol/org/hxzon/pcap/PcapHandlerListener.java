package org.hxzon.pcap;

public interface PcapHandlerListener {
    public void startPcapFile(PcapFile pcapFile);

    public void addPcapPacket(PcapPacket pcapPacket, PcapFile ownerFile);

    public void endPcapFile(PcapFile pcapFile);

    public void endAll();
}
