package hashing;

import java.util.Arrays;
import java.util.HashSet;

public class SubArrayWithSumZero {

    private static boolean findIfSubArrayHasSumZero(int[] arr) {
        HashSet<Integer> items = new HashSet<>();
        int prefixSum = 0;
        for (int value : arr) {
            prefixSum += value;
            if (items.contains(prefixSum)) {
                return true;
            }
            if (prefixSum == 0) {
                return true;
            }
            items.add(prefixSum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 8, -13, -1, -2, 12};
        System.out.println(Arrays.toString(a));
        System.out.println(findIfSubArrayHasSumZero(a));
    }
}
