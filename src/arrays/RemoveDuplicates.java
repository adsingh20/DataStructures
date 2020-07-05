package arrays;

import java.util.Arrays;
import java.util.Random;

public class RemoveDuplicates {

    public static int[] removeDuplicates(int[] a, int n) {
        int temp[] = new int[n];
        temp[0] = a[0];
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (temp[res - 1] != a[i]) {
                temp[res] = a[i];
                res++;
            }
        }
        return Arrays.copyOf(temp, res);
    }

    public static int[] removeDuplicatesWithOutAuxilairySpace(int[] a, int n) {
        int res = 1;
        for (int i = 1; i < n; i++) {
            if (a[res - 1] != a[i]) {
                a[res] = a[i];
                res++;
            }
        }
        return Arrays.copyOf(a, res);
    }

    public static void main(String[] args) {
        int a[] = new int[20];
        int b[] = new int[50];
        for (int i = 0; i < 20; i++) {
            a[i] = new Random().nextInt(50) % 10;
        }
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(removeDuplicates(a, a.length)));
        for (int i = 0; i < 50; i++) {
            b[i] = new Random().nextInt(150) % 10;
        }
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(removeDuplicatesWithOutAuxilairySpace(b, b.length)));
    }
}
