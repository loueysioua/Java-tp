public class Staff {
    private String fullName;
    private String job;
    static private long numStaffs;
    private long staffID;
    private float salary;
    private String status; //in vacation or working or finished working or isn't present
    private Library L;

    public Staff(String fullName, String job, float salary, String status , Library L) {
        numStaffs++;
        this.staffID=numStaffs;
        this.L = L;
        this.fullName = fullName;
        this.job = job;
        this.salary = salary;
        this.status = status;
        L.staffs.add(this);

    }

    public Staff() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public long getStaffID() {
        return staffID;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
