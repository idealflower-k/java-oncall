package oncall.model.worker;

public class WorkerManger {
    private WorkList workers;
    private String weekCache;
    private String holiCache;

    public WorkerManger(WorkList workers) {
        this.workers = workers;
    }

}
