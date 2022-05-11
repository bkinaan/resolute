import java.io.*;
import java.util.ArrayList;

public class SectionData {
    String username;
    private ArrayList<Section> sections;
    final private String FILE_EXT = this.getUsername() + "_sections";

    public SectionData(String username) {
        sections = readFromFile();
    }

    private String getUsername() {
        return username;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void addSection(Section section) {
        sections.add(section);
        writeToFile();
    }

    public void removeSection(Section section) {
        sections.remove(section);
        writeToFile();
    }

    private ArrayList<Section> readFromFile() {
        ArrayList<Section> sections;
        File file = new File(this.getUsername() + "_sections");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            if (file.length() == 0) {
                throw new IOException();
            }

            sections = (ArrayList<Section>) ois.readObject();
        } catch (IOException ioe) {
            sections = new ArrayList<>();
            writeToFile(sections);
        } catch (ClassNotFoundException cnfe) {
            sections = new ArrayList<>();
            writeToFile(sections);
        }

        return sections;
    }

    public void writeToFile() {
        writeToFile(sections);
    }

    private void writeToFile(ArrayList<Section> sections) {
        File file = new File(FILE_EXT);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(sections);
        } catch (IOException ioe) {
            return;
        }

        return;
    }
}
