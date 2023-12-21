public class Teacher implements LibraryUser {
    LibraryCard teacherCard;

    public Teacher(LibraryCard teacherCard){
        this.teacherCard = teacherCard;
    }

    public Teacher() {
    }

    @Override
    public void borrowBook() {
        System.out.println("Mr/Mrs "+ teacherCard.secondName + " has borrowed a book !");
    }
    @Override
    public void returnBook() {
        System.out.print("Mr/Mrs "+ teacherCard.secondName +"has returned a book he had borrowed !");
    }
}