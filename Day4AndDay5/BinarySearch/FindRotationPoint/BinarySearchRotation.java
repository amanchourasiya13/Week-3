package Day04AndDay05.BinarySearch.FindRotationPoint;

public class BinarySearchRotation {

    // Method to find the index of the rotation point (smallest element) in a rotated sorted array
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        // Perform binary search
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if the middle element is greater than the right element
            if (arr[mid] > arr[right]) {
                // The rotation point is in the right half
                left = mid + 1;
            } else {
                // The rotation point is in the left half (including mid)
                right = mid;
            }
        }

        // At the end, left == right, which is the rotation point
        return left;
    }

    public static void main(String[] args) {
        // Example rotated sorted array
        int[] arr = {6, 7, 9, 15, 19, 2, 3};

        // Find and print the rotation point index
        int rotationPoint = findRotationPoint(arr);
        System.out.println("The rotation point index is: " + rotationPoint);  // Output: 5
        System.out.println("The smallest element is: " + arr[rotationPoint]);  // Output: 2
    }
}

