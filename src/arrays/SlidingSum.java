package arrays;

import java.util.Arrays;
import java.util.Random;

public class SlidingSum {

    private static int findMaximumSlidingSumNaiveSolution(int arr[], int n, int k) {
        int result = Integer.MIN_VALUE;

        for (int i = 0; i + k -1 < n; i++){
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += arr[i + j];
            }
            result = Math.max(result, sum);
        }
        return result;
    }

    private static int findMaximumSlidingSum(int arr[], int n, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int result = sum;
        for (int j = k; j < n; j++) {
            sum += (arr[j] - arr[j-k]);
            result = Math.max(sum, result);
        }
        return result;
    }

    private static boolean findMaximumSlidingSumIfGreaterThanPredefinedSum(int arr[], int n, int k, int preDefinedSum) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (preDefinedSum <= sum) {
            return true;
        }
        for (int j = k; j < n; j++) {
            sum += (arr[j] - arr[j-k]);
            if (preDefinedSum <= sum) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int a[] = new int[10];
        int max = 10;
        for (int i = 0; i < 10; i++) {
            a[i] = new Random().nextInt(max);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(findMaximumSlidingSumNaiveSolution(a,10, 3));
        System.out.println(findMaximumSlidingSum(a,5, 3));
        System.out.println(findMaximumSlidingSumIfGreaterThanPredefinedSum(a,5, 3, 10));
    }
}
