package arrays;

import java.util.Arrays;
import java.util.Random;



public class MaximumLengthEvenOddSubarray {

    public static void main(String[] args) {
        int a[] = new int[5];
        int max = 10, min = -10;
        for (int i = 0; i < 5; i++) {
            a[i] = new Random().nextInt(max);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(findMaximumLengthEvenOddSubarrayNaiveSolution(a,5));
        System.out.println(findMaximumLengthEvenOddSubarray(a,5));
    }

    private static int findMaximumLengthEvenOddSubarrayNaiveSolution(int[] arr, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            int curr = 1;
            for (int j = i+1; j < n; j++) {
                if ((arr[j] % 2 == 0 && arr[j-1] % 2 == 1) ||
                        (arr[j] % 2 == 1 && arr[j-1] % 2 == 0)) {
                    curr++;
                } else {
                    break;
                }
            }
           result = Math.max(curr , result);
        }
        return result;
    }

    private static int findMaximumLengthEvenOddSubarray(int[] arr, int n) {
        int result = 1;
        int maxEnding = 1;
        for (int i = 1; i < n; i++) {
            if ((arr[i] % 2 == 0 && arr[i-1] % 2 == 1) ||
                    (arr[i] % 2 == 1 && arr[i-1] % 2 == 0)) {
                maxEnding++;
                result = Math.max(result, maxEnding);
            } else {
                maxEnding = 1;
            }
        }
        return result;
    }
}
