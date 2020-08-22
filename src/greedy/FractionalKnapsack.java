package greedy;

import util.ElementPair;

import java.util.ArrayList;
import java.util.Comparator;

public class FractionalKnapsack {

    /**
     * This method finds the maximum value that can be accommodated from the weights
     * Time Complexity O(nlogn)
     * @param items List of items containing weight and value as the first and second element respectively 
     * @param weight Maximum Weight that can be accomodated in the knapsack
     * @return
     */
    public double findMaximumValue(ArrayList<ElementPair> items, int weight) {

        // Sort to get the highest value item
        items.sort(Comparator.comparingDouble(elementPair -> (double) elementPair.getSecondElement() / elementPair.getFirstElement()));

        
        double result = 0;
        
        for (ElementPair item : items) {
            if (item.getFirstElement() <= weight) {
                result = result + items.get(1).getSecondElement();
                weight = weight - item.getFirstElement();
            } else {
                result = item.getSecondElement() * (double) weight / item.getFirstElement();
                break;
            }
        }
        
        return result;
    }
}
