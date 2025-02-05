package Day04AndDay05.ChallangeProblems.BothLinearAndBinarySearch;

public class LinearBinarySearchChallenge {

    // Method to find the first missing positive integer using Linear Search
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;

        // Step 1: Mark the numbers as visited (by making them negative) in their index positions
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                continue; // Ignore invalid numbers
            }
            // Mark arr[arr[i] - 1] as visited
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] > 0) {
                arr[index] = -arr[index];
            }
        }

        // Step 2: Find the first index with a positive number, that index + 1 is the missing positive integer
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        // If no missing number found, return n + 1
        return n + 1;
    }

    // Method to find the index of a target number using Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is at mid
            if (arr[mid] == target) {
                return mid;  // Return index of the target
            }

            // If the target is smaller, search the left half
            if (arr[mid] > target) {
                right = mid - 1;
            }
            // If the target is larger, search the right half
            else {
                left = mid + 1;
            }
        }

        // If the target is not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        // Example array for finding the first missing positive integer
        int[] arr = {3, 4, -1, 1};

        // Find and print the first missing positive integer using Linear Search
        int firstMissing = findFirstMissingPositive(arr);
        System.out.println("First missing positive integer: " + firstMissing);  // Output: 2

        // Example array for Binary Search
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        int target = 5;

        // Perform binary search to find the index of the target number
        int targetIndex = binarySearch(sortedArray, target);
        System.out.println("Target index: " + targetIndex);  // Output: 4
    }
}

