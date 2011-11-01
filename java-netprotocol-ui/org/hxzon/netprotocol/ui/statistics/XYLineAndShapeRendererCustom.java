package org.hxzon.netprotocol.ui.statistics;

import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;

import org.jfree.chart.LegendItem;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;

public class XYLineAndShapeRendererCustom extends XYLineAndShapeRenderer {
    private static final long serialVersionUID = 1L;
    private static final Shape legendItemShape = new Rectangle2D.Double(-3, -3, 6, 6);

    public XYLineAndShapeRendererCustom() {
        super(true, false);
        setAutoPopulateSeriesShape(false);
        setDrawSeriesLineAsPath(true);
        setDataBoundsIncludesVisibleSeriesOnly(false);
        setURLGenerator(null);
    }

    public LegendItem getLegendItem(int datasetIndex, int series) {

        XYPlot plot = getPlot();
        if (plot == null) {
            return null;
        }

        LegendItem result = null;
        XYDataset dataset = plot.getDataset(datasetIndex);
        if (dataset != null) {
            if (getItemVisible(series, 0)) {
                String label = getLegendItemLabelGenerator().generateLabel(dataset, series);
                String description = label;
                String toolTipText = null;
                if (getLegendItemToolTipGenerator() != null) {
                    toolTipText = getLegendItemToolTipGenerator().generateLabel(dataset, series);
                }
                String urlText = null;
                if (getLegendItemURLGenerator() != null) {
                    urlText = getLegendItemURLGenerator().generateLabel(dataset, series);
                }
                boolean shapeIsVisible = true;//getItemShapeVisible(series, 0);
                //Shape shape = lookupLegendShape(series);
                boolean shapeIsFilled = getItemShapeFilled(series, 0);
                Paint fillPaint = (this.getUseFillPaint() ? lookupSeriesFillPaint(series) : lookupSeriesPaint(series));
                boolean shapeOutlineVisible = this.getDrawOutlines();
                Paint outlinePaint = (this.getUseOutlinePaint() ? lookupSeriesOutlinePaint(series) : lookupSeriesPaint(series));
                Stroke outlineStroke = lookupSeriesOutlineStroke(series);
                boolean lineVisible = false;//getItemLineVisible(series, 0);
                Stroke lineStroke = lookupSeriesStroke(series);
                Paint linePaint = lookupSeriesPaint(series);
                result = new LegendItem(label, description, toolTipText, urlText, shapeIsVisible, legendItemShape, shapeIsFilled, fillPaint, shapeOutlineVisible, outlinePaint, outlineStroke,
                        lineVisible, this.getLegendLine(), lineStroke, linePaint);
                result.setLabelFont(lookupLegendTextFont(series));
                Paint labelPaint = lookupLegendTextPaint(series);
                if (labelPaint != null) {
                    result.setLabelPaint(labelPaint);
                }
                result.setSeriesKey(dataset.getSeriesKey(series));
                result.setSeriesIndex(series);
                result.setDataset(dataset);
                result.setDatasetIndex(datasetIndex);
            }
        }

        return result;

    }
}
