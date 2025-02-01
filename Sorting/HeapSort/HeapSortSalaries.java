package day3.Sorting.HeapSort;

import java.util.Arrays;
public class HeapSortSalaries {
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Step 1: Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap root (max element) with the last element
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Heapify reduced heap
            heapify(salaries, i, 0);
        }
    }

    private static void heapify(int[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // Check if right child is larger than largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;

            heapify(salaries, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] salaries = {45000, 30000, 50000, 70000, 60000, 40000};
        System.out.println("Before Sorting: " + Arrays.toString(salaries));

        heapSort(salaries);

        System.out.println("After Sorting: " + Arrays.toString(salaries));
    }
}
