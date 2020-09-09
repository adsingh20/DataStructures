package dynamicprogramming;

import java.util.Arrays;

public class MinimumCoinsForValue {

    /**
     * Finds the minimum number of coins to get the sum of value
     * Time Complexity (coins.length(exp(value))
     * @param coins Array containing coin denominations
     * @param value Total Value for the coins
     * @return Count of minimum coins
     */
    private int findMinimumCoinsForValueRecursive(int[] coins, int value) {
        if (value == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (coin <= value) {
                int subResult = findMinimumCoinsForValueRecursive(coins, value - coin);
                if (subResult != Integer.MAX_VALUE) {
                    result = Math.min(result, subResult);
                }
            }
        }

        return result;
    }

    /**
     * Finds the minimum number of coins to get the sum of value using DP tabulation
     * Time Complexity theta(coins.length * value)
     * Auxiliary Space theta(value)
     * @param coins Array containing coin denominations
     * @param value Total Value for the coins
     * @return Count of minimum coins
     */
    private int findMinimumCoinsForValueDP(int[] coins, int value) {
        int dp[] = new int[value + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 0; i < value; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    int subResult = dp[i - coin];
                    if (subResult != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], subResult);
                    }
                }
            }
        }

        return dp[value];
    }
}
