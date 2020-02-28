package com.ehyy.util.Date;

import java.util.Date;

public class WeekRange {
    Date begin;//周开始日
    Date end;//周结束日
    public WeekRange(Date begin) {
        super();
        this.begin = begin;
    }
    public WeekRange(Date begin, Date end) {
        super();
        this.begin = begin;
        this.end = end;
    }
    public Date getBegin() {
        return begin;
    }
    public void setBegin(Date begin) {
        this.begin = begin;
    }
    public Date getEnd() {
        return end;
    }
    public void setEnd(Date end) {
        this.end = end;
    }

    public String toString() {
        return "start:" + begin +
                "end:" + end;
    }

}
