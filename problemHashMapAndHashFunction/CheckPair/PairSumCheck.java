package day2.problemHashMapAndHashFunction.CheckPair;

import java.util.HashMap;
public class PairSumCheck {
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int num : arr) {
            int complement = target - num;
            if (numMap.containsKey(complement)) {
                return true; // Pair found
            }
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        return false; // No pair found
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 25;

        System.out.println(hasPairWithSum(arr, target)); // Output: true
    }
}

