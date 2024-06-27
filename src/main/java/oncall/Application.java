package oncall;

import camp.nextstep.edu.missionutils.Console;
import oncall.controller.AllocateController;
import oncall.inpput.CalendarInput;
import oncall.inpput.EnumError;
import oncall.inpput.WorkerInput;
import oncall.model.calendar.MyCalendar;
import oncall.model.worker.WorkerManger;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalendarInput calendarInput = CalendarInput.getInstance();
        WorkerInput workerInput = WorkerInput.getInstance();

        MyCalendar calendarFromInput = calendarInput.createCalendarFromInput();
        WorkerManger workerManagerFromInput = workerInput.createWorkerManagerFromInput();

        AllocateController controller = new AllocateController(calendarFromInput, workerManagerFromInput);
        controller.allocateWorker();
        controller.printResult();
    }
}
