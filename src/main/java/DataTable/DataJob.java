package DataTable;

public class DataJob {
    private String job_id, job_title;

    public DataJob(String job_id, String job_title) {
        this.job_id = job_id;
        this.job_title = job_title;
    }

    public String getJob_title() {
        return job_title;
    }

    public String getJob_id() {
        return job_id;
    }
}

