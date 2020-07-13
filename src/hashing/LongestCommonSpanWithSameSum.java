package hashing;

import java.util.Arrays;
import java.util.HashMap;

public class LongestCommonSpanWithSameSum {

    private static int findLongestSpan(int[] arr1, int[] arr2) {
        final int length = arr1.length;
        int sum = 0;
        int result = 0;
        HashMap<Integer, Integer> countHashMap = new HashMap<>();

        int[] temp = new int[length];
        for (int i = 0; i < length ; i++) {
            temp[i] = arr1[i] - arr2[i];
        }


        for (int i = 0; i < length ; i++) {

            sum += temp[i];

            if (sum == 0) {
                result = i + 1;
            }

            if (countHashMap.containsKey(sum)) {
                result = Math.max(result, i - countHashMap.get(sum));
            } else {
                // Else put this sum in hash table}
                countHashMap.put(sum, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 0, 0, 0, 0};
        int[] b = {1, 0, 1, 0, 0, 0, 1};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(findLongestSpan(a, b));
    }
}
