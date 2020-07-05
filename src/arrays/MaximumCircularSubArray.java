package arrays;

import java.util.Arrays;
import java.util.Random;

public class MaximumCircularSubArray {

    static int findMaximumCircularSubArrayNaiveSolution(int arr[], int n) {
        int result = arr[0];
        for (int i = 0; i < n; i++) {
            int curr_max = arr[i];
            int curr_sum = arr[i];
            for (int j = 1; j < n; j++) {
                //int index = (i + j) % n;
                curr_sum +=  arr[(i + j) % n];
                curr_max = Math.max(curr_sum, curr_max);
            }
            result = Math.max(result, curr_max);
        }
        return result;
    }

    static int findMaximumCircularSubArray(int arr[], int n) {
        //Find normal max
        int normal_max = MaximumSumSubArray.findMaximumSumArray(arr, n);
        if (normal_max < 0) {
            return normal_max;
        } else {
            /* To find circular max. Get the sum of whole array and subtract the minimum sub array
            * for eg arr = [5, -2, 3, 4]. Total sum is 5 + (-2) + 3 + 4 = 12.
            * now minimum subarray is -2, so to calculate that we are negating all the array elements as
            * negating and finding the maximum will give you the minimum(line 38). After finding the minimum subarray
            * using this property, we need to subtract it from Total sum but we add it here since we already negated the
            * array elements
             */
            int arr_sum = 0;
            for (int i = 0; i < n; i++) {
                arr_sum += arr[i];
                arr[i] = -arr[i];
            }
            int circular_max = arr_sum + MaximumSumSubArray.findMaximumSumArray(arr, n);
            return Math.max(normal_max, circular_max);
        }
    }


    public static void main(String[] args) {
        int a[] = new int[5];
        int max = 10, min = -10;
        for (int i = 0; i < 5; i++) {
            a[i] = new Random().nextInt(max - min) + min;
        }
        System.out.println(Arrays.toString(a));
        System.out.println(findMaximumCircularSubArrayNaiveSolution(a,5));
        System.out.println(findMaximumCircularSubArray(a,5));
    }
}
