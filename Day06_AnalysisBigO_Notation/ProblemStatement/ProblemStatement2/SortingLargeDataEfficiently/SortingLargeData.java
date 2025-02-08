package Day06_AnalysisBigO_Notation.ProblemStatement.ProblemStatement2.SortingLargeDataEfficiently;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SortingLargeData {

    // Bubble Sort Algorithm (O(N^2)) - Repeatedly steps through the list to compare adjacent elements and swaps them if they are in the wrong order.
    public static void BubbleSort(int[] arr){
        int n = arr.length;
        boolean Swapped;
        // Outer loop to perform passes over the entire array
        for(int i = 0; i < n - 1; i++) {
            Swapped = false;
            // Inner loop for comparison and swapping adjacent elements
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    // Swap if elements are in wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    Swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, the array is sorted
            if(!Swapped) break;
        }
    }

    // Quick Sort Algorithm (O(N log N) on average) - A divide and conquer algorithm that selects a pivot and sorts elements around it
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(arr, low, high);
            // Recursively sort the left and right partitions
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition the array for quick sort (Choose a pivot and reorder the elements such that smaller elements go to the left of pivot)
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivot is the last element
        int i = low - 1;  // Pointer for smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than pivot, swap it to the left
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap pivot to its correct position in the array
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;  // Return the pivot index
    }

    // Merge Sort Algorithm (O(N log N)) - Recursively divides the array and merges the subarrays in sorted order
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point of the array
            int mid = left + (right - left) / 2;

            // Recursively sort the left and right halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the two sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Merge two subarrays of arr[]: First subarray is arr[left...mid] and second subarray is arr[mid+1...right]
    private static void merge(int[] arr, int left, int mid, int right) {
        // Find the sizes of two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays to store the subarrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data into temporary arrays
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;

        // Merge the two subarrays back into the original array
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy remaining elements of leftArr[] if any
        while (i < n1) arr[k++] = leftArr[i++];

        // Copy remaining elements of rightArr[] if any
        while (j < n2) arr[k++] = rightArr[j++];
    }

    // Main method to test the sorting algorithms with different dataset sizes
    public static void main(String[] args) {
        Random random = new Random();  // Create a random number generator
        int[] dataSizes = {1000, 10000, 100000};  // Test with different dataset sizes (1000, 10000, 100000)

        // Run tests for different dataset sizes
        for (int size : dataSizes) {
            int[] dataSet = new int[size];  // Create a new dataset of the current size
            // Populate the dataset with random values
            for (int i = 0; i < size; i++) {
                dataSet[i] = random.nextInt(size * 10);  // Random numbers between 0 and size*10
            }
            System.out.println("Size: " + size);  // Print current dataset size

            // Measure time for Bubble Sort
            long startTime = System.nanoTime();  // Start measuring time
            BubbleSort(dataSet.clone());  // Perform bubble sort on a clone of the dataset
            long endTime = System.nanoTime();  // End measuring time
            long BubbleTime = endTime - startTime;  // Calculate time taken for Bubble Sort
            System.out.println("Total time for bubble sort: " + BubbleTime / 1000000.0 + " ms");

            // Measure time for Merge Sort
            startTime = System.nanoTime();  // Start measuring time
            mergeSort(dataSet.clone(), 0, dataSet.length - 1);  // Perform merge sort on a clone of the dataset
            endTime = System.nanoTime();  // End measuring time
            long MergeTime = endTime - startTime;  // Calculate time taken for Merge Sort
            System.out.println("Total time for Merge sort: " + MergeTime / 1000000.0 + " ms");

            // Measure time for Quick Sort
            startTime = System.nanoTime();  // Start measuring time
            quickSort(dataSet.clone(), 0, dataSet.length - 1);  // Perform quick sort on a clone of the dataset
            endTime = System.nanoTime();  // End measuring time
            long QuickTime = endTime - startTime;  // Calculate time taken for Quick Sort
            System.out.println("Total time for Quick Sort: " + QuickTime / 1000000.0 + " ms");
        }
    }
}
