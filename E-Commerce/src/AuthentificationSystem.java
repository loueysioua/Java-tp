import java.util.HashMap;
import java.util.Scanner;

public class AuthentificationSystem {
    //product manager for regestering users
    private ProductManager productManager;
    private HashMap<String , User> users;
    private HashMap<String , Admin> admins;
    private HashMap<String , User> loggedInUsers;
    private HashMap<String , Admin> loggedInAdmins;

    public AuthentificationSystem(ProductManager productManager) {
        this.productManager = productManager;
        users = new HashMap<>();
        admins = new HashMap<>();
        loggedInUsers = new HashMap<>();
        loggedInAdmins = new HashMap<>();
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

    public HashMap<String, Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(HashMap<String, Admin> admins) {
        this.admins = admins;
    }

    public HashMap<String, User> getLoggedInUsers() {
        return loggedInUsers;
    }

    public void setLoggedInUsers(HashMap<String, User> loggedInUsers) {
        this.loggedInUsers = loggedInUsers;
    }

    public HashMap<String, Admin> getLoggedInAdmins() {
        return loggedInAdmins;
    }

    public void setLoggedInAdmins(HashMap<String, Admin> loggedInAdmins) {
        this.loggedInAdmins = loggedInAdmins;
    }

    public void registerUser(User user) {
        if(!users.containsKey(user.getEmail()))
            users.put(user.getEmail(), user);
        else
            System.out.println("User already exists!");
    }

    public void registerAdmin(Admin admin) {
        if(!admins.containsKey(admin.getEmail()))
            admins.put(admin.getEmail(), admin);
        else
            System.out.println("Admin already exists!");
    }

    public boolean login(String email, String password) {
        if(users.containsKey(email) && !admins.containsKey(email)) {
            if(users.get(email).getPassword().equals(password)) {
                loggedInUsers.put(email, users.get(email));
                System.out.println("User logged in!");
                return true;
            }
            else{
                System.out.println("Wrong password!");
                return false;
            }
        }
        else if(admins.containsKey(email) && !users.containsKey(email)) {
            if(admins.get(email).getPassword().equals(password)) {
                loggedInAdmins.put(email, admins.get(email));
                System.out.println("Admin logged in!");
                return true;
            }
            else {
                System.out.println("Wrong password!");
                return false;
            }
        }
        else if (users.containsKey(email) && admins.containsKey(email)) {
            if(users.get(email).getPassword().equals(password)) {
                loggedInUsers.put(email, users.get(email));
                System.out.println("User logged in!");
                return true;
            }
            if(admins.get(email).getPassword().equals(password)) {
                loggedInAdmins.put(email, admins.get(email));
                System.out.println("Admin logged in!");
                return true;
            }
            else {
                System.out.println("Wrong password!");
                return false;
            }
        }
        else {
            System.out.println("User does not exist!");
            System.out.println("Would you like to register ? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            //register only as user
            if(answer.equalsIgnoreCase("y")) {
                System.out.println("Enter your first name : ");
                String firstName = scanner.nextLine();
                System.out.println("Enter your last name : ");
                String lastName = scanner.nextLine();
                System.out.println("Enter your email : ");
                String email1 = scanner.nextLine();
                System.out.println("Enter your password : ");
                String password1 = scanner.nextLine();
                System.out.println("Enter your phone number : ");
                String phoneNumber = scanner.nextLine();
                System.out.println("Enter your address : ");
                String address = scanner.nextLine();
                User user = new User(this, productManager,firstName, lastName, email1, password1, phoneNumber, address);
                registerUser(user);
                login(email1, password1);
                return true;
            }
            return false;
        }
    }

    //find user by email
    public User findUser(String email) {
        if(users.containsKey(email))
            return users.get(email);
        else
            return null;
    }

    //find admin by email
    public Admin findAdmin(String email) {
        if(admins.containsKey(email))
            return admins.get(email);
        else
            return null;
    }

    public void logout(String email) {
        if(loggedInUsers.containsKey(email)) {
            loggedInUsers.remove(email);
            System.out.println("User logged out!");
        }
        else if(loggedInAdmins.containsKey(email)) {
            loggedInAdmins.remove(email);
            System.out.println("Admin logged out!");
        }
        else
            System.out.println("User does not exist!");
    }

    public void viewUsers() {
        System.out.println("--------------------Users :----------------------");
        for(String email : users.keySet())
            System.out.println(users.get(email).toString());
        System.out.println("--------------------------------------------------");
    }

    public void kickUser(String email) {
        if(users.containsKey(email)) {
            users.remove(email);
            System.out.println("User kicked!");
        }
        else
            System.out.println("User does not exist!");
    }

    public void viewAdmins() {
        System.out.println("--------------------Admins :----------------------");
        for(String email : admins.keySet())
            System.out.println(admins.get(email).toString());
        System.out.println("--------------------------------------------------");
    }

    public void kickAdmin(String email) {
        if(admins.containsKey(email)) {
            admins.remove(email);
            System.out.println("Admin kicked!");
        }
        else
            System.out.println("Admin does not exist!");
    }

    public void viewLoggedInUsers() {
        System.out.println("--------------------Logged in users :----------------------");
        for(String email : loggedInUsers.keySet())
            System.out.println("\t-"+loggedInUsers.get(email).toString());
        System.out.println("-------------------------------------------------------------");
    }

    public void viewLoggedInAdmins() {
        System.out.println("--------------------Logged in admins :----------------------");
        for(String email : loggedInAdmins.keySet())
            System.out.println("\t-"+loggedInAdmins.get(email).toString());
        System.out.println("-------------------------------------------------------------");
    }

    public void viewAllUsers() {
        viewUsers();
        viewAdmins();
        viewLoggedInUsers();
        viewLoggedInAdmins();
    }


}
