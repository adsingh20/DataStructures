package bitwise;

public class Divide {

    /**
     * Divide integer a by b without using / operator
     * Time Complexity - O(log n)
     * Space Complexity - O(1)
     * @param a Dividend
     * @param b Divisor
     * @return Quotient
     * @throws Exception In case of an Divisor is 0
     */
    int divide(int a, int b) throws Exception {

        if (b == 0) {
            throw new Exception("Divisor cannot be zero");
        }

        int sign = (a < 0) ^ (b < 0) ? 1 : -1;

        a = Math.abs(a);
        b = Math.abs(a);

        int quotient = 0;

        // First Iteration  20 - 6 >= 0 {True}
        // Second Iteration  8 - 6 >= 0 {True}
        // Third Iteration  2 - 6 >= 0 {False}
        while (a - b >= 0) {

            int x = 0; // 2 exp 0 = 1
            // Shift b over 1 over x times until it's difference is less than 0
            // First iteration of outer loop and inner loop
            // 20 - (6 << 1 << 0) >= 0  => 20 - 12 >= 0 {True} => x = 1
            // First iteration of outer loop and second iteration of inner loop
            // 20 - (6 << 1 << 1) >= 0  => 20 - 24 >= 0 {False} => x = 1
            // Second iteration of outer loop and inner loop
            // 8 - (6 << 1 << 0) >= 0  => 8 - 12 >= 0 {False} => x = 0
            while (a - (b << 1 << x) >= 0) {
                ++x;
            }

            // How many times we can double x so that it is less than what of a
            // First iteration of outer loop
            // quotient = 0 + 1 << 1 => 2
            // Second iteration of outer loop
            // quotient = 1 + 0 << 1 => 3
            quotient += 1 << x;

            // Subtract from a how many times we have doubled b
            // First iteration a = 20 - (6 << 2) => 20 - 12 = 8
            // Second iteration of outer loop a = 8 - (6 << 0) => 2
            a -= b << x;
        }

        return sign * quotient;
    }
}
