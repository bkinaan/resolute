import java.io.*;
import java.util.ArrayList;

public class TaskData {
    String username;
    private ArrayList<Task> tasks;
    final private String FILE_EXT = "_tasks";
    
    public TaskData(String username) {
        this.username = username;
        tasks = readFromFile();
    }

    private String getUsername() {
        return username;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
        writeToFile();
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        writeToFile();
    }

    private ArrayList<Task> readFromFile() {
        ArrayList<Task> tasks;
        File file = new File(this.getUsername() + FILE_EXT);
        
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

    public void writeToFile() {
        writeToFile(tasks);
    }

    private void writeToFile(ArrayList<Task> tasks) {
        File file = new File(this.getUsername() + FILE_EXT);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(tasks);
        } catch (IOException ioe) {
            return;
        }

        return;
    }
}
