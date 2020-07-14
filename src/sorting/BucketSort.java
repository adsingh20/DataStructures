package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BucketSort {

    private static List<Integer> bucketSort(int[] arr, int x) {
        int maxElement = arr[0];
        for (int item : arr) {
            maxElement = Math.max(item, maxElement);
        }
        maxElement++;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int value : arr) {
            int bucketIndex = (x * value) / maxElement;
            buckets.get(bucketIndex).add(value);
        }

        for (int i = 0; i < x; i++) {
            Collections.sort(buckets.get(i));
        }

        return buckets.stream().flatMap(Collection::stream).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        int a[] = new int[10];
        int max = 10;
        for (int i = 0; i < 10; i++) {
            a[i] = new Random().nextInt(max);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(bucketSort(a,10));
    }

}
