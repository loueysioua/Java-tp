import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private String name;
    private String location;
    private static int libraryID;
    private String workHours;
    public ArrayList<Staff> staffs;
    public ArrayList<Event> events;
    public ArrayList<LibraryBook> books;
    public ArrayList<User> users;
    public ArrayList<Admin> admins;
    public Provider p;


    public Library(String name, String location, String workHours ,Provider p) {
        this.name = name;
        this.location = location;
        this.workHours = workHours;
        this.p = p;
        books = new ArrayList<LibraryBook>(4);
        users = new ArrayList<User>(4);
        staffs = new ArrayList<Staff>(4);
        events = new ArrayList<Event>(4);
        admins = new ArrayList<Admin>(4);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static int getLibraryID() {
        return libraryID;
    }

    public static void setLibraryID(int libraryID) {
        Library.libraryID = libraryID;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }



    @Override
    public String toString() {
        return "------------------------------------------\n" +
                "Library : \n\t" +
                "Name : '" + name + "'\n\t" +
                "WorkHours : " + workHours + "\n\t" +
                "Location : " + location + "\n\t" +
                "Books : " + this.showBooks() + "\n\t" +
                "Users : " + this.showUsers() + "\n\t" +
                "Events : " + this.showEvents() + "\n\t" +
                "Staff : " + this.showStaff() + "\n\t";
    }

    //search for username
    public int searchUsername(String username) {
        for (int i = 0; i < users.size(); i++) {
            if (((users.get(i)).getUsername()).equals(username)) {
                return i;
            }
        }
        return -1;
    }

    public int searchBook(long isbn) {
        for (int i = 0; i < books.size(); i++) {
            if ((books.get(i)).getIsbn() == isbn) {
                return i;
            }
        }
        return -1;
    }

    public int searchBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if ((books.get(i)).getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    public int searchUser(long userID) {
        for (int i = 0; i < users.size(); i++) {
            if ((users.get(i)).getUserID() == userID) {
                return i;
            }
        }
        return -1;
    }

    public int searchStaff(long staffID) {
        for (int i = 0; i < staffs.size(); i++) {
            if ((staffs.get(i)).getStaffID() == staffID) {
                return i;
            }
        }
        return -1;
    }

    public int searchEvent(long eventID) {
        for (int i = 0; i < events.size(); i++) {
            if ((events.get(i)).getEventID() == eventID) {
                return i;
            }
        }
        return -1;
    }
    public void addBook(Book b) {
        LibraryBook lB = new LibraryBook(b.getTitle(), b.getAuthor(), b.getIsbn(), b.getGenre(), b.getPublicationYear(), b.getPublisher(), b.getEdition(), b.getLanguage(), b.getNbPages(), this);
        int index = searchBook(b.getIsbn());
        if (index == -1) {
            books.add(lB);
            lB.setCopies(1);
        } else {
            books.get(index).setCopies((books.get(index)).getCopies() + 1);
            System.out.println("Another copy of the book '" + b.getTitle() + "' is added to the library .");
        }
    }

    public void addEvent(Event event) {
        boolean v=true;
        for (Event e : events){
            if(e.getEventID()== event.getEventID()){
                v=false;
                System.out.println("Event already exists !");
            }
        }
        if(v)
            events.add(event);
    }

    public void addStaff(Staff staff) {
        boolean v=true;
        for (Staff s : staffs){
            if(s.getStaffID()== staff.getStaffID()){
                v=false;
                System.out.println("Staff already exists !");
            }
        }
        if(v)
            staffs.add(staff);
    }

    public void addAdmins(){
        System.out.println("Full name :\t");
        Scanner sc = new Scanner(System.in);
        String name=sc.nextLine();
        System.out.println("Username :\t");
        String username=sc.nextLine();
        boolean v=true;
        for (Admin a : admins){
            if(a.getUsername().equals(username)){
                v=false;
                System.out.println("Username already exists !");
            }
        }
        if(v){
            System.out.println("Password :\t");
            String password=sc.nextLine();
            System.out.println("Phone Number :\t");
            int pNum= sc.nextInt();
            sc.nextLine();
            System.out.println("Adress :\t");
            String adress=sc.nextLine();
            Admin a = new Admin(password , username , name , adress , pNum , this);
        }
    }

    public void subscribeInTheLibrary(){
        System.out.println("Full name :\t");
        Scanner sc = new Scanner(System.in);
        String name=sc.nextLine();
        System.out.println("Username :\t");
        String username=sc.nextLine();
        boolean v=true;
        for (User user : users){
            if(user.getUsername().equals(username)){
                v=false;
                System.out.println("Username already exists !");
            }
        }
        if(v){
            System.out.println("Password :\t");
            String password=sc.nextLine();
            System.out.println("Phone Number :\t");
            int pNum= sc.nextInt();
            sc.nextLine();
            System.out.println("Adress :\t");
            String adress=sc.nextLine();
            System.out.println("What type of user ?(Prenium/Free) :\t");
            String type=sc.nextLine();
            if( type.equalsIgnoreCase("Prenium")) {
                PreniumUser u = new PreniumUser(password , username , name , adress , pNum , this);
            }
            else {
                FreeUser u = new FreeUser(password , username , name , adress , pNum , this);
            }
        }
    }

    public void loginToLibrary() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username:\t");
        String username = scanner.nextLine();
        System.out.print("Enter your password:\t");
        String password=scanner.nextLine();
        int userIndex= User.login(username , password , this);
        if(userIndex!=-1){
            if (password.contains("Admin") && username.contains("Admin")){
                Admin.menuAdmin( (Admin)( this.users.get(userIndex) ) );
            }
            else {
                User.menuUser(users.get(userIndex));
            }
        }
    }

    public String showUsers() {
        String uS = "------------------------------------------\n";
        if (users.isEmpty())
            uS += "There are still no users ";
        else {
            uS += "here is a list of '" + this.name + "' library users :\n";
            for (User u : users) {
                uS += ("\t- " + u.getUsername() + "\n");
            }
        }
        return (uS);
    }

    public String showBooks() {
        String bS = "----------------------------------------\n";
        if (books.isEmpty()) {
            bS += "There are no books";
        } else {
            bS += "here is a list of '" + this.name + "' library books :\n";
            for (LibraryBook b : books) {
                bS += "\t- '" + b.getTitle() + "'" + " with " + b.getCopies() + "copies" + "\n";
            }
        }
        return (bS);
    }

    public String showEvents() {
        String eS = "------------------------------------------\n";
        if (events.isEmpty())
            eS += "There are still no events ";
        else {
            eS += "here is a list of '" + this.name + "' library events :\n";
            for (Event e : events) {
                eS += (e.getName() + " (" + e.getStatus() + ") |");
            }
        }
        return eS;
    }

    public String showStaff() {
        String sS = "---------------------------------------\n";
        if (staffs.isEmpty())
            sS += "There is still no Staff";
        else {
            sS += "here is a list of '" + this.name + "' library events :\n";
            for (Staff s : staffs) {
                sS += ("\t- " + s.getFullName() + " --> " + s.getJob() + "\n");
            }
        }
        return sS;
    }

    public String showAdmins(){
        String aS = "------------------------------------------\n";
        if (admins.isEmpty())
            aS += "There are still no users ";
        else {
            aS += "here is a list of '" + this.name + "' library users :\n";
            for (Admin u : admins) {
                aS += ("\t- " + u.getUsername() + "\n");
            }
        }
        return (aS);
    }



}
