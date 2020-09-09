package segmenttree;

import java.util.Random;

public class ConstructSegmentTree {

    // Inital array
    static int arr[];

    static int tree[];


    public static int constructSegmentTree(int ss, int se, int si) {
        if (ss == se) {
            tree[si] = arr[ss];
            return arr[ss];
        }

        int mid = (ss + se) / 2;
        tree[si] = constructSegmentTree(ss, mid, 2 * si + 1) +
                   constructSegmentTree(mid + 1, se, 2 * si + 2);

        return tree[si];
    }

    public static void main(String args) {
        arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = new Random().nextInt(50);
        }
        tree = new int[5 * 4];
        constructSegmentTree(0, 5, 0);
        System.out.println(tree);
    }
}
