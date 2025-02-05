package Day04AndDay05.BinarySearch.FindPeakElement;

public class BinarySearchPeak {

    // Method to find a peak element in the array
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        // Perform binary search to find a peak element
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the peak element
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                return mid; // Mid is the peak element
            }

            // If the left neighbor is greater, search the left half
            else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            }
            // If the right neighbor is greater, search the right half
            else {
                left = mid + 1;
            }
        }

        return -1; // This line should not be reached if the array has a peak element
    }

    public static void main(String[] args) {
        // Example array
        int[] arr = {1, 3, 20, 4, 1, 0};

        // Find and print the peak element index
        int peakIndex = findPeakElement(arr);
        System.out.println("The peak element is at index: " + peakIndex);
        System.out.println("The peak element is: " + arr[peakIndex]);
    }
}

