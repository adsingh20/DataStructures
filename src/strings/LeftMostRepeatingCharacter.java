package strings;

import java.util.Arrays;

public class LeftMostRepeatingCharacter {

    static final int CHAR_SIZE = 256;

    private static int findLeftMostRepeatingCharacter(String str1) {

        int[] counts = new int[CHAR_SIZE];

        for (int i = 0; i < str1.length(); i++) {
            counts[str1.charAt(i)]++;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (counts[str1.charAt(i)] > 1) {
                return i;
            }
        }

        return -1;
    }

    private static int findLeftMostRepeatingCharacterEfficientSolution(String str1) {

        int[] counts = new int[CHAR_SIZE];

        Arrays.fill(counts, -1);

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < str1.length(); i++) {
            int indexValue = counts[str1.charAt(i)];
            if (indexValue == -1) {
                counts[str1.charAt(i)] = i;
            } else {
                result = Integer.min(result, indexValue);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int findLeftMostRepeatingCharacterEfficientSpaceSolution(String str1) {

        boolean[] visited = new boolean[CHAR_SIZE];
        Arrays.fill(visited, false);

        int result = -1;

        for (int i = str1.length() - 1; i >= 0; i--) {
            if (visited[str1.charAt(i)]) {
                result = i;
            } else {
                visited[str1.charAt(i)] = true;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(findLeftMostRepeatingCharacter("AmandeepSingh"));
        System.out.println(findLeftMostRepeatingCharacterEfficientSolution("AmandeepSingh"));
        System.out.println(findLeftMostRepeatingCharacterEfficientSpaceSolution("AmandeepSingh"));
        System.out.println(findLeftMostRepeatingCharacter("abccb"));
        System.out.println(findLeftMostRepeatingCharacterEfficientSolution("abccb"));
        System.out.println(findLeftMostRepeatingCharacterEfficientSpaceSolution("abccb"));
        System.out.println(findLeftMostRepeatingCharacter("abcc"));
        System.out.println(findLeftMostRepeatingCharacterEfficientSolution("abcc"));
        System.out.println(findLeftMostRepeatingCharacterEfficientSpaceSolution("abcc"));
        System.out.println(findLeftMostRepeatingCharacter("abbcc"));
        System.out.println(findLeftMostRepeatingCharacterEfficientSolution("abbcc"));
        System.out.println(findLeftMostRepeatingCharacterEfficientSpaceSolution("abbcc"));
    }
}
