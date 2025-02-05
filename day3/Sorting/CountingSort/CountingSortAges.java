package day3.Sorting.CountingSort;

import java.util.Arrays;

public class CountingSortAges {
    public static void countingSort(int[] ages) {
        int minAge = 10, maxAge = 18;
        int range = maxAge - minAge + 1;

        // Step 1: Create and populate the count array
        int[] count = new int[range];
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Compute cumulative frequencies
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place elements in correct positions
        int[] sortedAges = new int[ages.length];
        for (int i = ages.length - 1; i >= 0; i--) {
            sortedAges[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy sorted ages back to original array
        System.arraycopy(sortedAges, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 15, 11, 18, 10, 14, 13, 12, 16, 17, 15, 10};
        System.out.println("Before Sorting: " + Arrays.toString(studentAges));

        countingSort(studentAges);

        System.out.println("After Sorting: " + Arrays.toString(studentAges));
    }
}
