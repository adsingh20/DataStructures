package strings.patternsearch;

public class KnuthMorrisPrathPatternSearch {

    /**
     * Time Complexity
     * All characters same - Case 1 in which i is getting incremented again until n. theta(n)
     * All characters same - Case 2.1 in which i is getting incremented again until n. theta(n)
     * All characters same - Case 2.2 we might have to exeute the comparison n times again. theta(2n) => theta(n)
     * @param str
     * @return
     */
    private static int[] createLongestProperPrefixSuffixArray(String str) {
        int n = str.length(), len = 0;
        int[] lps = new int[str.length()];
        lps[0] = 0;
        int i = 1;
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) { // Case 1
                lps[i] = len + 1;
                len++;
                i++;
            } else {
                if (len == 0) { // Case 2.1
                    lps[i] = 0;
                    i++;
                } else { // Case 2.2
                    len = lps[len-1];
                }
            }
        }

        return lps;
    }

    /**
     * Does pattern matching for @pattern in @text. Time Complexity is upper bounded by O(2n)
     * Slide pattern n times - j++
     * Text Traveral n times - i++
     * O(2n)
     * @param text
     * @param pattern
     */
    private static void patternMatching(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = createLongestProperPrefixSuffixArray(pattern);
        int i = 0, j= 0;
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) { // Case 1
                i++;
                j++;
            }
            if (j == m) { // Pattern Matched
                System.out.println(i - j);
                j = lps[j-1];
            }
            else if (i < n && pattern.charAt(j) != text.charAt(i)){
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j-1];
                }
            }
        }
    }

    public static void main(String[] args) {

        patternMatching("ABCDA","AB");
        patternMatching("ABCABCD","ABCD");

        patternMatching("AAAA","AA");
        patternMatching("AAAABBCDDBB","BB");

        patternMatching("AAAABBCDDBB","Z");

        patternMatching("ABCDA","AB");
        patternMatching("ABCABCD","ABCD");

        patternMatching("AAAABBCDDBB","Z");

        patternMatching("ABABCABABAAD","ABABA");
    }
}
