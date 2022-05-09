//import java.io.*;
import java.security.DrbgParameters.NextBytes;
import java.util.*;

/**
* Main
*
* The main class that will run the program
*
* @author Brandon Kinaan
* @version May 8, 2022
*/

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        UserData userdata = new UserData();

        login(input, userdata);

        input.close();
        
    }

    public static User login(Scanner input, UserData userdata) {
        System.out.println("Welcome to Resolute.");
        System.out.println("Please enter your username:");
        String username = input.next();
        
        User user = userdata.getUser(username);

        /* user exists */

        if (user != null) {
            while (true) {
                System.out.println("Please enter your password:");
                String password = input.next();
                if (userdata.verfiyLogin(user, password)) {
                    System.out.println("Welcome back " + username);
                    return user;
                }
                System.out.println("Your password is incorrect please try again.");
            }
        }

        /* need to make a new user */

        System.out.println("Please enter a password for your account:");
        System.out.println("Note: your password must contain 10 characters including a capital letter, number, and special character");
        String password = input.next();


        Status status = null;
        if (username.equals("ADMIN")) {
            status = ADMIN;
        } else {
            status = MEMBER;
        }

        User user = new User(username, password, status);

        userdata.addUser(user);

        return user;
    }
}