import java.io.*;
import java.util.ArrayList;

public class UserData {
    private ArrayList<User> users;

    public UserData() {
        users = readFromFile();
    }

    private ArrayList<User> readFromFile() {
        ArrayList<User> users;
        File file = new File("users");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            if (file.length() == 0) {
                throw new IOException();
            }

            users = (ArrayList<User>) ois.readObject();
        } catch (IOException ioe) {
            users = new ArrayList<User>();
            writeToFile(users);
        } catch (ClassNotFoundException cnfe) {
            users = new ArrayList<User>();
            writeToFile(users);
        }

        return users;
    }

    public boolean writeToFile() {
        return writeToFile(users);
    }

    private boolean writeToFile(ArrayList<User> users) {
        File file = new File("users");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(users);
        } catch (IOException ioe) {
            return false;
        }
        
        return true;
    }

    public User getUser(String username) {
        for (User u: users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }

        return null;
    }

    public boolean verfiyLogin(User user, String password) {
        return user.getPassword().equals(password);
    }

    public boolean addUser(User user) {
        if (getUser(user.getUsername()) == null) {
            users.add(user);
            writeToFile();
            return true;
        } else {
            System.out.println("*** ERROR: Trying to add a user that already exists ***");
            return false;
        }
    }

    public void removeUser(String username) {
        User user = getUser(username);

        if (!(user == null)) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username)) {
                    users.remove(i);
                    writeToFile();
                }
            }
        }
    }
}
