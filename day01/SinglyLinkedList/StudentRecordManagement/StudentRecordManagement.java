package day1.SinglyLinkedList.StudentRecordManagement;

public class StudentRecordManagement {

    // Node class to represent a student
    class Node {
        int rollNumber;
        String name;
        int age;

        String grade;
        Node next;

        // Constructor to create a new node
        Node(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    // Head of the list (first student record)
    Node head;

    // Add a student record at the beginning
    public void addFirst(int rollNumber, String name, int age, String grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Add a student record at the end
    public void addLast(int rollNumber, String name, int age, String grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Add a student record at a specific position
    public void addAtPosition(int rollNumber, String name, int age, String grade, int position) {
        Node newNode = new Node(rollNumber, name, age, grade);
        if (position == 0) {
            addFirst(rollNumber, name, age, grade);
            return;
        }

        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        } else {
            System.out.println("Position is out of range.");
        }
    }

    // Delete a student record by roll number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        // If the head node itself is to be deleted
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }

        // If roll number is found
        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Student with roll number " + rollNumber + " not found.");
        }
    }

    // Search for a student by roll number
    public void searchByRollNumber(int rollNumber) {
        Node current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("Student Found: Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    // Update a student's grade by roll number
    public void updateGrade(int rollNumber, String newGrade) {
        Node current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = newGrade;
                System.out.println("Student grade updated successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    // Display all student records
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
    // count
    public int countNodes() {
        int count = 0;
        Node currNode = head;
        while (currNode != null) {
            count++;
            currNode = currNode.next;
        }
        return count;
    }

    public static void main(String[] args) {
        StudentRecordManagement list = new StudentRecordManagement();

        // Add students
        list.addFirst(101, "Alice", 20, "A");
        list.addLast(102, "Bob", 21, "B");
        list.addLast(103, "Charlie", 22, "A");
        list.addAtPosition(104, "David", 23, "C", 1);

        // Display all students
        System.out.println("All Student Records:");
        list.displayAll();

        // Search for a student by roll number
        System.out.println("\nSearching for student with roll number 102:");
        list.searchByRollNumber(102);

        // Update a student's grade
        System.out.println("\nUpdating grade for student with roll number 103:");
        list.updateGrade(103, "A+");

        // Display all students after update
        System.out.println("\nAll Student Records After Update:");
        list.displayAll();

        // Delete a student by roll number
        System.out.println("\nDeleting student with roll number 101:");
        list.deleteByRollNumber(101);

        // Display all students after deletion
        System.out.println("\nAll Student Records After Deletion:");
        list.displayAll();

        System.out.println("Total Nodes: "+list.countNodes());
    }
}
