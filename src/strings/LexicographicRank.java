package strings;

import util.MathUtil;

import java.math.BigInteger;

public class LexicographicRank {

    static final int CHAR_SIZE = 256;

    private static BigInteger findLexicographicalRank(String str) {
        BigInteger result = BigInteger.ONE;
        int n = str.length();
        BigInteger multiplier = MathUtil.findFactorial(n);

        int[] count = new int[CHAR_SIZE];

        for (int i = 0; i < n; i++) {
            count[str.charAt(i)]++;
        }

        for (int i = 1; i < CHAR_SIZE; i++) {
            count[i] += count[i-1];
        }

        for (int i = 0; i < n - 1; i++) {
            /* Consider CAMEL, the initial value of factorial will be 5 but we can 4! combination after first character because
            because C____. So we divide it by multiplier = multiplier/(n-1)  = 5!/(5-0) = 4!
            Simpler expression for below line of code is multiplier = multiplier/(n-i) */
            multiplier = multiplier.divide(BigInteger.valueOf(n).subtract(BigInteger.valueOf(i)));
            /* Multiply the factorial by A____ result = result + count[str.charAt(i) - 1] * multiplier
            count[str.charAt(i) - 1] gives the count of character which are smaller than C ie A which has been
            calculated in line 23. */
            result = result.add(BigInteger.valueOf(count[str.charAt(i) - 1]).multiply(multiplier));
            /* Decrement the count of character since one character has been processed*/
            for (int j = str.charAt(i); j < CHAR_SIZE; j++) {
                count[j]--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findLexicographicalRank("STRING"));
    }

}
