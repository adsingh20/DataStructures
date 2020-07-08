package hashing;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubArrayWithSameNumberOfZerosAndOnes {

    private static int findMaximumLengthWithSameNumberOfZerosAndOnes(int arr[]) {
        HashMap<Integer, Integer> prefixSumIndices = new HashMap<>();
        int prefixSum = 0, result = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == 0) {
                result = i + 1;
            }
            // store only the first index as we need to find longest subarray
            if (!prefixSumIndices.containsKey(prefixSum)) {
                prefixSumIndices.put(prefixSum, i);
            }
            if (prefixSumIndices.containsKey(prefixSum)) {
                result = Math.max(result, i - prefixSumIndices.get(prefixSum));
                // i - prefixSumIndices.get(prefixSum - sum) gives current length of subarray
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, -1, 1, 1, 1, -1, -1};
        System.out.println(Arrays.toString(a));
        System.out.println(findMaximumLengthWithSameNumberOfZerosAndOnes(a));
    }
}
