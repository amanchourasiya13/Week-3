package day2.problemHashMapAndHashFunction.CustomHashMap;
import java.util.LinkedList;

public class CustomHashMap<K, V> {
    // Initial capacity of the hash map (you can adjust this value)
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Node<K, V>>[] table;

    // Constructor
    public CustomHashMap() {
        table = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Node class to store key-value pairs
    private static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Hash function to map the key to an index in the table
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // Insert or update key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = table[index];

        // Check if key already exists in the bucket
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value; // Update value if key is found
                return;
            }
        }

        // If key is not found, add a new node
        bucket.add(new Node<>(key, value));
    }

    // Retrieve the value associated with the key
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = table[index];

        // Search for the key in the bucket
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value; // Return value if key is found
            }
        }

        return null; // Return null if key is not found
    }

    // Remove the key-value pair by key
    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = table[index];

        // Iterate through the list and remove the key-value pair
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                return;
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        map.put("Alice", 30);
        map.put("Bob", 25);
        map.put("Charlie", 35);

        System.out.println("Alice's age: " + map.get("Alice"));
        System.out.println("Bob's age: " + map.get("Bob"));

        // Update Bob's age
        map.put("Bob", 26);
        System.out.println("Bob's updated age: " + map.get("Bob"));

        // Remove Charlie
        map.remove("Charlie");
        System.out.println("Charlie's age after removal: " + map.get("Charlie"));
    }
}
