public class Novel extends Book{
    public Novel(String title , String author , int year){
        super(title , author , year);
    }

    public Novel() {
    }

    public void displayInformation(){
        System.out.println("this is a Novel");
        super.displayInformation();
    }
}
