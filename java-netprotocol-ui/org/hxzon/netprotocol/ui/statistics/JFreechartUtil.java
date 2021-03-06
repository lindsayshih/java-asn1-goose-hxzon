package org.hxzon.netprotocol.ui.statistics;

import java.text.DecimalFormat;

import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.TickUnits;

public class JFreechartUtil {
    public static TickUnitSource create1024IntegerTickUnits() {
        TickUnits units = new TickUnits();
        DecimalFormat df0 = new DecimalFormat("0");
        DecimalFormat df1 = new DecimalFormat("#,##0");
//        units.add(new NumberTickUnit(1, df0, 2));
//        units.add(new NumberTickUnit(2, df0, 2));
//        units.add(new NumberTickUnit(5, df0, 5));
//        units.add(new NumberTickUnit(10, df0, 2));
//        units.add(new NumberTickUnit(20, df0, 2));
//        units.add(new NumberTickUnit(50, df0, 5));
//        units.add(new NumberTickUnit(100, df0, 2));
//        units.add(new NumberTickUnit(200, df0, 2));
//        units.add(new NumberTickUnit(500, df0, 5));
//        units.add(new NumberTickUnit(1000, df1, 2));
//        units.add(new NumberTickUnit(2000, df1, 2));
//        units.add(new NumberTickUnit(5000, df1, 5));
//        units.add(new NumberTickUnit(10000, df1, 2));
//        units.add(new NumberTickUnit(20000, df1, 2));
//        units.add(new NumberTickUnit(50000, df1, 5));
//        units.add(new NumberTickUnit(100000, df1, 2));
//        units.add(new NumberTickUnit(200000, df1, 2));
//        units.add(new NumberTickUnit(500000, df1, 5));
//        units.add(new NumberTickUnit(1000000, df1, 2));
//        units.add(new NumberTickUnit(2000000, df1, 2));
//        units.add(new NumberTickUnit(5000000, df1, 5));
//        units.add(new NumberTickUnit(10000000, df1, 2));
//        units.add(new NumberTickUnit(20000000, df1, 2));
//        units.add(new NumberTickUnit(50000000, df1, 5));
//        units.add(new NumberTickUnit(100000000, df1, 2));
//        units.add(new NumberTickUnit(200000000, df1, 2));
//        units.add(new NumberTickUnit(500000000, df1, 5));
//        units.add(new NumberTickUnit(1000000000, df1, 2));
//        units.add(new NumberTickUnit(2000000000, df1, 2));
//        units.add(new NumberTickUnit(5000000000.0, df1, 5));
//        units.add(new NumberTickUnit(10000000000.0, df1, 2));

        units.add(new NumberTickUnit(1, df0, 2));
        units.add(new NumberTickUnit(2, df0, 2));
        units.add(new NumberTickUnit(4, df0, 2));
        units.add(new NumberTickUnit(8, df0, 2));
        units.add(new NumberTickUnit(16, df0, 2));
        units.add(new NumberTickUnit(32, df0, 2));
        units.add(new NumberTickUnit(64, df0, 2));
        units.add(new NumberTickUnit(128, df0, 2));
        units.add(new NumberTickUnit(256, df0, 2));
        units.add(new NumberTickUnit(512, df0, 2));

        units.add(new NumberTickUnit(1024, df1, 2));
        units.add(new NumberTickUnit(1024 * 2, df1, 2));
        units.add(new NumberTickUnit(1024 * 4, df1, 2));
        units.add(new NumberTickUnit(1024 * 8, df1, 2));
        units.add(new NumberTickUnit(1024 * 16, df1, 2));
        units.add(new NumberTickUnit(1024 * 32, df1, 2));
        units.add(new NumberTickUnit(1024 * 64, df1, 2));
        units.add(new NumberTickUnit(1024 * 128, df1, 2));
        units.add(new NumberTickUnit(1024 * 256, df1, 2));
        units.add(new NumberTickUnit(1024 * 512, df1, 2));

        units.add(new NumberTickUnit(1024 * 1024, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 2, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 4, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 8, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 16, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 32, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 64, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 128, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 256, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 512, df1, 2));

        units.add(new NumberTickUnit(1024 * 1024 * 1024, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 1024 * 2, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 1024 * 4, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 1024 * 8, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 1024 * 16, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 1024 * 32, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 1024 * 64, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 1024 * 128, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 1024 * 256, df1, 2));
        units.add(new NumberTickUnit(1024 * 1024 * 1024 * 512, df1, 2));

        units.add(new NumberTickUnit(1024 * 1024 * 1024 * 1024, df1, 2));
        return units;
    }
}
