package strings;

import java.util.Arrays;

public class LongestSubstringWithDistinctCharacters {

    private static final int CHAR_SIZE = 256;

    private static boolean isInputDistinct(String str) {

        boolean[] visited = new boolean[CHAR_SIZE];

        for (int i = 0; i < str.length(); i++) {
            if (visited[str.charAt(i)]) {
                return false;
            }
            visited[str.charAt(i)] = true;
        }

        return true;
    }

    private static int longestDistinctNaiveSolution(String str) {
        int length = str.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (isInputDistinct(str.substring(i, j))) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }

    private static int longestDistinctBetterSolution(String str) {
        boolean[] visited;

        int length = str.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            visited = new boolean[CHAR_SIZE];
            for (int j = i; j < length; j++) {
                if (visited[str.charAt(j)]) {
                   break;
                } else {
                    result = Math.max(result, j - i + 1);
                    visited[str.charAt(i)] = true;
                }
            }
        }
        return result;
    }

    /**
     * scan the string from left to right, keep track of the maximum length Non-Repeating Character Substring
     * seen so far in res. When we traverse the string, to know the length of current window we need to indexes.
     * 1) Ending index ( j ) : We consider current index as ending index.
     * 2) Starting index ( i ) : It is same as previous window if current character was not present in the
     * previous window. To check if the current character was present in the previous window or not,
     * we store last index of every character in an array lasIndex[].
     * If lastIndex[str[j]] + 1 is more than previous start, then we updated the start index i.
     * Else we keep same i.
     * @param str String for which the longest substring has to be searched
     * @return length of longest substring
     */
    private static int longestDistinct(String str) {
        int[] lastIndex = new int[CHAR_SIZE];

        Arrays.fill(lastIndex, -1);

        int strlength = str.length();
        int result = 0;
        int i = 0;
        for (int j = 0; j < strlength; j++) {

            /* Find the last index of str[j] then
             Update i (starting index of current window)
             as maximum of current value of i and last
             index plus 1
             */
            i = Math.max(j, lastIndex[str.charAt(j)] + 1);

            // Update result  if we get a larger window
            result = Math.max(result, j - i + 1);

            // Update last index of j.
            lastIndex[str.charAt(j)] = j;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestDistinctNaiveSolution("abcadbcd"));
        System.out.println(longestDistinctBetterSolution("abcadbcd"));
        System.out.println(longestDistinct("abcadbcd"));
    }
}
