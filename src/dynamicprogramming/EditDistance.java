package dynamicprogramming;

public class EditDistance {

    /**
     * Compute the minimum number of edits required to change string s1 to string s2 using
     * combination of addition, deletion and replacement operations
     * @param s1 First String
     * @param s2 Second String
     * @param m Char index of first string being evaluated
     * @param n Char index of second string being evaluated
     * @return Minimum Numbers of Edits required for transformation
     */
    private int findEditDistanceRecursive(String s1, String s2, int m, int n) {
        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return findEditDistanceRecursive(s1, s2, m - 1, n - 1);
        } else {
            return Math.min(Math.min(
                    findEditDistanceRecursive(s1, s2, m - 1, n),
                    findEditDistanceRecursive(s1, s2, m, n - 1)),
                    findEditDistanceRecursive(s1, s2, m - 1, n - 1));
        }
    }

    /**
     * Compute the minimum number of edits required to change string s1 to string s2 using
     * combination of addition, deletion and replacement operations using DP Tabulation Bottom Up approach
     * @param s1 First String
     * @param s2 Second String
     * @param m Char index of first string being evaluated
     * @param n Char index of second string being evaluated
     * @return Minimum Numbers of Edits required for transformation
     */
    private int findEditDistanceDPTabulation(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
