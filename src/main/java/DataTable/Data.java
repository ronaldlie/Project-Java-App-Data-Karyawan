package DataTable;

public class Data {
    // table employee
    private int id, nik, deptId;
    private String name, gender, religion, jobId, dob;

    public Data(int id, String name, int nik, String dob, String gender, String religion, String jobId, int deptId) {
        this.id = id;
        this.nik = nik;
        this.dob = dob;
        this.deptId = deptId;
        this.name = name;
        this.gender = gender;
        this.religion = religion;
        this.jobId = jobId;
    }

    public int getId() {
        return id;
    }

    public String getDob() {
        return dob;
    }

    public int getNik() {
        return nik;
    }

    public String getJobId() {
        return jobId;
    }

    public String getReligion() {
        return religion;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public int getDeptId() {
        return deptId;
    }
}



