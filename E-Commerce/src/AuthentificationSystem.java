import java.util.HashMap;

public class AuthentificationSystem {
    private HashMap<String , User> users;
    private HashMap<String , Admin> admins;
    private HashMap<String , User> loggedInUsers;
    private HashMap<String , Admin> loggedInAdmins;

    public AuthentificationSystem() {
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

    public void login(String email, String password) {
        if(users.containsKey(email)) {
            if(users.get(email).getPassword().equals(password)) {
                loggedInUsers.put(email, users.get(email));
                System.out.println("User logged in!");
            }
            else
                System.out.println("Wrong password!");
        }
        else if(admins.containsKey(email)) {
            if(admins.get(email).getPassword().equals(password)) {
                loggedInAdmins.put(email, admins.get(email));
                System.out.println("Admin logged in!");
            }
            else
                System.out.println("Wrong password!");
        }
        else
            System.out.println("User does not exist!");
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
        for(String email : users.keySet())
            System.out.println(users.get(email).toString());
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
        for(String email : admins.keySet())
            System.out.println(admins.get(email).toString());
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
        for(String email : loggedInUsers.keySet())
            System.out.println(loggedInUsers.get(email).toString());
    }

    public void viewLoggedInAdmins() {
        for(String email : loggedInAdmins.keySet())
            System.out.println(loggedInAdmins.get(email).toString());
    }

    public void viewAllUsers() {
        viewUsers();
        viewAdmins();
        viewLoggedInUsers();
        viewLoggedInAdmins();
    }


}
