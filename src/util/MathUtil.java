package util;

import java.math.BigInteger;

public final class MathUtil {

    private MathUtil() {}

    public static BigInteger findFactorial(int number) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= number; i++)  {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }
}
