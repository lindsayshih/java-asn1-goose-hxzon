package org.hxzon.netprotocol.ui.statistics;

import org.hxzon.netprotocol.packet.GoosePacket;
import org.hxzon.netprotocol.packet.SvPacket;
import org.hxzon.netprotocol.parse.PacketUtils;
import org.hxzon.pcap.PcapFile;
import org.hxzon.pcap.PcapHandlerListener;
import org.hxzon.pcap.PcapPacket;
import org.hxzon.util.Daytime;
import org.hxzon.util.DebugUtil;
import org.hxzon.util.IntList;

public class StatisticsListener implements PcapHandlerListener {
    private Daytime startTime;
    private Daytime endTime;
    private IntList goosePacketNum = new IntList(6000);
    private IntList mmsPacketNum = new IntList(6000);
    private IntList smvPacketNum = new IntList(6000);
    private IntList otherPacketNum = new IntList(6000);
    private IntList allPacketNum = new IntList(6000);
    private IntList gooseBitNum = new IntList(6000);
    private IntList mmsBitNum = new IntList(6000);
    private IntList smvBitNum = new IntList(6000);
    private IntList otherBitNum = new IntList(6000);
    private IntList allBitNum = new IntList(6000);
    private StatisticsPaintPanel paintPanel;
    private StatisticsControlPanel controlPanel;
    private PcapPacket lastPcapPacket;
    private int packetNum;

    public StatisticsListener(StatisticsPaintPanel paintPanel, StatisticsControlPanel controlPanel) {
        this.paintPanel = paintPanel;
        this.controlPanel = controlPanel;
    }

    public void startPcapFile(PcapFile pcapFile) {

    }

    public void endPcapFile(PcapFile pcapFile) {

    }

    public void endAll() {
        DebugUtil.debug("packet num:" + packetNum);
        StatisticsPaintModel model = new StatisticsPaintModel();
        model.setStartTime(startTime);
        if (endTime == null) {
            endTime = new Daytime(lastPcapPacket.getSeconds(), (int) lastPcapPacket.getMicroSeconds());
        }
        model.setEndTime(endTime);
        //packet num
        model.getGooseData().setPacketNumOrig(getGoosePacketNum());
        model.getMmsData().setPacketNumOrig(getMmsPacketNum());
        model.getSmvData().setPacketNumOrig(getSmvPacketNum());
        model.getOtherData().setPacketNumOrig(getOtherPacketNum());
        model.getAllData().setPacketNumOrig(getAllPacketNum());
        //bit num
        model.getGooseData().setBitNumOrig(getGooseBitNum());
        model.getMmsData().setBitNumOrig(getMmsBitNum());
        model.getSmvData().setBitNumOrig(getSmvBitNum());
        model.getOtherData().setBitNumOrig(getOtherBitNum());
        model.getAllData().setBitNumOrig(getAllBitNum());
        model.prepareData();
        paintPanel.setModel(model);
        controlPanel.initButton();
    }

    @Override
    public void addPcapPacket(PcapPacket pcapPacket, PcapFile ownerFile) {
        packetNum++;
        lastPcapPacket = pcapPacket;
        if (startTime == null) {
            startTime = new Daytime(pcapPacket.getSeconds(), (int) pcapPacket.getMicroSeconds());
//          startTime = new Daytime(pcapPacket.getSeconds(), 0);
        }
        int index = computeTimespan(pcapPacket.getSeconds(), pcapPacket.getMicroSeconds());
        if (index == -1) {
            return;
        }
//      TimespendDebug.start("detect type " + num);
        int type = detectType(pcapPacket);
//      TimespendDebug.end("detect type " + num);
//      TimespendDebug.start("add num");
        if (type == Type_Goose) {
            goosePacketNum.increaseSafe(index);
            gooseBitNum.addSafe(index, (int) pcapPacket.getPacketLen() * 8);
        } else if (type == Type_Smv) {
            smvPacketNum.increaseSafe(index);
            smvBitNum.addSafe(index, (int) pcapPacket.getPacketLen() * 8);
        } else if (type == Type_Mms) {
            mmsPacketNum.increaseSafe(index);
            mmsBitNum.addSafe(index, (int) pcapPacket.getPacketLen() * 8);
        } else {
            otherPacketNum.increaseSafe(index);
            otherBitNum.addSafe(index, (int) pcapPacket.getPacketLen() * 8);
        }
//      TimespendDebug.end("add num");
        allPacketNum.increaseSafe(index);
        allBitNum.addSafe(index, (int) pcapPacket.getPacketLen() * 8);
    }

    private int computeTimespan(long sec, long usec) {
        if (endTime != null) {
            if (sec > endTime.origsec || (sec == endTime.origsec && usec > endTime.usec)) {
                return -1;
            }
        }
        if (sec < startTime.origsec || (sec == startTime.origsec && usec < startTime.usec)) {
            return -1;
        }
        if (usec < startTime.usec) {
            usec += 1000000;
            sec -= 1;
        }
        int result = (int) ((sec - startTime.origsec) * 10 + (usec - startTime.usec) / 100000);
        return result;
    }

    public int[] getGoosePacketNum() {
        return goosePacketNum.getArray();
    }

    public int[] getMmsPacketNum() {
        return mmsPacketNum.getArray();
    }

    public int[] getSmvPacketNum() {
        return smvPacketNum.getArray();
    }

    public int[] getOtherPacketNum() {
        return otherPacketNum.getArray();
    }

    public int[] getAllPacketNum() {
        return allPacketNum.getArray();
    }

    public int[] getGooseBitNum() {
        return gooseBitNum.getArray();
    }

    public int[] getMmsBitNum() {
        return mmsBitNum.getArray();
    }

    public int[] getSmvBitNum() {
        return smvBitNum.getArray();
    }

    public int[] getOtherBitNum() {
        return otherBitNum.getArray();
    }

    public int[] getAllBitNum() {
        return allBitNum.getArray();
    }

    public Daytime getStartTime() {
        return startTime;
    }

    public void setStartTime(Daytime startTime) {
        this.startTime = startTime;
    }

    public Daytime getEndTime() {
        return endTime;
    }

    public void setEndTime(Daytime endTime) {
        this.endTime = endTime;
    }

    private static int Type_Goose = 1;
    private static int Type_Mms = 2;
    private static int Type_Smv = 3;
    private static int Type_Other = 4;

    private static int detectType(PcapPacket pcapPacket) {
        byte[] data = pcapPacket.getPacketData();
        try {
            int ethernetType = PacketUtils.ethernetType(data);
            if (GoosePacket.EthernetType_Goose == ethernetType) {
                return Type_Goose;
            } else if (SvPacket.EthernetType_Sv == ethernetType) {
                return Type_Smv;
            } else if (PacketUtils.isTpktPacket(data)) {
                return Type_Mms;
            }
            return Type_Other;
        } catch (IndexOutOfBoundsException e) {
            return Type_Other;
        }
    }
}
