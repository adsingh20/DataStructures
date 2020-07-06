package strings;

public class LongestCommonSubsequence {

    int getLengthOfLongestCommonSubsequence(char[] m, char[] n) {


        int length = n.length;
        int mlength = m.length;
        if (mlength == 0 || length == 0) {
            return 0;
        }

        int L[][] = new int[mlength + 1][length + 1];
        for (int i = 0; i <= mlength; i++) {
            for (int j = 0; j <= length; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (m[i - 1] == n[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[mlength][length];
    }

    int lcs(char[] X, char[] Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";


        System.out.println("Length of LCS is" + " " +
                lcs.getLengthOfLongestCommonSubsequence(s1.toCharArray(), s2.toCharArray()));

        System.out.println("Length of LCS is" + " " +
                lcs.lcs(s1.toCharArray(), s2.toCharArray(), s1.toCharArray().length, s2.toCharArray().length));
    }
}
