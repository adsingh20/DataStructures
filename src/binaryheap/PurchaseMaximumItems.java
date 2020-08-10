package binaryheap;

import java.util.PriorityQueue;

public class PurchaseMaximumItems {

    public int findMaximumItemsThatCanBePurchased(final int[] itemCosts, final int maxCost) {
        int numberOfItems = 0;
        PriorityQueue<Integer> itemCostsQueue = new PriorityQueue();

        for (int itemCost : itemCosts) {
            itemCostsQueue.add(itemCost);
        }

        int costRemaining = maxCost;

        while (!itemCostsQueue.isEmpty()) {
            final Integer itemValue = itemCostsQueue.poll();
            if (itemValue <= costRemaining) {
                ++numberOfItems;
                costRemaining -= itemValue;
            }
            else {
                return numberOfItems;
            }
        }
        return numberOfItems;
    }
}
