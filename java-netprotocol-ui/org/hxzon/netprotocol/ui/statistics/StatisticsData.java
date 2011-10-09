package org.hxzon.netprotocol.ui.statistics;

import java.awt.Color;

public class StatisticsData {
    private Color color;
    private String name;
    private int[] packetNumOrig;
    private int[] bitNumOrig;
    private int[] packetNumPer100;
    private int[] packetNumPer1000;
    private int[] bitNumPer100;
    private int[] bitNumPer1000;
    private boolean show = true;
    //dataset
    private TimeSeriesEx<StatisticsData> packetNumPer100Dataset;
    private TimeSeriesEx<StatisticsData> packetNumPer1000Dataset;
    private TimeSeriesEx<StatisticsData> bitNumPer100Dataset;
    private TimeSeriesEx<StatisticsData> bitNumPer1000Dataset;

    public StatisticsData(String name, Color color) {
        this.name = name;
        this.color = color;
        packetNumPer100Dataset = new TimeSeriesEx<StatisticsData>(name, this);
        packetNumPer1000Dataset = new TimeSeriesEx<StatisticsData>(name, this);
        bitNumPer100Dataset = new TimeSeriesEx<StatisticsData>(name, this);
        bitNumPer1000Dataset = new TimeSeriesEx<StatisticsData>(name, this);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public boolean isShow() {
        return show;
    }

    public int[] getPacketNumPer100() {
        return packetNumPer100;
    }

    public void setPacketNumPer100(int[] packetNumPer100) {
        this.packetNumPer100 = packetNumPer100;
    }

    public int[] getPacketNumPer1000() {
        return packetNumPer1000;
    }

    public void setPacketNumPer1000(int[] packetNumPer1000) {
        this.packetNumPer1000 = packetNumPer1000;
    }

    public int[] getBitNumPer100() {
        return bitNumPer100;
    }

    public void setBitNumPer100(int[] bitNumPer100) {
        this.bitNumPer100 = bitNumPer100;
    }

    public int[] getBitNumPer1000() {
        return bitNumPer1000;
    }

    public void setBitNumPer1000(int[] bitNumPer1000) {
        this.bitNumPer1000 = bitNumPer1000;
    }

    public int[] getPacketNumOrig() {
        return packetNumOrig;
    }

    public void setPacketNumOrig(int[] packetNumOrig) {
        this.packetNumOrig = packetNumOrig;
    }

    public int[] getBitNumOrig() {
        return bitNumOrig;
    }

    public void setBitNumOrig(int[] bitNumOrig) {
        this.bitNumOrig = bitNumOrig;
    }

    public TimeSeriesEx<StatisticsData> getPacketNumPer100Dataset() {
        return packetNumPer100Dataset;
    }

    public TimeSeriesEx<StatisticsData> getPacketNumPer1000Dataset() {
        return packetNumPer1000Dataset;
    }

    public TimeSeriesEx<StatisticsData> getBitNumPer100Dataset() {
        return bitNumPer100Dataset;
    }

    public TimeSeriesEx<StatisticsData> getBitNumPer1000Dataset() {
        return bitNumPer1000Dataset;
    }

}
