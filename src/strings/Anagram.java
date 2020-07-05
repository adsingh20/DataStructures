package strings;

import java.util.Arrays;

public class Anagram {

    static final int CHAR_SIZE = 256;

    private static boolean isAnagramNaiveSolution(String str1, String str2) {
        if (!isStringLengthSame(str1.length(), str2.length()))
            return false;

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return new String(chars1).equals(new String(chars2));
    }

    private static boolean isAnagram(String str1, String str2) {
        if (!isStringLengthSame(str1.length(), str2.length()))
            return false;

        int[] counts = new int[CHAR_SIZE];

        for (int i = 0; i < str1.length(); i++) {
            counts[str1.charAt(i)]++;
            counts[str2.charAt(i)]--;
        }

        for (int i = 0; i < CHAR_SIZE; i++) {
            if (counts[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagram(String str1, String str2, int i) {
        if (!isStringLengthSame(str1.length(), str2.length()))
            return false;

        int[] counts = new int[CHAR_SIZE];

        for (int j = 0; i < str1.length(); i++) {
            counts[str1.charAt(i)]++;
            counts[str2.charAt(i + j)]--;
        }

        for (int j = 0; i < CHAR_SIZE; i++) {
            if (counts[j] != 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isStringLengthSame(int length1, int length2) {
        return length1 == length2;
    }

    public static void main(String[] args) {

        System.out.println(isAnagramNaiveSolution("AmandeepSingh", "SinghAmandeep"));
        System.out.println(isAnagramNaiveSolution("AmandeepSingh", "SinghAmandweep"));

        System.out.println(isAnagram("AmandeepSingh", "SinghAmandeep"));
        System.out.println(isAnagram("AmandeepSingh", "SinghAmandweep"));
    }

}
