//import java.io.*;
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

        User user = login(input, userdata);

        application(input, userdata, user);

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
            status = Status.ADMIN;
        } else {
            status = Status.MEMBER;
        }

        user = new User(username, password, status);

        userdata.addUser(user);

        return user;
    }

    public static void application(Scanner input, UserData userdata, User user) {
        final int MAX_OPTIONS = 5;
        final String mainOptions = """
            What would you like to do?
            0. Logout
            1. View tasks
            2. Add task
            3. View sections
            4. Add section
            5. Settings
            """;

        TaskData taskData = new TaskData(user.getUsername());

        System.out.println("Logged in.");
        System.out.println(mainOptions);

        int userInput = input.nextInt();

        while (userInput < 0 || userInput > MAX_OPTIONS) {
            System.out.println("Invalid input. Please try again.");
            System.out.println(mainOptions);
            userInput = input.nextInt();
        }

        switch (userInput) {
            case 0: boolean logoutSuccess = logout(userdata, user);
                    if (logoutSuccess) {return;} 
                    else {System.out.println("There was an error. Ending application."); return;}
            case 1: viewAllTasks(taskData);
            case 2: addTask(input, taskData);
            case 3: // TODO: ADD FUNCTION TO VIEW SECTIONS [RENAME]
            case 4: // TODO: ADD FUNCTION TO ADD SECTION [RENAME]
            case 5: // TODO: ADD FUNCTION TO GO TO SETTINGS
        }
    }

    public static boolean logout(UserData userdata, User user) {
        System.out.println("Closing application...please wait.");
        
        userdata.writeToFile();

        return true;
    }

    public static void viewAllTasks(TaskData taskData) {
        ArrayList<Task> tasks = taskData.getTasks();

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public static void addTask(Scanner input, TaskData taskData) {
        System.out.println("Enter the task:");
        String taskContent = input.next();
        Task task = new Task(taskContent);
        boolean success = taskData.addTask(task);
        if (!success) {
            System.out.println("There was a problem. Please try again.");
        }
    }

    public static void viewSections() {
        
    }
}