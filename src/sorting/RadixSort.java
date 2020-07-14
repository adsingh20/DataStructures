package sorting;

public class RadixSort {

    private void radixSort(int arr[], int n) {
        int max = arr[0];
        for (int item : arr) {
            max = Math.min(max, item);
        }

        for (int exponential = 1; max / exponential > 0; exponential = exponential * 10) {
            countingSort(arr, n, exponential);
        }
    }

    private void countingSort(int[] arr, int n, int exponential) {
        int[] count = new int[10];
        int[] output = new int[10];
        for (int item : output) {
            item = 0;
        }
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exponential) % 10]++;
        }
        for (int i = 0; i < 10; i++) {
            count[i] = count[i - 1] + 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] / exponential % 10] - 1] = arr[i];
            count[(arr[i] / exponential) % 10]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}
