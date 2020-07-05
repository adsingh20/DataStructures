package arrays;

import java.util.Arrays;
import java.util.Random;

public class MaximumSumSubArray {

    static int findMaximumSumArrayNaiveSolution(int arr[], int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i; j < n; j++) {
                curr = curr + arr[j];
                result = Math.max(curr, result);
            }
        }
        return result;
    }

    static int findMaximumSumArray(int arr[], int n) {
        int result = arr[0];
        int maxEnding = arr[0];
        for (int i = 1; i < n; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            result = Math.max(result, maxEnding);
        }
        return result;
    }


    public static void main(String[] args) {
        int a[] = new int[5];
        int max = 10, min = -10;
        for (int i = 0; i < 5; i++) {
            a[i] = new Random().nextInt(max - min) + min;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(findMaximumSumArrayNaiveSolution(a,5));
        System.out.println(findMaximumSumArray(a,5));
    }
}
