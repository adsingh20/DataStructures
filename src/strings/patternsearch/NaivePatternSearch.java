package strings.patternsearch;

public class NaivePatternSearch {

    /**
     * Search for pattern in a given and print the indexes on which it is found in
     * main string. Time Complexity O((patternlength + strlength - 1) * patternlength)
     * Space Complexity O(1)
     * @param str String for which the pattern has to be searched
     * @param pattern Pattern to be searched
     */
    private static void naivePatternSearching(String str, String pattern) {
        int strlength = str.length();
        int patternlength = pattern.length();

        for (int i = 0; i <= strlength - patternlength; i++) {
            int j;
            for (j = 0; j < patternlength ; j++) {
                if (pattern.charAt(j) != str.charAt(i+j)) {
                    break;
                }
            }
            if (j == patternlength) {
                System.out.println("Index Matched at" + i);
            }
        }
    }

    /**
     * Search for distinct pattern (characters are not repeated) in a given and print the
     * indexes on which it is found in main string.
     * Time Complexity theta(strlength)
     * Space Complexity O(1)
     * @param str String for which the pattern has to be searched
     * @param pattern Pattern to be searched
     */
    private static void naivePatternSearchingForDistinctPattern(String str, String pattern) {
        int strlength = str.length();
        int patternlength = pattern.length();

        for (int i = 0; i <= strlength - patternlength;) {
            int j;
            for (j = 0; j < patternlength ; j++) {
                if (pattern.charAt(j) != str.charAt(i+j)) {
                    break;
                }
            }
            if (j == patternlength) {
                System.out.println("Index Matched at" + i);
            }

            /* First character didn't match, move in normal naive approach of
            single character window sliding */
            if (j == 0) {
                i++;
            } else {
                i = i + j;
            }
        }
    }

    public static void main(String[] args) {

        naivePatternSearching("ABCDA","AB");
        naivePatternSearching("ABCABCD","ABCD");

        naivePatternSearching("AAAA","AA");
        naivePatternSearching("AAAABBCDDBB","BB");

        naivePatternSearching("AAAABBCDDBB","Z");

        naivePatternSearchingForDistinctPattern("ABCDA","AB");
        naivePatternSearchingForDistinctPattern("ABCABCD","ABCD");

        naivePatternSearchingForDistinctPattern("AAAABBCDDBB","Z");
    }
}
