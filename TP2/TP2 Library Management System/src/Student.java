public class Student implements LibraryUser {
    LibraryCard studentCard;
    public Student(LibraryCard studentCard){
        this.studentCard = studentCard;
    }

    public Student() {
    }
    @Override
    public void borrowBook() {
        System.out.println(studentCard.firstName + " " + studentCard.firstName + " has borrowed a book !");
    }
    @Override
    public void returnBook() {
        System.out.print(studentCard.firstName + " " + studentCard.firstName + " has returned a book he had borrowed !");
    }
}
