package strings;

import java.util.Arrays;

public class KthNonRepeatingCharacter {

    static int findkthNonRepeatingCharacter(String str, int k) {
        int n = str.length();
        int[] count = new int[256];
        int[] index = new int[256];

        for (int i = 0; i < 256; i++) {
            count[i] = 0;
            index[i] = n;
        }

        for (int i = 0; i < n; i++) {
            char x = str.charAt(i);
            ++count[x];
            if (count[x] == 1)
                index[x] = i;
            if (count[x] == 2)
                index[x] = n;


        }
        Arrays.sort(index);

        return (index[k - 1] != n) ? index[k - 1] : -1;
    }

    public static void main(String[] args) {
        String str = "amandeeeeepsingh";
        int index = findkthNonRepeatingCharacter(str, 4);

        System.out.println(index == -1 ? "Either all characters are repeating or string " +
                "is empty" : "First non-repeating character is " + str.charAt(index));
    }
}
