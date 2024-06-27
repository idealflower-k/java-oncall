package oncall.model.calendar;

import java.time.Month;

public class MyCalendar {
    MyMonth month;
    MaxDay maxDay;
    DayEnum currDay;
    PublicHoliday publicHoliday;

    public MyCalendar(DayEnum currDay, MyMonth month) {
        this.currDay = currDay;
        this.month = month;
        publicHoliday = new PublicHoliday();
        Month monthEnum = Month.of(month.getMonth());
        maxDay = new MaxDay(monthEnum.length(false));
    }

    public MaxDay getMaxDay() {
        return maxDay;
    }

    public MyMonth getMonth() {
        return month;
    }

    public boolean isHoliday(int day) {
        return publicHoliday.isHoliday(month, day);
    }

    @Override
    public String toString() {
        return "MyCalendar{" +
                "month=" + month.getMonth() +
                ", maxDay=" + maxDay.getMaxDay() +
                ", currDay=" + currDay.getKoreanName() +
                '}';
    }
}
