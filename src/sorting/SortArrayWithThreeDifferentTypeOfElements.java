package sorting;

import util.MathUtil;

public class SortArrayWithThreeDifferentTypeOfElements {

    /**
     * Mantain three variable low, mid & high.
     * 0 - low - 1 => 0
     * mid - high => 1
     * mid - high - 1 => Unknown
     * bigh -1 - n => 2
     * @param arr
     */
    void sortThreeTypeOfNumbers(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    MathUtil.swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    MathUtil.swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }
}
