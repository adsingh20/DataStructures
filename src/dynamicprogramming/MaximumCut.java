package dynamicprogramming;

public class MaximumCut {

    /**
     * Given length n and cut lengths a, b and c find maximum number of pieces that
     * can be from pieces of length a, b and c
     *
     * @param n Total Length of the piece
     * @param a First Length a
     * @param b Second Length
     * @param c Third Length
     * @return Maximum Counts of Cuts
     */
    private int findMaximumCutsRecursive(int n, int a, int b, int c) {

        if (n == 0) {
            return 0;
        }

        if (n < 0) {
            return -1;
        }

        int result = Math.max(Math.max(findMaximumCutsRecursive(n - a, a, b, c),
                findMaximumCutsRecursive(n - b, a, b, c)),
                findMaximumCutsRecursive(n - c, a, b, c));

        if (result == -1) {
            return -1;
        }
        return result + 1;
    }

    /**
     * Given length n and cut lengths a, b and c find maximum number of pieces that
     * can be from pieces of length a, b and c
     * Time Complexity - theta(n)
     * Auxiliary Space - theta(n)
     * @param n Total Length of the piece
     * @param a First Length a
     * @param b Second Length
     * @param c Third Length
     * @return Maximum Counts of Cuts
     */
    private int findMaximumCutsDPTabulation(int n, int a, int b, int c) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
            if (i - a >= 0) {
                dp[i] = Math.max(dp[i], dp[i - a]);
            }
            if (i - b >= 0) {
                dp[i] = Math.max(dp[i], dp[i - b]);
            }
            if (i - c >= 0) {
                dp[i] = Math.max(dp[i], dp[i - c]);
            }
            if (dp[i] != -1) {
                ++dp[i];
            }
        }
        return dp[n];
    }
}
