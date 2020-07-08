package hashing;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubArrayWithGivenSum {

    private static int findMaximumLengthWithGivenSum(int arr[], int sum) {
        HashMap<Integer, Integer> prefixSumIndices = new HashMap<>();
        int prefixSum = 0, result = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == sum) {
                result = i + 1;
            }
            // store only the first index as we need to find longest subarray
            if (!prefixSumIndices.containsKey(prefixSum)) {
                prefixSumIndices.put(prefixSum, i);
            }
            if (prefixSumIndices.containsKey(prefixSum - sum)) {
                result = Math.max(result, i - prefixSumIndices.get(prefixSum - sum));
                // i - prefixSumIndices.get(prefixSum - sum) gives current length of subarray
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {8, 3, 1, 5, -6, 6, 2, 2};
        int sum = 4;
        System.out.println(Arrays.toString(a));
        System.out.println(findMaximumLengthWithGivenSum(a, sum));
    }
}
