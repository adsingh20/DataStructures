package arrays;

import java.util.Arrays;
import java.util.Random;

public class LeftRotateArray {

    public static void leftRotateOne(int arr[], int n) {
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;
    }

    public static void leftRotate(int arr[], int n, int d) {
        for (int i = 0; i < d; i++) {
            leftRotateOne(arr, n);
        }
    }

    public static void leftRotateWithSpace(int arr[], int n, int d) {
        int temp[] = new int[d];

        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        for (int i = d; i < n; i++) {
            arr[i-d] = arr[i];
        }
        for (int i = 0; i < d; i++) {
            arr[n-d+1] = temp[i];
        }
    }

    public static void leftRotateWithOutSpace(int arr[], int n, int d) {
        ReverseAnArray.reverseBruteForceWithSpecificIndex(arr, 0, d-1);
        ReverseAnArray.reverseBruteForceWithSpecificIndex(arr, d, n-1);
        ReverseAnArray.reverseBruteForceWithSpecificIndex(arr, 0, n-1);
    }

    public static void main(String[] args) {
        int a[] = new int[20];
        for (int i = 0; i < 20; i++) {
            a[i] = new Random().nextInt(50);
        }
        System.out.println(Arrays.toString(a));
        leftRotate(a, 20, 5);
        System.out.println(Arrays.toString(a));
        int b[] = new int[20];
        for (int i = 0; i < 20; i++) {
            b[i] = new Random().nextInt(50);
        }
        System.out.println(Arrays.toString(b));
        leftRotateWithSpace(b, 20, 5);
        System.out.println(Arrays.toString(b));
        int c[] = new int[20];
        for (int i = 0; i < 20; i++) {
            c[i] = new Random().nextInt(50);
        }
        System.out.println(Arrays.toString(c));
        leftRotateWithOutSpace(c, 20, 3);
        System.out.println(Arrays.toString(c));
    }

}
