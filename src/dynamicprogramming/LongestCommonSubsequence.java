package dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubsequence {

    /**
     * Finds Size of LCS using recursive solution
     * Time Complexity O(2 exp n)
     * @param s1 First String
     * @param s2 Second String
     * @param m Sub Length of First String to be considered
     * @param n Sub Length of Second String to be considered
     * @return Size of LCS
     */
    private int findLCSRecursive(String s1, String s2, int m, int n) {
        if (s1.charAt(m) == s2.charAt(n)) {
            return 1 + findLCSRecursive(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(findLCSRecursive(s1, s2, m - 1, n), findLCSRecursive(s1, s2, m, n - 1));
        }
    }

    // 2-D Array to store memoization of already computed subsequence
    int [][]lcsMemo;

    /**
     * Find Size of LCS using recursive memoization DP solution
     * by starting from last indices of the array using top down approach
     * Time Complexity theta(m * n)
     * @param s1 First String
     * @param s2 Second String
     * @param m Sub Length of First String to be considered
     * @param n Sub Length of Second String to be considered
     * @return Size of LCS
     */
    private int findLCSRecursiveMemoization(String s1, String s2, int m, int n) {
        lcsMemo = new int[m][n];

        Arrays.fill(lcsMemo, -1);

        if (lcsMemo[m][n] != -1) {
            return lcsMemo[m][n];
        }

        if (s1.charAt(m) == s2.charAt(n)) {
            lcsMemo[m][n] = 1 + findLCSRecursive(s1, s2, m - 1, n - 1);
        } else {
            lcsMemo[m][n] = Math.max(findLCSRecursive(s1, s2, m - 1, n),
                    findLCSRecursive(s1, s2, m, n - 1));
        }

        return lcsMemo[m][n];
    }

    /**
     * Find size of LCS using tabulation DP solution by starting from
     * first indices of the strings and constructing the solution using
     * bottom up approach
     * Time Complexity theta(m * n)
     * @param s1 First String
     * @param s2 Second String
     * @param m Sub Length of First String to be considered
     * @param n Sub Length of Second String to be considered
     * @return Size of LCS
     */
    private int findLCSTabulationDP(String s1, String s2, int m, int n) {
        lcsMemo = new int[m + 1][n + 1];

        Arrays.fill(lcsMemo, -1);

        for (int i = 0; i <= m; i++) {
            lcsMemo[0][i] = 0;
        }

        for (int i = 0; i <= n; i++) {
            lcsMemo[i][0] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    lcsMemo[i][j] = lcsMemo[i - 1][j - 1];
                } else {
                    lcsMemo[i][j] = Math.max(lcsMemo[i][j - 1], lcsMemo[i - 1][j]);
                }
            }
        }

        return lcsMemo[m][n];
    }
}
