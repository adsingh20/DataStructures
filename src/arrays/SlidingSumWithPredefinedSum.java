package arrays;

import java.util.Arrays;
import java.util.Random;

public class SlidingSumWithPredefinedSum {

    private static boolean isSlidingSumWithPredefinedSum(int arr[], int n, int sum) {
        int curr_sum = arr[0], start = 0;
        for (int end = 1; end < n; end++) {
            while (curr_sum > sum && start < end - 1) {
                curr_sum -= arr[start];
                start++;
            }
            if (curr_sum >= sum) {
                return true;
            }
            curr_sum += arr[end];
        }
        return (curr_sum == sum);
    }

    public static void main(String[] args) {
        int a[] = new int[10];
        int max = 10;
        for (int i = 0; i < 10; i++) {
            a[i] = new Random().nextInt(max);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(isSlidingSumWithPredefinedSum(a,10, 80));
    }
}
