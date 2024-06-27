package oncall.model.Output;

import oncall.model.calendar.DayEnum;
import oncall.model.calendar.MyMonth;

public class Output {
    private final MyMonth month;
    private final int dayNum;
    private final DayEnum day;
    private final boolean isHoliday;
    private final String worker;

    public Output(MyMonth month, int dayNum, DayEnum day, boolean isHoliday, String worker) {
        this.month = month;
        this.dayNum = dayNum;
        this.day = day;
        this.isHoliday = isHoliday;
        this.worker = worker;
    }

    public int getMonth() {
        return month.getMonth();
    }

    public int getDayNum() {
        return dayNum;
    }

    public DayEnum getDay() {
        return day;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public String getWorker() {
        return worker;
    }
}
