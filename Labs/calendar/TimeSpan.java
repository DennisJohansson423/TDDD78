package se.liu.denjo163.calendar;

import java.sql.Time;

public class TimeSpan
{
    private TimePoint start;
    private TimePoint end;

    public TimePoint getStart() {
        return start;
    }
    public TimePoint getEnd() {
        return end;
    }

    public TimeSpan(final TimePoint start, final TimePoint end) {
        this.start = start;
        this.end = end;
    }

    @Override public String toString() {
        return start + "-" + end;
    }
}
