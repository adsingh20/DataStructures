package arrays;

import java.util.Arrays;
import java.util.Random;

public class MajorityElement {

    static int findMajorityElementNaiveSolution(int arr[], int n) {
        int count = -1;
        for (int i = 0; i < n; i++) {
            count = 1;
            for (int j = i + 1; j < n; j++) {
                if(arr[i] == arr[j])
                    count++;
            }
            if (count > n/2){
                return i;
            }
        }
        return count;
    }

    static int findMajorityElement(int arr[], int n) {
        int result = 0, count = 1;
        for (int i = 0; i < n; i++) {
            if(arr[i] == arr[result]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result = i;
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] == arr[result]) {
                count++;
            }
            if (count <= n/2){
                return -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int a[] = new int[5];
        int max = 10;
        for (int i = 0; i < 5; i++) {
            a[i] = new Random().nextInt(max);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(findMajorityElementNaiveSolution(a,5));
        System.out.println(findMajorityElement(a,5));
    }
}
