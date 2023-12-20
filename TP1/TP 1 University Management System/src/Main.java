import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Instructor I = new Instructor(254 , "John" , "Doe");
        System.out.println(I.getInstructorId());
        System.out.println(I.getFirstName());
        System.out.println(I.getLastName());
        Course C = new Course(1 , "Java" , I);
        System.out.println(C.getCourseId());
        System.out.println(C.getCourseName());
        System.out.println(C.getInstructor());
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(C);
        Student S= new Student(1 , "John" , "Doe");
        S.enroll(C);
        System.out.println(S.getStudentId());
        System.out.println(S.getLastName());
        System.out.println(S.getFirstName());
        System.out.println(S.getCourses());
    }
}