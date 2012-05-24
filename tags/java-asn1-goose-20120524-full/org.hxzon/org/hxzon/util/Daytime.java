package org.hxzon.util;

import java.util.Calendar;
import java.util.Date;

public class Daytime {
    public final long origsec;
    public final int usec;
    public final int year;
    public final int month;
    public final int date;
    public final int hour;
    public final int minute;
    public final int second;
    public final int secondInDay;

    public Daytime(Date date) {
        this(date.getTime());
    }

    public Daytime(long millisec) {
        this(millisec / 1000, (int) (millisec % 1000) * 1000);
    }

    public Daytime(Daytime orig) {
        this(orig.origsec, orig.usec);
    }

    public Daytime(long sec, int usec) {
        this.origsec = sec;
        this.usec = usec;
        Calendar calendar = toCalendar();
        year = calendar.get(Calendar.YEAR);
        //FIXME month+1
        month = calendar.get(Calendar.MONTH) + 1;
        date = calendar.get(Calendar.DATE);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);
        secondInDay = hour * 3600 + minute * 60 + second;
    }

    //lost the (usec%1000)
    public long toMillssec() {
        return origsec * 1000 + usec / 1000;
    }

    public Date toDate() {
        return new Date(toMillssec());
    }

    public Calendar toCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(toMillssec());
        return calendar;
    }

    public String toString() {
        return year + "-" + month + "-" + date + "," + hour + ":" + minute + ":" + second + "." + NumberFormatUtil.format(usec, "000000");
    }

    public Daytime addYear(int add) {
        Calendar calendar = toCalendar();
        calendar.add(Calendar.YEAR, add);
        return new Daytime(calendar.getTime().getTime() / 1000, usec);
    }

    public Daytime addMonth(int add) {
        Calendar calendar = toCalendar();
        calendar.add(Calendar.MONTH, add);
        return new Daytime(calendar.getTime().getTime() / 1000, usec);
    }

    public Daytime addDate(int add) {
        Calendar calendar = toCalendar();
        calendar.add(Calendar.DATE, add);
        return new Daytime(calendar.getTime().getTime() / 1000, usec);
    }

    public Daytime addHour(int add) {
        Calendar calendar = toCalendar();
        calendar.add(Calendar.HOUR, add);
        return new Daytime(calendar.getTime().getTime() / 1000, usec);
    }

    public Daytime addMinute(int add) {
        Calendar calendar = toCalendar();
        calendar.add(Calendar.MINUTE, add);
        return new Daytime(calendar.getTime().getTime() / 1000, usec);
    }

    public Daytime addSecond(int add) {
        Calendar calendar = toCalendar();
        calendar.add(Calendar.SECOND, add);
        return new Daytime(calendar.getTime().getTime() / 1000, usec);
    }

    //FIXME hxzon
    public Daytime addMillisec(int add) {
        Calendar calendar = toCalendar();
        calendar.add(Calendar.MILLISECOND, add);
        long time = calendar.getTime().getTime();
        long newSec = time / 1000;
        long newUsec = (time % 1000) * 1000 + usec;
        return new Daytime(newSec + newUsec / 1000000, (int) (newUsec % 1000000));
    }

    //FIXME hxzon
    public Daytime addUsec(long add) {
        long usecNew = usec + add;
        long secondAdd = usecNew / 1000000;
        usecNew = usecNew % 1000000;
        Calendar calendar = toCalendar();
        calendar.add(Calendar.SECOND, (int) secondAdd);
        return new Daytime(calendar.getTime().getTime() / 1000, (int) usecNew);
    }

    public static void test() {
        Date date = new Date();
        Daytime d = new Daytime(date);
        System.out.println(DateFormatUtil.formatToUniteTime(date));
        System.out.println(d);
        Daytime d1 = d.addUsec(123);
        System.out.println(d1);
        d1 = d.addMonth(13);
        System.out.println(d1);
        d1 = d.addUsec(999999);
        System.out.println(d1);
        d1 = d.addUsec(1000999);//add 1 second and 999 usec
        System.out.println(d1);
        d1 = d.addMinute(240);//add 4 hour
        System.out.println(d1);
    }

    public static void main(String args[]) {
        test();
    }
}
