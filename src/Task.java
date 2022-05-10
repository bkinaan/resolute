import java.time.Instant;

public class Task {
    String task;
    Instant dueDate;
    Priority priority;

    public Task(String task) {
        this.task = task;
        this.dueDate = null;
        this.priority = Priority.P4;
    }

    public Task(String task, Instant dueDate) {
        this.task = task;
        this.dueDate = dueDate;
        this.priority = Priority.P4;
    }

    public Task(String task, Instant dueDate, Priority priority) {
        this.task = task;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public Task(String task, Priority priority) {
        this.task = task;
        this.dueDate = null;
        this.priority = priority;
    }

    public String getTask() {
        return task;
    }

    public Instant getDueDate() {
        return dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        String output = "";

        output += this.getTask() + "\n";

        if (this.getDueDate() == null) {
            output += "Due date: none\n";
        } else {
            output += "Due date: " + this.getDueDate() + "\n";
        }

        output += "Priority: " + this.getPriority();
        
        return output;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Task)) {
            return false;
        }

        Task task = (Task) obj;

        return (this.getTask().equals(task.getTask())) 
                && (this.getDueDate().equals(task.getDueDate())) 
                && (this.getPriority() == task.getPriority());
    }
}
