package day3.Sorting.QuickSort;

import java.util.Arrays;

public class QuickSortPrices {
    // Quick Sort function
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Partition function
    private static int partition(double[] prices, int low, int high) {
        double pivot = prices[high]; // Choosing last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                swap(prices, i, j);
            }
        }
        swap(prices, i + 1, high);
        return i + 1;
    }

    //    Swap helper function
    private static void swap(double[] prices, int i, int j) {
        double temp = prices[i];
        prices[i] = prices[j];
        prices[j] = temp;
    }

    public static void main(String[] args) {
        double[] productPrices = {99.99, 49.99, 19.99, 149.99, 89.99};
        System.out.println("Before sorting: " + Arrays.toString(productPrices));

        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("After sorting: " + Arrays.toString(productPrices));
    }
}
