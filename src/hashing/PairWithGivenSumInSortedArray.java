package hashing;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PairWithGivenSumInSortedArray {

    private static boolean isPair(int[] arr, int sum) {
        HashSet<Integer> items = new HashSet<>();
        for (int value : arr) {
            if (items.contains(sum - value)) {
                return true;
            }
            items.add(value);
        }
        return false;
    }

    private static Pair<Integer, Integer> findArraySumIndices(int[] arr, int sum) {
        HashMap<Integer, Integer> items = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (items.containsKey(sum - arr[i])) {
                return new Pair<>(items.get(sum - arr[i]), i);
            }
            items.put(arr[i], i);
        }
        return new Pair<>(-1, -1);
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 7, 10, -1, 8, 12};
        int sum = 17;
        System.out.println(Arrays.toString(a));
        System.out.println(isPair(a, sum));
        Pair<Integer, Integer> indices = findArraySumIndices(a, sum);
        System.out.println(indices.getKey() > -1 ? "Sum Found at Indices " + indices.getKey() + " and " +indices.getValue()
                : "Sum not found");
    }
}
