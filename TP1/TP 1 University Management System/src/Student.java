import java.util.ArrayList;

public class Student {
    private int studentId;
    private String firstName;
    private String lastName ;
    private ArrayList<Course> courses;

    public Student() {
    }

    public Student(int studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = new ArrayList<Course>();
    }

    public int getStudentId(){
        return(this.studentId);
    }

    public String getFirstName(){
        return(this.firstName);
    }

    public String getLastName(){
        return(this.lastName);
    }

    public ArrayList<Course> getCourses(){
        return(this.courses);
    }

    public void enroll(Course course){
        courses.add(course);
    }

}
