public class User {
    private int userId;
    public static newUserId;
    public String username;
    public String password;
    public User(int id , String username , String password){
        this.userId=id;
        this.username = username;
        this.password = password;
    }
    public void bookingABook(Book b){
        b.nbBooks--;

    }
}
