package sorting;

import util.MathUtil;

public class SortArrayWithTwoDifferentTypeOfElements {

    void sortNegativePositveNumbers(int[] arr) {
        int i = -1;
        int j = arr.length;
        while (true) {
            do {
                i++;
            } while (arr[i] < 0);
            do {
                j++;
            } while (arr[j] >= 0);
            if (i >= j){
                return;
            }
            MathUtil.swap(arr, i , j);
        }
    }

}
