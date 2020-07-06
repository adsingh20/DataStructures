package strings;

import java.util.HashSet;
import java.util.Set;

public class GetEncodedCheatSheatString {

    private static String getEncodedString(String input) {
        Set<Character> uniqueChars = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (uniqueChars.add(input.charAt(i))) {
                sb.append(input.charAt(i));
            } else {
                if (i > 0 && sb.toString().charAt(sb.toString().length() - 1) != '*') {
                    sb.append("*");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Number of ways = " + getEncodedString("ABABABCBACDABCDE"));
    }
}
