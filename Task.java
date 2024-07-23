import java.time.LocalDate;

// Represents a single task with a description, due date, and completion status
public class Task {
    private String description; // The description of the task
    private LocalDate dueDate; // The due date of the task
    private boolean isCompleted; // The completion status of the task

    // Constructor to create a new task with a description and due date
    public Task(String description, LocalDate dueDate) {
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = false; // Tasks are initially not completed
    }

    // Getter for task description
    public String getDescription() {
        return description;
    }

    // Getter for task due date
    public LocalDate getDueDate() {
        return dueDate;
    }

    // Getter for task completion status
    public boolean isCompleted() {
        return isCompleted;
    }

    // Method to mark the task as completed
    public void markCompleted() {
        this.isCompleted = true;
    }

    // Method to mark the task as incomplete
    public void markIncomplete() {
        this.isCompleted = false;
    }

    // Method to return a string representation of the task
    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
