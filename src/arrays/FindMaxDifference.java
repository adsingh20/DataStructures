package arrays;

import java.util.Random;

public class FindMaxDifference {

    public static void findMaxDifferenceBruteForce(int arr[], int n) {
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (maxDiff < arr[j] - arr[i]) {
                    maxDiff = arr[j] - arr[i];
                }
            }
        }
        System.out.println(maxDiff);
    }

    public static void findMaxDifference(int arr[], int n) {
        int maxDiff = arr[1] - arr[0], minVal = arr[0];
        for (int i = 1; i < n; i++) {
            maxDiff = Math.max(arr[i] - minVal, maxDiff);
            minVal = Math.min(minVal, arr[i]);
        }
        System.out.println(maxDiff);
    }

    public static void main(String[] args) {
        int a[] = new int[100];
        for (int i = 0; i < 100; i++) {
            a[i] = new Random().nextInt(1000);
        }
        //System.out.println(Arrays.toString(a));
        findMaxDifferenceBruteForce(a, 5);
        findMaxDifference(a, 5);
    }
}
