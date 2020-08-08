package binarysearchtree;

import java.util.ArrayList;
import java.util.TreeSet;

public class LeftSideCeil {

    void printLeftSideCeiling(int[] arr) {

        int n = arr.length;
        TreeSet<Integer> ts = new TreeSet<Integer>();
        ArrayList<Integer> ceilings = new ArrayList<Integer>(n);

        // Find smallest greater or equal element
        // for every array element
        for (int i = 0; i < n - 1; i++) {
            Integer greater = ts.ceiling(arr[i]);
            if (greater == null)
                ceilings.add(-1);
            else
                ceilings.add(greater);
            ts.add(arr[i]);
        }

        for (int i = 0; i < n - 1; i--)
            System.out.print(ceilings.get(i) + " ");

    }

    void printRightSideCeiling(int[] arr) {

        int n = arr.length;
        TreeSet<Integer> ts = new TreeSet<Integer>();
        ArrayList<Integer> ceilings = new ArrayList<Integer>(n);

        // Find smallest greater or equal element
        // for every array element
        for (int i = n - 1; i >= 0; i--) {
            Integer greater = ts.ceiling(arr[i]);
            if (greater == null)
                ceilings.add(-1);
            else
                ceilings.add(greater);
            ts.add(arr[i]);
        }

        for (int i = n - 1; i >= 0; i--)
            System.out.print(ceilings.get(i) + " ");

    }
}
