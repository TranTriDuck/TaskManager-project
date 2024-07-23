import java.util.ArrayList;
import java.time.LocalDate;

// Represents a list of tasks, each task list has a name and a collection of tasks
public class TaskList {
    private String name; // The name of the task list
    private ArrayList<Task> tasks; // The collection of tasks in the task list

    // Constructor to create a new task list with a specified name
    public TaskList(String name) {
        this.name = name;
        this.tasks = new ArrayList<>(); // Initialize the tasks collection
    }

    // Getter for task list name
    public String getName() {
        return name;
    }

    // Getter for the list of tasks
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    // Method to add a new task to the task list
    public void addTask(String description, LocalDate dueDate) {
        tasks.add(new Task(description, dueDate));
    }

    // Method to mark a specific task as completed
    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
        }
    }

    // Method to mark a specific task as incomplete
    public void markTaskIncomplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markIncomplete();
        }
    }

    // Method to list all tasks in the task list
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
