import java.util.ArrayList;

public class Section {
    String name;
    ArrayList<Task> tasks;
    ArrayList<Note> notes;

    public Section(String name) {
        this.name = name;
        this.tasks = null;
        this.notes = null;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void addNote(Note note) {
        this.notes.add(note);
    }

    @Override
    public String toString() {
        String output = "Section name: " + this.getName()
                        + "Tasks:\n";

        for (Task task : tasks) {
            output += task.getTask();
            output += "\n";
        }

        return output;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Section)) {
            return false;
        }

        Section section = (Section) obj;

        return (this.getName().equals(section.getName()));
    }
}
