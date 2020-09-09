package dynamicprogramming;

public class CoinChangeSum {

    /**
     * Find count of coin which can make up the sum
     * @param sum Sum for which count of coints have to be done
     * @param coins Array containing the coins
     * @param numberOfCoins Pointer to array for current iteration of coins
     * @return Count of Total Combinations
     */
    private int countCombination(int sum, int[] coins, int numberOfCoins) {

        // Number of Combinations for sum 0 is 1 since because we can no coins for sum 0
        if (sum == 0) {
            return 1;
        }

        // In case of number of coins is 0, then the number of combinations is since we cannot have a combination with no coin
        if (numberOfCoins == 0) {
            return 0;
        }


        // Dont consider the last coin first
        int result = countCombination(sum, coins, numberOfCoins - 1);

        // Include coin in case sum is the current coin
        if (coins[numberOfCoins - 1] <= sum) {
            result += countCombination(sum - coins[numberOfCoins - 1], coins, numberOfCoins);
        }

        return result;
    }

    int[][] resultDP;

    //TODO: This space complexity of this approach will be very high for huge sums. Find a way to reduce the same complexity
    /**
     * Find count of coin which can make up the sum using tabulation DP
     * We take dimensions as sum + 1 * n + 1 not the other way ie n + 1 * sum + 1 will
     * have more solutions since the former approach we are considering all coins for sum
     * and in latter we will be considering sums for all coins
     * @param sum Sum for which count of coints have to be done
     * @param coins Array containing the coins
     * @param numberOfCoins Pointer to array for current iteration of coins
     * @return Count of Total Combinations
     */
    private int countCombinationTabularDP(int sum, int[] coins, int numberOfCoins) {
        resultDP = new int[sum + 1][numberOfCoins + 1];

        for (int i = 0; i <= sum; i++) {
            resultDP[i][0] = 1;
        }

        for (int i = 0; i <= numberOfCoins; i++) {
            resultDP[0][i] = 0;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= numberOfCoins; j++) {
                resultDP[i][j] = resultDP[i][j - 1];
                if (coins[j - 1] <= sum) {
                    // Get count of sum - current coin with positions of coin
                    resultDP[i][j] += resultDP[i - coins[j - 1]][i];
                }
            }
        }

        return resultDP[sum][numberOfCoins];
    }
}
