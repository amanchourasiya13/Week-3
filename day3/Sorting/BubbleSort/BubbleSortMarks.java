package day3.Sorting.BubbleSort;
import java.util.Scanner;

public class BubbleSortMarks {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap marks[j] and marks[j+1]
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps occurred in the inner loop, array is already sorted
            if (!swapped) break;
        }
    }
public static void PrintArray(int []arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
}
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for number of students
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] marks = new int[n];

        // Taking input for student marks
        System.out.println("Enter the marks of students:");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }

        // Sorting the marks using Bubble Sort
        bubbleSort(marks);

        // Displaying the sorted marks
         PrintArray(marks);
        scanner.close();
    }
}
