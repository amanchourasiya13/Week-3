package Day06_AnalysisBigO_Notation.ProblemStatement.ProblemStatement1.SearchTargetInLargeDataSet;

import java.util.Arrays;
import java.util.Random;

public class SearchTarget {

    // Linear search algorithm (O(N))
    public static int LinearSearch(int[] arr, int target) {
        // Iterate over the entire array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {  // If the element is found, return the index
                return i;
            }
        }
        return -1;  // If the target is not found, return -1
    }

    // Binary search algorithm (O(log N)), requires a sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        // Perform binary search while the left index is less than or equal to the right index
        while (left <= right) {
            int mid = left + (right - left) / 2;  // Find the middle element

            // Check if the target is at the middle position
            if (arr[mid] == target)
                return mid;

            // If the target is greater than the mid element, ignore the left half
            if (arr[mid] < target)
                left = mid + 1;
                // If the target is smaller than the mid element, ignore the right half
            else
                right = mid - 1;
        }
        return -1;  // If the target is not found, return -1
    }

    public static void main(String[] args) {
        Random random = new Random();  // Create an object for generating random numbers
        int[] datasetSizes = {1000, 10000, 1000000};  // Array of different dataset sizes to test

        // Run tests for different dataset sizes
        for (int size : datasetSizes) {
            // Generate a random dataset of the given size
            int[] dataset = new int[size];
            for (int i = 0; i < size; i++) {
                dataset[i] = random.nextInt(size * 10);  // Populate the array with random numbers between 0 and size*10
            }

            // Sort the dataset for binary search (since binary search requires a sorted array)
            Arrays.sort(dataset);

            // Choose a random target value to search for from the dataset
            int target = dataset[random.nextInt(size)];
            System.out.println("Size: " + size);  // Print the current dataset size
            System.out.println("Target value: " + target);  // Print the chosen target value

            // Measure the time taken by Linear Search (O(N))
            long startTime = System.nanoTime();  // Start measuring time for Linear Search
            int linearSearchIndex = LinearSearch(dataset, target);  // Perform linear search
            long endTime = System.nanoTime();  // End measuring time for Linear Search
            long linearSearchTime = endTime - startTime;  // Calculate the time taken for Linear Search
            System.out.println("Linear Search - Found at index: " + linearSearchIndex);  // Print the index where the target was found
            System.out.println("Linear Search Time: " + linearSearchTime / 1000000.0 + " ms");  // Print the time taken in milliseconds

            // Measure the time taken by Binary Search (O(log N))
            startTime = System.nanoTime();  // Start measuring time for Binary Search
            int binarySearchIndex = binarySearch(dataset, target);  // Perform binary search
            endTime = System.nanoTime();  // End measuring time for Binary Search
            long binarySearchTime = endTime - startTime;  // Calculate the time taken for Binary Search
            System.out.println("Binary Search - Found at index: " + binarySearchIndex);  // Print the index where the target was found
            System.out.println("Binary Search Time: " + binarySearchTime / 1000000.0 + " ms");  // Print the time taken in milliseconds

            System.out.println();  // Print an empty line between different dataset sizes for readability
        }
    }
}
