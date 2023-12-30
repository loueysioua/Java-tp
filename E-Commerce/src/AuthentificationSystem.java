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

    public void changeUserPassword(String email, String oldPassword, String newPassword) {
        if(users.containsKey(email)) {
            if(users.get(email).getPassword().equals(oldPassword)) {
                users.get(email).setPassword(newPassword);
                System.out.println("Password changed!");
            }
            else
                System.out.println("Wrong password!");
        }
        else
            System.out.println("User does not exist!");
    }

    public void changeAdminPassword(String email, String oldPassword, String newPassword) {
        if(admins.containsKey(email)) {
            if(admins.get(email).getPassword().equals(oldPassword)) {
                admins.get(email).setPassword(newPassword+"Admin");
                System.out.println("Password changed!");
            }
            else
                System.out.println("Wrong password!");
        }
        else
            System.out.println("Admin does not exist!");
    }

    public void changeUserEmail(String email, String newEmail) {
        if(users.containsKey(email)) {
            users.get(email).setEmail(newEmail);
            System.out.println("Email changed!");
        }
        else
            System.out.println("User does not exist!");
    }

    public void changeAdminEmail(String email, String newEmail) {
        if(admins.containsKey(email)) {
            admins.get(email).setEmail(newEmail);
            System.out.println("Email changed!");
        }
        else
            System.out.println("Admin does not exist!");
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

    public void openMenu(){
        System.out.println("---------------Welcome to our online shop!---------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter your email : ");
                String email = scanner.nextLine();
                System.out.println("Enter your password : ");
                String password = scanner.nextLine();
                if( this.login(email, password) ){
                    if (this.findAdmin(email) != null) {
                        Admin admin1 = this.findAdmin(email);
                        Admin.AdminMenu(admin1);
                    }
                    else if (this.findUser(email) != null){
                        User.userMenu(this.findUser(email));
                    }
                }
            case 2:
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
                break;
            case 3:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Wrong choice!");
                break;
        }
    }

}
