import java.util.ArrayList;

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


    public Library(String name, String location, String workHours) {
        this.name = name;
        this.location = location;
        this.workHours = workHours;
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
                eS += (e.getName() + " |");
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



}
