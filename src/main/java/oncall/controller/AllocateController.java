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
        String worker;
        for (int i = 1; i <= maxDay; i++) {
            DayEnum day = myCalendar.getNextDay();
            if (day.getKoreanName().equals("토") || day.getKoreanName().equals("일") || myCalendar.isPublicHoliday(i)) {
                worker = workerManger.getHoliWorker();
                outputManager.addOutput(new MyMonth(month), i, day, myCalendar.isPublicHoliday(i), worker);
                continue;
            }
            worker = workerManger.getWeekWorker();
            outputManager.addOutput(new MyMonth(month), i, day, myCalendar.isPublicHoliday(i), worker);
        }
    }

    public void printResult() {
        outputManager.printResult();
    }
}
