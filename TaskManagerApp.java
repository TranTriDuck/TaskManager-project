 

/**
 * @Author Duc Tran Tri
 * 
 * 09/05/2024
 * Version: T3 1.1
 *Task Manager

 */



import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

// Main class for running the task manager application
public class TaskManagerApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager(); // Create TaskManager instance
        Scanner scanner = new Scanner(System.in); // Create scanner for user input
        
        boolean running = true; // Main loop control variable

        while (running) {
            // Display the main menu
            System.out.println("\nTask Manager");
            System.out.println("1. Add task list");
            System.out.println("2. Add task to a list");
            System.out.println("3. List tasks in a list");
            System.out.println("4. Mark task as completed");
            System.out.println("5. Mark task as incomplete");
            System.out.println("6. Compare two task lists");
            System.out.println("7. List all task lists");
            System.out.println("8. Evaluate all tasks");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            // Get the user's choice, ensuring it is a valid integer
            int choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    // Add a new task list
                    System.out.print("Enter task list name: ");
                    String listName = scanner.nextLine();
                    taskManager.addTaskList(listName);
                    break;
                case 2:
                    // Add a new task to an existing task list
                    taskManager.listTaskLists();
                    System.out.print("Choose a task list number: ");
                    int listIndex = getIntInput(scanner) - 1;
                    TaskList taskList = taskManager.getTaskList(listIndex);
                    if (taskList != null) {
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        LocalDate dueDate = getDateInput(scanner);
                        taskList.addTask(description, dueDate);
                    } else {
                        System.out.println("Invalid task list number.");
                    }
                    break;
                case 3:
                    // List all tasks in a specific task list
                    taskManager.listTaskLists();
                    System.out.print("Choose a task list number: ");
                    listIndex = getIntInput(scanner) - 1;
                    taskList = taskManager.getTaskList(listIndex);
                    if (taskList != null) {
                        taskList.listTasks();
                    } else {
                        System.out.println("Invalid task list number.");
                    }
                    break;
                case 4:
                    // Mark a task as completed
                    taskManager.listTaskLists();
                    System.out.print("Choose a task list number: ");
                    listIndex = getIntInput(scanner) - 1;
                    taskList = taskManager.getTaskList(listIndex);
                    if (taskList != null) {
                        taskList.listTasks();
                        System.out.print("Choose a task number to mark as completed: ");
                        int taskIndex = getIntInput(scanner) - 1;
                        taskList.markTaskCompleted(taskIndex);
                    } else {
                        System.out.println("Invalid task list number.");
                    }
                    break;
                case 5:
                    // Mark a task as incomplete
                    taskManager.listTaskLists();
                    System.out.print("Choose a task list number: ");
                    listIndex = getIntInput(scanner) - 1;
                    taskList = taskManager.getTaskList(listIndex);
                    if (taskList != null) {
                        taskList.listTasks();
                        System.out.print("Choose a task number to mark as incomplete: ");
                        int taskIndex = getIntInput(scanner) - 1;
                        taskList.markTaskIncomplete(taskIndex);
                    } else {
                        System.out.println("Invalid task list number.");
                    }
                    break;
                case 6:
                    // Compare tasks between two task lists
                    taskManager.listTaskLists();
                    System.out.print("Choose the first task list number: ");
                    int index1 = getIntInput(scanner) - 1;
                    System.out.print("Choose the second task list number: ");
                    int index2 = getIntInput(scanner) - 1;
                    taskManager.compareTaskLists(index1, index2);
                    break;
                case 7:
                    // List all task lists
                    taskManager.listTaskLists();
                    break;
                case 8:
                    // Evaluate all tasks and provide feedback
                    taskManager.evaluateAllTasks();
                    break;
                case 9:
                    // Exit the program
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    // Handle invalid menu choices
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    // Method to get a valid integer input from the user
    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                // Attempt to parse the input as an integer
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                // If input is not a valid integer, prompt the user again
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    // Method to get a valid date input from the user
    private static LocalDate getDateInput(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter due date (YYYY-MM-DD): ");
                // Attempt to parse the input as a date
                return LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                // If input is not a valid date, prompt the user again
                System.out.print("Invalid date format. Please enter date in YYYY-MM-DD format: ");
            }
        }
    }
}
