package binaryheap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    public List<Integer> mergeKSortedArrays(final List<List<Integer>> kSortedArrays) {

        PriorityQueue<KArray> priorityQueue = new PriorityQueue<KArray>();

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < kSortedArrays.size(); i++) {
            priorityQueue.add(new KArray(kSortedArrays.get(i).get(0), 0, i));
        }

        while (!priorityQueue.isEmpty()) {
            KArray kArray = priorityQueue.poll();
            result.add(kArray.value);
            int arrayPosition = kArray.arrayPosition;
            int elementPosition = kArray.elementPosition;

            if (elementPosition < kSortedArrays.get(arrayPosition).size()) {
                priorityQueue.add(new KArray(kSortedArrays.get(arrayPosition).get(elementPosition + 1),
                        elementPosition + 1,
                        arrayPosition));
            }
        }

        return result;
    }

}

class KArray implements Comparable<KArray> {
    int value;
    int elementPosition;
    int arrayPosition;

    public KArray(int value, int elementPosition, int arrayPosition) {
        this.value = value;
        this.elementPosition = elementPosition;
        this.arrayPosition = arrayPosition;
    }


    @Override
    public int compareTo(KArray kArray) {
        if (value < kArray.value) {
            return -1;
        } else {
            return 1;
        }
    }
}
