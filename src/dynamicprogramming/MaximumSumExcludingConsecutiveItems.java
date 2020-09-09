package dynamicprogramming;

public class MaximumSumExcludingConsecutiveItems {

    /**
     * Find the maximum sum from array while excluding consecutive elements
     * using recursion
     * @param arr Array from which maximum has to be found
     * @param n Number of elements in the array
     * @return Maximum Sum excluding consecutive elements
     */
    private int getMaximumSumExcludingConsecutiveItemsRecursively(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }

        if (n == 2) {
            return Math.max(arr[0], arr[1]);
        }

        /* Find maximum of two cases
         1. Exclude the current element and find sum from rest of the array
         2. Include the current element and find sum from rest of the array
         excluding the next item to the current item
         */
        return Math.max(getMaximumSumExcludingConsecutiveItemsRecursively(arr, n - 1),
                getMaximumSumExcludingConsecutiveItemsRecursively(arr, n - 2) + arr[n - 1]);
    }

    /**
     * Find the maximum sum from array while excluding consecutive elements using DP Tabulation
     * Time Complexity - O(n)
     * Auxiliary Space - O(n)
     * @param arr Array from which maximum has to be found
     * @param n Number of elements in the array
     * @return Maximum Sum excluding consecutive elements
     */
    private int getMaximumSumExcludingConsecutiveDPTabulation(int[] arr, int n) {
        int[] dp = new int[n + 1];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        /* Find maximum of two cases
         1. Exclude the current element and find sum from rest of the array
         2. Include the current element and find sum from rest of the array
         excluding the next item to the current item
         */

        for (int i = 3; i <= n; i++) {
            arr[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }

        return dp[n];
    }

    /**
     * Find the maximum sum from array while excluding consecutive elements using DP Tabulation
     * Time Complexity - O(n)
     * Auxiliary Space - O(1)
     * @param arr Array from which maximum has to be found
     * @param n Number of elements in the array
     * @return Maximum Sum excluding consecutive elements
     */
    private int getMaximumSumExcludingConsecutiveDPTabulationSpaceEffective(int[] arr, int n) {
        int prev_prev = arr[0];
        int prev = Math.max(arr[0], arr[1]);
        int result = prev;

        /* Find maximum of two cases
         1. Exclude the current element and find sum from rest of the array
         2. Include the current element and find sum from rest of the array
         excluding the next item to the current item
         */

        for (int i = 3; i <= n; i++) {
            result = Math.min(prev, prev_prev + arr[i]);
            prev_prev = prev;
            prev = result;
        }

        return result;
    }
}
