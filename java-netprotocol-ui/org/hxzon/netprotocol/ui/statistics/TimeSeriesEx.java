package org.hxzon.netprotocol.ui.statistics;

import org.jfree.data.time.TimeSeries;

public class TimeSeriesEx<T> extends TimeSeries {

    private static final long serialVersionUID = 1L;

    private T userObject;

    public TimeSeriesEx(Comparable name) {
        this(name, null);
    }

    public TimeSeriesEx(Comparable name, T userObject) {
        super(name);
        setUserObject(userObject);
    }

    public T getUserObject() {
        return userObject;
    }

    public void setUserObject(T userObject) {
        this.userObject = userObject;
    }

}
