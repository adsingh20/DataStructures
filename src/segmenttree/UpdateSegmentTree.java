package segmenttree;

public class UpdateSegmentTree {

    static int arr[];

    static int tree[];

    /**
     * Updates the corresponding segment tree index with the requested value
     * Time Complexity is theta(n)
     * @param ss Starting Index of range represented by current node
     * @param se Ending Index of range represented by current node
     * @param si Index of current node
     * @param i Index to be updated
     * @param diff Difference of value to be updated
     */
    public static void updateRecursively(int ss, int se, int si, int i, int diff) {

        // Since out of range just return
        if (i < ss || i > se) {
            return;
        }

        // Since not of range update the current node
        tree[si] = tree[si] + diff;

        // Check if the current node has children and in that case update all of them
        if (se > ss) {
            int mid = (se + ss) / 2;
            updateRecursively(ss, mid, 2 * si + 1, i, diff);
            updateRecursively(mid + 1, se, 2 * si + 2, i, diff);
        }
    }

    public static void main(String args) {
        int updatedNumber = 29;
        int updatedIndex = 3;
        int diff = updatedNumber - arr[updatedIndex];
        updateRecursively(2, arr.length - 1, 0, updatedIndex, diff);
    }
}
