package oncall.model.worker;

public class WorkerManger {
    private final WorkList workers;
    private String preWeek;
    private String preHoli;
    private String weekCache;
    private String holiCache;

    public WorkerManger(WorkList workers) {
        this.workers = workers;
    }

    public String getWeekWorker() {
        String target;

        if (!weekCache.isEmpty()) {
            target = weekCache;
            weekCache = null;
            return target;
        }

        target = workers.getWeek();
        if (!preWeek.equals(target)) {
            preWeek = target;
            return target;
        }

        weekCache = target;
        return workers.getWeek();
    }

    public String getHoliWorker() {
        String target;

        if (!holiCache.isEmpty()) {
            target = holiCache;
            holiCache = null;
            return target;
        }

        target = workers.getHoli();
        if (!preHoli.equals(target)) {
            preHoli = target;
            return target;
        }

        holiCache = target;
        return workers.getHoli();
    }

}
