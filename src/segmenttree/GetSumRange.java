package segmenttree;

public class GetSumRange {

    int tree[];

    /**
     * Calculated the sum of the query in the range qs and qe
     * @param qs User Input Start Range
     * @param qe User Input End Range
     * @param ss Starting Index of range represented by current node
     * @param se Ending Index of range represented by current node
     * @param si Index of current node
     * @return Sum of the range set
     */
    public int getSumRecursive(int qs, int qe, int ss, int se, int si) {

        // Completely out of range
        if (se < qs || ss > qe) {
            return 0;
        }

        // Completelt inside the range
        if (qs <= ss && qe >= se) {
            return tree[si];
        }

        int mid = (ss + se) / 2;

        return getSumRecursive(qs, qe, ss, mid, 2* si + 1) +
               getSumRecursive(qs, qe, mid + 1, se, 2* si + 2);
    }

}
