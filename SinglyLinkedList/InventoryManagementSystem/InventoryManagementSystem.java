package day1.SinglyLinkedList.InventoryManagementSystem;

import day1.SinglyLinkedList.StudentRecordManagement.StudentRecordManagement;

public class InventoryManagementSystem{

    // Node class to represent an item
    class Node {
        String itemName;
        int itemId;
        int quantity;
        double price;
        Node next;

        // Constructor to create a new node
        Node(String itemName, int itemId, int quantity, double price) {
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    // Head of the list (first item)
    Node head;

    // Add an item at the beginning
    public void addFirst(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    // Add an item at the end
    public void addLast(String itemName, int itemId, int quantity, double price) {
        Node newNode = new Node(itemName, itemId, quantity, price);
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

    // Add an item at a specific position
    public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        Node newNode = new Node(itemName, itemId, quantity, price);
        if (position == 0) {
            addFirst(itemName, itemId, quantity, price);
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

    // Remove an item based on Item ID
    public void removeItemById(int itemId) {
        if (head == null) {
            System.out.println("The inventory is empty.");
            return;
        }

        // If the head node itself is to be deleted
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }

        // If item is found
        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Item with ID " + itemId + " not found.");
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        Node current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = newQuantity;
                System.out.println("Quantity updated successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item ID
    public void searchById(int itemId) {
        Node current = head;
        while (current != null) {
            if (current.itemId == itemId) {
                System.out.println("Item Found: ID: " + current.itemId + ", Name: " + current.itemName + ", Quantity: " + current.quantity + ", Price: " + current.price);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item Name
    public void searchByName(String itemName) {
        Node current = head;
        while (current != null) {
            if (current.itemName.equals(itemName)) {
                System.out.println("Item Found: ID: " + current.itemId + ", Name: " + current.itemName + ", Quantity: " + current.quantity + ", Price: " + current.price);
                return;
            }
            current = current.next;
        }
        System.out.println("Item with name " + itemName + " not found.");
    }

    // Calculate and display the total value of inventory (Sum of Price * Quantity)
    public void calculateTotalInventoryValue() {
        double totalValue = 0;
        Node current = head;
        while (current != null) {
            totalValue += current.quantity * current.price;
            current = current.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    // Sort the inventory based on item name in ascending order using Merge Sort
    public void sortByItemNameAscending() {
        head = mergeSortByName(head);
    }

    // Merge Sort algorithm for sorting by name
    private Node mergeSortByName(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node middle = getMiddle(node);
        Node nextToMiddle = middle.next;

        middle.next = null;

        Node left = mergeSortByName(node);
        Node right = mergeSortByName(nextToMiddle);

        return mergeByName(left, right);
    }

    // Find the middle of the linked list
    private Node getMiddle(Node node) {
        if (node == null) {
            return node;
        }

        Node slow = node;
        Node fast = node.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        return slow;
    }

    // Merge two sorted linked lists based on item name
    private Node mergeByName(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.itemName.compareTo(right.itemName) <= 0) {
            left.next = mergeByName(left.next, right);
            return left;
        } else {
            right.next = mergeByName(left, right.next);
            return right;
        }
    }

    // Display all inventory items
    public void displayAllItems() {
        if (head == null) {
            System.out.println("No items in the inventory.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.println("Item ID: " + current.itemId + ", Name: " + current.itemName + ", Quantity: " + current.quantity + ", Price: " + current.price);
            current = current.next;
        }
    }
    // count
    public int countNodes() {
        int count = 0;
        InventoryManagementSystem.Node currNode = head;
        while (currNode != null) {
            count++;
            currNode = currNode.next;
        }
        return count;
    }

    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        // Add items
        inventory.addFirst("Apple", 101, 50, 0.99);
        inventory.addLast("Banana", 102, 30, 0.49);
        inventory.addLast("Orange", 103, 20, 0.79);
        inventory.addAtPosition("Mango", 104, 40, 1.49, 2);

        // Display all items
        System.out.println("All Inventory Items:");
        inventory.displayAllItems();

        // Calculate total inventory value
        inventory.calculateTotalInventoryValue();

        // Search for an item by Item ID
        System.out.println("\nSearching for item with ID 102:");
        inventory.searchById(102);

        // Search for an item by Item Name
        System.out.println("\nSearching for item with Name 'Mango':");
        inventory.searchByName("Mango");

        // Update quantity of an item
        System.out.println("\nUpdating quantity of item with ID 103:");
        inventory.updateQuantity(103, 25);

        // Sort items by name
        System.out.println("\nSorting items by name (Ascending):");
        inventory.sortByItemNameAscending();
        inventory.displayAllItems();

        // Remove an item by ID
        System.out.println("\nRemoving item with ID 101:");
        inventory.removeItemById(101);
        inventory.displayAllItems();

        System.out.println("Total Nodes: "+inventory.countNodes());
    }
}

