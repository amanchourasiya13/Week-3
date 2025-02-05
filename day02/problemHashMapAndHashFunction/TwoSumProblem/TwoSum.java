package day2.problemHashMapAndHashFunction.TwoSumProblem;

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i}; // Return indices
            }

            numMap.put(nums[i], i); // Store index of the current number
        }

        return new int[]{}; // Return empty array if no solution
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + ", " + result[1]); // Output: Indices: 0, 1
        } else {
            System.out.println("No solution found");
        }
    }
}

