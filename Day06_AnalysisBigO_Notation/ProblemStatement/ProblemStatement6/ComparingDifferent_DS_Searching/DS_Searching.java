package Day06_AnalysisBigO_Notation.ProblemStatement.ProblemStatement6.ComparingDifferent_DS_Searching;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class DS_Searching {

    // Linear search (O(N)) in an array
    public static void arraySearch(int[] arr, int target) {
        long startTime = System.nanoTime();  // Start measuring time

        // Iterate through the array to find the target element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                break;  // If the target is found, stop searching
            }
        }

        long endTime = System.nanoTime();  // End measuring time
        long result = endTime - startTime;  // Calculate the time taken for the search
        System.out.println("Total time taken by array search: " + result / 1000000.0 + " ms");  // Print the time in milliseconds
    }

    // HashSet search (O(1) on average)
    public static void hashSetSearch(int[] arr, int target) {
        HashSet<Integer> hash = new HashSet<>();  // Create a HashSet to store unique elements

        // Add all elements from the array to the HashSet
        for (int i = 0; i < arr.length; i++) {
            hash.add(arr[i]);
        }

        long startTime = System.nanoTime();  // Start measuring time
        hash.contains(target);  // Check if the target exists in the HashSet
        long endTime = System.nanoTime();  // End measuring time
        long result = endTime - startTime;  // Calculate the time taken for the search
        System.out.println("Total hashset search time: " + result / 1000000.0 + " ms");  // Print the time in milliseconds
    }

    // TreeSet search (O(log N) on average)
    public static void treeSetSearch(int[] arr, int target) {
        TreeSet<Integer> tree = new TreeSet<>();  // Create a TreeSet to store elements in sorted order

        // Add all elements from the array to the TreeSet
        for (int i = 0; i < arr.length; i++) {
            tree.add(arr[i]);
        }

        long startTime = System.nanoTime();  // Start measuring time
        tree.contains(target);  // Check if the target exists in the TreeSet
        long endTime = System.nanoTime();  // End measuring time
        long result = endTime - startTime;  // Calculate the time taken for the search
        System.out.println("Total treeSet search time: " + result / 1000000.0 + " ms");  // Print the time in milliseconds
    }

    public static void main(String[] args) {
        Random random = new Random();  // Create a Random object for generating random numbers
        int[] datasetSizes = {1000, 100000, 1000000};  // Define dataset sizes to test

        // Run tests for different dataset sizes
        for (int size : datasetSizes) {
            int[] dataset = new int[size];  // Create an array to hold the dataset

            // Generate random dataset with values between 0 and size*10
            for (int i = 0; i < size; i++) {
                dataset[i] = random.nextInt(size * 10);
            }

            // Choose a random target value to search for within the dataset
            int target = dataset[random.nextInt(size)];

            System.out.println("Size: " + size);  // Print the current dataset size

            // Call the search methods and measure the search times
            arraySearch(dataset, target);  // Perform linear search
            hashSetSearch(dataset, target);  // Perform HashSet search
            treeSetSearch(dataset, target);  // Perform TreeSet search
        }
    }
}
