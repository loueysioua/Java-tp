public class Textbook extends Book {

    public Textbook(String title , String author , int year){
        super(title , author , year);
    }

    public Textbook() {
    }

    public void displayInformation(){
        System.out.println("this is a Textbook ");
        super.displayInformation();
    }
}
