package strings;

import java.util.Arrays;

public class LeftMostNonRepeatingCharacter {

    static final int CHAR_SIZE = 256;

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(256)
     * @param str1 String for  which method has to run
     * @return Left Most Non Repeating Character Index
     */
    private static int findLeftMostNonRepeatingCharacterEfficientSolution(String str1) {

        int[] counts = new int[CHAR_SIZE];

        for (int i = 0; i < str1.length(); i++) {
            counts[str1.charAt(i)]++;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (counts[str1.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }

    /**
     * This method is an efficient solution than above for large strings since it in the
     * second loop it will maximum for 256 characters.
     * Time Complexity - O(n)
     * Space Complexity - O(256)
     * @param str1 String for  which method has to run
     * @return Left Most Non Repeating Character Index
     */
    private static int findLeftMostNonRepeatingCharacterEfficientSolution2(String str1) {

        int[] counts = new int[CHAR_SIZE];

        Arrays.fill(counts, -1);

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < str1.length(); i++) {
            int indexValue = counts[str1.charAt(i)];
            if (indexValue == -1) {
                counts[str1.charAt(i)] = i;
            } else {
                counts[str1.charAt(i)] = -2;
            }
        }

        for (int i = 0; i < CHAR_SIZE; i++) {
            if (counts[i] >= 0) {
                result = Integer.min(result, counts[i]);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {

        System.out.println(findLeftMostNonRepeatingCharacterEfficientSolution("amandeepSingh"));
        System.out.println(findLeftMostNonRepeatingCharacterEfficientSolution2("amandeepSingh"));
    }
}
