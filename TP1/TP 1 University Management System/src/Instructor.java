public class Instructor {

    private int instructorId;
    private String firstName ;
    private String lastName;

    public Instructor() {
    }

    public Instructor(int instructorId, String firstName, String lastName) {
        this.instructorId = instructorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getInstructorId(){
        return(this.instructorId);
    }
    public String getFirstName() {
        return(this.firstName);
    }
    public String getLastName(){
        return(this.lastName);
    }
}
