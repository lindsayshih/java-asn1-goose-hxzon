package org.hxzon.netprotocol.ui.statistics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.List;

import javax.swing.JPanel;

import org.hxzon.util.My1024NumberFormat;
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

    private final ValueAxis timeAxis;
    private final NumberAxis valueAxis;
    private final XYLineAndShapeRenderer rendererPer100;
    private final XYLineAndShapeRenderer rendererPer1000;
    private final XYPlot plot;
    private final JFreeChart chart;
    private final ChartPanel chartPanel;
    private static final Shape shape = new Ellipse2D.Double(-2, -2, 4, 4);

    public StatisticsPaintPanel() {
        super(new BorderLayout());
        timeAxis = new DateAxis("");
        timeAxis.setLowerMargin(0.02);
        timeAxis.setUpperMargin(0.02);
        valueAxis = new NumberAxis("");
        valueAxis.setAutoRangeIncludesZero(false);
        valueAxis.setStandardTickUnits(JFreechartUtil.create1024IntegerTickUnits());
        valueAxis.setNumberFormatOverride(My1024NumberFormat.getMyNumberFormat());
        XYToolTipGenerator toolTipGenerator = StandardXYToolTipGenerator.getTimeSeriesInstance();

        rendererPer100 = new XYLineAndShapeRendererCustom();
        rendererPer100.setBaseShape(shape);
        rendererPer100.setBaseToolTipGenerator(toolTipGenerator);

        rendererPer1000 = new XYLineAndShapeRendererCustom();
        rendererPer1000.setBaseShape(shape);
        rendererPer1000.setBaseToolTipGenerator(toolTipGenerator);

        EmptyDatasetPlaceholder dataset = new EmptyDatasetPlaceholder();
        plot = new XYPlot(dataset, timeAxis, valueAxis, null);
        plot.setRenderer(rendererPer100);
        plot.setRenderer(1, rendererPer1000);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        dataset.setupPlot(plot);
        chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, true);
        chartPanel = new ChartPanel(chart);
        chartPanel.setFillZoomRectangle(true);
        chartPanel.setMouseWheelEnabled(true);
        this.add(chartPanel);
    }

    public void useAntiAlias(boolean use) {
        chart.setAntiAlias(use);
    }

    public void showData(String name, boolean show) {
        TimeSeriesCollection dataset = model.getDatasetPer100();
        boolean shapeVisible = false;
        for (TimeSeriesEx<StatisticsData> timeSeriesEx : (List<TimeSeriesEx<StatisticsData>>) dataset.getSeries()) {
            StatisticsData data = timeSeriesEx.getUserObject();
            int seriesIndex = dataset.indexOf(timeSeriesEx);
            rendererPer100.setSeriesLinesVisible(seriesIndex, data.isShow());
            shapeVisible = data.isShow() && timeSeriesEx.getItemCount() == 1;
            rendererPer100.setSeriesShapesVisible(seriesIndex, shapeVisible);
        }
        dataset = model.getDatasetPer1000();
        for (TimeSeriesEx<StatisticsData> timeSeriesEx : (List<TimeSeriesEx<StatisticsData>>) dataset.getSeries()) {
            StatisticsData data = timeSeriesEx.getUserObject();
            int seriesIndex = dataset.indexOf(timeSeriesEx);
            rendererPer1000.setSeriesLinesVisible(seriesIndex, data.isShow());
            shapeVisible = data.isShow() && timeSeriesEx.getItemCount() == 1;
            rendererPer1000.setSeriesShapesVisible(seriesIndex, shapeVisible);
        }
    }

    public void showDataPer100(boolean b) {
        rendererPer100.setBaseShapesVisible(b);
        rendererPer1000.setBaseShapesVisible(!b);
        for (int i = 0; i < 5; i++) {
            rendererPer100.setSeriesVisible(i, b);
            rendererPer1000.setSeriesVisible(i, !b);
        }
    }

    public void updateForPacketNumOrBitNum() {
        plot.setDataset(model.getDatasetPer100());
        plot.setDataset(1, model.getDatasetPer1000());

        TimeSeriesCollection dataset = model.getDatasetPer100();
        boolean shapeVisible = false;
        for (TimeSeriesEx<StatisticsData> timeSeriesEx : (List<TimeSeriesEx<StatisticsData>>) dataset.getSeries()) {
            StatisticsData data = timeSeriesEx.getUserObject();
            int seriesIndex = dataset.indexOf(timeSeriesEx);
            rendererPer100.setSeriesPaint(seriesIndex, data.getColor());
            rendererPer100.setSeriesVisible(seriesIndex, model.isPer100());
            rendererPer100.setSeriesLinesVisible(seriesIndex, data.isShow());
            shapeVisible = data.isShow() && timeSeriesEx.getItemCount() == 1;
            rendererPer100.setSeriesShapesVisible(seriesIndex, shapeVisible);
        }
        dataset = model.getDatasetPer1000();
        for (TimeSeriesEx<StatisticsData> timeSeriesEx : (List<TimeSeriesEx<StatisticsData>>) dataset.getSeries()) {
            StatisticsData data = timeSeriesEx.getUserObject();
            int seriesIndex = dataset.indexOf(timeSeriesEx);
            rendererPer1000.setSeriesPaint(seriesIndex, data.getColor());
            rendererPer1000.setSeriesVisible(seriesIndex, !model.isPer100());
            rendererPer1000.setSeriesLinesVisible(seriesIndex, data.isShow());
            shapeVisible = data.isShow() && timeSeriesEx.getItemCount() == 1;
            rendererPer1000.setSeriesShapesVisible(seriesIndex, shapeVisible);
        }
        chartPanel.restoreAutoBounds();

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
