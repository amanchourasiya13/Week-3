package Day06_AnalysisBigO_Notation.ProblemStatement.ProblemStatement1.SearchTargetInLargeDataSet;
import java.util.Arrays;
import java.util.Random;
public class SearchTarget {

    public static int LinearSearch(int[] arr, int target) {
//        for (int ans : arr) {
//            if (ans == target) {
//                System.out.println("Value Found: " + arr[ans]);
//                return;
//            }
//            System.out.println("Value not found");
//            return;
//        }
//        System.out.println("arr is empty");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target)
                return mid;

            // If target greater, ignore left half
            if (arr[mid] < target)
                left = mid + 1;

                // If target is smaller, ignore right half
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] datasetSizes = {1000, 10000, 1000000};

        // Run tests for different dataset sizes
        for (int size : datasetSizes) {
            // Generate random dataset
            int[] dataset = new int[size];
            for (int i = 0; i < size; i++) {
                dataset[i] = random.nextInt(size * 10);  // Random numbers between 0 and size*10
            }

            // Sort the dataset for binary search (one-time sort)
            Arrays.sort(dataset);

            // Choose a random target to search for
            int target = dataset[random.nextInt(size)];
            System.out.println("Size: " + size);
            System.out.println("Target value: " + target);

            // Measure Linear Search Time (O(N))
            long startTime = System.nanoTime();
            int linearSearchIndex = LinearSearch(dataset, target);
            long endTime = System.nanoTime();
            long linearSearchTime = endTime - startTime;
            System.out.println("Linear Search - Found at index: " + linearSearchIndex);
            System.out.println("Linear Search Time: " + linearSearchTime / 1000000.0 + " ms");

            // Measure Binary Search Time (O(log N))
            startTime = System.nanoTime();
            int binarySearchIndex = binarySearch(dataset, target);
            endTime = System.nanoTime();
            long binarySearchTime = endTime - startTime;
            System.out.println("Binary Search - Found at index: " + binarySearchIndex);
            System.out.println("Binary Search Time: " + binarySearchTime / 1000000.0 + " ms");

            System.out.println();  // Print an empty line between dataset sizes
        }

    }
}