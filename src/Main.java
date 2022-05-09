//import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

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

        System.out.println("Welcome to Resolute.");
        System.out.println("Initilizing systems...please wait.");
        suspend(3);
        System.out.println("Please enter your username:");
        String username = input.next();
        
        System.out.println("Welcome " + username);

        input.close();
        
    }

    static private void suspend(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException ie) {
            System.out.println("*** ERROR: Interrupted stream ***");
        }
    }
/* 
    public static User login(Scanner input) {

    } */
}