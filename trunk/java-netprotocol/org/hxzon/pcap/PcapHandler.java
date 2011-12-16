package org.hxzon.pcap;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hxzon.util.DebugUtil;

public class PcapHandler implements Runnable {
    private List<PcapHandlerListener> _listeners = new ArrayList<PcapHandlerListener>();
    private final List<File> _files = new ArrayList<File>();
    private boolean _stop;

    public void addFile(File file) {
        _files.add(file);
    }

    public void addFile(String filepath) {
        addFile(new File(filepath));
    }

    public void addFiles(Collection<File> files) {
        _files.addAll(files);
    }

    public void addFiles(File[] files) {
        for (File file : files) {
            addFile(file);
        }
    }

    public void addListener(PcapHandlerListener listener) {
        _listeners.add(listener);
    }

    public void fireListenersForAddPcapPacket(PcapPacket pcapPacket, PcapFile ownerFile) {
        for (PcapHandlerListener listener : _listeners) {
            listener.addPcapPacket(pcapPacket, ownerFile);
        }
    }

    public void fireListenersForStartPcapFile(PcapFile pcapFile) {
        for (PcapHandlerListener listener : _listeners) {
            listener.startPcapFile(pcapFile);
        }
    }

    public void fireListenersForEndPcapFile(PcapFile pcapFile) {
        for (PcapHandlerListener listener : _listeners) {
            listener.endPcapFile(pcapFile);
        }
    }

    public void fireListenersForEndAll() {
        for (PcapHandlerListener listener : _listeners) {
            listener.endAll();
        }
    }

    public void run() {
        for (File file : _files) {
            if (_stop) {
                break;
            }
            readFile(file);
        }
        fireListenersForEndAll();
    }

    public void stop() {
        this._stop = true;
    }

    private void readFile(File filepath) {
        long startTime = System.currentTimeMillis();
        RandomAccessFile rafile = null;
        PcapFile pcapFile = null;
        try {
            rafile = new RandomAccessFile(filepath, "r");
            pcapFile = new PcapFile();
            byte[] pcapFileHeader = new byte[24];
            rafile.read(pcapFileHeader);
            pcapFile.init(pcapFileHeader);
            fireListenersForStartPcapFile(pcapFile);
            long point = 0;
            while (rafile.read() != -1) {
                byte[] pcapPacketHeader = new byte[16];
                rafile.seek(rafile.getFilePointer() - 1);
                rafile.read(pcapPacketHeader);
                PcapPacket pcapPacket = new PcapPacket();
                pcapPacket.init(pcapPacketHeader, pcapFile.isReverse());
                point = rafile.getFilePointer();
//				logger.debug("capLen:"+capLen+",packetLen:"+packetLen);
                byte[] packetData = new byte[(int) Math.min(pcapPacket.getCapLen(), pcapPacket.getPacketLen())];
                rafile.read(packetData);
                pcapPacket.setPacketData(packetData);
                pcapFile.addPcapPacket(pcapPacket);
                fireListenersForAddPcapPacket(pcapPacket, pcapFile);
                rafile.seek(point + pcapPacket.getCapLen());
            }
        } catch (IOException e) {

        } finally {
            try {
                if (rafile != null) {
                    rafile.close();
                }
            } catch (IOException ioe) {
                // ignore
            }
        }
        fireListenersForEndPcapFile(pcapFile);
        long endTime = System.currentTimeMillis();
        long spanTime = endTime - startTime;
        DebugUtil.debug("packet handler-span time:" + spanTime);
    }
}
