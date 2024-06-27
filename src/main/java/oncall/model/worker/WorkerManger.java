package oncall.model.worker;

public class WorkerManger {
    private final WorkList workers;
    private String preWorker;
    private String weekCache;
    private String holiCache;

    public WorkerManger(WorkList workers) {
        this.workers = workers;
    }

    public String getWeekWorker() {
        String target;

        if (weekCache != null) {
            target = weekCache;
            weekCache = null;
            preWorker = target;
            return target;
        }

        target = workers.getWeek();
        if (preWorker != null && preWorker.equals(target)) {
            weekCache = target;
            preWorker = workers.getWeek();
            return preWorker;
        }

        preWorker = target;
        return target;
    }

    public String getHoliWorker() {
        String target;

        if (holiCache != null) {
            target = holiCache;
            holiCache = null;
            preWorker = target;
            return target;
        }

        target = workers.getHoli();
        if (preWorker != null && preWorker.equals(target)) {
            holiCache = target;
            preWorker = workers.getHoli();
            return preWorker;
        }

        preWorker = target;
        return target;
    }

}
