package day1.CircularLinkedList.TaskScheduler;

import java.util.Date;

class Task {
    int taskId;
    String taskName;
    int priority;
    Date dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, Date dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularLinkedList {
    private Task head = null;

    // Add a task at the beginning
    public void addAtBeginning(int taskId, String taskName, int priority, Date dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head; // Circular reference
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
            head = newTask;
        }
    }

    // Add a task at the end
    public void addAtEnd(int taskId, String taskName, int priority, Date dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    // Add a task at a specific position
    public void addAtPosition(int position, int taskId, String taskName, int priority, Date dueDate) {
        if (position <= 0) {
            addAtBeginning(taskId, taskName, priority, dueDate);
        } else {
            Task newTask = new Task(taskId, taskName, priority, dueDate);
            Task temp = head;
            int counter = 0;
            while (counter < position - 1 && temp.next != head) {
                temp = temp.next;
                counter++;
            }
            newTask.next = temp.next;
            temp.next = newTask;
        }
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) return;
        if (head.taskId == taskId) {
            if (head.next == head) {
                head = null;
            } else {
                Task temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next;
                head = head.next;
            }
        } else {
            Task temp = head;
            while (temp.next != head && temp.next.taskId != taskId) {
                temp = temp.next;
            }
            if (temp.next != head) {
                temp.next = temp.next.next;
            }
        }
    }

    // View the current task and move to the next task in circular list
    public Task viewNextTask() {
        if (head == null) return null;
        Task currentTask = head;
        head = head.next;
        return currentTask;
    }

    // Display all tasks in the list
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for tasks by priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }
}

public class TaskScheduler{
    public static void main(String[] args) {
        CircularLinkedList taskList = new CircularLinkedList();

        // Example task data
        taskList.addAtEnd(1, "Task1", 3, new Date());
        taskList.addAtEnd(2, "Task2", 2, new Date());
        taskList.addAtEnd(3, "Task3", 1, new Date());

        taskList.displayAllTasks(); // Display all tasks

        taskList.removeTaskById(2); // Remove task with ID 2
        taskList.displayAllTasks(); // Display all tasks after removal

        taskList.addAtPosition(1, 4, "Task4", 4, new Date()); // Add Task4 at position 1
        taskList.displayAllTasks(); // Display all tasks

        // Move to the next task
        Task nextTask = taskList.viewNextTask();
        if (nextTask != null) {
            System.out.println("Next task is: " + nextTask.taskName);
        }

        // Search for tasks by priority
        taskList.searchTaskByPriority(1);
    }
}

