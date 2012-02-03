package org.hxzon.netprotocol.ui.statistics;

import java.util.Date;

import org.hxzon.util.Daytime;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeriesCollection;

public class EmptyDatasetPlaceholder extends TimeSeriesCollection {

    private static final long serialVersionUID = 1L;

    public EmptyDatasetPlaceholder() {
        TimeSeriesEx timeSeries = new TimeSeriesEx("");
        Daytime endTime = new Daytime(new Date());
        Daytime startTime = endTime.addMinute(-5);
        timeSeries.add(new Millisecond(startTime.usec / 1000, startTime.second, startTime.minute, startTime.hour, startTime.date, startTime.month, startTime.year), 0);
        timeSeries.add(new Millisecond(endTime.usec / 1000, endTime.second, endTime.minute, endTime.hour, endTime.date, endTime.month, endTime.year), 1000);
        addSeries(timeSeries);
    }

    public void setupPlot(XYPlot plot) {
        XYItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesVisible(0, false);
    }
}
