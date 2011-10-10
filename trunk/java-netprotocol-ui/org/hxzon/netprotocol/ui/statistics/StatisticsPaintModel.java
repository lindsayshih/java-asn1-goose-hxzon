package org.hxzon.netprotocol.ui.statistics;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.hxzon.util.Daytime;
import org.hxzon.util.MathUtil;
import org.hxzon.util.TimespendDebug;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class StatisticsPaintModel {
    //data
    private final StatisticsData gooseData = new StatisticsData("GOOSE", Color.cyan);
    private final StatisticsData mmsData = new StatisticsData("MMS", Color.green);
    private final StatisticsData smvData = new StatisticsData("采样值", Color.magenta);
    private final StatisticsData otherData = new StatisticsData("其它报文", Color.pink.darker());
    private final StatisticsData allData = new StatisticsData("全部", Color.orange.darker());
    private final List<StatisticsData> datas = new ArrayList<StatisticsData>();
    //
    private boolean isPacketNum = false;
    private boolean isPer100 = true;
    //time
    private Daytime startTime;
    private Daytime endTime;
    private static final ExecutorService executorService = Executors.newScheduledThreadPool(25);

    public StatisticsPaintModel() {
        datas.add(allData);
        datas.add(gooseData);
        datas.add(smvData);
        datas.add(mmsData);
        datas.add(otherData);
    }

    public void prepareData() {
        TimespendDebug.start("prepare data");
        FutureTask<StatisticsData> gooseCall = new FutureTask<StatisticsData>(new NumTask(gooseData));
        FutureTask<StatisticsData> mmsCall = new FutureTask<StatisticsData>(new NumTask(mmsData));
        FutureTask<StatisticsData> smvCall = new FutureTask<StatisticsData>(new NumTask(smvData));
        FutureTask<StatisticsData> otherCall = new FutureTask<StatisticsData>(new NumTask(otherData));
        FutureTask<StatisticsData> allCall = new FutureTask<StatisticsData>(new NumTask(allData));

        executorService.execute(gooseCall);
        executorService.execute(mmsCall);
        executorService.execute(smvCall);
        executorService.execute(otherCall);
        executorService.execute(allCall);
        try {
            gooseCall.get();
            mmsCall.get();
            smvCall.get();
            otherCall.get();
            allCall.get();
            TimespendDebug.end("prepare data");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private class NumTask implements Callable<StatisticsData> {
        private StatisticsData pointData;

        public NumTask(StatisticsData pointData) {
            this.pointData = pointData;
        }

        public StatisticsData call() {
            pointData.setPacketNumPer100(MathUtil.multiply(pointData.getPacketNumOrig(), 10));
            pointData.setBitNumPer100(MathUtil.multiply(pointData.getBitNumOrig(), 10));
            //
            pointData.setPacketNumPer1000(MathUtil.scala(pointData.getPacketNumOrig(), 10));
            pointData.setBitNumPer1000(MathUtil.scala(pointData.getBitNumOrig(), 10));
            //dataset
            TimespendDebug.start("prepare dataset for" + pointData.getName());
            TimeSeries dataset = pointData.getPacketNumPer100Dataset();
            int[] values = pointData.getPacketNumPer100();
            FutureTask<StatisticsData> packetNumPer100Call = new FutureTask<StatisticsData>(new DatasetTask(pointData, dataset, values, 100, startTime));
            dataset = pointData.getPacketNumPer1000Dataset();
            values = pointData.getPacketNumPer1000();
            FutureTask<StatisticsData> packetNumPer1000Call = new FutureTask<StatisticsData>(new DatasetTask(pointData, dataset, values, 1000, startTime));
            dataset = pointData.getBitNumPer100Dataset();
            values = pointData.getBitNumPer100();
            FutureTask<StatisticsData> bitNumPer100Call = new FutureTask<StatisticsData>(new DatasetTask(pointData, dataset, values, 100, startTime));
            dataset = pointData.getBitNumPer1000Dataset();
            values = pointData.getBitNumPer1000();
            FutureTask<StatisticsData> bitNumPer1000Call = new FutureTask<StatisticsData>(new DatasetTask(pointData, dataset, values, 1000, startTime));
            executorService.execute(packetNumPer100Call);
            executorService.execute(packetNumPer1000Call);
            executorService.execute(bitNumPer100Call);
            executorService.execute(bitNumPer1000Call);

            try {
                packetNumPer100Call.get();
                packetNumPer1000Call.get();
                bitNumPer100Call.get();
                bitNumPer1000Call.get();
                TimespendDebug.end("prepare dataset for" + pointData.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return pointData;
        }
    }

    private static class DatasetTask implements Callable<StatisticsData> {
        private StatisticsData pointData;
        private TimeSeries timeSeries;
        private int[] values;
        private int timespan;
        private Daytime startTime;

        public DatasetTask(StatisticsData pointData, TimeSeries timeSeries, int[] values, int timespan, Daytime startTime) {
            this.pointData = pointData;
            this.timeSeries = timeSeries;
            this.values = values;
            this.timespan = timespan;
            this.startTime = startTime;
        }

        public StatisticsData call() {
            int i = 0;
            TimespendDebug.start("prepare dataset for" + pointData.getName() + " " + timespan + this.hashCode());
            for (int value : values) {
                Daytime tmpTime = startTime.addMillisec(i * timespan);
                Millisecond millis = new Millisecond(tmpTime.usec / 1000, tmpTime.second, tmpTime.minute, tmpTime.hour, tmpTime.date, tmpTime.month, tmpTime.year);
                timeSeries.add(millis, value, false);
                i++;
            }
            TimespendDebug.end("prepare dataset for" + pointData.getName() + " " + timespan + this.hashCode());
            return pointData;
        }
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

    public StatisticsData getGooseData() {
        return gooseData;
    }

    public StatisticsData getMmsData() {
        return mmsData;
    }

    public StatisticsData getSmvData() {
        return smvData;
    }

    public StatisticsData getOtherData() {
        return otherData;
    }

    public StatisticsData getAllData() {
        return allData;
    }

    public boolean isPacketNum() {
        return isPacketNum;
    }

    public void setPacketNum(boolean isPacketNum) {
        this.isPacketNum = isPacketNum;
    }

    public boolean isPer100() {
        return isPer100;
    }

    public void setPer100(boolean isPer100) {
        this.isPer100 = isPer100;
    }

    public List<StatisticsData> getDatas() {
        return datas;
    }

    public void showData(String name, boolean show) {
        for (StatisticsData data : datas) {
            if (name.equals(data.getName())) {
                data.setShow(show);
                break;
            }
        }
    }

    private TimeSeriesCollection packetNumPer100Dataset;
    private TimeSeriesCollection packetNumPer1000Dataset;
    private TimeSeriesCollection bitNumPer100Dataset;
    private TimeSeriesCollection bitNumPer1000Dataset;

    private TimeSeriesCollection getPacketNumPer100Dataset() {
        if (packetNumPer100Dataset == null) {
            packetNumPer100Dataset = new TimeSeriesCollection();
            for (StatisticsData data : datas) {
                packetNumPer100Dataset.addSeries(data.getPacketNumPer100Dataset());
            }
        }
        return packetNumPer100Dataset;
    }

    private TimeSeriesCollection getPacketNumPer1000Dataset() {
        if (packetNumPer1000Dataset == null) {
            packetNumPer1000Dataset = new TimeSeriesCollection();
            for (StatisticsData data : datas) {
                packetNumPer1000Dataset.addSeries(data.getPacketNumPer1000Dataset());
            }
        }
        return packetNumPer1000Dataset;
    }

    private TimeSeriesCollection getBitNumPer100Dataset() {
        if (bitNumPer100Dataset == null) {
            bitNumPer100Dataset = new TimeSeriesCollection();
            for (StatisticsData data : datas) {
                bitNumPer100Dataset.addSeries(data.getBitNumPer100Dataset());
            }
        }
        return bitNumPer100Dataset;
    }

    private TimeSeriesCollection getBitNumPer1000Dataset() {
        if (bitNumPer1000Dataset == null) {
            bitNumPer1000Dataset = new TimeSeriesCollection();
            for (StatisticsData data : datas) {
                bitNumPer1000Dataset.addSeries(data.getBitNumPer1000Dataset());
            }
        }
        return bitNumPer1000Dataset;
    }

//    public XYDataset getDataset() {
//        if (isPacketNum) {
//            return isPer100 ? getPacketNumPer100Dataset() : getPacketNumPer1000Dataset();
//        } else {
//            return isPer100 ? getBitNumPer100Dataset() : getBitNumPer1000Dataset();
//        }
//    }

    public TimeSeriesCollection getDatasetPer100() {
        if (isPacketNum) {
            return getPacketNumPer100Dataset();
        } else {
            return getBitNumPer100Dataset();
        }
    }

    public TimeSeriesCollection getDatasetPer1000() {
        if (isPacketNum) {
            return getPacketNumPer1000Dataset();
        } else {
            return getBitNumPer1000Dataset();
        }
    }

}
