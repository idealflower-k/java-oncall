package oncall.model.calendar;

import java.util.ArrayList;
import java.util.HashMap;

public class PublicHoliday {
    private HashMap<Integer, ArrayList<Integer>> publicHolidays;

    PublicHoliday() {
        publicHolidays = new HashMap<>();
        for (int[] data : PublicHolidaySet.data) {
            int month = data[0];
            ArrayList<Integer> days = new ArrayList<>();
            for (int i = 1; i < data.length; i++) {
                days.add(data[i]);
            }
            publicHolidays.put(month, days);
        }
    }

    public boolean isHoliday(MyMonth month, Integer day) {
        int monthVal = month.getMonth();
        if (!publicHolidays.containsKey(monthVal)) {
            return false;
        }
        ArrayList<Integer> days = publicHolidays.get(monthVal);
        for (Integer d : days) {
            if (d.equals(day)) {
                return true;
            }
        }
        return false;
    }
}
