package org.hxzon.netprotocol.ui.statistics;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.hxzon.swing.layout.simple.SimpleLayout;
import org.hxzon.swing.layout.simple.SimpleLayoutData;

public class StatisticsPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private final StatisticsPaintPanel paintPanel;
    private final StatisticsControlPanel controlPanel;

    public StatisticsPanel() {
        paintPanel = new StatisticsPaintPanel();
        //
        final JScrollPane jsp = new JScrollPane(paintPanel);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.getHorizontalScrollBar().addAdjustmentListener(new AdjustmentListener() {

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
//				if (!e.getValueIsAdjusting()) {
                paintPanel.setViewSize(jsp.getViewport().getViewRect());
//				}
            }
        });
        jsp.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
//				if (!e.getValueIsAdjusting()) {
                paintPanel.setViewSize(jsp.getViewport().getViewRect());
//				}
            }
        });
        setLayout(new SimpleLayout(true));
        add(jsp, SimpleLayoutData.fillPercent(100));
        controlPanel = new StatisticsControlPanel(paintPanel);
        add(controlPanel, SimpleLayoutData.fixedSize(110));
    }

}
