package oncall.inpput;

import camp.nextstep.edu.missionutils.Console;
import oncall.model.calendar.DayEnum;
import oncall.model.calendar.MyCalendar;
import oncall.model.calendar.MyMonth;

import java.time.Month;

public class CalendarInput {
    private final int maxMonth = 12;
    private static CalendarInput instance;

    private CalendarInput() {
    }

    public static CalendarInput getInstance() {
        if (instance == null) {
            instance = new CalendarInput();
            return instance;
        }
        return instance;
    }

    public MyCalendar createCalendarFromInput() throws IllegalArgumentException {
        String line = Console.readLine();
        String[] split = line.split(",");
        if (split.length != 2 || !isValidMonth(split[0]) || !isValidDay(split[1])) {
            throw new IllegalArgumentException();
        }
        MyMonth month = new MyMonth(Integer.parseInt(split[0]));
        DayEnum dayEnum = DayEnum.getByKoreaName(split[1]);
        return new MyCalendar(dayEnum, month);
    }

    private boolean isValidMonth(String data) {
        try {
            int month = Integer.parseInt(data);
            if (month < 1 || month > maxMonth) {
                throw new IllegalArgumentException();
            }
            return true;
        } catch (IllegalArgumentException ignored) {
            return false;
        }
    }

    private boolean isValidDay(String data) {
        return DayEnum.containsKoreaName(data);
    }
}
