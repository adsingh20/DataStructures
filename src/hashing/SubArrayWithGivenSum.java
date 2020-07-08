package hashing;

import java.util.Arrays;
import java.util.HashSet;

public class SubArrayWithGivenSum {

    private static boolean findIfSubArrayHasGivenSum(int[] arr, int sum) {
        HashSet<Integer> items = new HashSet<>();
        int prefixSum = 0;
        for (int value : arr) {
            prefixSum += value;
            if (prefixSum == sum) {
                return true;
            }
            if (items.contains(prefixSum - sum)) {
                return true;
            }
            items.add(prefixSum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 8, -13, -1, -2, 12};
        System.out.println(Arrays.toString(a));
        System.out.println(findIfSubArrayHasGivenSum(a, 13));
    }
}
