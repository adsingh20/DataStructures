package hashing;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class LongestConsecutiveSubsequence {

    private static int findLongestConsecutiveSubsequenceLengthWithConsecutiveNumbers(int[] arr) {
        HashSet<Integer> items = new HashSet<>();
        Collections.addAll(items);
        for (int value : arr) {
            items.add(value);
        }

        int currentSize = 0;
        int result = 0;

        for (int i = 0 ; i < arr.length ; i++) {
            if (!items.contains(arr[i] - 1)) {
                currentSize = 1;
                while (items.contains(arr[i] + currentSize)) {
                    currentSize++;
                }
            }
            result = Math.max(currentSize, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {3, 8, 4, 5, 6, 11};
        System.out.println(Arrays.toString(a));
        System.out.println(findLongestConsecutiveSubsequenceLengthWithConsecutiveNumbers(a));
    }
}
