package greedy;

import util.ElementPair;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivitySelectionProblem {

    /**
     * Uses a greedy approach to find Maximum Number of Activities
     * so that they dont overlap. ElementPair's first element contains startTime
     * and second element contains end time
     * Time Complexity O(n)
     * @param activities List of activities used for the approach
     * @return Max number of activities
     */
    public int findMaximumNumberOfActivities(List<ElementPair> activities) {
        Collections.sort(activities, Comparator.comparingInt(ElementPair::getSecondElement));

        int result = 1;
        int previous = 0;

        for (int current = 1; current < activities.size(); current++) {
            if (activities.get(current).getFirstElement() >= activities.get(previous).getSecondElement()) {
                ++result;
                previous = current;
            }
        }

        return result;
    }


}
