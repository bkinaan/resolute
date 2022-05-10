import java.sql.Date;

public class Task {
    String task;
    Date dueDate;
    Priority priority;

    public Task(String task) {
        this.task = task;
        this.dueDate = null;
        this.priority = Priority.P4;
    }

    public Task(String task, Date dueDate) {
        this.task = task;
        this.dueDate = dueDate;
        this.priority = Priority.P4;
    }

    public Task(String task, Due dueDate, Priority priority) {
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

    public Date getDueDate() {
        return dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return this.getTask() + "\n" + "Due: " + this.getDueDate() + "\n" 
                + "Priority: " + this.getPriority();
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
                && (this.getDueDate() == task.getDueDate()) 
                && (this.getPriority() == task.getPriority());
    }
}
