package arrays;

import java.util.Arrays;
import java.util.Random;

public class LeaderArray {

    public static void findLeadersBruteForce(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] >= arr[i]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.print(arr[i]);
                System.out.print(',');
            }
        }
        System.out.println("Over");
    }

    public static void findLeadersBetter(int arr[], int n) {
        int curr_leader = arr[n - 1];
        System.out.print(curr_leader);
        for (int i = n - 2; i >= 0; i--) {
            if (curr_leader < arr[i]) {
                System.out.print(',');
                curr_leader = arr[i];
                System.out.print(curr_leader);
            }
        }
    }

    public static void main(String[] args) {
        int a[] = new int[20];
        for (int i = 0; i < 20; i++) {
            a[i] = new Random().nextInt(50);
        }
        System.out.println(Arrays.toString(a));
        findLeadersBruteForce(a, 20);
        findLeadersBetter(a, 20);
    }
}
