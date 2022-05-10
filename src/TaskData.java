import java.io.*;
import java.util.ArrayList;

public class TaskData {
    String username;
    private ArrayList<Task> tasks;
    
    public TaskData(String username) {
        this.username = username;
        tasks = readFromFile();
    }

    private String getUsername() {
        return username;
    }

    private ArrayList<Task> readFromFile() {
        ArrayList<Task> tasks;
        File file = new File(this.getUsername() + "_tasks_all");
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            if (file.length() == 0) {
                throw new IOException();
            }

            tasks = (ArrayList<Task>) ois.readObject();
        } catch (IOException ioe) {
            tasks = new ArrayList<>();
            writeToFile(tasks);
        } catch (ClassNotFoundException cnfe) {
            tasks = new ArrayList<>();
            writeToFile(tasks);
        }

        return tasks;
    }

    public boolean writeToFile() {
        return writeToFile(tasks);
    }

    private boolean writeToFile(ArrayList<Task> tasks) {
        File file = new File(this.getUsername() + "_tasks_all");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(tasks);
        } catch (IOException ioe) {
            return false;
        }

        return true;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public boolean addTask(Task task) {
        tasks.add(task);
        boolean success = writeToFile();
        return success;
    }
}
