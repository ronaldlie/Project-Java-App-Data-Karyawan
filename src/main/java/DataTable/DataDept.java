package DataTable;

public class DataDept {
    private int dept_id;
    private String dept_name;

    public DataDept(int dept_id, String dept_name) {
        this.dept_id = dept_id;
        this.dept_name = dept_name;
    }

    public String getDept_name() {
        return dept_name;
    }

    public int getDept_id() {
        return dept_id;
    }
}
