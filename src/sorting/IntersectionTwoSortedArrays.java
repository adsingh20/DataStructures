package sorting;

import java.util.Arrays;

public class IntersectionTwoSortedArrays {

    private static void getIntersectedArray(int[] a, int[] b, int[] c) {
        int i = 0, j =0, k = 0;
        while (i < a.length && j < b.length) {
            if (i > 0 && a[i-1] == a[i]) {
                i++;
                continue;
            }
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                c[k++] = a[i];
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {3, 5, 10, 10, 10, 15, 15, 20};
        System.out.println(Arrays.toString(a));
        int b[] = {5, 10, 10, 10, 15, 20};
        System.out.println(Arrays.toString(b));
        int c[] = new int[a.length];
        getIntersectedArray(a, b, c);
        System.out.println(Arrays.toString(c));
    }
}
