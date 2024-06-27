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

    public int getMaxDay() {
        return maxDay.getMaxDay();
    }

    public int getMonth() {
        return month.getMonth();
    }

    public boolean isPublicHoliday(int day) {
        return publicHoliday.isHoliday(month, day);
    }

    public DayEnum getNextDay() {
        DayEnum day = currDay;
        currDay = day.next(day);
        return day;
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
