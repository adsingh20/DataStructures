package dynamicprogramming;

import searching.BinarySearch;

public class LongestIncreasingSubsequence {

    private int findLISUsingDP(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        lis[0] = 1;

        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i ; j++) {
                if (arr[j] > arr[i]) {
                    lis[i] = Math.max(arr[i], arr[j]) + 1;
                }
            }
        }

        int result = lis[0];
        for (int i = 1; i < n; i++) {
            result = Math.max(arr[i], result);
        }

        return result;
    }

    private int findLISOptimalSolution(int[] arr) {
        int n = arr.length;
        int[] tail = new int[n];
        int length = 1;
        tail[0] = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] < tail[i - 1]) {
                tail[length] = arr[i];
                length++;
            } else {
                tail[i] = arr[i];
            }
        }
        return length;
    }

    private int findCeil(int[] arr, int length, int number) {
        int left = 0;
        int right = length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] < number) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        // return left; // Largest Small Element
        return right; // Next bigger element
    }
}
