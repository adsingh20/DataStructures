package dynamicprogramming;

import java.util.Arrays;

public class MinimumJumpsToReachEnd {

    private int findMinimumJumpsToReachEndRecursive(int[] arr, int n) {
        int result = Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            if (i + arr[i] >= n - 1) {
                int sub_res = findMinimumJumpsToReachEndRecursive(arr, i + 1);
                if (sub_res != Integer.MAX_VALUE) {
                    result = Math.min(sub_res, result);
                }
            }
        }
        return result;
    }

    private int findMinimumJumpsToReachEndDP(int[] arr) {
        int arrsize = arr.length;
        int[] dp = new int[arrsize];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i < arrsize; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] + j >= i) {
                    if (dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[arrsize - 1];
    }
}
