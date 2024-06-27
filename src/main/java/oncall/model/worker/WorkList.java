package oncall.model.worker;

import java.util.ArrayList;
import java.util.HashMap;

public class WorkList {
    private final ArrayList<String> weekday;
    private final ArrayList<String> holiday;
    private int weekIdx;
    private int holiIdx;

    public WorkList(ArrayList<String> weekday, ArrayList<String> holiday) {
        this.weekday = weekday;
        this.holiday = holiday;
        weekIdx = 0;
        holiIdx = 0;
    }

    public String getWeek() {
        String target = weekday.get(weekIdx);
        weekIdx = (weekIdx + 1) % weekday.size();
        return target;
    }

    public String getHoli() {
        String target = holiday.get(holiIdx);
        holiIdx = (holiIdx + 1) % holiday.size();
        return target;
    }
}
