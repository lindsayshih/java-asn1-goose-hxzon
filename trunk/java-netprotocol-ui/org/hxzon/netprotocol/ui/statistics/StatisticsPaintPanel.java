package org.hxzon.netprotocol.ui.statistics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JPanel;

import org.hxzon.util.MyNumberFormat;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;

@SuppressWarnings("serial")
public class StatisticsPaintPanel extends JPanel {

    private Rectangle viewRect;
    private StatisticsPaintModel model;

    private ValueAxis timeAxis;
    private NumberAxis valueAxis;
    private XYLineAndShapeRenderer rendererPer100;
    private XYLineAndShapeRenderer rendererPer1000;
    private XYPlot plot;
    private JFreeChart chart;
    private ChartPanel chartPanel;

    public StatisticsPaintPanel() {
        super(new BorderLayout());
        timeAxis = new DateAxis("");
        timeAxis.setLowerMargin(0.02); // reduce the default margins
        timeAxis.setUpperMargin(0.02);
//        timeAxis.setLowerBound(new Date().getTime() - 100000);
//        timeAxis.setUpperBound(new Date().getTime());
        valueAxis = new NumberAxis("");
        valueAxis.setAutoRangeIncludesZero(false); // override default
//        valueAxis.setUpperBound(10000);
//        valueAxis.setLowerBound(0);
        valueAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        valueAxis.setNumberFormatOverride(MyNumberFormat.getMyNumberFormat());
        XYToolTipGenerator toolTipGenerator = null;
        toolTipGenerator = StandardXYToolTipGenerator.getTimeSeriesInstance();

        rendererPer100 = new XYLineAndShapeRenderer(true, false);
        rendererPer100.setBaseToolTipGenerator(toolTipGenerator);
        rendererPer100.setURLGenerator(null);
        rendererPer100.setDrawSeriesLineAsPath(true);
        rendererPer100.setDataBoundsIncludesVisibleSeriesOnly(false);
        rendererPer1000 = new XYLineAndShapeRenderer(true, false);
        rendererPer1000.setBaseToolTipGenerator(toolTipGenerator);
        rendererPer1000.setURLGenerator(null);
        rendererPer1000.setDrawSeriesLineAsPath(true);
        rendererPer1000.setDataBoundsIncludesVisibleSeriesOnly(false);

        plot = new XYPlot(new TimeSeriesCollection(), timeAxis, valueAxis, null);
        plot.setRenderer(rendererPer100);
        plot.setRenderer(1, rendererPer1000);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, true);
        chartPanel = new ChartPanel(chart);
        chartPanel.setFillZoomRectangle(true);
        chartPanel.setMouseWheelEnabled(true);
        this.add(chartPanel);
    }

    public void showData(String name, boolean show) {
        if (rendererPer100 != null) {
            for (int i = 0; i < model.getDatasetPer100().getSeriesCount(); i++) {
                String series = (String) model.getDatasetPer100().getSeriesKey(i);
                if (series.equals(name)) {
                    rendererPer100.setSeriesLinesVisible(i, show);
                    break;
                }
            }
            for (int i = 0; i < model.getDatasetPer1000().getSeriesCount(); i++) {
                String series = (String) model.getDatasetPer1000().getSeriesKey(i);
                if (series.equals(name)) {
                    rendererPer1000.setSeriesLinesVisible(i, show);
                    break;
                }
            }
        }
    }

    public void showDataPer100(boolean b) {
        if (rendererPer100 != null) {
            for (int i = 0; i < 5; i++) {
                rendererPer100.setSeriesVisible(i, b);
                rendererPer1000.setSeriesVisible(i, !b);
            }
        }
    }

    public void updateForPacketNumOrBitNum() {
        plot.setDataset(model.getDatasetPer100());
        plot.setDataset(1, model.getDatasetPer1000());

        TimeSeriesCollection dataset = model.getDatasetPer100();
        for (TimeSeriesEx<StatisticsData> timeSeriesEx : (List<TimeSeriesEx<StatisticsData>>) dataset.getSeries()) {
            StatisticsData data = timeSeriesEx.getUserObject();
            int seriesIndex = dataset.indexOf(timeSeriesEx);
            rendererPer100.setSeriesPaint(seriesIndex, data.getColor());
            rendererPer100.setSeriesVisible(seriesIndex, model.isPer100());
            rendererPer100.setSeriesLinesVisible(seriesIndex, data.isShow());
        }
        dataset = model.getDatasetPer1000();
        for (TimeSeriesEx<StatisticsData> timeSeriesEx : (List<TimeSeriesEx<StatisticsData>>) dataset.getSeries()) {
            StatisticsData data = timeSeriesEx.getUserObject();
            int seriesIndex = dataset.indexOf(timeSeriesEx);
            rendererPer1000.setSeriesPaint(seriesIndex, data.getColor());
            rendererPer1000.setSeriesVisible(seriesIndex, !model.isPer100());
            rendererPer1000.setSeriesLinesVisible(seriesIndex, data.isShow());
        }

    }

    public StatisticsPaintModel getModel() {
        return model;
    }

    public void setViewSize(Rectangle size) {
        if (size.equals(viewRect)) {
            return;
        }
        this.viewRect = size;
        if (model != null) {
            updateForPacketNumOrBitNum();
        }
    }

    public Dimension getPreferredSize() {
        if (viewRect != null) {
            return new Dimension(viewRect.width, viewRect.height);
        }
        return new Dimension(800, 600);
    }

    public void setModel(StatisticsPaintModel model) {
        this.model = model;
        updateForPacketNumOrBitNum();
    }

}
