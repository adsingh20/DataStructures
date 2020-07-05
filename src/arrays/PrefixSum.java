package arrays;

import java.util.Arrays;
import java.util.Random;

public class PrefixSum {

    static int[] getPrefixArray(int arr[], int n) {
        int[] prefix_sum = new int[n];
        prefix_sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix_sum[i] = prefix_sum[i-1] + arr[i];
        }
        return prefix_sum;
    }

    static int getPrefixSum(int prefix[], int l , int r) {
        if (l > 0)
            return prefix[r] - prefix[l-1];
        else
            return prefix[r];
    }

    static boolean findIfEquilibiriumPointsExists(int arr[], int n) {
      int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int left_sum = 0;
        for (int i = 0; i < n; i++) {
            if (left_sum == sum - arr[i]) {
                return true;
            }
            left_sum += arr[i];
            sum -= arr[i];
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
        System.out.println(getPrefixSum(getPrefixArray(a, 10),2, 4));
        System.out.println(getPrefixSum(getPrefixArray(a, 10),0, 4));
        System.out.println(findIfEquilibiriumPointsExists(a, 10));
    }

}
