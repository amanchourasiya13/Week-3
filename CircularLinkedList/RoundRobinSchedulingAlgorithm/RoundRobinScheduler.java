package day1.CircularLinkedList.RoundRobinSchedulingAlgorithm;

class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime; // Initialize remaining time with burst time
        this.priority = priority;
        this.next = null;
    }
}

class CircularLinkedList {
    private Process head = null;
    private Process tail = null;

    // Add a new process at the end
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            newProcess.next = head; // Circular link
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; // Circular link
        }
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) return;

        Process temp = head;
        Process prev = null;

        // If head is the process to remove
        if (temp.processId == processId) {
            if (temp == head && temp == tail) {
                head = tail = null; // List is empty
            } else {
                prev = tail;
                while (temp.next != head) {
                    prev = temp;
                    temp = temp.next;
                }
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                    if (temp == tail) {
                        tail = prev;
                    }
                }
            }
        } else {
            while (temp != null && temp.processId != processId) {
                prev = temp;
                temp = temp.next;
            }
            if (temp != null) {
                prev.next = temp.next;
                if (temp == tail) {
                    tail = prev;
                }
            }
        }
    }

    // Simulate Round Robin Scheduling
    public void roundRobinScheduling(int timeQuantum) {
        if (head == null) return;

        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int completedProcesses = 0;
        int totalProcesses = countProcesses();

        Process current = head;

        while (completedProcesses < totalProcesses) {
            if (current.remainingTime > timeQuantum) {
                // Simulate execution for the time quantum
                current.remainingTime -= timeQuantum;
                current = current.next; // Move to next process
            } else if (current.remainingTime > 0) {
                // Process finishes execution
                totalWaitingTime += (current.remainingTime);
                totalTurnAroundTime += (current.burstTime);
                removeProcess(current.processId); // Remove finished process
                completedProcesses++;
                current = current.next; // Move to next process
            }
        }

        // Calculate average waiting time and turn around time
        double avgWaitingTime = (double) totalWaitingTime / totalProcesses;
        double avgTurnAroundTime = (double) totalTurnAroundTime / totalProcesses;

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnAroundTime);
    }

    // Count the total number of processes in the list
    public int countProcesses() {
        if (head == null) return 0;
        int count = 0;
        Process temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    // Display all processes in the circular queue
    public void displayQueue() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime +
                    ", Remaining Time: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinScheduler {
    public static void main(String[] args) {
        CircularLinkedList processQueue = new CircularLinkedList();

        // Add processes to the queue (Process ID, Burst Time, Priority)
        processQueue.addProcess(1, 10, 1);  // Process 1
        processQueue.addProcess(2, 5, 2);   // Process 2
        processQueue.addProcess(3, 8, 3);   // Process 3
        processQueue.addProcess(4, 6, 1);   // Process 4

        System.out.println("Initial Queue:");
        processQueue.displayQueue();

        // Time quantum for Round Robin scheduling
        int timeQuantum = 4;

        // Perform Round Robin Scheduling
        System.out.println("\nSimulating Round Robin Scheduling with Time Quantum: " + timeQuantum);
        processQueue.roundRobinScheduling(timeQuantum);
    }
}
