package Day04AndDay05.BinarySearch.SearchTargetValue;

public class BinarySearch2DMatrix {

    // Method to search for a target value in a 2D matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Treat the 2D matrix as a 1D array
        int left = 0;
        int right = rows * columns - 1;

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Convert mid to row and column indices
            int row = mid / columns;
            int col = mid % columns;

            // Compare the middle element with the target
            if (matrix[row][col] == target) {
                return true;  // Target found
            } else if (matrix[row][col] < target) {
                left = mid + 1;  // Search in the right half
            } else {
                right = mid - 1;  // Search in the left half
            }
        }

        return false;  // Target not found
    }

    public static void main(String[] args) {
        // Example 2D matrix
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 3;

        // Find and print if the target exists in the matrix
        boolean result = searchMatrix(matrix, target);
        System.out.println("Target found: " + result);  // Output: true
    }
}

