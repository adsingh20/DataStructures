package dynamicprogramming;

public class SubsetSumProblem {

    /**
     * Recursive solution for finding the sum of subsets
     * Time Complexity theta(2 exp n)
     * @param arr Array of elements for which sum has to be calculated
     * @param n Number of elements being considered currently
     * @param sum Sum of the current iteration
     * @return Number of subsets containing the sum
     */
    private int countSubsetsRecursive(int[] arr, int n, int sum) {
        if (n == 0)
            return sum == 0 ? 1 : 0;

        /* Create two subtrees one of which we include the elements
        and other we exclude the element */
        return countSubsetsRecursive(arr, n - 1, sum) +
                countSubsetsRecursive(arr, n - 1, sum - arr[n - 1]);
    }

    /**
     * DP solution for finding the sum of subsets
     * Time Complexity theta(n * sum)
     * Auxiliary Space theta(n * sum)
     * @param arr Array of elements for which sum has to be calculated
     * @param n Number of elements being considered currently
     * @param sum Sum of the current iteration
     * @return Number of subsets containing the sum
     */
    private int countSubsetsDP(int[] arr, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        /* For 0 sum we have solutions as 1 since we can exclude all elements from
        the current set */
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // With 0 element you cannot have any sum
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // Exclude case when sum is less than the current element
                if (j < arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }
}
