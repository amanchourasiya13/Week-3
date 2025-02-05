package Day04AndDay05.LinearSearch.FindFirstNegativeNo;

public class FirstNegative {

    // Function to find the first negative number in the array
    public static int findFirstNegative(int[] arr) {
        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Check if the current element is negative
            if (arr[i] < 0) {
                return i;  // Return the index of the first negative number
            }
        }
        return -1;  // Return -1 if no negative number is found
    }

    public static void main(String[] args) {
        // Sample array with mixed positive and negative numbers
        int[] arr = {3, 2, 5, -7, 9, 8, -4, 10};

        // Call the function and print the result
        int index = findFirstNegative(arr);

        if (index != -1) {
            System.out.println("The first negative number is at index: " + index);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }
}
