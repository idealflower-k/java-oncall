package oncall.controller;

import oncall.model.Output.OutputManager;
import oncall.model.calendar.DayEnum;
import oncall.model.calendar.MyCalendar;
import oncall.model.calendar.MyMonth;
import oncall.model.worker.WorkerManger;

public class AllocateController {
    private final MyCalendar myCalendar;
    private final WorkerManger workerManger;
    private final OutputManager outputManager;

    public AllocateController(MyCalendar myCalendar, WorkerManger workerManger) {
        this.myCalendar = myCalendar;
        this.workerManger = workerManger;
        this.outputManager = new OutputManager();
    }

    public void allocateWorker() {
        int maxDay = myCalendar.getMaxDay();
        int month = myCalendar.getMonth();
        allocate(maxDay, month);
    }

    private void allocate(int maxDay, int month) {
        String worker;
        DayEnum day;
        for (int dayNum = 1; dayNum <= maxDay; dayNum++) {
            day = myCalendar.getNextDay();
            if (isHoliday(day, dayNum)) {
                worker = workerManger.getHoliWorker();
                outputManager.addOutput(new MyMonth(month), dayNum, day, myCalendar.isPublicHoliday(dayNum), worker);
                continue;
            }
            worker = workerManger.getWeekWorker();
            outputManager.addOutput(new MyMonth(month), dayNum, day, myCalendar.isPublicHoliday(dayNum), worker);
        }
    }

    private boolean isHoliday(DayEnum day, int i) {
        return day.getKoreanName().equals("토") || day.getKoreanName().equals("일") || myCalendar.isPublicHoliday(i);
    }

    public void printResult() {
        outputManager.printResult();
    }
}
