package day3.Sorting.InsertionSort;

import java.util.Scanner;
import java.util.Arrays;
public class InsertionSortID {
    public static void insertionSort(int[]ids){
        int n=ids.length;
        for(int i=1; i<n; i++) {
            int current = ids[i];
            int j = i - 1;
            while(j >= 0 && ids[j] > current) {
                //Keep swapping
                ids[j+1] = ids[j];
                j--;
            }
            ids[j+1] = current;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for number of students
        System.out.print("Enter the number of Employees: ");
        int n = scanner.nextInt();

        int[] ids= new int[n];

        // Taking input for student marks
        System.out.println("Enter the employee id:");
        for (int i = 0; i < n; i++) {
            ids[i] = scanner.nextInt();
        }

        // Sorting the ids using Insertion sort.
         insertionSort(ids);
        // Displaying the sorted ids
        System.out.println(Arrays.toString(ids));
        scanner.close();
    }
}
