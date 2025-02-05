package Day04AndDay05.BinarySearch.FindFirstAndLastElement;

public class BinarySearchFirstAndLastOccurrence {

    // Method to find the first occurrence of the target element
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int first = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the target
            if (arr[mid] == target) {
                first = mid;  // Found the target, but continue searching on the left side
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return first;
    }

    // Method to find the last occurrence of the target element
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the target
            if (arr[mid] == target) {
                last = mid;  // Found the target, but continue searching on the right side
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return last;
    }

    // Method to find both the first and last occurrences
    public static int[] findFirstAndLast(int[] arr, int target) {
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);

        // If either is -1, return an array with -1 indicating not found
        if (first == -1 || last == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{first, last};
    }

    public static void main(String[] args) {
        // Example sorted array
        int[] arr = {1, 2, 2, 2, 3, 4, 4, 5, 6};

        int target = 2;

        // Find the first and last occurrence of the target
        int[] result = findFirstAndLast(arr, target);

        System.out.println("First occurrence: " + result[0]);
        System.out.println("Last occurrence: " + result[1]);
    }
}