import java.util.ArrayList;

// Manages multiple task lists and provides operations to manipulate them
public class TaskManager {
    private ArrayList<TaskList> taskLists; // Collection of task lists

    // Constructor to initialize the task manager
    public TaskManager() {
        taskLists = new ArrayList<>(); // Initialize the task lists collection
    }

    // Method to add a new task list
    public void addTaskList(String name) {
        taskLists.add(new TaskList(name));
    }

    // Method to get a specific task list by index
    public TaskList getTaskList(int index) {
        if (index >= 0 && index < taskLists.size()) {
            return taskLists.get(index);
        }
        return null; // Return null if index is out of range
    }

    // Method to compare tasks between two task lists
    public void compareTaskLists(int index1, int index2) {
        if (index1 >= 0 && index1 < taskLists.size() && index2 >= 0 && index2 < taskLists.size()) {
            TaskList list1 = taskLists.get(index1);
            TaskList list2 = taskLists.get(index2);

            ArrayList<Task> commonTasks = new ArrayList<>(); // List to store common tasks
            for (Task task1 : list1.getTasks()) {
                for (Task task2 : list2.getTasks()) {
                    if (task1.getDescription().equals(task2.getDescription())) {
                        commonTasks.add(task1); // Add common task to the list
                        break;
                    }
                }
            }

            if (commonTasks.isEmpty()) {
                System.out.println("No common tasks found between " + list1.getName() + " and " + list2.getName());
            } else {
                System.out.println("Common tasks between " + list1.getName() + " and " + list2.getName() + ":");
                for (Task task : commonTasks) {
                    System.out.println(task);
                }
            }
        } else {
            System.out.println("Invalid task list indexes.");
        }
    }

    // Method to list all task lists
    public void listTaskLists() {
        if (taskLists.isEmpty()) {
            System.out.println("No task lists available.");
        } else {
            for (int i = 0; i < taskLists.size(); i++) {
                System.out.println((i + 1) + ". " + taskLists.get(i).getName());
            }
        }
    }

    // Method to evaluate all tasks and provide feedback based on their completion status
    public void evaluateAllTasks() {
        int totalTasks = 0;
        int completedTasks = 0;

        for (TaskList taskList : taskLists) {
            for (Task task : taskList.getTasks()) {
                totalTasks++;
                if (task.isCompleted()) {
                    completedTasks++;
                }
            }
        }

        if (totalTasks == 0) {
            System.out.println("No tasks available to evaluate.");
        } else {
            double completionRate = (double) completedTasks / totalTasks;
            if (completionRate > 0.5) {
                System.out.println("Good job, keep cooking!");
            } else {
                System.out.println("Stop delaying your work.");
            }
        }
    }
}
