package day2.problemHashMapAndHashFunction.FindSubArray;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FindSubArrayZero{
    public static void findZeroSumSubarrays(int[] arr) {
        // Map to store the cumulative sum and list of indices where it appears
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;

        // Initialize with sum 0 at index -1 (to handle cases where subarray starts at index 0)
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Update cumulative sum

            // If sum is already present in the map, it means subarrays with zero sum exist
            if (sumMap.containsKey(sum)) {
                for (int start : sumMap.get(sum)) {
                    result.add(new int[]{start + 1, i}); // Subarray (start+1 to i)
                }
            }

            // Add this sum to the map
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        // Print the found subarrays
        if (result.isEmpty()) {
            System.out.println("No subarrays with zero sum found.");
        } else {
            System.out.println("Zero-sum subarrays:");
            for (int[] subarray : result) {
                System.out.println("Start: " + subarray[0] + ", End: " + subarray[1]);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        findZeroSumSubarrays(arr);
    }
}
