package sorting;

public class KthSmallestElement {

    private static int findKthSmallestElement(int[] arr, int n, int k) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int p = partition(arr, l, r);
            if (p == k - 1) {
                return p;
            } else if (p > k - 1) {
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return -1;
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        // Index of smaller element
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller
            // than or equal to pivot
            if (arr[j] <= pivot) {
                i++; // increment index of
                // smaller element
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    static void swap(int[] array, int position1, int position2) {
        // Swaps elements in an array

        // Copy the first position's element
        int temp = array[position1];

        // Assign to the second element
        array[position1] = array[position2];

        // Assign to the first element
        array[position2] = temp;
    }

}

