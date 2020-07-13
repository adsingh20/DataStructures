package sorting;

import java.util.Arrays;

public class ChocolateDistributionProblem {

    private static int findMinimumDifference(int[] arr, int numChildren) {
        if (numChildren > arr.length) {
            return -1;
        }

        Arrays.sort(arr);

        int result = arr[numChildren - 1] - arr[0];

        for (int i = 1; i + numChildren - 1 < arr.length; i++) {
            result = Math.min(arr[numChildren + i -1] - arr[i], result);
        }
        return result;
    }

    public static void main(String[] args) {
        int a[] = {7, 3, 2, 9, 12, 56};
        System.out.println(Arrays.toString(a));

        System.out.println(findMinimumDifference(a, 3));
    }
}
