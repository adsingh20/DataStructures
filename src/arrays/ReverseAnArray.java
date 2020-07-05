package arrays;

import java.util.Arrays;
import java.util.Random;

public class ReverseAnArray {

    public static void reverseBruteForce(int arr[], int n) {
        int low = 0, high = n - 1;

        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static void reverseBruteForceWithSpecificIndex(int arr[], int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        int a[] = new int[20];
        for (int i = 0; i < 20; i++) {
            a[i] = new Random().nextInt(50);
        }
        System.out.println(Arrays.toString(a));
        reverseBruteForce(a, 20);
        System.out.println(Arrays.toString(a));
    }

}
