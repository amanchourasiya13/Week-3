package day3.Sorting.MergeSort;
import java.util.Arrays;
import java.util.Scanner;

import java.util.Arrays;

public class MergeSortBook{

    // Function to divide the array into two halves
    public static void divide(int[] prices, int si, int ei) {
        if (si >= ei) {
            return;
        }

        // Find the middle index
        int mid = si + (ei - si) / 2;

        // Recursively divide the left and right parts
        divide(prices, si, mid);
        divide(prices, mid + 1, ei);

        // Merge the divided parts
        merge(prices, si, mid, ei);
    }

    // Function to merge two sorted halves of the array
    public static void merge(int[] prices, int si, int mid, int ei) {
        int[] merged = new int[ei - si + 1]; // Array to store merged result

        int idx1 = si;  // Starting index for the left subarray
        int idx2 = mid + 1; // Starting index for the right subarray
        int x = 0;  // Index for merged array

        // Merge both subarrays while comparing elements
        while (idx1 <= mid && idx2 <= ei) {
            if (prices[idx1] <= prices[idx2]) {
                merged[x++] = prices[idx1++];
            } else {
                merged[x++] = prices[idx2++];
            }
        }

        // Copy remaining elements of the left subarray (if any)
        while (idx1 <= mid) {
            merged[x++] = prices[idx1++];
        }

        // Copy remaining elements of the right subarray (if any)
        while (idx2 <= ei) {
            merged[x++] = prices[idx2++];
        }

        // Copy merged elements back to the original array
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            prices[j] = merged[i];
        }
    }

    // Main method to test the Merge Sort implementation
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for number of students
        System.out.print("Enter the number of Books: ");
        int n = scanner.nextInt();

        int[] bookPrices = new int[n];

        // Taking input for student marks
        System.out.println("Enter the price of books:");
        for (int i = 0; i < n; i++) {
            bookPrices[i] = scanner.nextInt();
        }
        int s = bookPrices.length;

        // Call the divide function to start sorting
        divide(bookPrices, 0, s - 1);

        // Print the sorted book prices
        System.out.println("Sorted Book Prices: " + Arrays.toString(bookPrices));
    }
}
