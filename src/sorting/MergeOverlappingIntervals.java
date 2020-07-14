package sorting;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeOverlappingIntervals {

    private static List<Pair<Integer, Integer>> getMergedOverlappingIntervals
            (List<Pair<Integer, Integer>> intervals) {
        LinkedList<Pair<Integer, Integer>> mergedIntervals = new LinkedList<>();
        intervals.sort(Comparator.comparing(Pair::getKey));

        int result = 0;

        mergedIntervals.add(result, intervals.get(0));

        for (Pair<Integer, Integer> interval : intervals) {
            if (mergedIntervals.isEmpty() || mergedIntervals.getLast().getValue() < interval.getKey()) {
                mergedIntervals.add(interval);
            } else {
                final Integer beginRange = mergedIntervals.getLast().getKey();
                final Integer endRange = Math.max(mergedIntervals.getLast().getValue(), interval.getValue());
                mergedIntervals.removeLast();
                mergedIntervals.addLast(new Pair<>(beginRange, endRange));
            }
        }

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Pair<Integer, Integer>> intervals = new ArrayList<>();
        intervals.add(new Pair<>(2, 7));
        intervals.add(new Pair<>(3, 15));
        intervals.add(new Pair<>(5, 10));
        intervals.add(new Pair<>(18, 30));
        System.out.println(getMergedOverlappingIntervals(intervals));
    }
}
