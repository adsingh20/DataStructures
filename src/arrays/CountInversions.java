package arrays;

public class CountInversions {

    private static int countAndMerge(int arr[], int m, int l, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = arr[m + 1 + i];
        }
        int result = 0, i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
                result = result + (n1 - i);
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }

        return result;
    }

    private static int countInversions(int arr[], int l, int r) {
        int result = 0;
        if (l < r) {
            int m = l + (r - l) / 2;
            result += countInversions(arr, l, m);
            result += countInversions(arr, m + 1, r);
            result += countAndMerge(arr, m, l, r);
        }
        return result;
    }
}
