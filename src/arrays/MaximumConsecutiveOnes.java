package arrays;

import java.util.Arrays;
import java.util.Random;

public class MaximumConsecutiveOnes {

    static int maxConsecutiveOnesNaiveApproach(int arr[]) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] == 1) {
                    curr++;
                } else {
                    break;
                }
            }
            res = Math.max(curr, res);
        }
        return res;
    }

    static int maxConsecutiveOnesEfficientApproach(int arr[]) {
        int n = arr.length;
        int curr = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                curr = 0;
            } else {
                curr++;
                res = Math.max(curr, res);
            }
        }
        return res;
    }

    static int maxConsecutiveOnesReducedComparison(int arr[]) {

        int curr = 0;
        int res = 0;
        for (int a: arr) {
            if (a == 1) {
                curr++;
            } else {
                res = Math.max(curr, res);
                curr = 0;
            }
        }
        res = Math.max(curr, res);
        return res;
    }

    public static void main(String[] args) {
        int a[] = new int[20];
        for (int i = 0; i < 20; i++) {
            a[i] = new Random().nextInt(2);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(maxConsecutiveOnesNaiveApproach(a));
        System.out.println(maxConsecutiveOnesEfficientApproach(a));
        System.out.println(maxConsecutiveOnesReducedComparison(a));
    }
}
