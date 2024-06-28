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

    public MyCalendar createCalendarFromInput() {
        while (true) {
            try {
                System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
                return getCalendarFromInput();
            } catch (IllegalArgumentException exception) {
                System.out.println(EnumError.ERROR_HEADER.getMessage() + " " + EnumError.ERROR_BODY.getMessage());
            }
        }
    }

    private MyCalendar getCalendarFromInput() throws IllegalArgumentException {
        String line = Console.readLine();
        String[] split = line.split(",");
        if (!isValid(split)) {
            throw new IllegalArgumentException();
        }

        MyMonth month = new MyMonth(Integer.parseInt(split[0]));
        DayEnum dayEnum = DayEnum.getByKoreaName(split[1]);
        return new MyCalendar(dayEnum, month);
    }

    private boolean isValid(String[] split) {
        return split.length == 2 && isValidMonth(split[0]) && isValidDay(split[1]);
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
