package oncall.model.Output;

import oncall.model.calendar.DayEnum;
import oncall.model.calendar.MyMonth;
import oncall.view.PrintOutput;

import java.util.ArrayList;
import java.util.Arrays;

public class OutputManager {
    private final ArrayList<Output> list;

    public OutputManager() {
        list = new ArrayList<>();
    }

    public void addOutput(MyMonth month, int dayNum, DayEnum day, boolean isHoliday, String worker) {
        Output output = new Output(month, dayNum, day, isHoliday, worker);
        list.add(output);
    }

    public ArrayList<Output> getNextOutput() {
        return list;
    }

    public void printResult() {
        PrintOutput.printOutput(list);
    }
}
