package greedy;

import util.ElementPair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class JobSequencingProblem {

    public long findMaximumProfit(List<ElementPair> deadlineProfitPairs, int deadline) {

        // Sort according to decreasing profit
        deadlineProfitPairs.sort(Comparator.comparingDouble(ElementPair::getSecondElement).reversed());

        HashMap<Integer, ElementPair> slots = new HashMap<>();

        long result = 0;

        for (int i = 0; i < deadline; i++) {
            slots.put(i, null);
        }

        for (ElementPair deadLineProfit : deadlineProfitPairs) {
            for (int j = Math.min(deadline - 1, deadLineProfit.getFirstElement() - 1);
                 j >= 0; j--) {

                // Free slot found
                if (slots.get(j) == null) {
                    slots.put(j, deadLineProfit);
                    result += deadLineProfit.getSecondElement();
                    break;
                }
            }
        }

        return result;
    }
}
