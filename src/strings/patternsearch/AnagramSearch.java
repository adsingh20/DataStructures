package strings.patternsearch;

import strings.Anagram;

import java.util.Arrays;

public class AnagramSearch {

    static final int CHAR_SIZE = 256;

    private static boolean isPresentNaiveSolution(String text, String pattern) {
        int m = text.length();
        int n = pattern.length();

        for (int i = 0; i < n - m; i++) {
            if(Anagram.isAnagram(text, pattern, i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * In this algorithm we construct the counts for text and pattern until pattern
     * length. Then we check the counts array are equal. If they are not equal we
     * remove the count of the first character from text counts array and add the count of
     * next character in the counts array.
     * Time Complexity - O(m + (n-m) * CHAR_SIZE) where n is text string length and m is pattern
     * string length -> Since n > m and CHAR_SIZE is a constant, O(n) is the time complexity
     * Space Complexity - O(CHAR_SIZE) -> O(1)
     * @param text
     * @param pattern
     * @return If Strings are anagram of one another
     */
    private static boolean isPresent(String text, String pattern) {
        int[] countsTextArray = new int[CHAR_SIZE];
        int[] countsPatternArray = new int[CHAR_SIZE];

        for (int i = 0; i < pattern.length(); i++) {
            countsTextArray[text.charAt(i)]++;
            countsPatternArray[pattern.charAt(i)]++;
        }

        for (int i = pattern.length(); i < text.length(); i++) {
            if (Arrays.equals(countsTextArray, countsPatternArray)) {
                return true;
            }
            countsTextArray[text.charAt(i)]++;
            countsPatternArray[pattern.charAt(i - pattern.length())]--;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println(isPresentNaiveSolution("AmandeepSingh", "SinghAmandeep"));
        System.out.println(isPresentNaiveSolution("AmandeepSingh", "SinghAmandweep"));

        System.out.println(isPresent("AmandeepSingh", "SinghAmandeep"));
        System.out.println(isPresent("AmandeepSingh", "SinghAmandweep"));
    }
}
